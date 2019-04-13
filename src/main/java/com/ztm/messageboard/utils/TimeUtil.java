package com.ztm.messageboard.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String dateTOString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }
    public static Date stringToDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date time = new Date();
        try {
            time = sdf.parse(date);
        }catch(ParseException pe){
            pe.printStackTrace();
        }
        return time;
    }
}
