package com.example.irkokey.presentation.modules.passwords

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.databinding.FragmentPasswordsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PasswordsFragment : Fragment() {

    private lateinit var binding: FragmentPasswordsBinding

    @Inject
    lateinit var passwordRepository: PasswordRepository
    private val viewModel: PasswordsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPasswordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            rvPasswords.layoutManager = LinearLayoutManager(context)

            viewModel.allPasswords.observe(viewLifecycleOwner) { passwords ->
                rvPasswords.adapter = PasswordsViewAdapter(passwords)
            }
        }
    }
}