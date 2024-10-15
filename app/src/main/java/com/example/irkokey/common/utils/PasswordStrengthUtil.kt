package com.example.irkokey.common.utils

object PasswordStrengthUtil {
    fun isPasswordStrong(password: String): Boolean {
        return password.length >= 12 &&
                containsLowerCase(password) &&
                containsUpperCase(password) &&
                containsDigit(password) &&
                containsSpecialCharacter(password)
    }
    private fun containsLowerCase(password: String): Boolean {
        val regex = Regex("[a-z]")
        return regex.containsMatchIn(password)
    }
    private fun containsUpperCase(password: String): Boolean {
        val regex = Regex("[A-Z]")
        return regex.containsMatchIn(password)
    }
    private fun containsDigit(password: String): Boolean {
        val regex = Regex("[0-9]")
        return regex.containsMatchIn(password)
    }
    private fun containsSpecialCharacter(password: String): Boolean {
        val regex = Regex("[^A-Za-z0-9]")
        return regex.containsMatchIn(password)
    }
}