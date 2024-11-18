package com.example.irkokey.presentation.modules.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.irkokey.R
import com.example.irkokey.databinding.FragmentLoginBinding
import com.example.irkokey.presentation.modules.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * Fragment for handling user login.
 * This fragment is annotated with `@AndroidEntryPoint` to support dependency injection with Hilt.
 */

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        observeViewModel()
    }

    /**
     * Set up the UI components and their click listeners.
     */
    private fun setupUI() {
        with(binding) {
            btnLogin.setOnClickListener { handleLoginClick() }
        }
    }

    /**
     * Handles the login button click event.
     */
    private fun handleLoginClick() {
        with(binding) {
            loginViewModel.didClickOnLogin(
                etEmail.text.toString(),
                etPasswordInput.text.toString()
            )
        }
    }

    /**
     * Observes the ViewModel LiveData properties and updates the UI accordingly.
     */
    private fun observeViewModel() {
        loginViewModel.isError.observe(viewLifecycleOwner) { isError ->
            if (isError) {
                showToast(getString(R.string.wrong))
            } else {
                showToast(getString(R.string.login_success))
                navigateToMainActivity()
            }
        }
    }

    /**
     * Shows a toast message.
     *
     * @param message The message to be displayed in the toast.
     */
    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Navigates to the MainActivity and finishes the current activity.
     */
    private fun navigateToMainActivity() {
        startActivity(Intent(context, MainActivity::class.java))
        activity?.finish()
    }
}