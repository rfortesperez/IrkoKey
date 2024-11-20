package com.example.irkokey.presentation.modules.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.common.infraestructure.Preferences;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.common.utils.SingleLiveEvent;
import com.example.irkokey.data.repository.UserRepository;
import com.example.irkokey.domain.models.User;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

/**
 * ViewModel for the RegisterActivity.
 * Handles user registration logic.
 *
 * @property prefs Preferences instance for storing user data.
 * @property userRepository UserRepository instance for database operations.
 * @property encryptionUtil EncryptionUtil instance for hashing user data.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/irkokey/presentation/modules/register/RegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "prefs", "Lcom/example/irkokey/common/infraestructure/Preferences;", "userRepository", "Lcom/example/irkokey/data/repository/UserRepository;", "encryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "(Lcom/example/irkokey/common/infraestructure/Preferences;Lcom/example/irkokey/data/repository/UserRepository;Lcom/example/irkokey/common/utils/EncryptionUtil;)V", "_isError", "Lcom/example/irkokey/common/utils/SingleLiveEvent;", "", "isError", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "didClickOnRegister", "", "email", "", "pin", "confirmPin", "isMailValidRegex", "isPinValid", "registerUser", "user", "Lcom/example/irkokey/domain/models/User;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class RegisterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.infraestructure.Preferences prefs = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.EncryptionUtil encryptionUtil = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.SingleLiveEvent<java.lang.Boolean> _isError = null;
    
    @javax.inject.Inject
    public RegisterViewModel(@org.jetbrains.annotations.NotNull
    com.example.irkokey.common.infraestructure.Preferences prefs, @org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull
    com.example.irkokey.common.utils.EncryptionUtil encryptionUtil) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isError() {
        return null;
    }
    
    /**
     * Validates the email using a regex pattern.
     *
     * @param email The email to be validated.
     * @return True if the email is valid, false otherwise.
     */
    private final boolean isMailValidRegex(java.lang.String email) {
        return false;
    }
    
    /**
     * Validates the PIN length.
     *
     * @param pin The PIN to be validated.
     * @return True if the PIN length is valid, false otherwise.
     */
    private final boolean isPinValid(java.lang.String pin) {
        return false;
    }
    
    /**
     * Handles the register button click event.
     * Validates the email and PIN, hashes them, and stores the user data.
     *
     * @param email The user's email.
     * @param pin The user's PIN.
     * @param confirmPin The confirmation PIN.
     */
    public final void didClickOnRegister(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String pin, @org.jetbrains.annotations.NotNull
    java.lang.String confirmPin) {
    }
    
    /**
     * Registers the user in the database.
     *
     * @param user The user to be registered.
     */
    private final void registerUser(com.example.irkokey.domain.models.User user) {
    }
}