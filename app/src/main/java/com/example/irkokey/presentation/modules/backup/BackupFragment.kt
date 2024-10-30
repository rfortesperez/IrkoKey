package com.example.irkokey.presentation.modules.backup

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.CreateDocument
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.irkokey.R
import com.example.irkokey.databinding.FragmentBackupBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BackupFragment : Fragment() {

    private lateinit var binding: FragmentBackupBinding
    private val backupViewModel: BackupViewModel by viewModels()

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions.all { it.value }) {
            Toast.makeText(requireContext(), "Permissions granted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Permissions denied", Toast.LENGTH_SHORT).show()
        }
    }

    private val createFileLauncher = registerForActivityResult(
        CreateDocument("application/json")
    ) { uri ->
        uri?.let {
            showPinDialog { pin ->
                backupViewModel.requestPinAndExport(pin, it)
            }
        }
    }

    private val openFileLauncher = registerForActivityResult(ActivityResultContracts.OpenDocument()
    ) { uri ->
        uri?.let {
            showPinDialog { pin ->
                backupViewModel.requestPinAndImport(pin, it)
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 1001
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentBackupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            // Export the data to a Json file
            btnExport.setOnClickListener {
                if (hasPermissions()) {
                    createFileLauncher.launch("irkokey.json")
                    backupViewModel.isPinCorrect.observe(viewLifecycleOwner) { isPinCorrect ->
                        if (isPinCorrect) {
                            Toast.makeText(requireContext(), getString(R.string.exporting_process), Toast.LENGTH_SHORT).show()
                            observeExportProgress()
                        } else {
                            Toast.makeText(requireContext(), getString(R.string.incorrect_pin), Toast.LENGTH_SHORT).show()
                        }
                    }

                } else {
                    requestPermissions()
                }
            }

            // Import the data from a Json file
            btnImport.setOnClickListener {
                if (hasPermissions()) {
                    openFileLauncher.launch(arrayOf("application/json"))
                    backupViewModel.isPinCorrect.observe(viewLifecycleOwner) { isPinCorrect ->
                        if (isPinCorrect) {
                            Toast.makeText(requireContext(), getString(R.string.importing_process), Toast.LENGTH_SHORT).show()
                            observeImportProgress()
                        } else {
                            Toast.makeText(requireContext(), getString(R.string.incorrect_pin), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    requestPermissions()
                }
            }

            //show a toast when finished importing
            backupViewModel.isImported.observe(viewLifecycleOwner) { isImported ->
                if (isImported) {
                    pbBackup.visibility = View.GONE
                    Toast.makeText(requireContext(), getString(R.string.imported), Toast.LENGTH_SHORT).show()
                }
            }

            //show a toast when finished exporting
            backupViewModel.isExported.observe(viewLifecycleOwner) { isExported ->
                if (isExported) {
                    pbBackup.visibility = View.GONE
                    Toast.makeText(requireContext(), getString(R.string.exported), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun hasPermissions(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        } else {
            ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                intent.data = Uri.parse("package:" + requireContext().packageName)
                startActivity(intent)
            } catch (e: Exception) {
                val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                startActivity(intent)
            }
        } else {
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            )
        }
    }

    private fun showPinDialog(onPinEntered: (String) -> Unit) {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_pin, null)
        val pinEditText = dialogView.findViewById<EditText>(R.id.et_introduce_pin)

        AlertDialog.Builder(requireContext()).setTitle(getString(R.string.enter_pin)).setView(dialogView)
            .setPositiveButton(getString(R.string.submit)) { dialog, _ ->
                val pin = pinEditText.text.toString()
                if (pin.isNotEmpty()) {
                    onPinEntered(pin)
                    dialog.dismiss()
                } else {
                    pinEditText.error = getString(R.string.enter_pin)
                }
            }.setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }.create().show()
    }

    private fun observeExportProgress() {
        // Show the progress bar
        binding.pbBackup.visibility = View.VISIBLE

        // Observe the progress
        backupViewModel.progress.observe(viewLifecycleOwner) { progress ->
            binding.pbBackup.progress = progress
        }
    }

    private fun observeImportProgress() {
        // Show the progress bar
        binding.pbBackup.visibility = View.VISIBLE

        // Observe the progress
        backupViewModel.progress.observe(viewLifecycleOwner) { progress ->
            binding.pbBackup.progress = progress
        }
    }
}