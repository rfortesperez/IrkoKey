package com.example.irkokey.domain.models

/**
 * Data class that represents the backup data.
 *
 * @property user the user data.
 * @property passwords the list of passwords.
 */
data class BackupData(
    val user: User,
    val passwords: List<Password>
)
