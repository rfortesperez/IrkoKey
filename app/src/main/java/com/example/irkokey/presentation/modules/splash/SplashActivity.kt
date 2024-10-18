package com.example.irkokey.presentation.modules.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.irkokey.R
import com.example.irkokey.presentation.modules.auth.AuthActivity
import com.example.irkokey.presentation.modules.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel.initFlow()
        splashViewModel.isLogged.observe(this) {isLogged ->
            val destination = if (isLogged == true)
                AuthActivity::class.java else RegisterActivity::class.java
            Log.d("SplashActivity", "Navegando a $destination")
            startActivity(Intent(this, destination))
            finish()
        }
    }
}