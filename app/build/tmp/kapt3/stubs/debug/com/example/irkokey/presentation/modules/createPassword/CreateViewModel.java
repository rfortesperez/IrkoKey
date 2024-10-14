package com.example.irkokey.presentation.modules.createPassword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.data.repository.PasswordRepository;
import com.example.irkokey.domain.models.Password;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/irkokey/presentation/modules/createPassword/CreateViewModel;", "Landroidx/lifecycle/ViewModel;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "(Lcom/example/irkokey/data/repository/PasswordRepository;)V", "_isComplete", "Landroidx/lifecycle/MutableLiveData;", "", "_isCorrect", "isComplete", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "isCorrect", "containsDigit", "password", "", "containsLowerCase", "containsSpecialCharacter", "containsUpperCase", "dicClickSaveButton", "", "website", "username", "isPasswordStrong", "savePassword", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class CreateViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.repository.PasswordRepository passwordRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isCorrect = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isComplete = null;
    
    @javax.inject.Inject
    public CreateViewModel(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.PasswordRepository passwordRepository) {
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
    
    public final boolean isPasswordStrong(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
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