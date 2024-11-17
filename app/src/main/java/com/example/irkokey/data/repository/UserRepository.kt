package com.example.irkokey.data.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.irkokey.data.dao.UserDao
import com.example.irkokey.domain.models.User
import javax.inject.Inject

/**
 * Repository class for managing user-related data operations.
 *
 * @property userDao The DAO for accessing user data.
 */
class UserRepository @Inject constructor(private val userDao: UserDao){

    /**
     * Inserts a new user into the database.
     *
     * @param user The user to be inserted.
     */
    @WorkerThread
    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    /**
     * Retrieves a user by their id.
     *
     * @param id The id of the user to be retrieved.
     * @return The user with the specified id.
     */
    @WorkerThread
    suspend fun getUser(id: Int): User {
        Log.d("UserRepository", "Getting user")
        val user = userDao.getUserById(id)
        Log.d("UserRepository", "UserHashedEmail: ${user.hashedEmail}, UserHashedPassword: ${user.hashedPassword}")
        return user
    }

    /**
     * Deletes all users from the database.
     */
    @WorkerThread
    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }
}