package com.example.irkokey.presentation.modules.passwords

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.irkokey.common.utils.SingleLiveEvent
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.domain.models.Password
import com.example.irkokey.presentation.modules.createPassword.CreateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordsViewModel @Inject constructor(private val passwordRepository: PasswordRepository) : ViewModel() {

    private val _allPasswords: LiveData<List<Password>> = passwordRepository.getAllPasswords().asLiveData()
    val allPasswords: LiveData<List<Password>> get() = _allPasswords

    // Use SingleLiveEvent for isCorrect
    private val _isCorrect = SingleLiveEvent<Boolean>()
    val isCorrect: LiveData<Boolean> get() = _isCorrect

    private val createViewModel = CreateViewModel(passwordRepository)


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
            if (createViewModel.isPasswordStrong(newPassword)) {
                passwordRepository.updatePassword(password.id, newPassword)
            } else {
                _isCorrect.value = false
            }
        }
    }

    fun copyPassword(password: Password) {
        // TODO: Implement this method
    }

    fun copyUserName(password: Password) {
        // TODO: Implement this method
    }
}