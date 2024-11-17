package com.example.irkokey.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Data class that represents a password entity in the database.
 *
 * @property id The unique identifier of the password.
 * @property website The website associated with the password.
 * @property userName The username associated with the password.
 * @property password The hashed password.
 * @property isFavorite Indicates whether the password is marked as a favorite.
 */
@Entity(
    tableName = "passwords_table",
    indices = [Index(value = ["website", "userName"], unique = true)]
)
data class Password(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "website")
    val website: String,
    @ColumnInfo(name = "userName")
    val userName: String,
    @ColumnInfo(name = "password_hash")
    val password: String,
    @ColumnInfo(name = "favorite")
    val isFavorite: Boolean = false
)