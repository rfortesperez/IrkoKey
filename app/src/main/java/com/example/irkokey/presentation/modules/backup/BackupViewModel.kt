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

            if (storedPinHash == inputPinHash) {
                exportDatabaseToCSV(userPin)
            } else {
                _isExported.postValue(false)
            }        }
    }

    // Request the user to enter the PIN and import the data
    fun requestPinAndImport(userPin: String) {
        viewModelScope.launch {
            val user = userRepository.getUser(1)
            val storedPinHash = user.hashedPassword.trim()
            val inputPinHash = encryptionUtil.hash(userPin).trim()

            if (storedPinHash == inputPinHash) {
                importDatafromCSV(userPin)
            } else {
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

                // Export passwords
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
                }

                // Export the encryption key securely

                val key = encryptionUtil.exportKey()
                //val encryptedKey = encryptionUtil.encryptKeyWithPin(key, userPin)
                val encryptedKey = encryptionUtil.encryptKeyWithPin(key, userPin)
                val keyParts = encryptedKey.chunked(100) // Divide la clave en partes de 100 caracteres
                keyParts.forEach { part ->
                    csvWriter.writeNext(arrayOf("Encryption Key", part))
                }

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
            val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val file = File(downloadsDir, "backup.csv")

            if (!file.exists()) {
                return@launch
            }

            try {
                file.bufferedReader().use { reader ->
                    val csvReader = CSVReader(reader)
                    val csvLines = csvReader.readAll().filter { it.isNotEmpty() }
                    if (csvLines.size < 4) {
                        return@launch
                    }

                    // Clear existing data in the database
                    userRepository.deleteAllUsers()
                    passwordRepository.deleteAllPasswords()

                    // Import user data
                    val userData = csvLines[1].map { it.trim().removeSurrounding("\"") }
                    if (userData.size != 3 || userData.any { it.isEmpty() }) {
                        return@launch
                    }
                    val myUser = User(
                        id = userData[0].toInt(),
                        hashedEmail = userData[1],
                        hashedPassword = userData[2]
                    )
                    userRepository.insertUser(myUser)

                    // Import password data
                    val passwordDataLines = csvLines.drop(3)
                        .takeWhile { !it[0].trim().startsWith("Encryption Key", ignoreCase = true) }
                    passwordDataLines.forEach { line ->
                        val passwordData = line.map { it.trim().removeSurrounding("\"") }
                        if (passwordData.size != 5 || passwordData.any { it.isEmpty() }) {
                            return@forEach
                        }
                        val myPassword = Password(
                            id = passwordData[0].toInt(),
                            website = passwordData[1],
                            userName = passwordData[2],
                            password = passwordData[3],
                            isFavorite = passwordData[4].toBoolean()
                        )
                        passwordRepository.insertPassword(myPassword)
                    }

                    // Import the encryption key securely
                    val encryptedKey = StringBuilder()
                    var readingKey = false
                    for (line in csvLines) {

                        if (line[0].trim().equals("Encryption Key", ignoreCase = true)) {
                            readingKey = true
                        }
                        if(readingKey) {
                            encryptedKey.append(line[1].trim().removeSurrounding("\n"))
                            //Log.d("BackupViewModel", "Parches de encryptedKey = $encryptedKey")
                        }

                    }

                    if (encryptedKey.isNotEmpty()) {
                        try {
                            val key = encryptionUtil.decryptKeyWithPin(encryptedKey.trim().toString(), userPin)
                            encryptionUtil.importKey(key)
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