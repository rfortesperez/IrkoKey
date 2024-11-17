package com.example.irkokey.presentation.modules.createPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.irkokey.R
import com.example.irkokey.databinding.FragmentCreateBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment class for creating a new password.
 * This fragment is annotated with `@AndroidEntryPoint` to support dependency injection with Hilt.
 */
@AndroidEntryPoint
class CreateFragment : Fragment() {

    private val createViewModel: CreateViewModel by viewModels()
    private lateinit var binding: FragmentCreateBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        observeViewModel()
    }

    /**
     * Sets up the UI components and their click listeners.
     */
    private fun setupUI() {
        with(binding) {
            btnSave.setOnClickListener { handleSaveClick() }
            btnGenerate.setOnClickListener { createViewModel.didClickGenerateButton() }
        }
    }

    /**
     * Handles the save button click event.
     */
    private fun handleSaveClick() {
        with(binding) {
            createViewModel.didClickSaveButton(
                etWebsiteInput.text.toString(),
                etUsernameInput.text.toString(),
                etPasswordInput.text.toString()
            )
            etWebsiteInput.requestFocus() // Return focus to website input
        }
    }

    /**
     * Observes the ViewModel LiveData properties and updates the UI accordingly.
     */
    private fun observeViewModel() {
        createViewModel.generatedPassword.observe(viewLifecycleOwner) { password ->
            binding.etPasswordInput.setText(password)
        }

        createViewModel.isComplete.observe(viewLifecycleOwner) { isComplete ->
            if (isComplete) {
                createViewModel.isCorrect.observe(viewLifecycleOwner) { isCorrect ->
                    if (isCorrect) {
                        showToast(getString(R.string.password_saved))
                        clearInputFields()
                    } else {
                        showToast(getString(R.string.password_not_strong))
                    }
                }
            } else {
                showToast(getString(R.string.fill_fields))
            }
        }
    }

    /**
     * Shows a toast message.
     *
     * @param message The message to be displayed in the toast.
     */
    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Clears the input fields.
     */
    private fun clearInputFields() {
        with(binding) {
            etWebsiteInput.text.clear()
            etUsernameInput.text.clear()
            etPasswordInput.text?.clear()
        }
    }
}