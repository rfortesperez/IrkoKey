package com.example.irkokey.presentation.modules.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.data.repository.UserRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

/**
 * ViewModel class for handling user login logic.
 * This ViewModel is annotated with `@HiltViewModel` to support dependency injection with Hilt.
 *
 * @property userRepository The repository for user data.
 * @property encryptionUtil The utility class for encryption and decryption.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J!\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/irkokey/presentation/modules/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/example/irkokey/data/repository/UserRepository;", "encryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "(Lcom/example/irkokey/data/repository/UserRepository;Lcom/example/irkokey/common/utils/EncryptionUtil;)V", "_isError", "Landroidx/lifecycle/MutableLiveData;", "", "isError", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "didClickOnLogin", "", "mail", "", "pin", "isEmailValidRegex", "email", "isPindValid", "validateCredentials", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.EncryptionUtil encryptionUtil = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isError = null;
    
    @javax.inject.Inject
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull
    com.example.irkokey.common.utils.EncryptionUtil encryptionUtil) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isError() {
        return null;
    }
    
    /**
     * Validates the email format using a regular expression.
     *
     * @param email The email to be validated.
     * @return True if the email format is valid, false otherwise.
     */
    private final boolean isEmailValidRegex(java.lang.String email) {
        return false;
    }
    
    /**
     * Validates the PIN length.
     *
     * @param pin The PIN to be validated.
     * @return True if the PIN length is valid, false otherwise.
     */
    private final boolean isPindValid(java.lang.String pin) {
        return false;
    }
    
    /**
     * Validates the user's credentials by comparing the hashed values.
     *
     * @param mail The email to be validated.
     * @param pin The PIN to be validated.
     * @return True if the credentials are valid, false otherwise.
     */
    private final java.lang.Object validateCredentials(java.lang.String mail, java.lang.String pin, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Handles the login button click event.
     *
     * @param mail The email entered by the user.
     * @param pin The PIN entered by the user.
     */
    public final void didClickOnLogin(@org.jetbrains.annotations.NotNull
    java.lang.String mail, @org.jetbrains.annotations.NotNull
    java.lang.String pin) {
    }
}