package com.hcon.utils;

public class Base64 {
    public static String encode(byte[] bytes) {
        return encode(bytes, Format.Purified);
    }

    public static String padding(String s) {
        return Str.padding(s, '=', s.length() % 4).toString();
    }

    public static String purify(String s) {
        return Str.removeLastLetters(s, '=').toString();
    }

    public static enum Format {
        Standard,
        // URL安全(将Base64中的URL非法字符'+'和'/'转为'-'和'_', 见RFC3548)
        UrlSafe,
        // 去除末尾=号
        Purified
    }

    public static String encode(String s) {
        return encode(s, Format.Purified);
    }

    public static String encode(String s, Format format) {
        return encode(Bytes.getBytes(s), format);
    }

    public static String encode(byte[] bytes, Format format) {
        switch (format) {
            case Standard:
                return org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
            case UrlSafe:
                return purify(org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(bytes));
            case Purified:
                return purify(org.apache.commons.codec.binary.Base64.encodeBase64String(bytes));
        }
        return null;
    }

    public static byte[] decode(String value) {
        return org.apache.commons.codec.binary.Base64.decodeBase64(padding(value));
    }

    public static String decodeAsString(String value) {
        return Bytes.getString(decode(value));
    }
}
