package com.example.irkokey.presentation.modules.explorePasswords

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.irkokey.R
import com.example.irkokey.databinding.FragmentExplorePasswordBinding
import com.example.irkokey.presentation.modules.main.FragmentPageAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExplorePasswordFragment : Fragment() {

    private lateinit var binding: FragmentExplorePasswordBinding
    private val ExplorePasswordViewModel: ExplorePasswordViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentExplorePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, saveInstaceState: Bundle?){
        super.onViewCreated(view, saveInstaceState)

        val titles = listOf("Create", "Password")
        val icons = listOf(R.drawable.baseline_create_24, R.drawable.baseline_password_24)

        with(binding){
            activity?.let { viewPager2.adapter = FragmentPageAdapter(it) }
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.text = titles[position]
                tab.icon = ContextCompat.getDrawable(requireContext(), icons[position])
            }.attach()
        }
    }


}