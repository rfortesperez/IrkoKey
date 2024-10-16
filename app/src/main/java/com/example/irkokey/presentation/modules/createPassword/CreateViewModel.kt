package com.example.irkokey.presentation.modules.createPassword

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.common.utils.PasswordStrengthUtil
import com.example.irkokey.common.utils.SingleLiveEvent
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.domain.models.Password
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    application: Application,
    private val passwordRepository: PasswordRepository,
    private val encryptionUtil: EncryptionUtil,

    ) : AndroidViewModel(application) {

    private val _isCorrect = SingleLiveEvent<Boolean>()
    val isCorrect: LiveData<Boolean> get() = _isCorrect

    private val _isComplete = SingleLiveEvent<Boolean>()
    val isComplete: LiveData<Boolean> get() = _isComplete

    init {
        encryptionUtil.initialize(application)
    }


    private fun savePassword(password: Password) {
        viewModelScope.launch {
            val encryptedPassword = encryptionUtil.encrypt(password.password)
            Log.d("CreateViewModel", "Encrypted password: $encryptedPassword")
            val encryptedPasswordObj = password.copy(password = encryptedPassword)
            passwordRepository.insertPassword(encryptedPasswordObj)
        }
    }


    fun didClickSaveButton(website: String, username: String, password: String) {
        if (website.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
            _isComplete.value = true
            if (isPasswordStrong(password)) {
                _isCorrect.value = true

                savePassword(Password(website = website, userName = username, password = password))

            } else {
                _isCorrect.value = false
            }
        } else {
            _isComplete.value = false
        }
    }

    private fun isPasswordStrong(password: String): Boolean {
        return PasswordStrengthUtil.isPasswordStrong(password)
    }
}