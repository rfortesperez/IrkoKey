package com.example.irkokey.presentation.modules.favoritePasswords

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.domain.models.Password
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val passwordRepository: PasswordRepository): ViewModel() {

    private val _allFavorites: LiveData<List<Password>> = passwordRepository.getAllFavorites().asLiveData()
    val allFavorites: LiveData<List<Password>> get() = _allFavorites

    // get all favorites
    fun getAllFavorites() {
        passwordRepository.getAllFavorites()
    }
}