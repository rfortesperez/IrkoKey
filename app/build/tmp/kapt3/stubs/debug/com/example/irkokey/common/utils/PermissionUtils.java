package com.example.irkokey.common.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * Utility object for handling permission requests.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/irkokey/common/utils/PermissionUtils;", "", "()V", "requestStoragePermissions", "", "activity", "Landroid/app/Activity;", "app_debug"})
public final class PermissionUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.example.irkokey.common.utils.PermissionUtils INSTANCE = null;
    
    private PermissionUtils() {
        super();
    }
    
    /**
     * Requests storage permissions (READ\_EXTERNAL\_STORAGE and WRITE\_EXTERNAL\_STORAGE) if they are not already granted.
     *
     * @param activity The activity from which the permissions are requested.
     */
    public final void requestStoragePermissions(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
}