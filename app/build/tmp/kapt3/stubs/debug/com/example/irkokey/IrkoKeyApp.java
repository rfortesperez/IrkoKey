package com.example.irkokey;

import android.app.Application;
import com.example.irkokey.common.infraestructure.Preferences;
import com.example.irkokey.common.utils.EncryptionUtil;
import dagger.hilt.android.HiltAndroidApp;
import javax.inject.Inject;

@dagger.hilt.android.HiltAndroidApp
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/irkokey/IrkoKeyApp;", "Landroid/app/Application;", "()V", "preferences", "Lcom/example/irkokey/common/infraestructure/Preferences;", "getPreferences", "()Lcom/example/irkokey/common/infraestructure/Preferences;", "setPreferences", "(Lcom/example/irkokey/common/infraestructure/Preferences;)V", "onCreate", "", "app_debug"})
public final class IrkoKeyApp extends android.app.Application {
    @javax.inject.Inject
    public com.example.irkokey.common.infraestructure.Preferences preferences;
    
    public IrkoKeyApp() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.common.infraestructure.Preferences getPreferences() {
        return null;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.NotNull
    com.example.irkokey.common.infraestructure.Preferences p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
}