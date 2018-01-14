package com.jkubica.persistence;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.jkubica.persistence.Constants.DATE_TIME_PATTERN;

/**
 * Created by jkubica on 14.01.2018.
 */

public class CommonUtils {

    // =============================================================================================
    // Attributes
    // =============================================================================================

    static DateFormat df = new SimpleDateFormat(DATE_TIME_PATTERN);

    // =============================================================================================
    // Data time methods
    // =============================================================================================

    /**
     * Convert {@link Date} to {@link String}
     *
     * @param date
     * @return
     */
    public static String fromDateToString(Date date) {
        return date == null ? null : df.format(date);
    }

    /**
     * Convert {@link String} to {@link Date}
     *
     * @param strDate
     * @return
     */
    public static Date fromStringToDate(String strDate) {
        if (strDate != null) {
            try {
                return df.parse(strDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Remove miliseconds from date
     *
     * @param value
     *
     * @return - rounded date
     */
    public static Date removeMiliseconds(Date value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(value);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
