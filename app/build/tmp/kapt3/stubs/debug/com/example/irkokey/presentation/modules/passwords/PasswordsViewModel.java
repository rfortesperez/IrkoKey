package com.example.irkokey.presentation.modules.passwords;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.data.repository.PasswordRepository;
import com.example.irkokey.domain.models.Password;
import com.example.irkokey.presentation.modules.createPassword.CreateViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u0016\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u000e\u001a\u00020\u0017R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordsViewModel;", "Landroidx/lifecycle/ViewModel;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "(Lcom/example/irkokey/data/repository/PasswordRepository;)V", "_allPasswords", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/irkokey/domain/models/Password;", "_isCorrect", "", "_isFavorite", "allPasswords", "Landroidx/lifecycle/LiveData;", "getAllPasswords", "()Landroidx/lifecycle/LiveData;", "createViewModel", "Lcom/example/irkokey/presentation/modules/createPassword/CreateViewModel;", "getCreateViewModel", "()Lcom/example/irkokey/presentation/modules/createPassword/CreateViewModel;", "isCorrect", "isFavorite", "addFavorite", "", "password", "copyPassword", "copyUserName", "deletePassword", "editPassword", "newPassword", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PasswordsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.repository.PasswordRepository passwordRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.irkokey.domain.models.Password>> _allPasswords = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isFavorite = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isCorrect = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.presentation.modules.createPassword.CreateViewModel createViewModel = null;
    
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
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isFavorite() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isCorrect() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.presentation.modules.createPassword.CreateViewModel getCreateViewModel() {
        return null;
    }
    
    public final void getAllPasswords() {
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
    
    public final void copyPassword(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password) {
    }
    
    public final void copyUserName(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password) {
    }
}