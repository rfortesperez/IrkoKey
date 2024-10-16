package com.example.irkokey

import android.app.Application
import com.google.crypto.tink.aead.AeadConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IrkoKeyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        AeadConfig.register()
    }
}