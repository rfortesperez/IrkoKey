package com.example.irkokey.presentation.modules.splash

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.irkokey.common.infraestructure.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val prefs: Preferences) : ViewModel() {

    private val _isLogged: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isLogged: MutableLiveData<Boolean> get() = _isLogged

    fun initFlow() {

        Handler(Looper.getMainLooper()).postDelayed({
            _isLogged.value = checkUserLoggedIn()
        }, 2000)
    }

    private fun checkUserLoggedIn(): Boolean {
        Log.d("SplashViewModel", "Verificando si el usuario está logueado...")
        Log.d("SplashViewModel", "Usuario logueado: ${prefs.mail}")
        return prefs.mail?.let { true } ?: false

    }
}