package ru.tagirov.tm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    SimpleDateFormat formatForDateNow  = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    Date date;
    String uuid;

    public String getDate(){
        date = new java.util.Date();
        uuid = formatForDateNow.format(date);
        return uuid;
    }
}
