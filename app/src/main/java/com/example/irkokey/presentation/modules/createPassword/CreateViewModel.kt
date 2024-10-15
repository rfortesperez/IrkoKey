package com.example.irkokey.presentation.modules.createPassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.common.utils.PasswordStrengthUtil
import com.example.irkokey.common.utils.SingleLiveEvent
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.domain.models.Password
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.crypto.SecretKey
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(private val passwordRepository: PasswordRepository, private val encryptionUtil: EncryptionUtil, private val secretKey: SecretKey) : ViewModel() {

    private val _isCorrect = SingleLiveEvent<Boolean>()
    val isCorrect: LiveData<Boolean> get() = _isCorrect

    private val _isComplete = SingleLiveEvent<Boolean>()
    val isComplete: LiveData<Boolean> get() = _isComplete

    fun saveNewPassword(password: Password) {
        viewModelScope.launch {
            val encryptedPassword = encryptionUtil.encrypt(secretKey, password.password)
            val encryptedPasswordObj = password.copy(password = encryptedPassword)
            passwordRepository.insertPassword(encryptedPasswordObj)
        }
    }


    fun didClickSaveButton(website: String, username: String, password: String) {
        if (website.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
            _isComplete.value = true
            if (isPasswordStrong(password)) {
                _isCorrect.value = true
                savePassword(website, username, password)
                _isComplete.value = false
            } else {
                _isCorrect.value = false
            }
        } else {
            _isComplete.value = false
        }
    }

    fun isPasswordStrong(password: String): Boolean {
        return PasswordStrengthUtil.isPasswordStrong(password)
    }



    //method to save the website, username and password
    private fun savePassword(website: String, username: String, password: String) {
        // variable to store the password
        val newPassword = Password(website = website, userName = username, password = password)
        viewModelScope.launch {
            passwordRepository.insertPassword(newPassword)
        }
    }
}