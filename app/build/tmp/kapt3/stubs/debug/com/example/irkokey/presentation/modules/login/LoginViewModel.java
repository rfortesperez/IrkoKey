package com.example.irkokey.presentation.modules.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.common.infraestructure.Preferences;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/irkokey/presentation/modules/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "prefs", "Lcom/example/irkokey/common/infraestructure/Preferences;", "(Lcom/example/irkokey/common/infraestructure/Preferences;)V", "PASSWORD_LENGTH", "", "_isError", "Landroidx/lifecycle/MutableLiveData;", "", "isError", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "didClickOnLogin", "", "mail", "", "pass", "isEmailValidRegex", "email", "isPasswordValid", "password", "saveUser", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.infraestructure.Preferences prefs = null;
    private final int PASSWORD_LENGTH = 4;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isError = null;
    
    @javax.inject.Inject
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.example.irkokey.common.infraestructure.Preferences prefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isError() {
        return null;
    }
    
    private final boolean isEmailValidRegex(java.lang.String email) {
        return false;
    }
    
    private final boolean isPasswordValid(java.lang.String password) {
        return false;
    }
    
    private final void saveUser(java.lang.String mail) {
    }
    
    public final void didClickOnLogin(@org.jetbrains.annotations.NotNull
    java.lang.String mail, @org.jetbrains.annotations.NotNull
    java.lang.String pass) {
    }
}