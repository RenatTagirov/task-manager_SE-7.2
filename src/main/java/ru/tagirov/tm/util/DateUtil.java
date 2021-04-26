package ru.tagirov.tm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat formatForDateNow  = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private static Date date;
    private static String uuid;

    public static String getDate(){
        date = new java.util.Date();
        uuid = formatForDateNow.format(date);
        return uuid;
    }
}
