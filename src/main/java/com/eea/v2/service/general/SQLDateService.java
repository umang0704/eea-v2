package com.eea.v2.service.general;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SQLDateService {
    public static Date getSQLDate(String format, String date) {

        try {
            return new Date(new SimpleDateFormat(format).parse(date).getTime());
        } catch (ParseException e) {
            return null;
        }
    }
}
