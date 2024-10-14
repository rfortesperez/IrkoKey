package com.example.irkokey.data.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.irkokey.data.dao.PasswordDao;
import com.example.irkokey.data.dao.UserDao;
import com.example.irkokey.domain.models.Password;
import com.example.irkokey.domain.models.User;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/example/irkokey/data/database/PasswordRoomDatabase;", "Landroidx/room/RoomDatabase;", "()V", "passwordDao", "Lcom/example/irkokey/data/dao/PasswordDao;", "userDao", "Lcom/example/irkokey/data/dao/UserDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.irkokey.domain.models.User.class, com.example.irkokey.domain.models.Password.class}, version = 1, exportSchema = false)
public abstract class PasswordRoomDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.example.irkokey.data.database.PasswordRoomDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.example.irkokey.data.database.PasswordRoomDatabase.Companion Companion = null;
    
    public PasswordRoomDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.irkokey.data.dao.PasswordDao passwordDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.irkokey.data.dao.UserDao userDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/irkokey/data/database/PasswordRoomDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/irkokey/data/database/PasswordRoomDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.irkokey.data.database.PasswordRoomDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}