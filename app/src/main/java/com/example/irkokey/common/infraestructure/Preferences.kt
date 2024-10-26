package com.example.irkokey.common.infraestructure

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(context: Context) {

    private val SHARED_NAME = "sharedPreferences"
    private val SHARED_MAIL = "mail"


    // storage is the object that will be used to store the preferences
    private val storage: SharedPreferences =
        context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    // mail is a property that will be used to get and set the user's email
    var mail: String?
        get() = storage.getString(SHARED_MAIL, null)
        set(value) = storage.edit().putString(SHARED_MAIL, value).apply()

    // pin is a property that will be used to get and set the user's pin
    var pin: String?
        get() = storage.getString(SHARED_MAIL, null)
        set(value) = storage.edit().putString(SHARED_MAIL, value).apply()

}
