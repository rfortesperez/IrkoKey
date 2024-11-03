package com.example.irkokey.presentation.modules.favoritePasswords;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.databinding.ItemFavoritePasswordBinding;
import com.example.irkokey.domain.models.Password;
import com.example.irkokey.domain.models.WebsiteIcon;
import com.example.irkokey.domain.models.WebsiteIcons;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u000e\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0014\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0016\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0005R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteViewAdapter$ViewHolder;", "favoriteList", "", "Lcom/example/irkokey/domain/models/Password;", "actionListener", "Lkotlin/Function1;", "Lcom/example/irkokey/presentation/modules/favoritePasswords/PasswordAction;", "", "encryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lcom/example/irkokey/common/utils/EncryptionUtil;)V", "originalList", "filterList", "filteredList", "getItemCount", "", "getOriginalList", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateOriginalList", "newList", "updatePassword", "password", "ViewHolder", "app_debug"})
public final class FavoriteViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.irkokey.presentation.modules.favoritePasswords.FavoriteViewAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.irkokey.domain.models.Password> favoriteList;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.example.irkokey.presentation.modules.favoritePasswords.PasswordAction, kotlin.Unit> actionListener = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.utils.EncryptionUtil encryptionUtil = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.irkokey.domain.models.Password> originalList;
    
    public FavoriteViewAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.irkokey.domain.models.Password> favoriteList, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.irkokey.presentation.modules.favoritePasswords.PasswordAction, kotlin.Unit> actionListener, @org.jetbrains.annotations.NotNull
    com.example.irkokey.common.utils.EncryptionUtil encryptionUtil) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.irkokey.presentation.modules.favoritePasswords.FavoriteViewAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.irkokey.presentation.modules.favoritePasswords.FavoriteViewAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updatePassword(int position, @org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void filterList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.irkokey.domain.models.Password> filteredList) {
    }
    
    public final void updateOriginalList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.irkokey.domain.models.Password> newList) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.irkokey.domain.models.Password> getOriginalList() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/irkokey/presentation/modules/favoritePasswords/FavoriteViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/irkokey/databinding/ItemFavoritePasswordBinding;", "(Lcom/example/irkokey/databinding/ItemFavoritePasswordBinding;)V", "bind", "", "password", "Lcom/example/irkokey/domain/models/Password;", "actionListener", "Lkotlin/Function1;", "Lcom/example/irkokey/presentation/modules/favoritePasswords/PasswordAction;", "encryptionUtil", "Lcom/example/irkokey/common/utils/EncryptionUtil;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.irkokey.databinding.ItemFavoritePasswordBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.example.irkokey.databinding.ItemFavoritePasswordBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super com.example.irkokey.presentation.modules.favoritePasswords.PasswordAction, kotlin.Unit> actionListener, @org.jetbrains.annotations.NotNull
        com.example.irkokey.common.utils.EncryptionUtil encryptionUtil) {
        }
    }
}