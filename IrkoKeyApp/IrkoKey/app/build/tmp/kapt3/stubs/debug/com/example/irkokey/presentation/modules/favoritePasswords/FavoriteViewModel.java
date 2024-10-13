package com.example.irkokey.presentation.modules.favoritePasswords;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.data.repository.PasswordRepository;
import com.example.irkokey.domain.models.Password;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteViewModel;", "Landroidx/lifecycle/ViewModel;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "(Lcom/example/irkokey/data/repository/PasswordRepository;)V", "_allFavorites", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/irkokey/domain/models/Password;", "allFavorites", "getAllFavorites", "()Landroidx/lifecycle/LiveData;", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class FavoriteViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.repository.PasswordRepository passwordRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.irkokey.domain.models.Password>> _allFavorites = null;
    
    @javax.inject.Inject
    public FavoriteViewModel(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.PasswordRepository passwordRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.irkokey.domain.models.Password>> getAllFavorites() {
        return null;
    }
    
    public final void getAllFavorites() {
    }
}