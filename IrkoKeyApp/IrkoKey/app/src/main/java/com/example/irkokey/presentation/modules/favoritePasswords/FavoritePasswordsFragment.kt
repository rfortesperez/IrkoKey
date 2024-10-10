package com.example.irkokey.presentation.modules.favoritePasswords

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.irkokey.R
import com.example.irkokey.databinding.FragmentFavoriteBinding


class FavoritePasswordsFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }


}