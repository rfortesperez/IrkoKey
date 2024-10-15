package com.example.irkokey.presentation.modules.passwords;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.irkokey.R;
import com.example.irkokey.data.repository.PasswordRepository;
import com.example.irkokey.databinding.FragmentPasswordsBinding;
import com.example.irkokey.domain.models.Password;
import com.google.android.material.snackbar.Snackbar;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/irkokey/presentation/modules/passwords/PasswordsViewAdapter;", "binding", "Lcom/example/irkokey/databinding/FragmentPasswordsBinding;", "listener", "Lcom/example/irkokey/presentation/modules/passwords/OnItemClick;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "getPasswordRepository", "()Lcom/example/irkokey/data/repository/PasswordRepository;", "setPasswordRepository", "(Lcom/example/irkokey/data/repository/PasswordRepository;)V", "passwordsList", "", "Lcom/example/irkokey/domain/models/Password;", "viewModel", "Lcom/example/irkokey/presentation/modules/passwords/PasswordsViewModel;", "getViewModel", "()Lcom/example/irkokey/presentation/modules/passwords/PasswordsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_debug"})
public final class PasswordsFragment extends androidx.fragment.app.Fragment {
    private com.example.irkokey.databinding.FragmentPasswordsBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.List<com.example.irkokey.domain.models.Password> passwordsList;
    private com.example.irkokey.presentation.modules.passwords.PasswordsViewAdapter adapter;
    @javax.inject.Inject
    public com.example.irkokey.data.repository.PasswordRepository passwordRepository;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.presentation.modules.passwords.OnItemClick listener = null;
    
    public PasswordsFragment() {
        super();
    }
    
    private final com.example.irkokey.presentation.modules.passwords.PasswordsViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.data.repository.PasswordRepository getPasswordRepository() {
        return null;
    }
    
    public final void setPasswordRepository(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.PasswordRepository p0) {
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