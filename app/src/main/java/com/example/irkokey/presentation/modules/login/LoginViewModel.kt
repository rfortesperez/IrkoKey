package com.example.irkokey.presentation.modules.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val encryptionUtil: EncryptionUtil
) : ViewModel() {

    private val PIN_LENGTH = 6

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> get() = _isError

    private fun isEmailValidRegex(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    private fun isPindValid(pin: String): Boolean {
        return pin.length >= PIN_LENGTH
    }


    fun didClickOnLogin(mail: String, pin: String) {

        Log.d("LoginViewModel", "didClickOnLogin: $mail, $pin")
        val isMailCorrect = isEmailValidRegex(mail)
        val isPinCorrect = isPindValid(pin)

        viewModelScope.launch {
            val user = userRepository.getUser(1)
            Log.d("LoginViewModel", "DATABASE HashedEmail: ${user.hashedEmail}, DATABASE HashedPassword: ${user.hashedPassword}")
            val dbHashEmail = user.hashedEmail
            val dbHashPassword = user.hashedPassword
            val hashEmail = encryptionUtil.hash(mail)
            val hashPassword = encryptionUtil.hash(pin)
            Log.d("LoginViewModel", "HashEmail: $hashEmail, HashPassword: $hashPassword")

            if(isMailCorrect && isPinCorrect && dbHashEmail == hashEmail && dbHashPassword == hashPassword) {
                Log.d("LoginViewModel", "Datos correctos")
                _isError.value = false
            } else {
                Log.d("LoginViewModel", "Datos incorrectos")
                _isError.value = true
            }
        }
    }
}