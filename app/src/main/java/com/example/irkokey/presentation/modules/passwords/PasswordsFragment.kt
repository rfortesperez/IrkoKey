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
import com.example.irkokey.databinding.FragmentPasswordsBinding
import com.example.irkokey.domain.models.Password
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Fragment that displays a list of passwords and provides functionality to search, edit, delete, and copy passwords.
 */
@AndroidEntryPoint
class PasswordsFragment : Fragment() {

    private lateinit var binding: FragmentPasswordsBinding
    private val viewModel: PasswordsViewModel by viewModels()
    private lateinit var passwordsList: MutableList<Password>
    private lateinit var adapter: PasswordsViewAdapter

    // Inject the EncryptionUtil to decrypt passwords.
    @Inject
    lateinit var encryptionUtil: EncryptionUtil

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPasswordsBinding.inflate(inflater, container, false)
        binding.svSearch.clearFocus()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupSearchView()
        observeViewModel()
    }

    /**
     * Sets up the RecyclerView with an adapter and layout manager.
     */
    private fun setupRecyclerView() {
        passwordsList = mutableListOf()
        adapter = PasswordsViewAdapter(passwordsList, viewModel::handlePasswordAction, encryptionUtil)
        binding.rvPasswords.adapter = adapter
        binding.rvPasswords.layoutManager = LinearLayoutManager(context)
    }

    /**
     * Sets up the SearchView to filter the passwords list based on user input.
     */
    private fun setupSearchView() {
        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                filterPasswords(newText)
                return true
            }
        })
    }

    /**
     * Filters the passwords list based on the search query.
     * @param newText The search query entered by the user.
     */
    private fun filterPasswords(newText: String?) {
        val filteredList = if (newText.isNullOrEmpty()) {
            adapter.getOriginalList()
        } else {
            passwordsList.filter { it.website.contains(newText, ignoreCase = true) }
        }.toMutableList()

        if (filteredList.isEmpty() && !newText.isNullOrEmpty()) {
            Toast.makeText(context, getString(R.string.no_results), Toast.LENGTH_SHORT).show()
        }

        adapter.filterList(filteredList)
    }

    /**
     * Observes the ViewModel LiveData and updates the UI accordingly.
     */
    private fun observeViewModel() {
        viewModel.allPasswords.observe(viewLifecycleOwner) { updatePasswordsList(it) }
        viewModel.isFavorite.observe(viewLifecycleOwner) { showFavoriteToast(it) }
        viewModel.showEditPasswordDialog.observe(viewLifecycleOwner) { it?.let { showEditPasswordDialog(it) } }
        viewModel.isCorrect.observe(viewLifecycleOwner) { handlePasswordStrength(it) }
        viewModel.showDeleteConfirmation.observe(viewLifecycleOwner) { it?.let { showDeleteConfirmationDialog(it) } }
        viewModel.isCopied.observe(viewLifecycleOwner) { if (it) showCopyConfirmationDialog() }
    }

    /**
     * Updates the passwords list and notifies the adapter of changes.
     * @param passwords The new list of passwords.
     */
    private fun updatePasswordsList(passwords: List<Password>) {
        val decryptedPasswords = passwords.map { it.copy(password = viewModel.getDecryptedPassword(it.password)) }
        val diffCallback = PasswordDiffCallback(passwordsList, decryptedPasswords)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        passwordsList.clear()
        passwordsList.addAll(passwords)
        adapter.updateOriginalList(passwords.toMutableList())
        diffResult.dispatchUpdatesTo(adapter)
    }

    /**
     * Shows a toast message based on the favorite status.
     * @param isFavorite True if the password is a favorite, false otherwise.
     */
    private fun showFavoriteToast(isFavorite: Boolean) {
        val message = if (isFavorite) R.string.removed_from_favorite else R.string.added_to_favorite
        Toast.makeText(context, getString(message), Toast.LENGTH_SHORT).show()
    }

    /**
     * Handles the password strength check result.
     * @param isCorrect True if the password is strong, false otherwise.
     */
    private fun handlePasswordStrength(isCorrect: Boolean) {
        if (!isCorrect) {
            Snackbar.make(requireView(), getString(R.string.password_not_strong), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.got_it)) { }
                .show()
        } else {
            Toast.makeText(context, getString(R.string.updated), Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Shows a confirmation dialog to delete a password.
     * @param password The password to be deleted.
     */
    private fun showDeleteConfirmationDialog(password: Password) {
        AlertDialog.Builder(requireContext())
            .setTitle(HtmlCompat.fromHtml("<font color='red' style= 'bold'>${getString(R.string.delete)}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY))
            .setMessage(getString(R.string.sure))
            .setPositiveButton(getString(R.string.yes)) { _, _ -> viewModel.deletePassword(password) }
            .setNegativeButton(getString(R.string.no), null)
            .show()
    }

    /**
     * Shows a confirmation dialog after copying a password.
     */
    private fun showCopyConfirmationDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(HtmlCompat.fromHtml("<font color='red' style= 'bold'>${getString(R.string.security_warning)}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY))
            .setMessage(getString(R.string.copy_warning_message))
            .setPositiveButton(HtmlCompat.fromHtml("<font color='red'>${getString(R.string.got_it)}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY)) { _, _ -> }
            .show()
    }

    /**
     * Shows a dialog to edit a password.
     * @param password The password to be edited.
     */
    private fun showEditPasswordDialog(password: Password) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit, null)
        val editText = dialogView.findViewById<EditText>(R.id.et_new_password)
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.edit))
            .setView(dialogView)
            .setPositiveButton(getString(R.string.save)) { _, _ -> viewModel.editPassword(password, editText.text.toString()) }
            .setNegativeButton(getString(R.string.cancel), null)
            .create()
            .show()
    }
}