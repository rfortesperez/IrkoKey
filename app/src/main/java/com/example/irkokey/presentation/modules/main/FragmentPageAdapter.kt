package com.example.irkokey.presentation.modules.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.irkokey.presentation.modules.createPassword.CreateFragment
import com.example.irkokey.presentation.modules.passwords.PasswordsFragment

class FragmentPageAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            CreateFragment()
        } else {
            PasswordsFragment()
        }
    }
}