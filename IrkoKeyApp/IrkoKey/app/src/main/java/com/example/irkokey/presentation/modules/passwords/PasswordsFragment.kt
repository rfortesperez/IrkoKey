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
import com.example.irkokey.domain.models.Password
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PasswordsFragment : Fragment() {

    private lateinit var binding: FragmentPasswordsBinding
    private val viewModel: PasswordsViewModel by viewModels()
    private lateinit var passwordsList: List<Password>

    @Inject
    lateinit var passwordRepository: PasswordRepository


    private val listener = object : OnItemClick {

        override fun onDeleteClick(position: Int) {
            val password = passwordsList[position]
            viewModel.deletePassword(password)
        }

        override fun onEditClick(position: Int) {
            val password = passwordsList[position]
            // Handle edit click, e.g., show a dialog to edit the password
        }

        override fun onAddFavoriteClick(position: Int) {
            val password = passwordsList[position]
            viewModel.addFavorite(password)
        }

        override fun onCopyUserNameClick(position: Int) {
            val password = passwordsList[position]
            viewModel.copyUserName(password)
        }

        override fun onCopyPasswordClick(position: Int) {
            val password = passwordsList[position]
            viewModel.copyPassword(password)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPasswordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllPasswords()

        viewModel.allPasswords.observe(viewLifecycleOwner) { passwords ->
            passwordsList = passwords
            with(binding) {
                rvPasswords.adapter = PasswordsViewAdapter(passwords, listener)
                rvPasswords.layoutManager = LinearLayoutManager(context)
            }
        }
    }
}