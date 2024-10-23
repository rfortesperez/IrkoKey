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
import java.security.GeneralSecurityException
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
        keysetHandle =
            AndroidKeysetManager.Builder().withSharedPref(context, KEYSET_NAME, PREF_FILE_NAME)
                .withKeyTemplate(KeyTemplates.get("AES256_GCM")).withMasterKeyUri(MASTER_KEY_URI)
                .build().keysetHandle
        aead = keysetHandle.getPrimitive(Aead::class.java)
    }

    fun encrypt(data: String): String {
        checkInitialization()
        val ciphertext = aead.encrypt(data.toByteArray(), null)
        return Base64.encodeToString(ciphertext, Base64.DEFAULT)
    }

    fun decrypt(encryptedData: String): String {
        checkInitialization()
        val decodedData = Base64.decode(encryptedData, Base64.DEFAULT)
        val plaintext = aead.decrypt(decodedData, null)
        return String(plaintext)
    }

    fun hash(data: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(data.toByteArray())
        return Base64.encodeToString(hashBytes, Base64.DEFAULT)
    }

    // import keyset
    fun setKeySet(keyset: String) {
        checkInitialization()
        val keysetBytes = Base64.decode(keyset, Base64.DEFAULT)
        keysetHandle = KeysetHandle.read(JsonKeysetReader.withBytes(keysetBytes), null)
        aead = keysetHandle.getPrimitive(Aead::class.java)
    }

    // export keyset
    fun getKeyset(): String {
        checkInitialization()
        val outputStream = ByteArrayOutputStream()
        keysetHandle.write(JsonKeysetWriter.withOutputStream(outputStream), aead)
        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
    }

    // encrypt json with userPin
    fun encryptJson(json: String, userPin: String): String {
        checkInitialization()
        val aead = keysetHandle.getPrimitive(Aead::class.java)
        val encryptedJson = aead.encrypt(json.toByteArray(), userPin.toByteArray())
        return Base64.encodeToString(encryptedJson, Base64.DEFAULT)
    }

    // decrypt json with userPin
    fun decryptJson(encryptedJson: String, userPin: String): String {
        checkInitialization()
        return try {
            val aead = keysetHandle.getPrimitive(Aead::class.java)
            val decodedData = Base64.decode(encryptedJson, Base64.DEFAULT)
            Log.d("EncryptionUtil", "Decoded data: ${decodedData.contentToString()}")
            val decryptedJson = aead.decrypt(decodedData, userPin.toByteArray())
            Log.d("EncryptionUtil", "Decryption successful")
            String(decryptedJson)
        } catch (e: GeneralSecurityException) {
            Log.e("EncryptionUtil", "Decryption failed", e)
            throw e
        }
    }

    private fun checkInitialization() {
        if (!::aead.isInitialized) {
            throw IllegalStateException("EncryptionUtil is not initialized. Call initialize() first.")
        }
    }
}