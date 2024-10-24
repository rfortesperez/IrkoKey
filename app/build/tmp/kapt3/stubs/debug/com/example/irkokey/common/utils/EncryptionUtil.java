package com.example.irkokey.common.utils;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.example.irkokey.common.infraestructure.Preferences;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import java.io.ByteArrayOutputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/irkokey/common/utils/EncryptionUtil;", "", "()V", "ITERATIONS", "", "KEYSET_NAME", "", "KEY_LENGTH", "MASTER_KEY_URI", "PREF_FILE_NAME", "SALT", "appContext", "Landroid/content/Context;", "derivedKey", "Ljavax/crypto/SecretKey;", "keysetHandle", "Lcom/google/crypto/tink/KeysetHandle;", "checkInitialization", "", "decrypt", "encryptedData", "derivedKeyFromUserPin", "userPin", "encrypt", "data", "exportKeyset", "getDerivedKey", "hash", "importKeyset", "encryptedKeyset", "initialize", "context", "app_debug"})
public final class EncryptionUtil {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEYSET_NAME = "irkokey_keyset";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PREF_FILE_NAME = "irkokey_pref";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String MASTER_KEY_URI = "android-keystore://irkokey_master_key";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SALT = "irkokey_salt";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    private static com.google.crypto.tink.KeysetHandle keysetHandle;
    @org.jetbrains.annotations.Nullable
    private static javax.crypto.SecretKey derivedKey;
    private static android.content.Context appContext;
    @org.jetbrains.annotations.NotNull
    public static final com.example.irkokey.common.utils.EncryptionUtil INSTANCE = null;
    
    private EncryptionUtil() {
        super();
    }
    
    public final void initialize(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    private final javax.crypto.SecretKey getDerivedKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String encrypt(@org.jetbrains.annotations.NotNull
    java.lang.String data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String decrypt(@org.jetbrains.annotations.NotNull
    java.lang.String encryptedData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String hash(@org.jetbrains.annotations.NotNull
    java.lang.String data) {
        return null;
    }
    
    private final javax.crypto.SecretKey derivedKeyFromUserPin(java.lang.String userPin) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String exportKeyset() {
        return null;
    }
    
    public final void importKeyset(@org.jetbrains.annotations.NotNull
    java.lang.String encryptedKeyset) {
    }
    
    private final void checkInitialization() {
    }
}