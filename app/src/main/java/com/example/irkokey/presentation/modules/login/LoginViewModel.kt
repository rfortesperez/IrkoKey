package com.example.irkokey.presentation.modules.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
/**
 * ViewModel class for handling user login logic.
 * This ViewModel is annotated with `@HiltViewModel` to support dependency injection with Hilt.
 *
 * @property userRepository The repository for user data.
 * @property encryptionUtil The utility class for encryption and decryption.
 */

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository, private val encryptionUtil: EncryptionUtil) : ViewModel() {

    private val PIN_LENGTH = 6

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> get() = _isError

    /**
     * Validates the email format using a regular expression.
     *
     * @param email The email to be validated.
     * @return True if the email format is valid, false otherwise.
     */
    private fun isEmailValidRegex(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    /**
     * Validates the PIN length.
     *
     * @param pin The PIN to be validated.
     * @return True if the PIN length is valid, false otherwise.
     */
    private fun isPindValid(pin: String): Boolean {
        return pin.length >= PIN_LENGTH
    }

    /**
     * Validates the user's credentials by comparing the hashed values.
     *
     * @param mail The email to be validated.
     * @param pin The PIN to be validated.
     * @return True if the credentials are valid, false otherwise.
     */
    private suspend fun validateCredentials(mail: String, pin: String): Boolean {
        val user = userRepository.getUser(1)
        val dbHashEmail = user.hashedEmail
        val dbHashPassword = user.hashedPassword
        val hashEmail = encryptionUtil.hash(mail)
        val hashPassword = encryptionUtil.hash(pin)
        return dbHashEmail == hashEmail && dbHashPassword == hashPassword
    }

    /**
     * Handles the login button click event.
     *
     * @param mail The email entered by the user.
     * @param pin The PIN entered by the user.
     */
    fun didClickOnLogin(mail: String, pin: String) {
        val isMailCorrect = isEmailValidRegex(mail)
        val isPinCorrect = isPindValid(pin)

        viewModelScope.launch {
            _isError.value = !(isMailCorrect && isPinCorrect && validateCredentials(mail, pin))
        }
    }
}