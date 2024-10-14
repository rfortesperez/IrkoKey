package com.example.irkokey.presentation.modules.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.irkokey.R
import com.example.irkokey.presentation.modules.auth.AuthActivity
import com.example.irkokey.presentation.modules.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        splashViewModel.initFlow()
        splashViewModel.isLogged.observe(this) {
            val destination = if (it) MainActivity::class.java else AuthActivity::class.java
            startActivity(Intent(this, destination))
            finish()

        }
    }
}