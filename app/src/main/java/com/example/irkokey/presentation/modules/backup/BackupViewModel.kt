package com.example.irkokey.presentation.modules.backup

import android.app.Application
import android.net.Uri
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
import javax.inject.Inject

@HiltViewModel
class BackupViewModel @Inject constructor(
    private val application: Application,
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

    private val _isPinCorrect = SingleLiveEvent<Boolean>()
    val isPinCorrect: LiveData<Boolean> get() = _isPinCorrect

    // Request the user to enter the PIN and export the data
    fun requestPinAndExport(userPin: String, uri: Uri) {
        viewModelScope.launch {
            val user = userRepository.getUser(1)
            val storedPinHash = user.hashedPassword.trim()
            val inputPinHash = encryptionUtil.hash(userPin).trim()

            if (storedPinHash == inputPinHash) {
                _isPinCorrect.postValue(true)
                exportDatabaseToJson(uri)
            } else {
                _isPinCorrect.postValue(false)
                _isExported.postValue(false)
            }
        }
    }

    // Request the user to enter the PIN and import the data
    fun requestPinAndImport(userPin: String, uri: Uri) {

        viewModelScope.launch {
            val user = userRepository.getUser(1)
            val storedPinHash = user.hashedPassword.trim()
            val inputPinHash = encryptionUtil.hash(userPin).trim()

            if (storedPinHash == inputPinHash) {
                _isPinCorrect.postValue(true)
                importDatafromJson(uri)
            } else {
                _isPinCorrect.postValue(false)
                _isImported.postValue(false)
            }
        }
    }


    private fun exportDatabaseToJson(uri: Uri) {

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(BackupData::class.java)

        viewModelScope.launch {
            val user = userRepository.getUser(1)
            val passwords = passwordRepository.getAllPasswordsList()

            val backupData = BackupData(user = user, passwords = passwords)
            val json = adapter.toJson(backupData)

            // Encrypt the JSON before saving it
            val encryptedJson = encryptionUtil.encrypt(json).trim().replace("\n", "")
            val backupJson = """
            {
                "data": "$encryptedJson"
            }""".trimIndent()

            // Save the JSON to the provided URI
            try {
                val contentResolver = application.contentResolver
                val outputStream = contentResolver.openOutputStream(uri, "wt")
                outputStream?.use {
                    it.write(backupJson.toByteArray())
                    _isExported.value = true
                    _progress.postValue(100)
                }
            }catch (e: Exception){
                _isExported.value = false
            }
        }
    }

    private fun importDatafromJson(uri: Uri) {

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(BackupData::class.java)

        try {
            // Read the JSON from the file
            val inputStream = application.contentResolver.openInputStream(uri)
            val backupJson = inputStream?.bufferedReader().use { it?.readText() } ?: ""
            val jsonObject = JSONObject(backupJson)
            val encryptedData = jsonObject.getString("data")

            // Decrypt the JSON
            val json = encryptionUtil.decrypt(encryptedData)
            val backupData = adapter.fromJson(json)

            if (backupData != null) {
                viewModelScope.launch {
                    userRepository.insertUser(backupData.user)

                    for (password in backupData.passwords) {
                        passwordRepository.insertPassword(password)
                    }
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