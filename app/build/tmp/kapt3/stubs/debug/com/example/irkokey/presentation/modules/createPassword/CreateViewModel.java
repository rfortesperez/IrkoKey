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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0019H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/irkokey/presentation/modules/createPassword/CreateViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "encryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "(Landroid/app/Application;Lcom/example/irkokey/data/repository/PasswordRepository;Lcom/example/irkokey/common/utils/EncryptionUtil;)V", "_isComplete", "Lcom/example/irkokey/common/utils/SingleLiveEvent;", "", "_isCorrect", "isComplete", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "isCorrect", "didClickSaveButton", "", "website", "", "username", "password", "isPasswordStrong", "savePassword", "Lcom/example/irkokey/domain/models/Password;", "app_debug"})
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
    
    private final void savePassword(com.example.irkokey.domain.models.Password password) {
    }
    
    public final void didClickSaveButton(@org.jetbrains.annotations.NotNull
    java.lang.String website, @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    private final boolean isPasswordStrong(java.lang.String password) {
        return false;
    }
}