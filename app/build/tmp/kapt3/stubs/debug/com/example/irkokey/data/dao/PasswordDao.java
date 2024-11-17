package com.example.irkokey.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.irkokey.domain.models.Password;
import kotlinx.coroutines.flow.Flow;

/**
 * Data Access Object for the passwords table.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\'J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\'J\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0018H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/example/irkokey/data/dao/PasswordDao;", "", "changeFavorite", "", "id", "", "favorite", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllPasswords", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassword", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/irkokey/domain/models/Password;", "getAllPasswords", "getAllPasswordsList", "getPasswordById", "insertPassword", "password", "(Lcom/example/irkokey/domain/models/Password;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassword", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface PasswordDao {
    
    /**
     * Inserts a new password into the database. If a password with the same id already exists, it will be replaced.
     *
     * @param password The password to be inserted.
     */
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertPassword(@org.jetbrains.annotations.NotNull
    com.example.irkokey.domain.models.Password password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Retrieves all passwords from the database, ordered by website in ascending order.
     *
     * @return A Flow that emits a list of all passwords.
     */
    @androidx.room.Query(value = "SELECT * FROM passwords_table ORDER BY website ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.irkokey.domain.models.Password>> getAllPasswords();
    
    /**
     * Retrieves a password by its id.
     *
     * @param id The id of the password to be retrieved.
     * @return The password with the specified id.
     */
    @androidx.room.Query(value = "SELECT * FROM passwords_table WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPasswordById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.irkokey.domain.models.Password> $completion);
    
    /**
     * Updates the password of a specific entry in the database.
     *
     * @param id The id of the password to be updated.
     * @param password The new password hash.
     */
    @androidx.room.Query(value = "UPDATE passwords_table SET password_hash = :password WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updatePassword(int id, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Deletes a password from the database.
     *
     * @param id The id of the password to be deleted.
     */
    @androidx.room.Query(value = "DELETE FROM passwords_table WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deletePassword(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Changes the favorite status of a password.
     *
     * @param id The id of the password to be updated.
     * @param favorite The new favorite status.
     */
    @androidx.room.Query(value = "UPDATE passwords_table SET favorite = :favorite WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object changeFavorite(int id, boolean favorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Retrieves all favorite passwords from the database, ordered by website in ascending order.
     *
     * @return A Flow that emits a list of all favorite passwords.
     */
    @androidx.room.Query(value = "SELECT * FROM passwords_table WHERE favorite = true ORDER BY website ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.irkokey.domain.models.Password>> getAllFavorites();
    
    /**
     * Deletes all passwords from the database.
     */
    @androidx.room.Query(value = "DELETE FROM passwords_table")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllPasswords(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Retrieves all passwords from the database as a list.
     *
     * @return A list of all passwords.
     */
    @androidx.room.Query(value = "SELECT * FROM passwords_table")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllPasswordsList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.irkokey.domain.models.Password>> $completion);
}