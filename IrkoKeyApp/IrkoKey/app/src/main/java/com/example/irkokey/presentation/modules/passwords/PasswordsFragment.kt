package com.example.irkokey.presentation.modules.passwords

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.irkokey.R
import com.example.irkokey.databinding.FragmentPasswordsBinding


class PasswordsFragment : Fragment() {

    private lateinit var binding: FragmentPasswordsBinding
    private val passwordsViewModel: PasswordsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPasswordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            rvPasswords.layoutManager = LinearLayoutManager(context)
            rvPasswords.adapter = PasswordsViewAdapter()
        }
    }
}