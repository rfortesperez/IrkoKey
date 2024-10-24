package com.example.irkokey.common.utils

import android.content.Context
import android.util.Base64
import android.util.Log
import com.example.irkokey.common.infraestructure.Preferences
import com.google.crypto.tink.CleartextKeysetHandle
import com.google.crypto.tink.DeterministicAead
import com.google.crypto.tink.JsonKeysetReader
import com.google.crypto.tink.JsonKeysetWriter
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.daead.DeterministicAeadConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.security.GeneralSecurityException
import java.security.MessageDigest
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

object EncryptionUtil {
    private const val KEYSET_NAME = "irkokey_keyset"
    private const val PREF_FILE_NAME = "irkokey_pref"
    private const val MASTER_KEY_URI = "android-keystore://irkokey_master_key"
    private const val SALT = "irkokey_salt"
    private const val ITERATIONS = 10000
    private const val KEY_LENGTH = 256

    private lateinit var keysetHandle: KeysetHandle
    private var derivedKey: SecretKey? = null
    private lateinit var appContext: Context

    init {
        Log.d("EncryptionUtil", "Initializing Tink")
        DeterministicAeadConfig.register()
    }

    fun initialize(context: Context) {
        appContext = context.applicationContext
        keysetHandle = try {
            // Attempt to load existing keyset from KeyStore
            AndroidKeysetManager.Builder()
                .withSharedPref(context, KEYSET_NAME, PREF_FILE_NAME)
                .withMasterKeyUri(MASTER_KEY_URI)
                .build()
                .keysetHandle
        } catch (e: Exception) {
            // If no keyset found, generate a new one
            Log.w("EncryptionUtil", "No keyset found, generating a new one", e)
            AndroidKeysetManager.Builder()
                .withSharedPref(context, KEYSET_NAME, PREF_FILE_NAME)
                .withKeyTemplate(KeyTemplates.get("AES256_SIV"))
                .withMasterKeyUri(MASTER_KEY_URI)
                .build()
                .keysetHandle
        }
    }

    private fun getDerivedKey(): SecretKey {
        if (derivedKey == null) {
            val prefs = Preferences(appContext)
            val userPin = prefs.pin ?: throw IllegalStateException("User pin not set in preferences")
            derivedKey = derivedKeyFromUserPin(userPin)
        }
        return derivedKey!!
    }

    fun encrypt(data: String): String {
        checkInitialization()
        val derivedKey = getDerivedKey()
        Log.d("EncryptionUtil", "Derived key: ${Base64.encodeToString(derivedKey.encoded, Base64.DEFAULT)}")
        val daead = keysetHandle.getPrimitive(DeterministicAead::class.java)
        val ciphertext = daead.encryptDeterministically(data.toByteArray(), derivedKey.encoded)
        Log.d("EncryptionUtil", "Ciphertext: ${Base64.encodeToString(ciphertext, Base64.DEFAULT)}")
        return Base64.encodeToString(ciphertext, Base64.DEFAULT)
    }

    fun decrypt(encryptedData: String): String {
        Log.d("EncryptionUtil", "Starting decryption")
        checkInitialization()
        val derivedKey = getDerivedKey()
        Log.d("EncryptionUtil", "Derived key: ${Base64.encodeToString(derivedKey.encoded, Base64.DEFAULT)}")
        val daead = keysetHandle.getPrimitive(DeterministicAead::class.java)
        val decodedData = Base64.decode(encryptedData, Base64.DEFAULT)
        Log.d("EncryptionUtil", "Decoded data: ${Base64.encodeToString(decodedData, Base64.DEFAULT)}")
        return try {
            val plaintext = daead.decryptDeterministically(decodedData, derivedKey.encoded)
            Log.d("EncryptionUtil", "Decrypted data: ${String(plaintext)}")
            String(plaintext)
        } catch (e: GeneralSecurityException) {
            Log.e("EncryptionUtil", "Decryption failed", e)
            throw e
        }
    }

    fun hash(data: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(data.toByteArray())
        return Base64.encodeToString(hashBytes, Base64.DEFAULT)
    }

    private fun derivedKeyFromUserPin(userPin: String): SecretKey {
        val hashedUserPin = hash(userPin)
        val salt = SALT.toByteArray()
        val spec = PBEKeySpec(hashedUserPin.toCharArray(), salt, ITERATIONS, KEY_LENGTH)
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val secretKey = factory.generateSecret(spec)
        Log.d("EncryptionUtil", "Derived key: ${Base64.encodeToString(secretKey.encoded, Base64.DEFAULT)}")
        return SecretKeySpec(secretKey.encoded, "AES")
    }

    fun exportKeyset(): String {
        checkInitialization()
        val outputStream = ByteArrayOutputStream()
        val writer = JsonKeysetWriter.withOutputStream(outputStream)
        CleartextKeysetHandle.write(keysetHandle, writer)
        val keysetBytes = outputStream.toByteArray()
        Log.d("EncryptionUtil", "Keyset: ${Base64.encodeToString(keysetBytes, Base64.DEFAULT)}")

        // Encrypt the keyset using DeterministicAead
        val daead = keysetHandle.getPrimitive(DeterministicAead::class.java)
        val encryptedKeyset = daead.encryptDeterministically(keysetBytes, getDerivedKey().encoded)
        return encryptedKeyset.let { Base64.encodeToString(it, Base64.DEFAULT) }
    }

    fun importKeyset(encryptedKeyset: String) {
        Log.d("EncryptionUtil", "Importing keyset")
        try {
            val decodedKeyset = Base64.decode(encryptedKeyset, Base64.DEFAULT)
            Log.d("EncryptionUtil", "Decoded keyset: ${Base64.encodeToString(decodedKeyset, Base64.DEFAULT)}")

            val derivedKey = getDerivedKey()
            Log.d("EncryptionUtil", "Derived key: ${Base64.encodeToString(derivedKey.encoded, Base64.DEFAULT)}")

            val daead = keysetHandle.getPrimitive(DeterministicAead::class.java)
            val keysetBytes = daead.decryptDeterministically(decodedKeyset, derivedKey.encoded)
            Log.d("EncryptionUtil", "Decrypted keyset: ${Base64.encodeToString(keysetBytes, Base64.DEFAULT)}")
            Log.d("EncryptionUtil", "Decrypted keyset length: ${keysetBytes.size}")

            val keysetHandle = KeysetHandle.read(JsonKeysetReader.withInputStream(keysetBytes.inputStream()), null)
            Log.d("EncryptionUtil", "Keyset imported successfully")
            this.keysetHandle = keysetHandle
        } catch (e: GeneralSecurityException) {
            Log.e("EncryptionUtil", "Decryption failed", e)
        } catch (e: IOException) {
            Log.e("EncryptionUtil", "Failed to read keyset", e)
        } catch (e: Exception) {
            Log.e("EncryptionUtil", "Unexpected error", e)
        }
    }

    private fun checkInitialization() {
        if (!::keysetHandle.isInitialized) {
            throw IllegalStateException("EncryptionUtil is not initialized. Call initialize() first.")
        }
    }
}