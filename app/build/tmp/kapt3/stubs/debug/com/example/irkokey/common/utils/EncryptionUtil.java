package com.example.irkokey.common.utils;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/irkokey/common/utils/EncryptionUtil;", "", "()V", "KEYSET_NAME", "", "MASTER_KEY_URI", "PREF_FILE_NAME", "aead", "Lcom/google/crypto/tink/Aead;", "keysetHandle", "Lcom/google/crypto/tink/KeysetHandle;", "checkInitialization", "", "decrypt", "encryptedData", "decryptKeyWithPin", "encryptedKey", "pin", "encrypt", "data", "encryptKeyWithPin", "key", "exportKey", "hash", "importKey", "initialize", "context", "Landroid/content/Context;", "app_debug"})
public final class EncryptionUtil {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEYSET_NAME = "irkokey_keyset";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PREF_FILE_NAME = "irkokey_pref";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String MASTER_KEY_URI = "android-keystore://irkokey_master_key";
    private static com.google.crypto.tink.Aead aead;
    private static com.google.crypto.tink.KeysetHandle keysetHandle;
    @org.jetbrains.annotations.NotNull
    public static final com.example.irkokey.common.utils.EncryptionUtil INSTANCE = null;
    
    private EncryptionUtil() {
        super();
    }
    
    public final void initialize(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
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
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String exportKey() {
        return null;
    }
    
    public final void importKey(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String encryptKeyWithPin(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String pin) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String decryptKeyWithPin(@org.jetbrains.annotations.NotNull
    java.lang.String encryptedKey, @org.jetbrains.annotations.NotNull
    java.lang.String pin) {
        return null;
    }
    
    private final void checkInitialization() {
    }
}