/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.commun.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anas
 */
public class ConverterUtil {

    private static final Double ZERO_DOUBLE = 0D;

    public static Double toDouble(String value) {
        if (value == null || value.isEmpty()) {
            return 0D;
        } else {
            return Double.parseDouble(value);
        }
    }

    public static Integer toInteger(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(value);
        }
    }

    //convert Data to String
    public static String formateDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    //convert String to data
    public static java.util.Date parseDate(String date) throws java.text.ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return (simpleDateFormat.parse(date));
    }
}
