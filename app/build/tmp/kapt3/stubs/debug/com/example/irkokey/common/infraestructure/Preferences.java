package com.example.irkokey.common.infraestructure;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * A singleton class for managing shared preferences.
 * @param context The application context.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/irkokey/common/infraestructure/Preferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SHARED_MAIL", "", "SHARED_NAME", "SHARED_PIN", "value", "derivedKey", "getDerivedKey", "()Ljava/lang/String;", "setDerivedKey", "(Ljava/lang/String;)V", "mail", "getMail", "setMail", "pin", "getPin", "setPin", "storage", "Landroid/content/SharedPreferences;", "app_debug"})
public final class Preferences {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String SHARED_NAME = "sharedPreferences";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String SHARED_MAIL = "mail";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String SHARED_PIN = "pin";
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences storage = null;
    
    @javax.inject.Inject
    public Preferences(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMail() {
        return null;
    }
    
    public final void setMail(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPin() {
        return null;
    }
    
    public final void setPin(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDerivedKey() {
        return null;
    }
    
    public final void setDerivedKey(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
}