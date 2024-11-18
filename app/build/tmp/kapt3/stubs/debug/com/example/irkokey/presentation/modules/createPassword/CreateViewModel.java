package com.example.irkokey.presentation.modules.createPassword;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.common.utils.PasswordStrengthUtil;
import com.example.irkokey.common.utils.SingleLiveEvent;
import com.example.irkokey.data.repository.PasswordRepository;
import com.example.irkokey.domain.models.Password;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

/**
 * ViewModel class for handling the creation of new passwords.
 * This ViewModel is annotated with `@HiltViewModel` to support dependency injection with Hilt.
 *
 * @property passwordRepository The repository for password data.
 * @property encryptionUtil The utility class for encryption and decryption.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bJ\u0012\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020 H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/irkokey/presentation/modules/createPassword/CreateViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "encryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "(Landroid/app/Application;Lcom/example/irkokey/data/repository/PasswordRepository;Lcom/example/irkokey/common/utils/EncryptionUtil;)V", "_generatedPassword", "Lcom/example/irkokey/common/utils/SingleLiveEvent;", "", "_isComplete", "", "_isCorrect", "generatedPassword", "Landroidx/lifecycle/LiveData;", "getGeneratedPassword", "()Landroidx/lifecycle/LiveData;", "isComplete", "isCorrect", "didClickGenerateButton", "", "didClickSaveButton", "website", "username", "password", "generateStrongPassword", "length", "", "isPasswordStrong", "savePassword", "Lcom/example/irkokey/domain/models/Password;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class CreateViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.repository.PasswordRepository passwordRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.EncryptionUtil encryptionUtil = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.SingleLiveEvent<java.lang.Boolean> _isCorrect = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.SingleLiveEvent<java.lang.Boolean> _isComplete = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.SingleLiveEvent<java.lang.String> _generatedPassword = null;
    
    @javax.inject.Inject
    public CreateViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application, @org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.PasswordRepository passwordRepository, @org.jetbrains.annotations.NotNull
    com.example.irkokey.common.utils.EncryptionUtil encryptionUtil) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isCorrect() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isComplete() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getGeneratedPassword() {
        return null;
    }
    
    /**
     * Saves the password to the database after encrypting it.
     *
     * @param password The password object to be saved.
     */
    private final void savePassword(com.example.irkokey.domain.models.Password password) {
    }
    
    /**
     * Checks if the password is strong enough and saves it.
     *
     * @param website The website associated with the password.
     * @param username The username associated with the password.
     * @param password The password to be saved.
     */
    public final void didClickSaveButton(@org.jetbrains.annotations.NotNull
    java.lang.String website, @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    /**
     * Responds to the click of the generate button.
     */
    public final void didClickGenerateButton() {
    }
    
    /**
     * Generates a strong password.
     *
     * @param length The length of the password to be generated. Default is 12.
     * @return The generated strong password.
     */
    private final java.lang.String generateStrongPassword(int length) {
        return null;
    }
    
    /**
     * Checks if the password is strong enough.
     *
     * @param password The password to be checked.
     * @return True if the password is strong, false otherwise.
     */
    private final boolean isPasswordStrong(java.lang.String password) {
        return false;
    }
}