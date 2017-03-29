package com.hcon.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by kunlun on 2017/3/29.
 */
public class Aes {
    private static final String KEY_ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static String generateKey() {
        KeyGenerator kg;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        kg.init(128);
        SecretKey secretKey = kg.generateKey();
        return Base64.encode(secretKey.getEncoded(), Base64.Format.Purified);
    }

    public static Key getKey(String key) {
        return new SecretKeySpec(Base64.decode(key), KEY_ALGORITHM);
    }

    public static String decrypt(String value, Key key) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(Base64.decode(value));
            return Bytes.getString(decrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String value, Key key) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(Bytes.getBytes(value));
            return Base64.encode(encrypted, Base64.Format.UrlSafe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}