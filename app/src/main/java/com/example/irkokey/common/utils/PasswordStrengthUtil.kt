package com.example.irkokey.common.utils

/**
 * Utility object for checking the strength of a password.
 */
object PasswordStrengthUtil {

    /**
     * Checks if the password is strong using the following criteria:
     * contains at least 12 characters, at least one lowercase letter,
     * at least one uppercase letter, at least one digit, and at least one special character.
     *
     * @param password The password to check.
     * @return True if the password is strong, false otherwise.
     */
    fun isPasswordStrong(password: String): Boolean {
        return password.length >= 12 &&
                containsLowerCase(password) &&
                containsUpperCase(password) &&
                containsDigit(password) &&
                containsSpecialCharacter(password)
    }

    /**
     * Checks if the password contains a lowercase letter.
     *
     * @param password The password to check.
     * @return True if the password contains a lowercase letter, false otherwise.
     */
    private fun containsLowerCase(password: String): Boolean {
        val regex = Regex("[a-z]")
        return regex.containsMatchIn(password)
    }

    /**
     * Checks if the password contains an uppercase letter.
     *
     * @param password The password to check.
     * @return True if the password contains an uppercase letter, false otherwise.
     */
    private fun containsUpperCase(password: String): Boolean {
        val regex = Regex("[A-Z]")
        return regex.containsMatchIn(password)
    }

    /**
     * Checks if the password contains a digit.
     *
     * @param password The password to check.
     * @return True if the password contains a digit, false otherwise.
     */
    private fun containsDigit(password: String): Boolean {
        val regex = Regex("[0-9]")
        return regex.containsMatchIn(password)
    }

    /**
     * Checks if the password contains a special character.
     *
     * @param password The password to check.
     * @return True if the password contains a special character, false otherwise.
     */
    private fun containsSpecialCharacter(password: String): Boolean {
        val regex = Regex("[^A-Za-z0-9]")
        return regex.containsMatchIn(password)
    }
}