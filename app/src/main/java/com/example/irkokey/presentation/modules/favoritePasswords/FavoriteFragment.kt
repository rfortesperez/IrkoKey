package com.example.irkokey.presentation.modules.favoritePasswords


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.databinding.FragmentFavoriteBinding
import com.example.irkokey.domain.models.Password
import com.example.irkokey.common.utils.PasswordDiffCallback
import com.example.irkokey.data.repository.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * A Fragment that displays a list of favorite passwords and provides functionality to search, copy, and remove passwords from favorites.
 */
@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val viewModel: FavoriteViewModel by viewModels()
    private lateinit var favoritePasswordsList: MutableList<Password>
    private lateinit var adapter: FavoriteViewAdapter

    @Inject
    lateinit var passwordRepository: PasswordRepository

    @Inject
    lateinit var encryptionUtil: EncryptionUtil

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritePasswordsList = mutableListOf()
        adapter = FavoriteViewAdapter(favoritePasswordsList, ::handlePasswordAction, encryptionUtil)

        with(binding) {
            rvFavoritePasswords.layoutManager = LinearLayoutManager(context)
            rvFavoritePasswords.adapter = adapter

            // Search bar

            svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText.isNullOrEmpty()) {
                        favoritePasswordsList.clear() // Clear the list on empty search
                        // Add back the original list
                        favoritePasswordsList.addAll(adapter.getOriginalList())
                        adapter.notifyDataSetChanged() // Update the adapter
                    } else {
                        val filteredList = favoritePasswordsList.filter { password ->
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

        viewModel.allFavorites.observe(viewLifecycleOwner) {

            val diffCallback = PasswordDiffCallback(favoritePasswordsList, it)
            val diffResult = DiffUtil.calculateDiff(diffCallback)

            favoritePasswordsList.clear()
            favoritePasswordsList.addAll(it)
            adapter.updateOriginalList(it.toMutableList())
            diffResult.dispatchUpdatesTo(adapter)
        }

        viewModel.isRemoved.observe(viewLifecycleOwner) { isRemoved ->
            if (isRemoved) {
                Toast.makeText(context, getString(R.string.removed_from_favorite), Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.isCopied.observe(viewLifecycleOwner) { isCopied ->
            if (isCopied) {
                Toast.makeText(context, getString(R.string.password_copied), Toast.LENGTH_SHORT).show()
                showCopyAlertDialog()
            }
        }

    }


    /**
     * Handles password actions such as copying and removing favorites.
     * @param action The action to be handled.
     */
    private fun handlePasswordAction(action: PasswordAction) {
        when (action) {
            is PasswordAction.CopyPassword -> viewModel.copyPassword(action.password.password)
            is PasswordAction.RemoveFavorite -> viewModel.removeFavorite(action.password)
        }
    }

    /**
     * Shows an alert dialog to warn the user about the security risks of copying passwords.
     */
    private fun showCopyAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(HtmlCompat.fromHtml("<font color='red' style= 'bold'>${getString(R.string.security_warning)}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY))
            .setMessage(getString(R.string.copy_warning_message))
            .setPositiveButton(HtmlCompat.fromHtml("<font color='red'>${getString(R.string.got_it)}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY)) { _, _ -> }
            .show()
    }


    /**
     * Filters the favorite passwords list based on the search query.
     * @param text The search query entered by the user.
     */
    private fun filter(text: String) {
        val filteredList = favoritePasswordsList.filter { password ->
            password.website.contains(text, ignoreCase = true)
        }
        // convert the filtered list to mutable list
        val newList = filteredList.toMutableList()

        adapter.filterList(newList)
    }
}