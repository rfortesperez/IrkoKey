package com.example.irkokey.presentation.modules.passwords

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irkokey.R
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.databinding.FragmentPasswordsBinding
import com.example.irkokey.domain.models.Password
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PasswordsFragment : Fragment() {

    private lateinit var binding: FragmentPasswordsBinding
    private val viewModel: PasswordsViewModel by viewModels()
    private lateinit var passwordsList: MutableList<Password>
    private lateinit var adapter: PasswordsViewAdapter

    @Inject
    lateinit var passwordRepository: PasswordRepository

    private val listener = object : OnItemClick {

        override fun onDeleteClick(position: Int) {
            val password = passwordsList[position]
            viewModel.confirmDeletePassword(password)
        }

        override fun onEditClick(position: Int) {
            val password = passwordsList[position]
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit, null)
            val editText = dialogView.findViewById<EditText>(R.id.et_new_password)
            val dialog = AlertDialog.Builder(requireContext())
                .setTitle("Edit Password")
                .setView(dialogView)
                .setPositiveButton("Save") { _, _ ->
                    val newPassword = editText.text.toString()
                    viewModel.editPassword(password, newPassword)
                }
                .setNegativeButton("Cancel", null)
                .create()

            dialog.show()
        }

        override fun onAddFavoriteClick(position: Int) {
            val password = passwordsList[position]
            viewModel.addFavorite(password)
            adapter.updatePassword(position, password)
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

        passwordsList = mutableListOf()
        adapter = PasswordsViewAdapter(passwordsList, listener)
        with(binding){
            rvPasswords.adapter = adapter
            rvPasswords.layoutManager = LinearLayoutManager(context)
        }

        viewModel.allPasswords.observe(viewLifecycleOwner){ passwords ->
            val diffCallback = PasswordDiffCallback(passwordsList, passwords)
            val diffResult = DiffUtil.calculateDiff(diffCallback)

            passwordsList.clear()
            passwordsList.addAll(passwords)
            diffResult.dispatchUpdatesTo(adapter)
        }
        viewModel.isCorrect.observe(viewLifecycleOwner){ isCorrect ->
            if (!isCorrect) {
                Snackbar.make(view, "Password is not strong enough", Snackbar.LENGTH_LONG)
                    .setAction("Got it!") { }
                    .show()
            } else {
                Toast.makeText(context, "Password updated", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.showDeleteConfirmation.observe(viewLifecycleOwner) { password ->
            password?.let {
                showDeleteConfirmationDialog(it)
            }
        }
    }

    private fun showDeleteConfirmationDialog(password: Password) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Password")
            .setMessage("Are you sure you want to delete this password?")
            .setPositiveButton("Yes") { dialog, which ->
                viewModel.deletePassword(password)
            }
            .setNegativeButton("No", null)
            .show()
    }
}