package com.example.irkokey.common.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 * Utility object for handling permission requests.
 */
object PermissionUtils {

    /**
     * Requests storage permissions (READ\_EXTERNAL\_STORAGE and WRITE\_EXTERNAL\_STORAGE) if they are not already granted.
     *
     * @param activity The activity from which the permissions are requested.
     */
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