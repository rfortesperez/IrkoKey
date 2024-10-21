package com.example.irkokey.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.irkokey.domain.models.User

@Dao
interface UserDao {

    // Insert a new user in the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    //Get user by Id
    @Query("SELECT * FROM user_table WHERE id = :id")
    suspend fun getUserById(id: Int): User

    // Delete all users
    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()
}