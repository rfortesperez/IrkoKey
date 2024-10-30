package com.example.irkokey.presentation.modules.passwords

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
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
                .setTitle(getString(R.string.edit))
                .setView(dialogView)
                .setPositiveButton(getString(R.string.save)) { _, _ ->
                    val newPassword = editText.text.toString()
                    viewModel.editPassword(password, newPassword)
                }
                .setNegativeButton(getString(R.string.cancel), null)
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
        binding.svSearch.clearFocus()
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
            svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText.isNullOrEmpty()) {
                        passwordsList.clear() // Clear the list on empty search
                        // Add back the original list
                        passwordsList.addAll(adapter.getOriginalList())
                        adapter.notifyDataSetChanged() // Update the adapter
                    } else {
                        val filteredList = passwordsList.filter { password ->
                            password.website.contains(newText, ignoreCase = true)
                        }.toMutableList()
                        if (filteredList.isEmpty()){
                            Toast.makeText(context, getString(R.string.no_results), Toast.LENGTH_SHORT).show()
                        }
                        adapter.filterList(filteredList)
                    }
                    return true
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
            adapter.updateOriginalList(passwords.toMutableList())
            diffResult.dispatchUpdatesTo(adapter)
        }
        viewModel.isCorrect.observe(viewLifecycleOwner){ isCorrect ->
            if (!isCorrect) {
                Snackbar.make(view, getString(R.string.password_not_strong), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.got_it)) { }
                    .show()
            } else {
                Toast.makeText(context, getString(R.string.updated), Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.showDeleteConfirmation.observe(viewLifecycleOwner) { password ->
            password?.let {
                showDeleteConfirmationDialog(it)
            }
        }

        viewModel.isCopied.observe(viewLifecycleOwner) { isCopied ->
            if (isCopied) {
                Toast.makeText(context, getString(R.string.password_copied), Toast.LENGTH_SHORT).show()
                showCopyConfirmationDialog()
            }
        }
    }

    private fun showDeleteConfirmationDialog(password: Password) {
        AlertDialog.Builder(requireContext())
            .setTitle(HtmlCompat.fromHtml("<font color='red' style= 'bold'>${getString(R.string.delete)}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY))
            .setMessage(getString(R.string.sure))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.deletePassword(password)
            }
            .setNegativeButton(getString(R.string.no), null)
            .show()
    }



    private fun showCopyConfirmationDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(HtmlCompat.fromHtml("<font color='red' style= 'bold'>${getString(R.string.security_warning)}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY))
            .setMessage(getString(R.string.copy_warning_message))
            .setPositiveButton(HtmlCompat.fromHtml("<font color='red'>${getString(R.string.got_it)}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY)) { _, _ -> }
            .show()
    }


}