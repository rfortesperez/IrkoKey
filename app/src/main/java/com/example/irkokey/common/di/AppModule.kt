package com.example.irkokey.common.di

import android.app.Application
import android.content.ClipboardManager
import android.content.Context
import android.os.Environment
import com.example.irkokey.common.infraestructure.Preferences
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.common.utils.PasswordStrengthUtil
import com.example.irkokey.data.dao.PasswordDao
import com.example.irkokey.data.dao.UserDao
import com.example.irkokey.data.database.PasswordRoomDatabase
import com.example.irkokey.data.repository.PasswordRepository
import com.example.irkokey.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.crypto.SecretKey
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
    @Provides
    @Singleton
    fun providePreferences(context: Context): Preferences {
        return Preferences(context)
    }
    @Provides
    @Singleton
    fun providePasswordDao(database: PasswordRoomDatabase): PasswordDao {
        return database.passwordDao()
    }
    @Provides
    @Singleton
    fun provideUserDao(database: PasswordRoomDatabase): UserDao {
        return database.userDao()
    }
    @Provides
    @Singleton
    fun provideDatabase(context: Context): PasswordRoomDatabase {
        return PasswordRoomDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun providePasswordRepository(passwordDao: PasswordDao): PasswordRepository {
        return PasswordRepository(passwordDao)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }

    @Provides
    @Singleton
    fun provideEncryptionUtil(): EncryptionUtil {
        return EncryptionUtil
    }

    @Provides
    @Singleton
    fun providePasswordStrengthUtil(): PasswordStrengthUtil {
        return PasswordStrengthUtil
    }

    @Provides
    @Singleton
    fun provideClipboardManager(context: Context): ClipboardManager {
        return context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }
    @Provides
    @Singleton
    fun provideCsvFile(): File {
        return File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "database_export.csv")
    }
}