package com.example.irkokey.presentation.modules.register;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.common.infraestructure.Preferences;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.common.utils.SingleLiveEvent;
import com.example.irkokey.data.repository.UserRepository;
import com.example.irkokey.domain.models.User;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/irkokey/presentation/modules/register/RegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "prefs", "Lcom/example/irkokey/common/infraestructure/Preferences;", "userRepository", "Lcom/example/irkokey/data/repository/UserRepository;", "encryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "(Lcom/example/irkokey/common/infraestructure/Preferences;Lcom/example/irkokey/data/repository/UserRepository;Lcom/example/irkokey/common/utils/EncryptionUtil;)V", "PIN_LENGHT", "", "_isError", "Lcom/example/irkokey/common/utils/SingleLiveEvent;", "", "isError", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "didClickOnRegister", "", "email", "", "pin", "confirmPin", "isMailValidRegex", "isPinValid", "registerUser", "user", "Lcom/example/irkokey/domain/models/User;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class RegisterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.infraestructure.Preferences prefs = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.EncryptionUtil encryptionUtil = null;
    private final int PIN_LENGHT = 6;
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
    
    private final boolean isMailValidRegex(java.lang.String email) {
        return false;
    }
    
    private final boolean isPinValid(java.lang.String pin) {
        return false;
    }
    
    public final void didClickOnRegister(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String pin, @org.jetbrains.annotations.NotNull
    java.lang.String confirmPin) {
    }
    
    private final void registerUser(com.example.irkokey.domain.models.User user) {
    }
}