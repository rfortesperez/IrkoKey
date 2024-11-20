package com.example.irkokey.presentation.modules.passwords

import android.content.ClipData
import android.content.ClipboardManager
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

/**
 * ViewModel class for managing password-related actions and data.
 * This ViewModel is annotated with `@HiltViewModel` to support dependency injection with Hilt.
 *
 * @property passwordRepository The repository for password data.
 * @property clipboardManager The system clipboard manager.
 * @property encryptionUtil The utility class for encryption and decryption.
 */
@HiltViewModel
class PasswordsViewModel @Inject constructor(
    private val passwordRepository: PasswordRepository,
    private val clipboardManager: ClipboardManager,
    val encryptionUtil: EncryptionUtil
) : ViewModel() {

    // LiveData for all passwords
    private val _allPasswords: LiveData<List<Password>> = passwordRepository.getAllPasswords().asLiveData()
    val allPasswords: LiveData<List<Password>> get() = _allPasswords

    // LiveData to check if a password is correct
    private val _isCorrect = SingleLiveEvent<Boolean>()
    val isCorrect: LiveData<Boolean> get() = _isCorrect

    // LiveData to show the edit password dialog
    private val _showEditPasswordDialog = SingleLiveEvent<Password>()
    val showEditPasswordDialog: LiveData<Password> get() = _showEditPasswordDialog

    // LiveData to show the delete confirmation dialog
    private val _showDeleteConfirmation = SingleLiveEvent<Password>()
    val showDeleteConfirmation: LiveData<Password> get() = _showDeleteConfirmation

    // LiveData to check if a password is copied
    private val _isCopied = SingleLiveEvent<Boolean>()
    val isCopied: LiveData<Boolean> get() = _isCopied

    // LiveData to check if a password is favorite
    private val _isFavorite = SingleLiveEvent<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    /**
     * Handles different password actions.
     *
     * @param action The action to be handled.
     */
    fun handlePasswordAction(action: PasswordAction) {
        when (action) {
            is PasswordAction.Delete -> confirmDeletePassword(action.password)
            is PasswordAction.Edit -> showEditPasswordDialog(action.password)
            is PasswordAction.AddFavorite -> addFavorite(action.password)
            is PasswordAction.CopyPassword -> copyPassword(action.password.password)
        }
    }

    /**
     * Confirms the deletion of a password.
     *
     * @param password The password to be deleted.
     */
    private fun confirmDeletePassword(password: Password) {
        _showDeleteConfirmation.value = password
    }

    /**
     * Adds a password to the favorites list.
     *
     * @param password The password to be added to favorites.
     */
    private fun addFavorite(password: Password) {
        viewModelScope.launch {
            passwordRepository.changeFavorite(password.id)
            _isFavorite.value = password.isFavorite
        }
    }

    /**
     * Deletes a password.
     *
     * @param password The password to be deleted.
     */
    fun deletePassword(password: Password) {
        viewModelScope.launch {
            passwordRepository.deletePassword(password.id)
        }
    }

    /**
     * Shows the edit password dialog.
     *
     * @param password The password to be edited.
     */
    private fun showEditPasswordDialog(password: Password){
        _showEditPasswordDialog.value = password
    }
    /**
     * Edits a password.
     *
     * @param password The password to be edited.
     * @param newPassword The new password value.
     */
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

    /**
     * Checks if a password is strong.
     *
     * @param newPassword The new password to be checked.
     * @return True if the password is strong, false otherwise.
     */
    private fun isPasswordStrong(newPassword: String): Boolean {
        return PasswordStrengthUtil.isPasswordStrong(newPassword)
    }

    /**
     * Copies a password to the clipboard.
     *
     * @param encryptedPassword The encrypted password to be copied.
     */
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

    /**
     * Decrypts a password.
     *
     * @param encryptedPassword The encrypted password to be decrypted.
     * @return The decrypted password.
     */
    fun getDecryptedPassword(encryptedPassword: String): String {
        return encryptionUtil.decrypt(encryptedPassword)
    }
}