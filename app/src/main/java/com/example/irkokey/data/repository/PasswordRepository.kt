package com.example.irkokey.data.repository

import androidx.annotation.WorkerThread
import com.example.irkokey.data.dao.PasswordDao
import com.example.irkokey.domain.models.Password
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class PasswordRepository @Inject constructor(private val passwordDao: PasswordDao) {

    // Insert a new website, username and password in the app
    @WorkerThread
    suspend fun insertPassword(password: Password) {
        passwordDao.insertPassword(password)
    }

    // get all the data of the table passwords_table
    @WorkerThread
    fun getAllPasswords(): Flow<List<Password>> {
        return passwordDao.getAllPasswords()
    }

    @WorkerThread
    suspend fun getPasswordById(id: Int):  Password {
        return passwordDao.getPasswordById(id)
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
    suspend fun changeFavorite(id: Int) {
        val favorite = getPasswordById(id).isFavorite
        passwordDao.changeFavorite(id, !favorite)
    }

    // delete all the passwords from the table passwords_table
    @WorkerThread
    suspend fun deleteAllPasswords() {
        passwordDao.deleteAllPasswords()
    }
    //get all de passwords on a list
    @WorkerThread
    suspend fun getAllPasswordsList(): List<Password> {
        return passwordDao.getAllPasswordsList()
    }
}