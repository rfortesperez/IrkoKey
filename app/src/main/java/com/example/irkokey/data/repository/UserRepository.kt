package com.example.irkokey.data.repository

import androidx.annotation.WorkerThread
import com.example.irkokey.data.dao.UserDao
import com.example.irkokey.domain.models.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao){

    // Insert a new user in the app for registration
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}