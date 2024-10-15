package com.example.irkokey.common.di;

import android.app.Application;
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
import javax.crypto.SecretKey;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0007\u00a8\u0006\u001d"}, d2 = {"Lcom/example/irkokey/common/di/AppModule;", "", "()V", "provideContext", "Landroid/content/Context;", "application", "Landroid/app/Application;", "provideDatabase", "Lcom/example/irkokey/data/database/PasswordRoomDatabase;", "context", "provideEncryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "providePasswordDao", "Lcom/example/irkokey/data/dao/PasswordDao;", "database", "providePasswordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "passwordDao", "providePasswordStrengthUtil", "Lcom/example/irkokey/common/utils/PasswordStrengthUtil;", "providePreferences", "Lcom/example/irkokey/common/infraestructure/Preferences;", "provideSecretKey", "Ljavax/crypto/SecretKey;", "provideUserDao", "Lcom/example/irkokey/data/dao/UserDao;", "provideUserRepository", "Lcom/example/irkokey/data/repository/UserRepository;", "userDao", "app_debug"})
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
    public final javax.crypto.SecretKey provideSecretKey() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.common.utils.PasswordStrengthUtil providePasswordStrengthUtil() {
        return null;
    }
}