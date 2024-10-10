package com.example.irkokey.presentation.modules.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.irkokey.common.infraestructure.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val prefs: Preferences): ViewModel() {

    private val PASSWORD_LENGTH = 4

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> get() = _isError

    private fun isEmailValidRegex(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length >= PASSWORD_LENGTH
    }

    private fun saveUser(mail: String) {
        prefs.mail = mail
    }

    fun didClickOnLogin(mail: String, pass: String) {
        val isMailCorrect = isEmailValidRegex(mail)
        val isPassCorrect = isPasswordValid(pass)

        if (isMailCorrect && isPassCorrect) {
            saveUser(mail)
            _isError.value = false
        } else {
            _isError.value = true
        }
    }

}