package com.newland.bd.component.common.ext.date.dateparser;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间数据
 * User: YECK
 * Date: 2019/11/14
 */
public final class DateInfo {
    public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("GMT+8");

    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;
    int ssss;

    long millisecond;

    public void reset() {
        this.year = 0;
        this.month = 1;
        this.day = 1;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.millisecond = 0;
        this.ssss = 0;
    }

    public String getStandardTime() {
        Calendar calendar = Calendar.getInstance();
        if (millisecond != 0) {
            calendar.setTimeInMillis(millisecond);
            return DateFormatUtils.format(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
        } else {
            StringBuilder standardTime = new StringBuilder().append(year)
                                                            .append("-")
                                                            .append(month < 10 ? "0"+month : month)
                                                            .append("-")
                                                            .append(day < 10 ? "0"+day : day)
                                                            .append(" ")
                                                            .append(hour < 10 ? "0"+hour : hour)
                                                            .append(":")
                                                            .append(minute < 10 ? "0"+minute : minute)
                                                            .append(":")
                                                            .append(second < 10 ? "0"+second : second);
//            calendar.set(Calendar.MILLISECOND, ssss);
            return standardTime.toString();
        }
    }

    public Date getDate() {

        Calendar calendar = Calendar.getInstance();
        if (millisecond != 0) {
            calendar.setTimeInMillis(millisecond);
        } else {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            calendar.set(Calendar.SECOND, second);
            calendar.set(Calendar.MILLISECOND, ssss);
        }
        return calendar.getTime();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public long getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(long millisecond) {
        this.millisecond = millisecond;
    }
}
