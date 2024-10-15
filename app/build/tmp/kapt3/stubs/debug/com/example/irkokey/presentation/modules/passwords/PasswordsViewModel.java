package com.example.irkokey.presentation.modules.passwords;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.common.utils.PasswordStrengthUtil;
import com.example.irkokey.common.utils.SingleLiveEvent;
import com.example.irkokey.data.repository.PasswordRepository;
import com.example.irkokey.domain.models.Password;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.crypto.SecretKey;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u0016\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f\u00a8\u0006$"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordsViewModel;", "Landroidx/lifecycle/ViewModel;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "(Lcom/example/irkokey/data/repository/PasswordRepository;)V", "_allPasswords", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/irkokey/domain/models/Password;", "_isCorrect", "Lcom/example/irkokey/common/utils/SingleLiveEvent;", "", "_showDeleteConfirmation", "allPasswords", "getAllPasswords", "()Landroidx/lifecycle/LiveData;", "isCorrect", "keyString", "", "secretKey", "Ljavax/crypto/SecretKey;", "showDeleteConfirmation", "getShowDeleteConfirmation", "addFavorite", "", "password", "confirmDeletePassword", "copyPassword", "copyUserName", "deletePassword", "editPassword", "newPassword", "getDecryptedPassword", "encryptedPassword", "isPasswordStrong", "savePassword", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PasswordsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.repository.PasswordRepository passwordRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.irkokey.domain.models.Password>> _allPasswords = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.SingleLiveEvent<java.lang.Boolean> _isCorrect = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.SingleLiveEvent<com.example.irkokey.domain.models.Password> _showDeleteConfirmation = null;
    @org.jetbrains.annotations.NotNull
    private final javax.crypto.SecretKey secretKey = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String keyString = null;
    
    @javax.inject.Inject
    public PasswordsViewModel(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.PasswordRepository passwordRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.irkokey.domain.models.Password>> getAllPasswords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isCorrect() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.irkokey.domain.models.Password> getShowDeleteConfirmation() {
        return null;
    }
    
    public final void savePassword(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password) {
    }
    
    public final void confirmDeletePassword(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDecryptedPassword(@org.jetbrains.annotations.NotNull
    java.lang.String encryptedPassword) {
        return null;
    }
    
    public final void addFavorite(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password) {
    }
    
    public final void deletePassword(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password) {
    }
    
    public final void editPassword(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password, @org.jetbrains.annotations.NotNull
    java.lang.String newPassword) {
    }
    
    private final boolean isPasswordStrong(java.lang.String newPassword) {
        return false;
    }
    
    public final void copyPassword(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password) {
    }
    
    public final void copyUserName(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password) {
    }
}