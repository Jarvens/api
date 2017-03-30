package com.hcon.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kunlun on 2017/3/30.
 */
public class Md5 {

    private static final Logger logger = LoggerFactory.getLogger(Md5.class);

    public static String digest(String val) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(Bytes.getBytes(val));
            return Base64.encode(digest, Base64.Format.Purified);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
