package com.hcon.common;

import com.hcon.utils.Aes;
import org.n3r.diamond.client.Miner;
import org.n3r.diamond.client.Minerable;

import java.security.Key;

/**
 * Created by kunlun on 2017/3/29.
 */
public class HconAes {

    public Key getCookieKey() {
        Minerable system = new Miner().getMiner("hcon.base", "system");
        String encryptionKeyConfig = system.getString("cookie.encryption.key", "8Ts1Ax2Duehy7BSLJEo2Rg==");

        return Aes.getKey(encryptionKeyConfig);
    }

    public String encryptCookieName(String value) {
        return Aes.encrypt(value, getCookieKey());
    }

    public String decryptCookieName(String value) {
        return Aes.decrypt(value, getCookieKey());
    }

    private  Key getAesKey() {
        Minerable miner = new Miner().getMiner("poet.base", "system");
        return Aes.getKey(miner.getString("hcon.secure.key", "RXBHaOCc/fAz5WyD3+fxjQ"));
    }

    public String encrypt(String value) {
        return Aes.encrypt(value, getAesKey());
    }

    public String decrypt(String value) {
        return Aes.decrypt(value, getAesKey());
    }
}
