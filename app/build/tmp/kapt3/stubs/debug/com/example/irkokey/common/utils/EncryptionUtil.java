package com.example.irkokey.common.utils;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/irkokey/common/utils/EncryptionUtil;", "", "()V", "ALGORITHM", "", "TRANSFORMATION", "decrypt", "key", "Ljavax/crypto/SecretKey;", "encryptedData", "encrypt", "data", "generateKey", "getKeyFromString", "keyString", "keyToString", "app_debug"})
public final class EncryptionUtil {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ALGORITHM = "AES";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TRANSFORMATION = "AES.ECB/PKCS5Padding";
    @org.jetbrains.annotations.NotNull
    public static final com.example.irkokey.common.utils.EncryptionUtil INSTANCE = null;
    
    private EncryptionUtil() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final javax.crypto.SecretKey generateKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String encrypt(@org.jetbrains.annotations.NotNull
    javax.crypto.SecretKey key, @org.jetbrains.annotations.NotNull
    java.lang.String data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String decrypt(@org.jetbrains.annotations.NotNull
    javax.crypto.SecretKey key, @org.jetbrains.annotations.NotNull
    java.lang.String encryptedData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final javax.crypto.SecretKey getKeyFromString(@org.jetbrains.annotations.NotNull
    java.lang.String keyString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String keyToString(@org.jetbrains.annotations.NotNull
    javax.crypto.SecretKey key) {
        return null;
    }
}