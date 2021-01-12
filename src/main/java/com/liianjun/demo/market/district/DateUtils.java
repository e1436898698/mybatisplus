package com.liianjun.demo.market.district;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getDate(LocalDateTime dateTime){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDateTime localDateTime=LocalDateTime.now();
        return formatter.format(localDateTime);

    }

    public static String getDateTo(LocalDateTime dateTime){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyyMM");
        LocalDateTime localDateTime=LocalDateTime.now();
        return formatter.format(localDateTime);
    }
}
