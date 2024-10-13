package com.example.irkokey.presentation.modules.passwords

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.domain.models.Password
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PasswordsViewModel @Inject constructor(private val passwordRepository: PasswordRepository): ViewModel() {

    private val _allPasswords: LiveData<List<Password>> = passwordRepository.getAllPasswords().asLiveData()
    val allPasswords: LiveData<List<Password>> get() = _allPasswords

    // get all passwords
    fun getAllPasswords() {
        passwordRepository.getAllPasswords()
    }
}