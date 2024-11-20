package com.example.irkokey.presentation.modules.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.irkokey.common.infraestructure.Preferences
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.common.utils.SingleLiveEvent
import com.example.irkokey.data.repository.UserRepository
import com.example.irkokey.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Length of the PIN
private const val PIN_LENGTH = 6

/**
 * ViewModel for the RegisterActivity.
 * Handles user registration logic.
 *
 * @property prefs Preferences instance for storing user data.
 * @property userRepository UserRepository instance for database operations.
 * @property encryptionUtil EncryptionUtil instance for hashing user data.
 */
@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val prefs: Preferences,
    private val userRepository: UserRepository,
    private val encryptionUtil: EncryptionUtil
) : ViewModel() {

    // LiveData for error handling
    private val _isError = SingleLiveEvent<Boolean>()
    val isError: LiveData<Boolean> get() = _isError

    /**
     * Validates the email using a regex pattern.
     *
     * @param email The email to be validated.
     * @return True if the email is valid, false otherwise.
     */
    private fun isMailValidRegex(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    /**
     * Validates the PIN length.
     *
     * @param pin The PIN to be validated.
     * @return True if the PIN length is valid, false otherwise.
     */
    private fun isPinValid(pin: String): Boolean {
        return pin.length >= PIN_LENGTH
    }

    /**
     * Handles the register button click event.
     * Validates the email and PIN, hashes them, and stores the user data.
     *
     * @param email The user's email.
     * @param pin The user's PIN.
     * @param confirmPin The confirmation PIN.
     */
    fun didClickOnRegister(email: String, pin: String, confirmPin: String) {
        val isMailCorrect = isMailValidRegex(email)
        val isPassCorrect = isPinValid(pin)
        val isConfirmPassCorrect = isPinValid(confirmPin)

        if (isMailCorrect && isPassCorrect && isConfirmPassCorrect && pin == confirmPin) {
            val hashedEmail = encryptionUtil.hash(email)
            val hashedPassword = encryptionUtil.hash(pin)

            val user = User(hashedEmail = hashedEmail, hashedPassword = hashedPassword)
            registerUser(user)

            prefs.mail = hashedEmail
            prefs.pin = hashedPassword
            _isError.value = false
        } else {
            _isError.value = true
        }
    }

    /**
     * Registers the user in the database.
     *
     * @param user The user to be registered.
     */
    private fun registerUser(user: User) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }
}