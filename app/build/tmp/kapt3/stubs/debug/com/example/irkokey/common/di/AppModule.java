package com.example.irkokey.common.di;

import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;
import com.example.irkokey.common.infraestructure.Preferences;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.common.utils.PasswordStrengthUtil;
import com.example.irkokey.data.dao.PasswordDao;
import com.example.irkokey.data.dao.UserDao;
import com.example.irkokey.data.database.PasswordRoomDatabase;
import com.example.irkokey.data.repository.PasswordRepository;
import com.example.irkokey.data.repository.UserRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

/**
 * Module that provides the dependencies for the application.
 */
@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0007\u00a8\u0006\u001d"}, d2 = {"Lcom/example/irkokey/common/di/AppModule;", "", "()V", "provideClipboardManager", "Landroid/content/ClipboardManager;", "context", "Landroid/content/Context;", "provideContext", "application", "Landroid/app/Application;", "provideDatabase", "Lcom/example/irkokey/data/database/PasswordRoomDatabase;", "provideEncryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "providePasswordDao", "Lcom/example/irkokey/data/dao/PasswordDao;", "database", "providePasswordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "passwordDao", "providePasswordStrengthUtil", "Lcom/example/irkokey/common/utils/PasswordStrengthUtil;", "providePreferences", "Lcom/example/irkokey/common/infraestructure/Preferences;", "provideUserDao", "Lcom/example/irkokey/data/dao/UserDao;", "provideUserRepository", "Lcom/example/irkokey/data/repository/UserRepository;", "userDao", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.example.irkokey.common.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final android.content.Context provideContext(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.common.infraestructure.Preferences providePreferences(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.data.dao.PasswordDao providePasswordDao(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.database.PasswordRoomDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.data.dao.UserDao provideUserDao(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.database.PasswordRoomDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.data.database.PasswordRoomDatabase provideDatabase(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.data.repository.PasswordRepository providePasswordRepository(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.dao.PasswordDao passwordDao) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.data.repository.UserRepository provideUserRepository(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.dao.UserDao userDao) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.common.utils.EncryptionUtil provideEncryptionUtil() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.common.utils.PasswordStrengthUtil providePasswordStrengthUtil() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final android.content.ClipboardManager provideClipboardManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
}