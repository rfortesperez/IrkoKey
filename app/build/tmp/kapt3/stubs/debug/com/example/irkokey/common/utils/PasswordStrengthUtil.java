package com.example.irkokey.common.utils;

/**
 * Utility object for checking the strength of a password.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/irkokey/common/utils/PasswordStrengthUtil;", "", "()V", "containsDigit", "", "password", "", "containsLowerCase", "containsSpecialCharacter", "containsUpperCase", "isPasswordStrong", "app_debug"})
public final class PasswordStrengthUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.example.irkokey.common.utils.PasswordStrengthUtil INSTANCE = null;
    
    private PasswordStrengthUtil() {
        super();
    }
    
    /**
     * Checks if the password is strong using the following criteria:
     * contains at least 12 characters, at least one lowercase letter,
     * at least one uppercase letter, at least one digit, and at least one special character.
     *
     * @param password The password to check.
     * @return True if the password is strong, false otherwise.
     */
    public final boolean isPasswordStrong(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
        return false;
    }
    
    /**
     * Checks if the password contains a lowercase letter.
     *
     * @param password The password to check.
     * @return True if the password contains a lowercase letter, false otherwise.
     */
    private final boolean containsLowerCase(java.lang.String password) {
        return false;
    }
    
    /**
     * Checks if the password contains an uppercase letter.
     *
     * @param password The password to check.
     * @return True if the password contains an uppercase letter, false otherwise.
     */
    private final boolean containsUpperCase(java.lang.String password) {
        return false;
    }
    
    /**
     * Checks if the password contains a digit.
     *
     * @param password The password to check.
     * @return True if the password contains a digit, false otherwise.
     */
    private final boolean containsDigit(java.lang.String password) {
        return false;
    }
    
    /**
     * Checks if the password contains a special character.
     *
     * @param password The password to check.
     * @return True if the password contains a special character, false otherwise.
     */
    private final boolean containsSpecialCharacter(java.lang.String password) {
        return false;
    }
}