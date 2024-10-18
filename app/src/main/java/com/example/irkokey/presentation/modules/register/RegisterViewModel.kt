package com.example.irkokey.presentation.modules.register

import android.util.Log
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

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val prefs: Preferences,
    private val userRepository: UserRepository,
    private val encryptionUtil: EncryptionUtil
) : ViewModel() {

    private val PIN_LENGHT = 6

    private val _isError = SingleLiveEvent<Boolean>()
    val isError: LiveData<Boolean> get() = _isError

    private fun isMailValidRegex(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    private fun isPinValid(pin: String): Boolean {
        return pin.length >= PIN_LENGHT
    }


    fun didClickOnRegister(email: String, pin: String, confirmPin: String) {
        val isMailCorrect = isMailValidRegex(email)
        val isPassCorrect = isPinValid(pin)
        val isConfirmPassCorrect = isPinValid(confirmPin)

        if (isMailCorrect && isPassCorrect && isConfirmPassCorrect && pin == confirmPin) {
            Log.d("RegisterViewModel", "datos usuario correctos")

            val hashedEmail = encryptionUtil.hash(email)
            Log.d("RegisterViewModel", "email Hash: $hashedEmail")
            val hashedPassword = encryptionUtil.hash(pin)
            Log.d("RegisterViewModel", "password Hash: $hashedPassword")

            Log.d("RegisterViewModel", "PIN usuario ENCRIPTADO")
            val user = User(hashedEmail = hashedEmail, hashedPassword = hashedPassword)
            registerUser(user)
            Log.d("RegisterViewModel", "procediendo a registrar al usuario en la base de datos...")

            prefs.mail = hashedEmail
            Log.d("RegisterViewModel", "USUARIO REGISTRADO en shared PREFERENCES")
            _isError.value = false
        } else {
            _isError.value = true
        }

    }

    private fun registerUser(user: User) {
        viewModelScope.launch {
            Log.d("RegisterViewModel", "insertando usuario en la base de datos")
            userRepository.insertUser(user)
            Log.d("RegisterViewModel", "usuario insertado en la base de datos con éxito")
        }
    }
}