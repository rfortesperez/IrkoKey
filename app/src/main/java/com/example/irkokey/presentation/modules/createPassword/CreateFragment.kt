package com.example.irkokey.presentation.modules.createPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.irkokey.databinding.FragmentCreateBinding
import dagger.hilt.android.AndroidEntryPoint

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
        with(binding) {
            btnSave.setOnClickListener {
                createViewModel.didClickSaveButton(
                    etWebsiteInput.text.toString(),
                    etUsernameInput.text.toString(),
                    etPasswordInput.text.toString()
                )
                etWebsiteInput.requestFocus() // Return focus to website input
            }

            btnGenerate.setOnClickListener{
                createViewModel.didClickGenerateButton()
            }
        }

        createViewModel.generatedPassword.observe(viewLifecycleOwner){ password ->
            binding.etPasswordInput.setText(password)
        }

        createViewModel.isComplete.observe(viewLifecycleOwner) { isComplete ->
            if(isComplete){
                createViewModel.isCorrect.observe(viewLifecycleOwner){ isCorrect->
                    if(isCorrect){
                        Toast.makeText(context, "Password saved", Toast.LENGTH_SHORT).show()
                        with(binding){
                            etWebsiteInput.text.clear()
                            etUsernameInput.text.clear()
                            etPasswordInput.text?.clear()
                        }
                    }else{
                        Toast.makeText(context, "Password is not strong enough", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
