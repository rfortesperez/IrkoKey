package com.example.irkokey

import android.app.Application
import com.example.irkokey.common.infraestructure.Preferences
import com.example.irkokey.common.utils.EncryptionUtil
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


/**
 * IrkoKeyApp is the Application class for the IrkoKey application.
 * It initializes the EncryptionUtil and provides a Preferences instance.
 */
@HiltAndroidApp
class IrkoKeyApp: Application() {

    // Preferences instance for accessing stored user data
    @Inject
    lateinit var preferences: Preferences

    /**
     * Called when the application is starting, before any other application objects have been created.
     * Initializes the EncryptionUtil.
     */
    override fun onCreate() {
        super.onCreate()
        EncryptionUtil.initialize(this)
    }
}
