package com.example.irkokey.presentation.modules.favoritePasswords;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.irkokey.R;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.data.repository.PasswordRepository;
import com.example.irkokey.databinding.FragmentFavoriteBinding;
import com.example.irkokey.domain.models.Password;
import com.example.irkokey.common.utils.PasswordDiffCallback;
import com.example.irkokey.data.repository.UserRepository;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0002J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00102\u001a\u00020%H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u00a8\u00063"}, d2 = {"Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteViewAdapter;", "binding", "Lcom/example/irkokey/databinding/FragmentFavoriteBinding;", "encryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "getEncryptionUtil", "()Lcom/example/irkokey/common/utils/EncryptionUtil;", "setEncryptionUtil", "(Lcom/example/irkokey/common/utils/EncryptionUtil;)V", "favoritePasswordsList", "", "Lcom/example/irkokey/domain/models/Password;", "listener", "Lcom/example/irkokey/presentation/modules/favoritePasswords/OnFavItemClick;", "passwordRepository", "Lcom/example/irkokey/data/repository/PasswordRepository;", "getPasswordRepository", "()Lcom/example/irkokey/data/repository/PasswordRepository;", "setPasswordRepository", "(Lcom/example/irkokey/data/repository/PasswordRepository;)V", "userRepository", "Lcom/example/irkokey/data/repository/UserRepository;", "getUserRepository", "()Lcom/example/irkokey/data/repository/UserRepository;", "setUserRepository", "(Lcom/example/irkokey/data/repository/UserRepository;)V", "viewModel", "Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteViewModel;", "getViewModel", "()Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "filter", "", "text", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showCopyConfirmationDialog", "app_debug"})
public final class FavoriteFragment extends androidx.fragment.app.Fragment {
    private com.example.irkokey.databinding.FragmentFavoriteBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.List<com.example.irkokey.domain.models.Password> favoritePasswordsList;
    private com.example.irkokey.presentation.modules.favoritePasswords.FavoriteViewAdapter adapter;
    @javax.inject.Inject
    public com.example.irkokey.data.repository.PasswordRepository passwordRepository;
    @javax.inject.Inject
    public com.example.irkokey.common.utils.EncryptionUtil encryptionUtil;
    @javax.inject.Inject
    public com.example.irkokey.data.repository.UserRepository userRepository;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.presentation.modules.favoritePasswords.OnFavItemClick listener = null;
    
    public FavoriteFragment() {
        super();
    }
    
    private final com.example.irkokey.presentation.modules.favoritePasswords.FavoriteViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.data.repository.PasswordRepository getPasswordRepository() {
        return null;
    }
    
    public final void setPasswordRepository(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.PasswordRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.common.utils.EncryptionUtil getEncryptionUtil() {
        return null;
    }
    
    public final void setEncryptionUtil(@org.jetbrains.annotations.NotNull
    com.example.irkokey.common.utils.EncryptionUtil p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.irkokey.data.repository.UserRepository getUserRepository() {
        return null;
    }
    
    public final void setUserRepository(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.repository.UserRepository p0) {
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
    
    private final void showCopyConfirmationDialog() {
    }
    
    private final void filter(java.lang.String text) {
    }
}