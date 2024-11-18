package com.example.irkokey.presentation.modules.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.irkokey.presentation.modules.createPassword.CreateFragment
import com.example.irkokey.presentation.modules.passwords.PasswordsFragment

/**
 * Adapter class for managing fragments in a ViewPager2.
 *
 * @param fragmentActivity The activity that hosts the ViewPager2.
 */
class FragmentPageAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    /**
     * Returns the number of fragments to be displayed in the ViewPager2.
     *
     * @return The number of fragments.
     */
    override fun getItemCount(): Int {
        return 2
    }
    /**
     * Creates a new fragment for the given position.
     *
     * @param position The position of the fragment in the ViewPager2.
     * @return The fragment to be displayed.
     */

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            CreateFragment()
        } else {
            PasswordsFragment()
        }
    }
}