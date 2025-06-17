package com.spring_boot_mongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    public static String decodeParam(String text) throws UnsupportedEncodingException {
        return URLDecoder.decode(text, java.nio.charset.StandardCharsets.UTF_8);
    }

    public static Date convertDate(String text, Date defaultValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        try {
            return sdf.parse(text);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
