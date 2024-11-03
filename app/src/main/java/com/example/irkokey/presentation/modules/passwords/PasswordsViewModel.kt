package com.example.irkokey.presentation.modules.passwords

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.util.Log
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordsViewModel @Inject constructor(
    private val passwordRepository: PasswordRepository,
    private val clipboardManager: ClipboardManager,
    val encryptionUtil: EncryptionUtil
) : ViewModel() {

    private val _allPasswords: LiveData<List<Password>> = passwordRepository.getAllPasswords().asLiveData()
    val allPasswords: LiveData<List<Password>> get() = _allPasswords

    private val _isCorrect = SingleLiveEvent<Boolean>()
    val isCorrect: LiveData<Boolean> get() = _isCorrect

    private val _showEditPasswordDialog = SingleLiveEvent<Password>()
    val showEditPasswordDialog: LiveData<Password> get() = _showEditPasswordDialog

    private val _showDeleteConfirmation = SingleLiveEvent<Password>()
    val showDeleteConfirmation: LiveData<Password> get() = _showDeleteConfirmation

    private val _isCopied = SingleLiveEvent<Boolean>()
    val isCopied: LiveData<Boolean> get() = _isCopied

    fun handlePasswordAction(action: PasswordAction) {
        when (action) {
            is PasswordAction.Delete -> confirmDeletePassword(action.password)
            is PasswordAction.Edit -> showEditPasswordDialog(action.password)
            is PasswordAction.AddFavorite -> addFavorite(action.password)
            is PasswordAction.CopyPassword -> copyPassword(action.password.password)
        }
    }

    private fun confirmDeletePassword(password: Password) {
        _showDeleteConfirmation.value = password
    }

    private fun addFavorite(password: Password) {
        viewModelScope.launch {
            passwordRepository.changeFavorite(password.id)
        }
    }

    fun deletePassword(password: Password) {
        viewModelScope.launch {
            passwordRepository.deletePassword(password.id)
        }
    }

    private fun showEditPasswordDialog(password: Password){
        _showEditPasswordDialog.value = password
    }

    fun editPassword(password: Password, newPassword: String) {
        viewModelScope.launch {
            if (isPasswordStrong(newPassword)) {
                val encryptedPassword = encryptionUtil.encrypt(newPassword)
                passwordRepository.updatePassword(password.id, encryptedPassword)
            } else {
                _isCorrect.value = false
            }
        }
    }

    private fun isPasswordStrong(newPassword: String): Boolean {
        return PasswordStrengthUtil.isPasswordStrong(newPassword)
    }

    private fun copyPassword(encryptedPassword: String) {
        val decryptedPassword = encryptionUtil.decrypt(encryptedPassword)
        val clipboard = ClipData.newPlainText("password", decryptedPassword)
        clipboardManager.setPrimaryClip(clipboard)
        _isCopied.value = true
        GlobalScope.launch(Dispatchers.IO) {
            delay(30000L)
            clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""))
        }
    }

    fun getDecryptedPassword(encryptedPassword: String): String {
        return encryptionUtil.decrypt(encryptedPassword)
    }
}