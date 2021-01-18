package com.newland.bd.component.common.tuple.record.struct;

import com.newland.bd.component.common.exception.ComponentCommonError;
import com.newland.bd.component.common.exception.ComponentException;
import com.newland.bd.component.common.ext.date.dateparser.AutoDateParserUtils;
import com.newland.bd.component.common.tuple.Column;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间字段
 * User: YECK
 * Date: 2019/11/14
 */
public class DateColumn implements Column {
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("GMT+8");

    private String standardValue = ""; //yyyy-MM-dd HH:mm:ss

    /**
     * 构造一个时间对象.使用自动匹配格式.
     *
     * @param column
     */
    public DateColumn(String column) {
        if (column != null && !column.isEmpty()) {
            standardValue = AutoDateParserUtils.parseStandardTime(column);
        }
    }

    /**
     * @param column
     * @param format
     */
    public DateColumn(String column, String format) {
        if (column != null && !column.isEmpty()) {
            if (format == null || format.isEmpty()) {
                standardValue = AutoDateParserUtils.parseStandardTime(column);
            } else {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                    Date date = simpleDateFormat.parse(column);
                    standardValue = DateFormatUtils.format(date, DEFAULT_DATE_TIME_FORMAT);
                } catch (ParseException e) {
                    throw new ComponentException(ComponentCommonError.C_COMMON_00003, "无法转换时间字符串[" + column + "]为format[" + format + "]格式");
                }
            }
        }
    }

    /**
     * 毫秒数/秒数
     *
     * @param millis
     */
    public DateColumn(long millis) {
        Date date = new Date(millis);
        DateFormatUtils.format(date, DEFAULT_DATE_TIME_FORMAT);
    }

    public DateColumn(Date date) {
        if (date != null) {
            this.standardValue = DateFormatUtils.format(date, DEFAULT_DATE_TIME_FORMAT);
        }
    }

    public DateColumn(Date date, String format) {
        if (date != null) {
            if (format == null || format.isEmpty()) {
                this.standardValue = DateFormatUtils.format(date, DEFAULT_DATE_FORMAT);
            } else {
                this.standardValue = DateFormatUtils.format(date, format);
            }
        }
    }

    @Override
    public String asString() {
        return standardValue;
    }

    @Override
    public String getValue() {
        return standardValue;
    }
}