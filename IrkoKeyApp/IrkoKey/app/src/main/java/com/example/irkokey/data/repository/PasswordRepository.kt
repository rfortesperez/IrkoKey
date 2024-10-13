package com.example.irkokey.data.repository

import androidx.annotation.WorkerThread
import com.example.irkokey.data.dao.PasswordDao
import com.example.irkokey.domain.models.Password
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PasswordRepository @Inject constructor(private val passwordDao: PasswordDao) {

    // Insert a new website, username and password in the app
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertPassword(password: Password) {
        passwordDao.insertPassword(password)
    }


    // get all the data of the table passwords_table

    @WorkerThread
    fun getAllPasswords(): Flow<List<Password>> {
        return passwordDao.getAllPasswords()
    }

    // get all the favorite passwords
    @WorkerThread
    fun getAllFavorites(): Flow<List<Password>> {
        return passwordDao.getAllFavorites()
    }

    // update the password of a website
    @WorkerThread
    suspend fun updatePassword(id: Int, password: String) {
        passwordDao.updatePassword(id, password)
    }

    // delete a password from the table passwords_table
    @WorkerThread
    suspend fun deletePassword(id: Int) {
        passwordDao.deletePassword(id)
    }

    // change the favorite status of a password
    @WorkerThread
    suspend fun changeFavorite(id: Int, favorite: Boolean) {
        passwordDao.changeFavorite(id, favorite)
    }
}