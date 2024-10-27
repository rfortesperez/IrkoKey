package com.example.irkokey.presentation.modules.passwords

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irkokey.R
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.common.utils.PasswordDiffCallback
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.data.repository.UserRepository
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

    @Inject
    lateinit var encryptionUtil: EncryptionUtil

    @Inject
    lateinit var userRepository: UserRepository

    private val listener = object : OnPassItemClick {

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

        override fun onCopyPasswordClick(position: Int) {
            val password = passwordsList[position]
            viewModel.copyPassword(password.password)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPasswordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        passwordsList = mutableListOf()
        adapter = PasswordsViewAdapter(passwordsList, listener, encryptionUtil)
        with(binding){
            rvPasswords.adapter = adapter
            rvPasswords.layoutManager = LinearLayoutManager(context)

            // Search bar
            etSearch.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

                override fun afterTextChanged(p0: Editable?) {
                    filter(p0.toString())
                }

            })
        }

        viewModel.allPasswords.observe(viewLifecycleOwner){ passwords ->
            val decryptedPasswords = passwords.map{password ->
                password.copy(password = viewModel.getDecryptedPassword(password.password))
            }
            val diffCallback = PasswordDiffCallback(passwordsList, decryptedPasswords)
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

        viewModel.isCopied.observe(viewLifecycleOwner) { isCopied ->
            if (isCopied) {
                Toast.makeText(context, "Password copied to clipboard", Toast.LENGTH_SHORT).show()
                showCopyConfirmationDialog()
            }
        }
    }

    private fun showDeleteConfirmationDialog(password: Password) {
        AlertDialog.Builder(requireContext())
            .setTitle(HtmlCompat.fromHtml("<font color='red' style= 'bold'>Delete Password</font>", HtmlCompat.FROM_HTML_MODE_LEGACY))
            .setMessage("Are you sure you want to delete this password?")
            .setPositiveButton("Yes") { _, _ ->
                viewModel.deletePassword(password)
            }
            .setNegativeButton("No", null)
            .show()
    }



    private fun showCopyConfirmationDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(HtmlCompat.fromHtml("<font color='red' style= 'bold'>Security Warning!!!.</font>", HtmlCompat.FROM_HTML_MODE_LEGACY))
            .setMessage("Make sure to erase the password from the clipboard after use it!")
            .setPositiveButton(HtmlCompat.fromHtml("<font color='red'> Got it!</font>", HtmlCompat.FROM_HTML_MODE_LEGACY)) { _, _ -> }
            .show()
    }

    private fun filter(text: String) {
        val filteredList = passwordsList.filter { password ->
            password.website.contains(text, ignoreCase = true)
        }
        // convert the filtered list to mutable list
        val newList = filteredList.toMutableList()

        adapter.filterList(newList)
    }
}