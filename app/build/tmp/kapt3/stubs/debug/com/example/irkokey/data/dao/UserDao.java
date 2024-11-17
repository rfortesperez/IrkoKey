package com.example.irkokey.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.irkokey.domain.models.User;

/**
 * Data Access Object for the users table.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/irkokey/data/dao/UserDao;", "", "deleteAllUsers", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserById", "Lcom/example/irkokey/domain/models/User;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "user", "(Lcom/example/irkokey/domain/models/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface UserDao {
    
    /**
     * Inserts a new user into the database. If a user with the same id already exists, it will be replaced.
     *
     * @param user The user to be inserted.
     */
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Retrieves a user by their id.
     *
     * @param id The id of the user to be retrieved.
     * @return The user with the specified id.
     */
    @androidx.room.Query(value = "SELECT * FROM user_table WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.irkokey.domain.models.User> $completion);
    
    /**
     * Deletes all users from the database.
     */
    @androidx.room.Query(value = "DELETE FROM user_table")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllUsers(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}