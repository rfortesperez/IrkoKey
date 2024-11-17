package com.example.irkokey.presentation.modules.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.irkokey.databinding.ActivityAuthBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Activity class for handling authentication.
 * This activity is annotated with `@AndroidEntryPoint` to support dependency injection with Hilt.
 */
@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    //private val authViewModel: AuthViewModel by viewModels()
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}