package com.example.irkokey.common.utils


import android.content.Context
import android.util.Base64
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager

object EncryptionUtil {
    private const val KEYSET_NAME = "irkokey_keyset"
    private const val PREF_FILE_NAME = "irkokey_pref"
    private const val MASTER_KEY_URI = "android-keystore://irkokey_master_key"

    init {
        AeadConfig.register()
    }

    private lateinit var aead: Aead

    fun initialize(context: Context) {
        val keysetHandle: KeysetHandle = AndroidKeysetManager.Builder()
            .withSharedPref(context, KEYSET_NAME, PREF_FILE_NAME)
            .withKeyTemplate(KeyTemplates.get("AES256_GCM"))
            .withMasterKeyUri(MASTER_KEY_URI)
            .build()
            .keysetHandle
        aead = keysetHandle.getPrimitive(Aead::class.java)
    }

    fun encrypt(data: String): String {
        val ciphertext = aead.encrypt(data.toByteArray(), null)
        return Base64.encodeToString(ciphertext, Base64.DEFAULT)
    }

    fun decrypt(encryptedData: String): String {
        val decodedData = Base64.decode(encryptedData, Base64.DEFAULT)
        val plaintext = aead.decrypt(decodedData, null)
        return String(plaintext)
    }
}