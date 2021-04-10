package ru.tagirov.tm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetMd5 {

    public String getMd5(String password){
        StringBuilder builder = null;
        MessageDigest md5;

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
