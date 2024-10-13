package com.example.irkokey.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passwords_table")
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
    val favorite: Boolean = false
)
