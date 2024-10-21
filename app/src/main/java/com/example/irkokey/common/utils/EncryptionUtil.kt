package com.example.irkokey.common.utils


import android.content.Context
import android.util.Base64
import android.util.Log
import com.google.crypto.tink.Aead
import com.google.crypto.tink.JsonKeysetReader
import com.google.crypto.tink.JsonKeysetWriter
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import java.io.ByteArrayOutputStream
import java.security.MessageDigest


object EncryptionUtil {
    private const val KEYSET_NAME = "irkokey_keyset"
    private const val PREF_FILE_NAME = "irkokey_pref"
    private const val MASTER_KEY_URI = "android-keystore://irkokey_master_key"

    init {
        Log.d("EncryptionUtil", "Initializing Tink")
        AeadConfig.register()
    }

    private lateinit var aead: Aead
    private lateinit var keysetHandle: KeysetHandle

    fun initialize(context: Context) {
        keysetHandle = AndroidKeysetManager.Builder()
            .withSharedPref(context, KEYSET_NAME, PREF_FILE_NAME)
            .withKeyTemplate(KeyTemplates.get("AES256_GCM"))
            .withMasterKeyUri(MASTER_KEY_URI)
            .build()
            .keysetHandle
        aead = keysetHandle.getPrimitive(Aead::class.java)
    }

    fun encrypt(data: String): String {
        Log.d("EncryptionUtil", "Encrypting data")
        checkInitialization()
        Log.d("EncryptionUtil", "Data: $data")
        val ciphertext = aead.encrypt(data.toByteArray(), null)
        Log.d("EncryptionUtil", "Data encrypted")
        return Base64.encodeToString(ciphertext, Base64.DEFAULT)
    }

    fun decrypt(encryptedData: String): String {
        Log.d("EncryptionUtil", "Decrypting data")
        checkInitialization()
        Log.d("EncryptionUtil", "Encrypted data: $encryptedData")
        val decodedData = Base64.decode(encryptedData, Base64.DEFAULT)
        Log.d("EncryptionUtil", "Data decoded")
        val plaintext = aead.decrypt(decodedData, null)
        Log.d("EncryptionUtil", "Data decrypted")
        return String(plaintext)
    }

    fun hash(data: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(data.toByteArray())
        return Base64.encodeToString(hashBytes, Base64.DEFAULT)
    }


    fun exportKey(): String {
        Log.d("EncryptionUtil", "Exporting key")
        checkInitialization()
        Log.d("EncryptionUtil", "Keyset handle: $keysetHandle")
        val outputStream = ByteArrayOutputStream()
        try {
            Log.d("EncryptionUtil", "Writing key")
            keysetHandle.write(JsonKeysetWriter.withOutputStream(outputStream), aead)
            Log.d("EncryptionUtil", "Key exported")
        } catch (e: Exception) {
            Log.e("EncryptionUtil", "Error exporting key", e)
            throw e
        }
        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
    }

    fun importKey(key: String) {
        Log.d("EncryptionUtil", "Importing key")
        val keysetBytes = Base64.decode(key, Base64.DEFAULT)
        Log.d("EncryptionUtil", "Key decoded")
        val keysetHandle = KeysetHandle.readNoSecret(JsonKeysetReader.withBytes(keysetBytes))
        Log.d("EncryptionUtil", "Key imported")
        aead = keysetHandle.getPrimitive(Aead::class.java)
        Log.d("EncryptionUtil", "Keyset handle updated")
    }

    fun encryptKeyWithPin(key: String, pin: String): String {
        Log.d("EncryptionUtil", "Encrypting key with pin")
        val pinHash = hash(pin)
        Log.d("EncryptionUtil", "Pin hashed")
        val aead = KeysetHandle.generateNew(KeyTemplates.get("AES256_GCM")).getPrimitive(Aead::class.java)
        Log.d("EncryptionUtil", "Aead generated")
        val encryptedKey = aead.encrypt(key.toByteArray(), pinHash.toByteArray())
        Log.d("EncryptionUtil", "Key encrypted")
        return Base64.encodeToString(encryptedKey, Base64.DEFAULT)
    }

    fun decryptKeyWithPin(encryptedKey: String, pin: String): String {
        Log.d("EncryptionUtil", "Decrypting key with pin")
        val pinHash = hash(pin)
        Log.d("EncryptionUtil", "Pin hashed")
        val aead = KeysetHandle.generateNew(KeyTemplates.get("AES256_GCM")).getPrimitive(Aead::class.java)
        Log.d("EncryptionUtil", "Aead generated")
        val decodedKey = Base64.decode(encryptedKey, Base64.DEFAULT)
        Log.d("EncryptionUtil", "Key decoded")
        val decryptedKey = aead.decrypt(decodedKey, pinHash.toByteArray())
        Log.d("EncryptionUtil", "Key decrypted")
        return String(decryptedKey)
    }

    private fun checkInitialization() {
        if (!::aead.isInitialized) {
            throw IllegalStateException("EncryptionUtil is not initialized. Call initialize() first.")
        }
    }
}