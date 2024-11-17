package com.example.irkokey.common.infraestructure

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * A singleton class for managing shared preferences.
 * @param context The application context.
 */
@Singleton
class Preferences @Inject constructor(context: Context) {

    private val SHARED_NAME = "sharedPreferences"
    private val SHARED_MAIL = "mail"
    private val SHARED_PIN = "pin"


    // storage is the object that will be used to store the preferences
    private val storage: SharedPreferences =
        context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    /**
     * Property to get and set the user's email.
     */
    var mail: String?
        get() = storage.getString(SHARED_MAIL, null)
        set(value) = storage.edit().putString(SHARED_MAIL, value).apply()

    /**
     * Property to get and set the user's pin.
     */
    var pin: String?
        get() = storage.getString(SHARED_PIN, null)
        set(value) = storage.edit().putString(SHARED_PIN, value).apply()

    /**
     * Property to get and set the derived key.
     */
    var derivedKey: String?
        get() = storage.getString("derived_key", null)
        set(value) = storage.edit().putString("derived_key", value).apply()

}
