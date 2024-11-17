package com.example.irkokey.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class that represents a user entity in the database.
 *
 * @property id The unique identifier of the user.
 * @property hashedEmail The hashed email of the user.
 * @property hashedPassword The hashed password of the user.
 */
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 1,
    @ColumnInfo(name = "hashed_email")
    val hashedEmail: String,
    @ColumnInfo(name = "hashed_password")
    val hashedPassword: String
)