package com.example.irkokey.presentation.modules.backup

import android.os.Environment
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.common.utils.SingleLiveEvent
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.data.repository.UserRepository
import com.example.irkokey.domain.models.Password
import com.example.irkokey.domain.models.User
import com.opencsv.CSVReader
import com.opencsv.CSVWriter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileWriter
import javax.inject.Inject

@HiltViewModel
class BackupViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val passwordRepository: PasswordRepository,
    private val encryptionUtil: EncryptionUtil
) : ViewModel() {

    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int> get() = _progress

    private val _isExported = SingleLiveEvent<Boolean>()
    val isExported: LiveData<Boolean> get() = _isExported

    private val _isImported = SingleLiveEvent<Boolean>()
    val isImported: LiveData<Boolean> get() = _isImported

    // Request the user to enter the PIN and export the data
    fun requestPinAndExport(userPin: String) {
        viewModelScope.launch {
            val user = userRepository.getUser(1)
            val storedPinHash = user.hashedPassword.trim()
            val inputPinHash = encryptionUtil.hash(userPin).trim()
            Log.d("BackupViewModel", "Stored PIN: $storedPinHash, Input PIN: $inputPinHash")
            Log.d("BackupViewModel", "Verification: ${storedPinHash == inputPinHash}")

            if (storedPinHash == inputPinHash) {
                Log.d("BackupViewModel", "PIN verified")
                exportDatabaseToCSV(userPin)
            } else {
                Log.d("BackupViewModel", "PIN verification failed")
                _isExported.postValue(false)
            }
        }
    }

    // Request the user to enter the PIN and import the data
    fun requestPinAndImport(userPin: String) {
        viewModelScope.launch {
            val user = userRepository.getUser(1)
            val storedPinHash = user.hashedPassword.trim()
            val inputPinHash = encryptionUtil.hash(userPin).trim()
            Log.d("BackupViewModel", "Stored PIN: $storedPinHash, Input PIN: $inputPinHash")
            Log.d("BackupViewModel", "Verification: ${storedPinHash == inputPinHash}")

            if (storedPinHash == inputPinHash) {
                Log.d("BackupViewModel", "PIN verified")
                importDatafromCSV(userPin)
            } else {
                Log.d("BackupViewModel", "PIN verification failed")
                _isImported.postValue(false)
            }
        }
    }

    private fun exportDatabaseToCSV(userPin: String) {
        viewModelScope.launch {
            val downloadsDir =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val csvFile = File(downloadsDir, "backup.csv")
            var csvWriter: CSVWriter? = null
            try {
                csvWriter = CSVWriter(FileWriter(csvFile))

                // Export user
                Log.d("BackupViewModel", "Exporting user data")
                val user = userRepository.getUser(1)
                csvWriter.writeNext(arrayOf("User ID", "Hashed Email", "Hashed Password"))
                csvWriter.writeNext(
                    arrayOf(
                        user.id.toString(),
                        user.hashedEmail.trim(),
                        user.hashedPassword.trim()
                    )
                )
                _progress.postValue(50) // 50% progress for user
                Log.d("BackupViewModel", "User data exported")

                // Export passwords
                Log.d("BackupViewModel", "Exporting password data")
                val passwords = passwordRepository.getAllPasswords().first()
                csvWriter.writeNext(
                    arrayOf(
                        "Password ID",
                        "Website",
                        "Username",
                        "Password Hash",
                        "Favorite"
                    )
                )
                passwords.forEachIndexed { index, password ->
                    csvWriter.writeNext(
                        arrayOf(
                            password.id.toString(),
                            password.website.trim(),
                            password.userName.trim(),
                            password.password.trim(),
                            password.isFavorite.toString().trim()
                        )
                    )
                    _progress.postValue(50 + (index + 1) * 50 / passwords.size) // Remaining 50% progress for passwords
                    Log.d("BackupViewModel", "Password $index exported")
                }
                Log.d("BackupViewModel", "Password data exported")

                // Export the encryption key securely
                Log.d("BackupViewModel", "Exporting encryption key")
                val key = encryptionUtil.exportKey()
                val encryptedKey = encryptionUtil.encryptKeyWithPin(key, userPin)
                Log.d("BackupViewModel", "Key: $key, Encrypted Key: $encryptedKey")
                csvWriter.writeNext(arrayOf("Encryption Key", encryptedKey))
                Log.d("BackupViewModel", "Encryption key exported")

                _isExported.postValue(true)
                _progress.postValue(100) // Complete progress
            } catch (e: Exception) {
                Log.e("BackupViewModel", "Error exporting data")
                e.printStackTrace()
            } finally {
                try {
                    csvWriter?.close()
                } catch (e: Exception) {
                    Log.e("BackupViewModel", "Error closing CSV writer")
                    e.printStackTrace()
                }
            }
        }
    }

    private fun importDatafromCSV(userPin: String) {
        viewModelScope.launch {
            val downloadsDir =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val file = File(downloadsDir, "backup.csv")

            if (!file.exists()) {
                Log.e("BackupViewModel", "Backup file not found")
                return@launch
            }

            try {
                file.bufferedReader().use { reader ->
                    val csvReader = CSVReader(reader)
                    val csvLines = csvReader.readAll().filter { it.isNotEmpty() }
                    Log.d("BackupViewModel", "CSV lines: $csvLines")
                    if (csvLines.size < 4) {
                        Log.e("BackupViewModel", "Invalid file format")
                        return@launch
                    }

                    // Clear existing data in the database
                    Log.d("BackupViewModel", "Clearing existing data")
                    userRepository.deleteAllUsers()
                    passwordRepository.deleteAllPasswords()

                    // Import user data
                    val userData = csvLines[1].map { it.trim().removeSurrounding("\"") }
                    Log.d("BackupViewModel", "Importing user data")
                    if (userData.size != 3 || userData.any { it.isEmpty() }) {
                        Log.e("BackupViewModel", "Invalid user data")
                        return@launch
                    }
                    val myUser = User(
                        id = userData[0].toInt(),
                        hashedEmail = userData[1],
                        hashedPassword = userData[2]
                    )
                    Log.d("BackupViewModel", "User data: $myUser")
                    userRepository.insertUser(myUser)
                    Log.d("BackupViewModel", "User data imported")

                    // Import password data
                    Log.d("BackupViewModel", "Importing password data")
                    val passwordDataLines = csvLines.drop(3)
                        .takeWhile { !it[0].trim().startsWith("Encryption Key", ignoreCase = true) }
                    Log.d("BackupViewModel", "Password data lines: $passwordDataLines")
                    passwordDataLines.forEach { line ->
                        val passwordData = line.map { it.trim().removeSurrounding("\"") }
                        Log.d("BackupViewModel", "Password data: $passwordData")
                        if (passwordData.size != 5 || passwordData.any { it.isEmpty() }) {
                            Log.e("BackupViewModel", "Invalid password data")
                            return@forEach
                        }
                        val myPassword = Password(
                            id = passwordData[0].toInt(),
                            website = passwordData[1],
                            userName = passwordData[2],
                            password = passwordData[3],
                            isFavorite = passwordData[4].toBoolean()
                        )
                        Log.d("BackupViewModel", "Password data: $myPassword")
                        passwordRepository.insertPassword(myPassword)
                    }

                    // Import the encryption key securely
                    val encryptionKeyIndex = csvLines.indexOfFirst {
                        it[0].trim().startsWith("Encryption Key", ignoreCase = true)
                    }
                    if (encryptionKeyIndex != -1 && encryptionKeyIndex + 1 < csvLines.size) {
                        val encryptedKey = csvLines[encryptionKeyIndex + 1].joinToString("").replace("\n", "")                                .replace(",", "").trim()
                        Log.d("BackupViewModel", "Encrypted Key: $encryptedKey")
                        try {
                            val key = encryptionUtil.decryptKeyWithPin(encryptedKey, userPin)
                            Log.d("BackupViewModel", "Decrypted Key: $key")
                            encryptionUtil.importKey(key)
                            Log.d("BackupViewModel", "Encryption key imported")
                        } catch (e: Exception) {
                            Log.e("BackupViewModel", "Error decrypting key", e)
                        }
                    } else {
                        Log.e("BackupViewModel", "Invalid encryption key")
                    }

                    _isImported.postValue(true)
                }
            } catch (e: Exception) {
                Log.e("BackupViewModel", "Error importing data", e)
                _isImported.postValue(false)
            }
        }
    }
}