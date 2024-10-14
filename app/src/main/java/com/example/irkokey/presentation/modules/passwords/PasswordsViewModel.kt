package com.example.irkokey.presentation.modules.passwords

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.domain.models.Password
import com.example.irkokey.presentation.modules.createPassword.CreateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordsViewModel @Inject constructor(private val passwordRepository: PasswordRepository) :
    ViewModel() {

    private val _allPasswords: MutableLiveData<List<Password>> = MutableLiveData()
    val allPasswords: LiveData<List<Password>> get() = _allPasswords

    // liveData to check if password is favorite
    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    // liveData to check if new password is good enough to replace old password
    private val _isCorrect = MutableLiveData<Boolean>()
    val isCorrect: LiveData<Boolean> get() = _isCorrect

    val createViewModel = CreateViewModel(passwordRepository)

    // get all passwords
    fun getAllPasswords() {
        viewModelScope.launch {
            passwordRepository.getAllPasswords().asLiveData().observeForever {
                _allPasswords.value = it
            }
        }
    }

    fun addFavorite(password: Password): Unit {
        viewModelScope.launch {
            val isFavorite = _isFavorite.value ?: false
            passwordRepository.changeFavorite(password.id, !isFavorite)
            _isFavorite.value = !isFavorite
        }
    }

    fun deletePassword(password: Password): Unit {
        viewModelScope.launch {
            passwordRepository.deletePassword(password.id)
        }
    }

    fun editPassword(password: Password, newPassword: String): Unit {
        viewModelScope.launch {
            if (createViewModel.isPasswordStrong(newPassword)) {
                passwordRepository.updatePassword(password.id, newPassword)
            } else {
                _isCorrect.value = false
            }
        }
    }

    fun copyPassword(password: Password): Unit {
        // TODO: Implement this method
    }

    fun copyUserName(password: Password): Unit {
        // TODO: Implement this method
    }
}