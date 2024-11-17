package com.example.irkokey.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.irkokey.domain.models.Password
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for the passwords table.
 */
@Dao
interface PasswordDao {

    /**
     * Inserts a new password into the database. If a password with the same id already exists, it will be replaced.
     *
     * @param password The password to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPassword(password: Password)


    /**
     * Retrieves all passwords from the database, ordered by website in ascending order.
     *
     * @return A Flow that emits a list of all passwords.
     */
    @Query("SELECT * FROM passwords_table ORDER BY website ASC")
    fun getAllPasswords(): Flow<List<Password>>

    /**
     * Retrieves a password by its id.
     *
     * @param id The id of the password to be retrieved.
     * @return The password with the specified id.
     */
    @Query("SELECT * FROM passwords_table WHERE id = :id")
    suspend fun getPasswordById(id: Int): Password

    /**
     * Updates the password of a specific entry in the database.
     *
     * @param id The id of the password to be updated.
     * @param password The new password hash.
     */
    @Query("UPDATE passwords_table SET password_hash = :password WHERE id = :id")
    suspend fun updatePassword(id: Int, password: String)

    /**
     * Deletes a password from the database.
     *
     * @param id The id of the password to be deleted.
     */
    @Query("DELETE FROM passwords_table WHERE id = :id")
    suspend fun deletePassword(id: Int)

    /**
     * Changes the favorite status of a password.
     *
     * @param id The id of the password to be updated.
     * @param favorite The new favorite status.
     */
    @Query("UPDATE passwords_table SET favorite = :favorite WHERE id = :id")
    suspend fun changeFavorite(id: Int, favorite: Boolean)

    /**
     * Retrieves all favorite passwords from the database, ordered by website in ascending order.
     *
     * @return A Flow that emits a list of all favorite passwords.
     */
    @Query("SELECT * FROM passwords_table WHERE favorite = true ORDER BY website ASC")
    fun getAllFavorites(): Flow<List<Password>>

    /**
     * Deletes all passwords from the database.
     */
    @Query("DELETE FROM passwords_table")
    suspend fun deleteAllPasswords()

    /**
     * Retrieves all passwords from the database as a list.
     *
     * @return A list of all passwords.
     */
    @Query("SELECT * FROM passwords_table")
    suspend fun getAllPasswordsList(): List<Password>

}