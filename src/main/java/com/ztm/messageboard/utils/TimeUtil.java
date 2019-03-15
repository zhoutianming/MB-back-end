package com.ztm.messageboard.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String dateTOString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
