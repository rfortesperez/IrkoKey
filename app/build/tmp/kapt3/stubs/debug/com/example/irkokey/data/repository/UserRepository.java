package com.example.irkokey.data.repository;

import androidx.annotation.WorkerThread;
import com.example.irkokey.data.dao.UserDao;
import com.example.irkokey.domain.models.User;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/example/irkokey/data/repository/UserRepository;", "", "userDao", "Lcom/example/irkokey/data/dao/UserDao;", "(Lcom/example/irkokey/data/dao/UserDao;)V", "insertUser", "", "user", "Lcom/example/irkokey/domain/models/User;", "(Lcom/example/irkokey/domain/models/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class UserRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.data.dao.UserDao userDao = null;
    
    @javax.inject.Inject
    public UserRepository(@org.jetbrains.annotations.NotNull
    com.example.irkokey.data.dao.UserDao userDao) {
        super();
    }
    
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}