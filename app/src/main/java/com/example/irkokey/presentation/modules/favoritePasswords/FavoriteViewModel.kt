package com.example.irkokey.presentation.modules.favoritePasswords

import android.content.ClipData
import android.content.ClipboardManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.common.utils.SingleLiveEvent
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.domain.models.Password
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for managing favorite passwords.
 * @param passwordRepository The repository for accessing password data.
 * @param clipboardManager The system clipboard manager.
 * @param encryptionUtil The utility for encrypting and decrypting passwords.
 */

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val passwordRepository: PasswordRepository,
    private val clipboardManager: ClipboardManager,
    private val encryptionUtil: EncryptionUtil
) : ViewModel() {

    // LiveData for observing the list of all favorite passwords
    private val _allFavorites: LiveData<List<Password>> =
        passwordRepository.getAllFavorites().asLiveData()
    val allFavorites: LiveData<List<Password>> get() = _allFavorites

    // LiveData for observing the copy status of a password
    private val _isCopied = SingleLiveEvent<Boolean>()
    val isCopied: LiveData<Boolean> get() = _isCopied

    /**
     * Fetches all favorite passwords from the repository.
     */
    fun getAllFavorites() {
        passwordRepository.getAllFavorites()
    }

    /**
     * Copies the decrypted password to the clipboard and clears it after 30 seconds.
     * @param encryptedPassword The encrypted password to be copied.
     */
    @OptIn(DelicateCoroutinesApi::class)
    fun copyPassword(encryptedPassword: String) {
        var decryptedPassword = ""
        viewModelScope.launch {
            decryptedPassword = encryptionUtil.decrypt(encryptedPassword)
        }

        val clipboard = ClipData.newPlainText("password", decryptedPassword)
        clipboardManager.setPrimaryClip(clipboard)
        _isCopied.value = true

        // Clear clipboard after 30 seconds
        GlobalScope.launch(Dispatchers.IO) {
            delay(30000L)
            clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""))
        }
    }


    /**
     * Removes a password from the favorites.
     * @param password The password to be removed from favorites.
     */
    fun removeFavorite(password: Password) {
        viewModelScope.launch {
            passwordRepository.changeFavorite(password.id)
        }
    }
}