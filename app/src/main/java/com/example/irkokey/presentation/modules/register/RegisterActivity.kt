package com.example.irkokey.presentation.modules.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.irkokey.databinding.ActivityRegisterBinding
import com.example.irkokey.presentation.modules.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private val registerViewModel: RegisterViewModel by viewModels()
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            btnRegister.setOnClickListener {
                val email = etEmail.text.toString()
                val password = etPin.text.toString()
                val confirmPassword = etConfirmPin.text.toString()
                registerViewModel.didClickOnRegister(email, password, confirmPassword)
            }
        }

        registerViewModel.isError.observe(this) { isError ->
            if (isError) {
                Toast.makeText(this, "Wrong mail or pin. Please check!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
                finish()
            }
        }
    }
}