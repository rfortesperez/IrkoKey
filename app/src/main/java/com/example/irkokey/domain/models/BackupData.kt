package com.example.irkokey.domain.models

data class BackupData(
    val user: User,
    val passwords: List<Password>,
    val keyset: String
)
