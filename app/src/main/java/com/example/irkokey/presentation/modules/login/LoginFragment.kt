package com.example.irkokey.presentation.modules.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.irkokey.R
import com.example.irkokey.databinding.FragmentLoginBinding
import com.example.irkokey.presentation.modules.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        Log.d("LoginFragment", "onCreateView: LoginFragment creado")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("LoginFragment", "onViewCreated: LoginFragment creado")

        with(binding) {
            btnLogin.setOnClickListener {
                loginViewModel.didClickOnLogin(
                    etEmail.text.toString(),
                    etPasswordInput.text.toString()
                )
            }
        }

        loginViewModel.isError.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(context, "Wrong email or password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, MainActivity::class.java))
                activity?.finish()
            }
        }
    }
}