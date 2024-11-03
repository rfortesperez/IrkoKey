package com.example.irkokey.presentation.modules.passwords;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.databinding.RowPasswordBinding;
import com.example.irkokey.domain.models.Password;
import com.example.irkokey.domain.models.WebsiteIcon;
import com.example.irkokey.domain.models.WebsiteIcons;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordAction;", "", "()V", "AddFavorite", "CopyPassword", "Delete", "Edit", "Lcom/example/irkokey/presentation/modules/passwords/PasswordAction$AddFavorite;", "Lcom/example/irkokey/presentation/modules/passwords/PasswordAction$CopyPassword;", "Lcom/example/irkokey/presentation/modules/passwords/PasswordAction$Delete;", "Lcom/example/irkokey/presentation/modules/passwords/PasswordAction$Edit;", "app_debug"})
public abstract class PasswordAction {
    
    private PasswordAction() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordAction$AddFavorite;", "Lcom/example/irkokey/presentation/modules/passwords/PasswordAction;", "password", "Lcom/example/irkokey/domain/models/Password;", "(Lcom/example/irkokey/domain/models/Password;)V", "getPassword", "()Lcom/example/irkokey/domain/models/Password;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class AddFavorite extends com.example.irkokey.presentation.modules.passwords.PasswordAction {
        @org.jetbrains.annotations.NotNull
        private final com.example.irkokey.domain.models.Password password = null;
        
        public AddFavorite(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.domain.models.Password getPassword() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.domain.models.Password component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.presentation.modules.passwords.PasswordAction.AddFavorite copy(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordAction$CopyPassword;", "Lcom/example/irkokey/presentation/modules/passwords/PasswordAction;", "password", "Lcom/example/irkokey/domain/models/Password;", "(Lcom/example/irkokey/domain/models/Password;)V", "getPassword", "()Lcom/example/irkokey/domain/models/Password;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class CopyPassword extends com.example.irkokey.presentation.modules.passwords.PasswordAction {
        @org.jetbrains.annotations.NotNull
        private final com.example.irkokey.domain.models.Password password = null;
        
        public CopyPassword(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.domain.models.Password getPassword() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.domain.models.Password component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.presentation.modules.passwords.PasswordAction.CopyPassword copy(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordAction$Delete;", "Lcom/example/irkokey/presentation/modules/passwords/PasswordAction;", "password", "Lcom/example/irkokey/domain/models/Password;", "(Lcom/example/irkokey/domain/models/Password;)V", "getPassword", "()Lcom/example/irkokey/domain/models/Password;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Delete extends com.example.irkokey.presentation.modules.passwords.PasswordAction {
        @org.jetbrains.annotations.NotNull
        private final com.example.irkokey.domain.models.Password password = null;
        
        public Delete(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.domain.models.Password getPassword() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.domain.models.Password component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.presentation.modules.passwords.PasswordAction.Delete copy(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/irkokey/presentation/modules/passwords/PasswordAction$Edit;", "Lcom/example/irkokey/presentation/modules/passwords/PasswordAction;", "password", "Lcom/example/irkokey/domain/models/Password;", "(Lcom/example/irkokey/domain/models/Password;)V", "getPassword", "()Lcom/example/irkokey/domain/models/Password;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Edit extends com.example.irkokey.presentation.modules.passwords.PasswordAction {
        @org.jetbrains.annotations.NotNull
        private final com.example.irkokey.domain.models.Password password = null;
        
        public Edit(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.domain.models.Password getPassword() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.domain.models.Password component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.presentation.modules.passwords.PasswordAction.Edit copy(@org.jetbrains.annotations.NotNull
        com.example.irkokey.domain.models.Password password) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}