package com.yzhan648.lil.learning_spring.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date createDateFromDateString(String dateString) {
        if (dateString == null) return new Date();
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        }catch (ParseException pe){
            date=new Date();
        }
        return date;
    }

}
