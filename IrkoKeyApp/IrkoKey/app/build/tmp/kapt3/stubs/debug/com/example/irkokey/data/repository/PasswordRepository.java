package com.example.irkokey.data.repository;

import androidx.annotation.WorkerThread;
import com.example.irkokey.data.dao.PasswordDao;
import com.example.irkokey.domain.models.Password;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0007J\u0019\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0011H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/irkokey/data/repository/PasswordRepository;", "", "passwordDao", "Lcom/example/irkokey/data/dao/PasswordDao;", "(Lcom/example/irkokey/data/dao/PasswordDao;)V", "changeFavorite", "", "id", "", "favorite", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassword", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPasswords", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/irkokey/domain/models/Password;", "insertPassword", "password", "(Lcom/example/irkokey/domain/models/Password;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassword", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PasswordRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.dao.PasswordDao passwordDao = null;
    
    @javax.inject.Inject
    public PasswordRepository(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.dao.PasswordDao passwordDao) {
        super();
    }
    
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertPassword(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.irkokey.domain.models.Password>> getAllPasswords() {
        return null;
    }
    
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updatePassword(int id, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deletePassword(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object changeFavorite(int id, boolean favorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}