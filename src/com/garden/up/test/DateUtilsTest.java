package com.garden.up.test;

import com.garden.up.utils.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * 日期工具测试类
 * Created by Garden on 2018/9/26.
 */
public class DateUtilsTest {

    @Test
    public void dateFormatTest() {
        System.err.println(DateUtils.format(new Date(), DateUtils.Y_M_DHMS));
    }

    @Test
    public void stringDateFormatTest() {
        System.err.println(DateUtils.format("2018-09-26", DateUtils.Y));
    }

    @Test
    public void dateDefaultFormatTest() {
        System.err.println(DateUtils.format(new Date()));
    }

    @Test
    public void stringDefaultDateFormatTest() {
        System.err.println(DateUtils.format("2018-09-26 00:00:00"));
    }

    @Test
    public void getYearTest() {
        System.err.println(DateUtils.getYear(new Date()));
    }

    @Test
    public void getMonthTest() {
        System.err.println(DateUtils.getMonth(new Date()));
    }

    @Test
    public void getDayTest() {
        System.err.println(DateUtils.getDay(new Date()));
    }

    @Test
    public void getHourTest() {
        System.err.println(DateUtils.getHour(new Date()));
    }

    @Test
    public void getMinuteTest() {
        System.err.println(DateUtils.getMinute(new Date()));
    }

    @Test
    public void getSecondTest() {
        System.err.println(DateUtils.getSecond(new Date()));
    }

    @Test
    public void isLeapYearTest() {
        System.err.println(DateUtils.isLeapYear(new Date()));
    }

    @Test
    public void getDateDiffTest() {
        System.err.println(DateUtils.getDateDiff(new Date(), DateUtils.format("2018-09-22 00:00:00")));
    }
}
