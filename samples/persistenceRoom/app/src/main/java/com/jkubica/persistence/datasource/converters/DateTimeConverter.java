package com.jkubica.persistence.datasource.converters;
import android.arch.persistence.room.TypeConverter;


import com.jkubica.persistence.CommonUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.jkubica.persistence.Constants.DATE_TIME_PATTERN;

/**
 * Converter for time
 *
 * Created by jkubica on 13.01.2018.
 */
public class DateTimeConverter {

    static DateFormat df = new SimpleDateFormat(DATE_TIME_PATTERN);

    /**
     * Convert type {@link String} into {@link Date}
     *
     * @param value
     * @return
     */
    @TypeConverter
    public static Date fromTimestamp(String value) {
        return CommonUtils.fromStringToDate(value);
    }

    /**
     * Convert type {@link Date} into {@link String}
     *
     * @param value
     * @return
     */
    @TypeConverter
    public static String dateToTimestamp(Date value) {
        return CommonUtils.fromDateToString(value);
    }
}
