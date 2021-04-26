package ru.tagirov.tm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    private static StringBuilder builder = null;
    private static MessageDigest md5;

    public static String getMd5(String password){
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());
            builder = new StringBuilder();
            for (byte b : bytes){
                builder.append(String.format("%2X", b));
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
