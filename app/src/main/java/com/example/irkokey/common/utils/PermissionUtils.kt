package com.example.irkokey.common.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtils {

    // Request storage permissions
    fun requestStoragePermissions(activity: Activity){
        val permissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val permissionsToRequest = permissions.filter{
            ContextCompat.checkSelfPermission(activity, it) != PackageManager.PERMISSION_GRANTED
        }

        if(permissionsToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(activity, permissionsToRequest.toTypedArray(), 1)
        }
    }
}