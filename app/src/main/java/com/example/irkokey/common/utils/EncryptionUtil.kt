package com.example.irkokey.common.utils

import android.util.Base64
import android.util.Log
import com.example.irkokey.IrkoKeyApp
import com.example.irkokey.common.infraestructure.Preferences
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

/**
 * Utility object for encryption and decryption operations.
 */
object EncryptionUtil {
    private const val SALT = "irkokey_salt"
    private const val ITERATIONS = 10000
    private const val KEY_LENGTH = 256
    private const val GCM_IV_LENGTH = 12
    private const val GCM_TAG_LENGTH = 16

    private lateinit var preferences: Preferences

    private var derivedKey: SecretKey? = null

    /**
     * Retrieves the user's PIN from preferences.
     * @return The user's PIN.
     */
    private fun getUserPin(): String {
        Log.d("EncryptionUtil", "User pin: ${preferences.pin}")
        return preferences.pin ?: ""
    }

    /**
     * Retrieves or generates the derived key for encryption and decryption.
     * @return The derived SecretKey.
     */
    private fun getDerivedKey(): SecretKey {
        if (derivedKey == null) {
            val storedKey = preferences.derivedKey
            if (storedKey != null) {
                derivedKey = SecretKeySpec(Base64.decode(storedKey, Base64.DEFAULT), "AES")
            } else {
                val userPin = getUserPin()
                Log.d("EncryptionUtil", "User pin: $userPin")
                val salt = SALT.toByteArray()
                val spec = PBEKeySpec(userPin.toCharArray(), salt, ITERATIONS, KEY_LENGTH)
                val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                val secretKey = factory.generateSecret(spec)
                derivedKey = SecretKeySpec(secretKey.encoded, "AES")
                preferences.derivedKey = Base64.encodeToString(derivedKey!!.encoded, Base64.DEFAULT)
            }
        }
        Log.d("EncryptionUtil", "Derived key: ${Base64.encodeToString(derivedKey!!.encoded, Base64.DEFAULT)}")
        return derivedKey!!
    }

    /**
     * Encrypts the given data using AES/GCM/NoPadding.
     * @param data The data to be encrypted.
     * @return The encrypted data as a Base64 encoded string.
     */
    fun encrypt(data: String): String {
        val secretKey = getDerivedKey()
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val iv = ByteArray(GCM_IV_LENGTH)
        java.security.SecureRandom().nextBytes(iv)
        val parameterSpec = GCMParameterSpec(GCM_TAG_LENGTH * 8, iv)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec)
        val encryptedData = cipher.doFinal(data.toByteArray())
        val encryptedIvAndData = iv + encryptedData
        Log.d("EncryptionUtil", "Encrypted data: ${Base64.encodeToString(encryptedIvAndData, Base64.DEFAULT)}")
        return Base64.encodeToString(encryptedIvAndData, Base64.DEFAULT)
    }

    /**
     * Decrypts the given cipher text using AES/GCM/NoPadding.
     * @param cipherText The Base64 encoded cipher text to be decrypted.
     * @return The decrypted data as a string.
     */
    fun decrypt(cipherText: String): String {
        val secretKey = getDerivedKey()
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val decodedCipherText = Base64.decode(cipherText, Base64.DEFAULT)
        val iv = decodedCipherText.copyOfRange(0, GCM_IV_LENGTH)
        val encryptedData = decodedCipherText.copyOfRange(GCM_IV_LENGTH, decodedCipherText.size)
        val parameterSpec = GCMParameterSpec(GCM_TAG_LENGTH * 8, iv)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec)
        val decryptedData = cipher.doFinal(encryptedData)
        Log.d("EncryptionUtil", "Decrypted data: ${String(decryptedData)}")
        return String(decryptedData)
    }

    /**
     * Hashes the given data using SHA-256.
     * @param data The data to be hashed.
     * @return The hashed data as a Base64 encoded string.
     */
    fun hash(data: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(data.toByteArray())
        return Base64.encodeToString(hashBytes, Base64.DEFAULT)
    }

    /**
     * Initializes the EncryptionUtil with the given application context.
     * @param irkoKeyApp The application context.
     */
    fun initialize(irkoKeyApp: IrkoKeyApp) {
        this.preferences = Preferences(irkoKeyApp)
    }
}