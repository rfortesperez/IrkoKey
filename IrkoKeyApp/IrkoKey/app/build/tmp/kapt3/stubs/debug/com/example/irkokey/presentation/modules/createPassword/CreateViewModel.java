package com.example.irkokey.presentation.modules.createPassword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/example/irkokey/presentation/modules/createPassword/CreateViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_isComplete", "Landroidx/lifecycle/MutableLiveData;", "", "_isCorrect", "isComplete", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "isCorrect", "containsDigit", "password", "", "containsLowerCase", "containsSpecialCharacter", "containsUpperCase", "dicClickSaveButton", "", "website", "username", "isPasswordStrong", "savePassword", "app_debug"})
public final class CreateViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isCorrect = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isComplete = null;
    
    public CreateViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isCorrect() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isComplete() {
        return null;
    }
    
    public final void dicClickSaveButton(@org.jetbrains.annotations.NotNull
    java.lang.String website, @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    private final boolean isPasswordStrong(java.lang.String password) {
        return false;
    }
    
    private final boolean containsLowerCase(java.lang.String password) {
        return false;
    }
    
    private final boolean containsUpperCase(java.lang.String password) {
        return false;
    }
    
    private final boolean containsDigit(java.lang.String password) {
        return false;
    }
    
    private final boolean containsSpecialCharacter(java.lang.String password) {
        return false;
    }
    
    private final void savePassword(java.lang.String website, java.lang.String username, java.lang.String password) {
    }
}