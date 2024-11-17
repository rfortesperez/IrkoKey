package com.example.irkokey.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.irkokey.data.dao.PasswordDao
import com.example.irkokey.data.dao.UserDao
import com.example.irkokey.domain.models.Password
import com.example.irkokey.domain.models.User


/**
 * The Room database for this app, containing the User and Password entities.
 */
@Database(entities = [User::class, Password::class], version = 1, exportSchema = false)
abstract class PasswordRoomDatabase : RoomDatabase() {

    /**
     * Gets the PasswordDao for accessing password-related database operations.
     *
     * @return The PasswordDao instance.
     */
    abstract fun passwordDao(): PasswordDao
    /**
     * Gets the UserDao for accessing user-related database operations.
     *
     * @return The UserDao instance.
     */
    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: PasswordRoomDatabase? = null

        /**
         * Gets the singleton instance of the database. If it doesn't exist, creates it.
         *
         * @param context The application context.
         * @return The PasswordRoomDatabase instance.
         */
        fun getDatabase(context: Context): PasswordRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PasswordRoomDatabase::class.java,
                    "password_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}