package com.example.irkokey.presentation.modules.passwords;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.irkokey.databinding.RowPasswordBinding;
import com.example.irkokey.domain.models.Password;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordsViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/irkokey/presentation/modules/passwords/PasswordsViewAdapter$ViewHolder;", "passwords", "", "Lcom/example/irkokey/domain/models/Password;", "listener", "Lcom/example/irkokey/presentation/modules/passwords/OnItemClick;", "(Ljava/util/List;Lcom/example/irkokey/presentation/modules/passwords/OnItemClick;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class PasswordsViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.irkokey.presentation.modules.passwords.PasswordsViewAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.irkokey.domain.models.Password> passwords = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.presentation.modules.passwords.OnItemClick listener = null;
    
    public PasswordsViewAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.irkokey.domain.models.Password> passwords, @org.jetbrains.annotations.NotNull
    com.example.irkokey.presentation.modules.passwords.OnItemClick listener) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.irkokey.presentation.modules.passwords.PasswordsViewAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.irkokey.presentation.modules.passwords.PasswordsViewAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordsViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/irkokey/databinding/RowPasswordBinding;", "(Lcom/example/irkokey/databinding/RowPasswordBinding;)V", "bind", "", "password", "Lcom/example/irkokey/domain/models/Password;", "listener", "Lcom/example/irkokey/presentation/modules/passwords/OnItemClick;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.irkokey.databinding.RowPasswordBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.example.irkokey.databinding.RowPasswordBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password, @org.jetbrains.annotations.NotNull
        com.example.irkokey.presentation.modules.passwords.OnItemClick listener) {
        }
    }
}