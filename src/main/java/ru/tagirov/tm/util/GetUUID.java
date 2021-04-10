package ru.tagirov.tm.util;

import java.util.UUID;

public class GetUUID {
    String id;

    public String getUuid(){
        return id = UUID.randomUUID().toString();
    }
}
