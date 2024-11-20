package com.example.irkokey.presentation.modules.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.irkokey.R
import com.example.irkokey.databinding.ActivityRegisterBinding
import com.example.irkokey.presentation.modules.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * Activity for user registration.
 */
@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private val registerViewModel: RegisterViewModel by viewModels()
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRegisterButton()
        observeViewModel()
    }

    /**
     * Sets up the register button click listener.
     */
    private fun setupRegisterButton() {
        with(binding) {
            btnRegister.setOnClickListener {
                val email = etEmail.text.toString()
                val password = etPin.text.toString()
                val confirmPassword = etConfirmPin.text.toString()
                registerViewModel.didClickOnRegister(email, password, confirmPassword)
            }
        }
    }

    /**
     * Observes the ViewModel LiveData and updates the UI accordingly.
     */
    private fun observeViewModel() {
        registerViewModel.isError.observe(this) { isError ->
            if (isError) {
                showToast(getString(R.string.check_again))
            } else {
                showToast(getString(R.string.user_registered))
                navigateToMainActivity()
            }
        }
    }
    /**
     * Shows a toast message.
     * @param message The message to be displayed.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Navigates to the MainActivity.
     */
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}