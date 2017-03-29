package com.hcon.utils;

import com.google.common.base.Charsets;

public class Str {
    public static StringBuilder padding(String s, char letter, int repeats) {
        StringBuilder sb = new StringBuilder(s);
        while (repeats-- > 0) {
            sb.append(letter);
        }

        return sb;
    }


    public static StringBuilder removeLastLetters(String s, char letter) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.charAt(sb.length() - 1) == letter)
            sb.deleteCharAt(sb.length() - 1);

        return sb;
    }


    public static byte[] getUtf8Bytes(String s) {
        return s.getBytes(Charsets.UTF_8);
    }

    public static String newUtf8Str(byte[] bytes) {
        return new String(bytes, Charsets.UTF_8);
    }

    public static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }


    public static void main(String args[]) {

        System.out.println(Str.capitalize("dasdafdasd"));

    }
}
