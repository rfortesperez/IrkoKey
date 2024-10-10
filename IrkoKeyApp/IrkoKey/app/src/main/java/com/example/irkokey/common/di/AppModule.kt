package com.example.irkokey.common.di

import android.app.Application
import android.content.Context
import com.example.irkokey.common.infraestructure.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}