package com.example.irkokey.presentation.modules.createPassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.domain.models.Password
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(private val passwordRepository: PasswordRepository) : ViewModel() {

    private val _isCorrect = MutableLiveData<Boolean>()
    val isCorrect: LiveData<Boolean> get() = _isCorrect

    private val _isComplete = MutableLiveData<Boolean>()
    val isComplete: LiveData<Boolean> get() = _isComplete

    fun dicClickSaveButton(website: String, username: String, password: String) {
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
        return password.length >= 12 &&
                containsLowerCase(password) &&
                containsUpperCase(password) &&
                containsDigit(password) &&
                containsSpecialCharacter(password)
    }

    // method to check if the password contains lowercase letters
    private fun containsLowerCase(password: String): Boolean {
        val regex = Regex("[a-z]")
        return regex.containsMatchIn(password)
    }

    // method to check if the password contains uppercase letters
    private fun containsUpperCase(password: String): Boolean {
        val regex = Regex("[A-Z]")
        return regex.containsMatchIn(password)
    }

    // method to check if the password contains digits
    private fun containsDigit(password: String): Boolean {
        val regex = Regex("[0-9]")
        return regex.containsMatchIn(password)
    }

    // method to check if the password contains special characters
    private fun containsSpecialCharacter(password: String): Boolean {
        val regex = Regex("[^A-Za-z0-9]")
        return regex.containsMatchIn(password)
    }

    // method to save the website, username and password
    private fun savePassword(website: String, username: String, password: String) {
        // variable to store the password
        val password = Password(website =website, userName = username, password = password)
        viewModelScope.launch {
            passwordRepository.insertPassword(password)
        }

    }

}