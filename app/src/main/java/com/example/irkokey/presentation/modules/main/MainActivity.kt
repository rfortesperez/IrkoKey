package com.example.irkokey.presentation.modules.main

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.irkokey.R
import com.example.irkokey.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity class that hosts the main UI components and handles navigation.
 * This activity is annotated with `@AndroidEntryPoint` to support dependency injection with Hilt.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = binding.bottomNavigationView
        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigate_logout -> {
                    showLogoutConfirmationDialog()
                    true
                }
                else -> {
                    navController.navigate(item.itemId)
                    true
                }
            }
        }
    }

    /**
     * Shows a confirmation dialog for logging out.
     */
    private fun showLogoutConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle(HtmlCompat.fromHtml("<font color='red' style= 'bold'>${getString(R.string.logout)}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY))
            .setMessage(getString(R.string.logout_info))
            .setPositiveButton(getString(R.string.logout)) { _, _ ->
                finish()
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
