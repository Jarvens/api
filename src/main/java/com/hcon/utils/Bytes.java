package com.hcon.utils;

import com.google.common.base.Charsets;

public class Bytes {
    public static byte[] getBytes(String str) {
        return str == null ? null : str.getBytes(Charsets.UTF_8);
    }

    public static String getString(byte[] bytes) {
        return new String(bytes, Charsets.UTF_8);
    }
}
