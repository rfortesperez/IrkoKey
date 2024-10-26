package com.example.irkokey

import android.app.Application
import com.example.irkokey.common.infraestructure.Preferences
import com.example.irkokey.common.utils.EncryptionUtil
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class IrkoKeyApp: Application() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate() {
        super.onCreate()
        EncryptionUtil.initialize(this)
    }
}
