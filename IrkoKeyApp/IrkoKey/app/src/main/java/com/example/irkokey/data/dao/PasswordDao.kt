package com.example.irkokey.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.irkokey.domain.models.Password
import kotlinx.coroutines.flow.Flow

@Dao
interface PasswordDao {

    // Insert a new website, username and password in the app
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPassword(password: Password)

    // Get all the data of the table passwords_table
    @Query("SELECT * FROM passwords_table ORDER BY website ASC")
    fun getAllPasswords(): Flow<List<Password>>

    // Update the password of a website
    @Query("UPDATE passwords_table SET password_hash = :password WHERE id = :id")
    suspend fun updatePassword(id: Int, password: String)

    // Delete a password from the table passwords_table
    @Query("DELETE FROM passwords_table WHERE id = :id")
    suspend fun deletePassword(id: Int)

    // Change the favorite status of a password
    @Query("UPDATE passwords_table SET favorite = :favorite WHERE id = :id")
    suspend fun changeFavorite(id: Int, favorite: Boolean)

    // get all the favorite passwords
    @Query("SELECT * FROM passwords_table WHERE favorite = true ORDER BY website ASC")
    fun getAllFavorites(): Flow<List<Password>>

}