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
import com.google.gson.stream.JsonReader
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.StringReader
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

    fun exportKey(): String {
        checkInitialization()
        val outputStream = ByteArrayOutputStream()
        try {
            keysetHandle.write(JsonKeysetWriter.withOutputStream(outputStream), aead)
        } catch (e: Exception) {
            Log.e("EncryptionUtil", "Error exporting key", e)
            throw e
        }
        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
    }


    fun importKey(key: String) {
        try {
            val keysetBytes = Base64.decode(key, Base64.DEFAULT)

            // Convert to JSON String
            val keysetJson = String(keysetBytes)

            // Parse the JSON to extract the encryptedKeyset
            val jsonObject = JSONObject(keysetJson)
            val encryptedKeyset = jsonObject.getString("encryptedKeyset")

            // Decrypt the encryptedKeyset
            val decryptedKeysetBytes =
                aead.decrypt(Base64.decode(encryptedKeyset, Base64.DEFAULT), null)
            val decryptedKeysetJson = String(decryptedKeysetBytes)

            // Validate the decrypted JSON string
            val jsonReader = JsonReader(StringReader(decryptedKeysetJson))
            jsonReader.isLenient = true
            val keysetHandle =
                KeysetHandle.readNoSecret(JsonKeysetReader.withString(decryptedKeysetJson))
            aead = keysetHandle.getPrimitive(Aead::class.java)
        } catch (e: Exception) {
            Log.e("EncryptionUtil", "Error importing key", e)
            throw e
        }
    }

    fun encryptKeyWithPin(key: String, pin: String): String {
        val pinHash = hash(pin)
        val encryptedKey = aead.encrypt(key.toByteArray(), pinHash.toByteArray())
        return Base64.encodeToString(encryptedKey, Base64.DEFAULT)
    }

    fun decryptKeyWithPin(encryptedKey: String, pin: String): String {
        val pinHash = hash(pin)
        val decodedKey = Base64.decode(encryptedKey, Base64.DEFAULT)
        val decryptedKey = aead.decrypt(decodedKey, pinHash.toByteArray())
        return String(decryptedKey)
    }

    private fun checkInitialization() {
        if (!::aead.isInitialized) {
            throw IllegalStateException("EncryptionUtil is not initialized. Call initialize() first.")
        }
    }
}