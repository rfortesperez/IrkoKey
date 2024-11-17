package com.example.irkokey.data.repository

import androidx.annotation.WorkerThread
import com.example.irkokey.data.dao.PasswordDao
import com.example.irkokey.domain.models.Password
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * Repository class for managing password-related data operations.
 *
 * @property passwordDao The DAO for accessing password data.
 */
class PasswordRepository @Inject constructor(private val passwordDao: PasswordDao) {

    /**
     * Inserts a new password into the database.
     *
     * @param password The password to be inserted.
     */
    @WorkerThread
    suspend fun insertPassword(password: Password) {
        passwordDao.insertPassword(password)
    }

    /**
     * Retrieves all passwords from the database as a Flow.
     *
     * @return A Flow that emits a list of all passwords.
     */
    @WorkerThread
    fun getAllPasswords(): Flow<List<Password>> {
        return passwordDao.getAllPasswords()
    }
    /**
     * Retrieves a password by its id.
     *
     * @param id The id of the password to be retrieved.
     * @return The password with the specified id.
     */
    @WorkerThread
    suspend fun getPasswordById(id: Int):  Password {
        return passwordDao.getPasswordById(id)
    }

    /**
     * Retrieves all favorite passwords from the database as a Flow.
     *
     * @return A Flow that emits a list of all favorite passwords.
     */
    @WorkerThread
    fun getAllFavorites(): Flow<List<Password>> {
        return passwordDao.getAllFavorites()
    }

    /**
     * Updates the password of a specific entry in the database.
     *
     * @param id The id of the password to be updated.
     * @param password The new password hash.
     */
    @WorkerThread
    suspend fun updatePassword(id: Int, password: String) {
        passwordDao.updatePassword(id, password)
    }

    /**
     * Deletes a password from the database.
     *
     * @param id The id of the password to be deleted.
     */
    @WorkerThread
    suspend fun deletePassword(id: Int) {
        passwordDao.deletePassword(id)
    }

    /**
     * Changes the favorite status of a password.
     *
     * @param id The id of the password to be updated.
     */
    @WorkerThread
    suspend fun changeFavorite(id: Int) {
        val favorite = getPasswordById(id).isFavorite
        passwordDao.changeFavorite(id, !favorite)
    }


    /**
     * Deletes all passwords from the database.
     */
    @WorkerThread
    suspend fun deleteAllPasswords() {
        passwordDao.deleteAllPasswords()
    }
    /**
     * Retrieves all passwords from the database as a list.
     *
     * @return A list of all passwords.
     */
    @WorkerThread
    suspend fun getAllPasswordsList(): List<Password> {
        return passwordDao.getAllPasswordsList()
    }
}