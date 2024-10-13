package com.example.irkokey.presentation.modules.favoritePasswords

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    @Inject
    lateinit var passwordRepository: PasswordRepository
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            rvFavoritePasswords.layoutManager = LinearLayoutManager(context)

            viewModel.allFavorites.observe(viewLifecycleOwner) { passwords ->
                rvFavoritePasswords.adapter = FavoriteViewAdapter(passwords)
            }
        }
    }


}