package com.example.irkokey.common.di

import android.app.Application
import android.content.ClipboardManager
import android.content.Context
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
import javax.inject.Singleton

/**
 * Module that provides the dependencies for the application.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Provides the application context.
     * @param application The application instance.
     * @return The application context.
     */
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    /**
     * Provides the preferences.
     * @param context The application context.
     * @return The Preferences instance.
     */
    @Provides
    @Singleton
    fun providePreferences(context: Context): Preferences {
        return Preferences(context)
    }

    /**
     * Provides the PasswordDao.
     * @param database The PasswordRoomDatabase instance.
     * @return The PasswordDao instance.
     */
    @Provides
    @Singleton
    fun providePasswordDao(database: PasswordRoomDatabase): PasswordDao {
        return database.passwordDao()
    }

    /**
     * Provides the UserDao.
     * @param database The PasswordRoomDatabase instance.
     * @return The UserDao instance.
     */
    @Provides
    @Singleton
    fun provideUserDao(database: PasswordRoomDatabase): UserDao {
        return database.userDao()
    }

    /**
     * Provides the PasswordRoomDatabase.
     * @param context The application context.
     * @return The PasswordRoomDatabase instance.
     */
    @Provides
    @Singleton
    fun provideDatabase(context: Context): PasswordRoomDatabase {
        return PasswordRoomDatabase.getDatabase(context)
    }

    /**
     * Provides the PasswordRepository.
     * @param passwordDao The PasswordDao instance.
     * @return The PasswordRepository instance.
     */
    @Provides
    @Singleton
    fun providePasswordRepository(passwordDao: PasswordDao): PasswordRepository {
        return PasswordRepository(passwordDao)
    }

    /**
     * Provides the UserRepository.
     * @param userDao The UserDao instance.
     * @return The UserRepository instance.
     */
    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }


    /**
     * Provides the EncryptionUtil.
     * @return The EncryptionUtil instance.
     */
    @Provides
    @Singleton
    fun provideEncryptionUtil(): EncryptionUtil {
        return EncryptionUtil
    }

    /**
     * Provides the PasswordStrengthUtil.
     * @return The PasswordStrengthUtil instance.
     */
    @Provides
    @Singleton
    fun providePasswordStrengthUtil(): PasswordStrengthUtil {
        return PasswordStrengthUtil
    }
    /**
     * Provides the ClipboardManager.
     * @param context The application context.
     * @return The ClipboardManager instance.
     */
    @Provides
    @Singleton
    fun provideClipboardManager(context: Context): ClipboardManager {
        return context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }
}