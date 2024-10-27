package com.example.irkokey.presentation.modules.favoritePasswords


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.databinding.FragmentFavoriteBinding
import com.example.irkokey.domain.models.Password
import com.example.irkokey.common.utils.PasswordDiffCallback
import com.example.irkokey.data.repository.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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

    private val listener = object : OnFavItemClick {

        override fun onCopyPasswordClick(position: Int) {
            val password = favoritePasswordsList[position]
            viewModel.copyPassword(password.password)
        }

        override fun onRemoveFavoriteClick(position: Int) {
            val password = favoritePasswordsList[position]
            viewModel.removeFavorite(password)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritePasswordsList = mutableListOf()
        adapter = FavoriteViewAdapter(favoritePasswordsList, listener, encryptionUtil)

        with(binding) {
            rvFavoritePasswords.layoutManager = LinearLayoutManager(context)
            rvFavoritePasswords.adapter = adapter
        }

        viewModel.allFavorites.observe(viewLifecycleOwner) {

            val diffCallback = PasswordDiffCallback(favoritePasswordsList, it)
            val diffResult = DiffUtil.calculateDiff(diffCallback)

            favoritePasswordsList.clear()
            favoritePasswordsList.addAll(it)
            diffResult.dispatchUpdatesTo(adapter)
        }
        viewModel.isCopied.observe(viewLifecycleOwner) { isCopied ->
            if (isCopied) {
                Toast.makeText(context, "Password copied to clipboard", Toast.LENGTH_SHORT).show()
                showCopyConfirmationDialog()
            }
        }

    }

    private fun showCopyConfirmationDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(HtmlCompat.fromHtml("<font color='red' style= 'bold'>Security Warning!!!.</font>", HtmlCompat.FROM_HTML_MODE_LEGACY))
            .setMessage("Make sure to erase the password from the clipboard after use it!")
            .setPositiveButton(HtmlCompat.fromHtml("<font color='red'> Got it!</font>", HtmlCompat.FROM_HTML_MODE_LEGACY)) { _, _ -> }
            .show()
    }



}

