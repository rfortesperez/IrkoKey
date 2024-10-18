package com.example.irkokey.data.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.irkokey.data.dao.UserDao
import com.example.irkokey.domain.models.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao){

    // Insert a new user in the app for registration
    @WorkerThread
    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    // Get user by Id
    @WorkerThread
    suspend fun getUser(id: Int): User {
        Log.d("UserRepository", "Getting user")
        val user = userDao.getUserById(id)
        Log.d("UserRepository", "UserHashedEmail: ${user.hashedEmail}, UserHashedPassword: ${user.hashedPassword}")
        return user
    }
}