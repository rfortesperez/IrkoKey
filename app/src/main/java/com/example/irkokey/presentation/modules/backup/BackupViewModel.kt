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
import com.example.irkokey.domain.models.BackupData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.File
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
                exportDatabaseToJson()
            } else {
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

            if (storedPinHash == inputPinHash) {
                importDatafromJson()
            } else {
                _isImported.postValue(false)
            }
        }
    }


    private fun exportDatabaseToJson() {
        val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val jsonFile = File(downloadsDir, "backup.json")

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(BackupData::class.java)

        viewModelScope.launch {
            val user = userRepository.getUser(1)
            val passwords = passwordRepository.getAllPasswordsList()

            Log.d("BackupViewModel", "PASO UNO DE EXPORTACION")
            val backupData = BackupData(user = user, passwords = passwords)
            val json = adapter.toJson(backupData)
            Log.d("BackupViewModel", "Backup JSON: $json")

            // Encrypt the JSON before saving it
            val encryptedJson = encryptionUtil.encrypt(json).trim().replace("\n", "")
            Log.d("BackupViewModel", "Encrypted data: $encryptedJson")

            Log.d("BackupViewModel", "PASO DOS DE EXPORTACION")


            val backupJson = """
            {
                "data": "$encryptedJson"
            }""".trimIndent()

            Log.d("BackupViewModel", "Backup JSON: $backupJson")

            Log.d("BackupViewModel", "PASO TRES DE EXPORTACION")
            // Save the JSON to a file
            jsonFile.writeText(backupJson)
            Log.d("BackupViewModel", "Backup JSON saved to file successfully!")
            Log.d("BackupViewModel", "------------------------------------------------")
            Log.d("BackupViewModel", "- ******************************************** -")
            Log.d("BackupViewModel", "------------------------------------------------")
            _isExported.value = true
            _progress.postValue(100)
        }
    }

    private fun importDatafromJson() {

        val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val jsonFile = File(downloadsDir, "backup.json")

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(BackupData::class.java)

        try {
            Log.d("BackupViewModel", "PASO UNO DE IMPORTACION")
            // Read the JSON from the file
            Log.d("BackupViewModel", "Reading JSON from file")
            val backupJson = jsonFile.readText()
            Log.d("BackupViewModel", "Backup JSON: $backupJson")
            val jsonObject = JSONObject(backupJson)
            Log.d("BackupViewModel", "convirtiendo a jsonobject")
            Log.d("BackupViewModel", "JSON object: $jsonObject")


            Log.d("BackupViewModel", "PASO DOS DE IMPORTACION")
            val encryptedData = jsonObject.getString("data")

            Log.d("BackupViewModel", "PASO TRES DE IMPORTACION")

            // Decrypt the JSON

            Log.d("BackupViewModel", "PASO CUATRO DE IMPORTACION")
            val json = encryptionUtil.decrypt(encryptedData)
            Log.d("BackupViewModel", "Decrypted data: $encryptedData")
            val backupData = adapter.fromJson(json)
            Log.d("BackupViewModel", "Backup data: $backupData")

            Log.d("BackupViewModel", "PASO CINCO DE IMPORTACION")
            if (backupData != null) {
                viewModelScope.launch {
                    userRepository.insertUser(backupData.user)
                    Log.d("BackupViewModel", "User = ${backupData.user}")
                    Log.d("BackupViewModel", "User imported")
                    for (password in backupData.passwords) {
                        passwordRepository.insertPassword(password)
                        Log.d("BackupViewModel", "Password = $password")
                    }
                    Log.d("BackupViewModel", "Passwords imported")
                    Log.d("BackupViewModel", "Data imported successfully!")

                    Log.d("BackupViewModel", "SE ACABÓ LA IMPORTASIOOON")

                    _progress.postValue(100)
                    _isImported.postValue(true)
                }
            } else {
                _isImported.postValue(false)
            }
        } catch (e: Exception) {
            _isImported.postValue(false)
        }
    }
}