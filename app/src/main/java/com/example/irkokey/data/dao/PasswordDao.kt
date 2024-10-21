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

    // get all the data of the table passwords_table
    @Query("SELECT * FROM passwords_table ORDER BY website ASC")
    fun getAllPasswords(): Flow<List<Password>>

    // get a password by its id
    @Query("SELECT * FROM passwords_table WHERE id = :id")
    suspend fun getPasswordById(id: Int): Password

    // update the password of a website
    @Query("UPDATE passwords_table SET password_hash = :password WHERE id = :id")
    suspend fun updatePassword(id: Int, password: String)

    // delete a password from the table passwords_table
    @Query("DELETE FROM passwords_table WHERE id = :id")
    suspend fun deletePassword(id: Int)

    // change the favorite status of a password
    @Query("UPDATE passwords_table SET favorite = :favorite WHERE id = :id")
    suspend fun changeFavorite(id: Int, favorite: Boolean)

    // get all the favorite passwords
    @Query("SELECT * FROM passwords_table WHERE favorite = true ORDER BY website ASC")
    fun getAllFavorites(): Flow<List<Password>>

    // delete all the passwords from the table passwords_table
    @Query("DELETE FROM passwords_table")
    suspend fun deleteAllPasswords()

}