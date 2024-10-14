package com.example.irkokey.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.irkokey.data.dao.PasswordDao
import com.example.irkokey.data.dao.UserDao
import com.example.irkokey.domain.models.Password
import com.example.irkokey.domain.models.User

@Database(entities = [User::class, Password::class], version = 1, exportSchema = false)
abstract class PasswordRoomDatabase : RoomDatabase() {

    abstract fun passwordDao(): PasswordDao
    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PasswordRoomDatabase? = null

        // Get a database. If it doesn't exist, create it
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