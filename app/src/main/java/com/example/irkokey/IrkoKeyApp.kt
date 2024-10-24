package com.example.irkokey

import android.app.Application
import com.example.irkokey.common.utils.EncryptionUtil
import com.google.crypto.tink.daead.DeterministicAeadConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IrkoKeyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        DeterministicAeadConfig.register()
        EncryptionUtil.initialize(this)
    }
}
