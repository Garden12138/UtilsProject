package com.garden.up.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * Created by Garden on 2018/9/26.
 */
public class DateUtils {

    /**
     * 声明日期格式常量
     */
    public static final String Y = "yyyy";
    public static final String YM = "yyyyMM";
    public static final String Y_M = "yyyy-MM";
    public static final String YMD = "yyyyMMdd";
    public static final String YMDHMS = "yyyyMMdd HH:mm:ss";
    public static final String Y_M_D = "yyyy-MM-dd";
    public static final String Y_M_DHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMDHS = "yyyyMMddHHmmss";
    public static final String YMDHMSSSS = "yyyyMMddHHmmssSSS";
    public static final String Y_M_DHMSSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String Y_M_DHMSSSSSSSSSS = "yyyy-MM-dd HH:mm.ss.SSSSSSSSS";

    /**
     * 根据格式获取日期字符串
     * @param date
     * @param pattern
     * @return
     * @ps DateToString
     */
    public static String format(Date date, String pattern) {
        if (null == date || null == pattern || "".equals(pattern)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 根据格式获取日期
     * @param date
     * @param pattern
     * @return
     * @ps StringToDate
     *     日期字符串必须大于等于字符串格式要求的字符串大小
     */
    public static Date format(String date, String pattern) {
        if (null == date || "".equals(date) || null == pattern || "".equals(pattern)) {
            return null;
        }
        Date newDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            newDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return newDate;
    }

    /**
     * 默认格式获取日期字符串
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date,DateUtils.Y_M_DHMS);
    }

    /**
     * 默认格式获取日期
     * @param date
     * @return
     */
    public static Date format(String date) {
        return format(date,DateUtils.Y_M_DHMS);
    }

    /**
     * 根据日期获取日历
     * @param date
     * @return
     */
    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * 获取年份
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        return getCalendar(date).get(Calendar.YEAR);
    }

    /**
     * 获取月份
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        return getCalendar(date).get(Calendar.MONTH);
    }

    /**
     * 获取天数
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        return getCalendar(date).get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取小时数
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        return getCalendar(date).get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分钟数
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        return getCalendar(date).get(Calendar.MINUTE);
    }

    /**
     * 获取秒数
     * @param date
     * @return
     */
    public static int getSecond(Date date) {
        return getCalendar(date).get(Calendar.SECOND);
    }

    /**
     * 根据年份判断是否为闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据日期判断是否为闰年
     * @param date
     * @return
     */
    public static boolean isLeapYear(Date date) {
        return isLeapYear(getYear(date));
    }

    /**
     * 获取两天相差天数
     * @param d1
     * @param d2
     * @return
     */
    public static long getDateDiff(Date d1, Date d2) {
        return (d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000);
    }
}
