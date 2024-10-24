package com.example.irkokey.common.infraestructure

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(context: Context) {

    private val SHARED_NAME = "sharedPreferences"
    private val SHARED_MAIL = "mail"


    private val storage: SharedPreferences =
        context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    var mail: String?
        get() = storage.getString(SHARED_MAIL, null)
        set(value) = storage.edit().putString(SHARED_MAIL, value).apply()
    var pin: String?
        get() = storage.getString(SHARED_MAIL, null)
        set(value) = storage.edit().putString(SHARED_MAIL, value).apply()

}
/*
* 1. Se crea la clase Shared Preferences que se encarga de manejar las preferencias de la aplicación.
* 2. Se crea la propiedad privada SHARED_NAME de tipo String que representa el nombre del archivo.
* 3. Se crea la propiedad privada SHARED_MAIL de tipo String que representa la clave del correo electrónico.
* 4. Se crea la propiedad privada storage de tipo SharedPreferences que se encarga de almacenar las preferencias de la aplicación.
* 5. Se crea la propiedad pública mail de tipo String? que se encarga de obtener y asignar el correo electrónico del usuario.
* 6. La propiedad mail se encarga de obtener y asignar el correo electrónico del usuario en las preferencias de la aplicación.
* 7. @Singleton indica que la clase Preferences es un Singleton, lo que significa que solo se
* creará una instancia de la clase en toda la aplicación.
* 8. @Inject indica que el constructor de la clase Preferences será inyectado en otras clases.
* */