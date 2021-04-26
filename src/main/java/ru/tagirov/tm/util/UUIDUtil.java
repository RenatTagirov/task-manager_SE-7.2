package ru.tagirov.tm.util;

import java.util.UUID;

public class UUIDUtil {
    private  static String id;

    public static String getUuid(){
        return id = UUID.randomUUID().toString();
    }
}
