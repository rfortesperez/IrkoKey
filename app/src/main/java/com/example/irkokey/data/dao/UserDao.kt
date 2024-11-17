package com.example.irkokey.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.irkokey.domain.models.User

/**
 * Data Access Object for the users table.
 */
@Dao
interface UserDao {

    /**
     * Inserts a new user into the database. If a user with the same id already exists, it will be replaced.
     *
     * @param user The user to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)


    /**
     * Retrieves a user by their id.
     *
     * @param id The id of the user to be retrieved.
     * @return The user with the specified id.
     */
    @Query("SELECT * FROM user_table WHERE id = :id")
    suspend fun getUserById(id: Int): User

    /**
     * Deletes all users from the database.
     */
    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()
}