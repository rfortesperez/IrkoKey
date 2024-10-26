package com.example.irkokey.common.utils

object PasswordStrengthUtil {

    /* Check if password is strong using the following criteria: contains at least 12 characters,
    * at least one lowercase letter, at least one uppercase letter, at least one digit, and at least one special character.
    * */

    fun isPasswordStrong(password: String): Boolean {
        return password.length >= 12 &&
                containsLowerCase(password) &&
                containsUpperCase(password) &&
                containsDigit(password) &&
                containsSpecialCharacter(password)
    }

    // Check if password contains lowercase letter
    private fun containsLowerCase(password: String): Boolean {
        val regex = Regex("[a-z]")
        return regex.containsMatchIn(password)
    }

    // Check if password contains uppercase letter
    private fun containsUpperCase(password: String): Boolean {
        val regex = Regex("[A-Z]")
        return regex.containsMatchIn(password)
    }

    // Check if password contains digit
    private fun containsDigit(password: String): Boolean {
        val regex = Regex("[0-9]")
        return regex.containsMatchIn(password)
    }

    // Check if password contains special character
    private fun containsSpecialCharacter(password: String): Boolean {
        val regex = Regex("[^A-Za-z0-9]")
        return regex.containsMatchIn(password)
    }
}