package com.example.irkokey.presentation.modules.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.irkokey.common.infraestructure.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val prefs: Preferences): ViewModel() {

    private val _isLogged: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isLogged: LiveData<Boolean> get() = _isLogged

    fun initFlow() {

        Handler(Looper.getMainLooper()).postDelayed({
            _isLogged.value = prefs.mail?.let { true } ?: false
        }, 2000)
    }

}