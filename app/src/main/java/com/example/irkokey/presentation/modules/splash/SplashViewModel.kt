package com.example.irkokey.presentation.modules.splash

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.irkokey.common.infraestructure.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for the SplashActivity.
 * Handles the logic for determining if the user is logged in.
 *
 * @property prefs Preferences instance for accessing stored user data.
 */
@HiltViewModel
class SplashViewModel @Inject constructor(private val prefs: Preferences) : ViewModel() {

    private val _isLogged: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isLogged: MutableLiveData<Boolean> get() = _isLogged

    /**
     * Initializes the flow by checking the user's login status after a delay.
     */
    fun initFlow() {
        Handler(Looper.getMainLooper()).postDelayed({
            _isLogged.value = checkUserLoggedIn()
        }, 2000)
    }

    /**
     * Checks if the user is logged in by verifying the presence of an email in preferences.
     *
     * @return True if the user is logged in, false otherwise.
     */
    private fun checkUserLoggedIn(): Boolean {
        return prefs.mail?.let { true } ?: false
    }
}