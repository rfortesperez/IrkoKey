package com.example.irkokey.presentation.modules.passwords

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
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
class PasswordsViewModel @Inject constructor(private val passwordRepository: PasswordRepository) : ViewModel() {

    private val _allPasswords: LiveData<List<Password>> = passwordRepository.getAllPasswords().asLiveData()
    val allPasswords: LiveData<List<Password>> get() = _allPasswords

    // Use SingleLiveEvent for isCorrect
    private val _isCorrect = SingleLiveEvent<Boolean>()
    val isCorrect: LiveData<Boolean> get() = _isCorrect

    private val _showDeleteConfirmation = SingleLiveEvent<Password>()
    val showDeleteConfirmation: LiveData<Password> get() = _showDeleteConfirmation

    private val secretKey: SecretKey = EncryptionUtil.generateKey()
    private val keyString: String = EncryptionUtil.keyToString(secretKey)



    fun savePassword(password: Password) {
        viewModelScope.launch {
            val encryptedPassword = EncryptionUtil.encrypt(secretKey, password.password)
            val encryptedPasswordObj = password.copy(password = encryptedPassword)
            passwordRepository.insertPassword(encryptedPasswordObj)
        }
    }

    fun confirmDeletePassword(password: Password) {
        _showDeleteConfirmation.value = password
    }

    fun getDecryptedPassword(encryptedPassword: String): String {
        val key = EncryptionUtil.getKeyFromString(keyString)
        return EncryptionUtil.decrypt(key, encryptedPassword)
    }

    fun addFavorite(password: Password) {
        viewModelScope.launch {
            passwordRepository.changeFavorite(password.id)
        }
    }

    fun deletePassword(password: Password) {
        viewModelScope.launch {
            passwordRepository.deletePassword(password.id)
        }
    }

    fun editPassword(password: Password, newPassword: String) {
        viewModelScope.launch {
            if (isPasswordStrong(newPassword)) {
                val encryptedPassword = EncryptionUtil.encrypt(secretKey, newPassword)
                passwordRepository.updatePassword(password.id, encryptedPassword)
            } else {
                _isCorrect.value = false
            }
        }
    }

    private fun isPasswordStrong(newPassword: String): Boolean {
        return PasswordStrengthUtil.isPasswordStrong(newPassword)
    }

    fun copyPassword(password: Password) {
        // TODO: Implement this method
    }

}