package com.example.irkokey.presentation.modules.favoritePasswords;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.irkokey.data.repository.PasswordRepository;
import com.example.irkokey.databinding.FragmentFavoriteBinding;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/irkokey/databinding/FragmentFavoriteBinding;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "getPasswordRepository", "()Lcom/example/irkokey/data/repository/PasswordRepository;", "setPasswordRepository", "(Lcom/example/irkokey/data/repository/PasswordRepository;)V", "viewModel", "Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteViewModel;", "getViewModel", "()Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_debug"})
public final class FavoriteFragment extends androidx.fragment.app.Fragment {
    private com.example.irkokey.databinding.FragmentFavoriteBinding binding;
    @javax.inject.Inject
    public com.example.irkokey.data.repository.PasswordRepository passwordRepository;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    
    public FavoriteFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.data.repository.PasswordRepository getPasswordRepository() {
        return null;
    }
    
    public final void setPasswordRepository(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.PasswordRepository p0) {
    }
    
    private final com.example.irkokey.presentation.modules.favoritePasswords.FavoriteViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}