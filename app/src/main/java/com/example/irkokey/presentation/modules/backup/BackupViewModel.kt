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
                exportDatabaseToJson(userPin)
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
                importDatafromJson(userPin)
            } else {
                _isImported.postValue(false)
            }
        }
    }


    private fun exportDatabaseToJson(userPin: String) {
        val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val jsonFile = File(downloadsDir, "backup.json")

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(BackupData::class.java)

        viewModelScope.launch {

            val user = userRepository.getUser(1)
            Log.d("BackupViewModel", "User retrieved: $user")
            val passwords = passwordRepository.getAllPasswordsList()
            Log.d("BackupViewModel", "Passwords retrieved: $passwords")

            // get the keyset from the keystore
            val keyset = encryptionUtil.getKeyset()
            Log.d("BackupViewModel", "Keyset retrieved: $keyset")

            val backupData = BackupData(
                user = user,
                passwords = passwords,
                keyset = keyset
            )
            _progress.postValue(50)
            val json = adapter.toJson(backupData)
            Log.d("BackupViewModel", "JSON created: $json")

            // Encrypt the JSON before saving it
            val encryptedJson = encryptionUtil.encryptJson(json, userPin) // Use the PIN to encrypt
            Log.d("BackupViewModel", "Encrypted JSON created: $encryptedJson")

            jsonFile.writeText(encryptedJson)
            Log.d("BackupViewModel", "Encrypted JSON saved to file: ${jsonFile.absolutePath}")
            _isExported.value= true
            _progress.postValue(100)

        }
    }

    private fun importDatafromJson(userPin: String) {
        val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val jsonFile = File(downloadsDir, "backup.json")

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(BackupData::class.java)

        try {
            // Read the encrypted JSON from the file
            val encryptedJson = jsonFile.readText()

            // Decrypt the Json using the user Pin
            val json = encryptionUtil.decryptJson(encryptedJson, userPin)
            Log.d("BackupViewModel", "Decrypted JSON: $json")

            // Parse the Json to retrieve the BackupData
            val backupData = adapter.fromJson(json)

            if (backupData != null) {
                viewModelScope.launch {

                    // Restore the user data
                    userRepository.insertUser(backupData.user)
                    Log.d("BackupViewModel", "User restored: ${backupData.user}")

                    // Restore the passwords
                    for (password in backupData.passwords) {
                        passwordRepository.insertPassword(password)
                        Log.d("BackupViewModel", "Password restored: $password")
                    }

                    // Restore keyset to the Android Keystore
                    encryptionUtil.setKeySet(backupData.keyset)
                    Log.d("BackupViewModel", "Keyset restored: ${backupData.keyset}")

                    _progress.postValue(100)
                    _isImported.postValue(true)
                }
            } else {
                Log.e("BackupViewModel", "Failed to parse backup data")
                _isImported.postValue(false)
            }
        }catch(e: Exception){
            Log.e("BackupViewModel", "Failed to import backup data", e)
            _isImported.postValue(false)
        }
    }
}