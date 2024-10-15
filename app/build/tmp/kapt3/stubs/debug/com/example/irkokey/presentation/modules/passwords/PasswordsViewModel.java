package com.example.irkokey.presentation.modules.passwords;

import android.content.ClipData;
import android.content.ClipboardManager;
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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nJ\u0016\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0016H\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordsViewModel;", "Landroidx/lifecycle/ViewModel;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "clipboardManager", "Landroid/content/ClipboardManager;", "(Lcom/example/irkokey/data/repository/PasswordRepository;Landroid/content/ClipboardManager;)V", "_allPasswords", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/irkokey/domain/models/Password;", "_isCopied", "Lcom/example/irkokey/common/utils/SingleLiveEvent;", "", "_isCorrect", "_showDeleteConfirmation", "allPasswords", "getAllPasswords", "()Landroidx/lifecycle/LiveData;", "isCopied", "isCorrect", "keyString", "", "secretKey", "Ljavax/crypto/SecretKey;", "showDeleteConfirmation", "getShowDeleteConfirmation", "addFavorite", "", "password", "confirmDeletePassword", "copyPassword", "deletePassword", "editPassword", "newPassword", "getDecryptedPassword", "encryptedPassword", "isPasswordStrong", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PasswordsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.repository.PasswordRepository passwordRepository = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.ClipboardManager clipboardManager = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.irkokey.domain.models.Password>> _allPasswords = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.SingleLiveEvent<java.lang.Boolean> _isCorrect = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.SingleLiveEvent<com.example.irkokey.domain.models.Password> _showDeleteConfirmation = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.SingleLiveEvent<java.lang.Boolean> _isCopied = null;
    @org.jetbrains.annotations.NotNull
    private final javax.crypto.SecretKey secretKey = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String keyString = null;
    
    @javax.inject.Inject
    public PasswordsViewModel(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.PasswordRepository passwordRepository, @org.jetbrains.annotations.NotNull
    android.content.ClipboardManager clipboardManager) {
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
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isCopied() {
        return null;
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
    java.lang.String password) {
    }
}