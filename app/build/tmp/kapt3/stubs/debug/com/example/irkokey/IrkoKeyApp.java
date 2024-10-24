package com.example.irkokey;

import android.app.Application;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import dagger.hilt.android.HiltAndroidApp;

@dagger.hilt.android.HiltAndroidApp
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/example/irkokey/IrkoKeyApp;", "Landroid/app/Application;", "()V", "onCreate", "", "app_debug"})
public final class IrkoKeyApp extends android.app.Application {
    
    public IrkoKeyApp() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
}