package com.cuong.cdroid.calendar;

public class TimeUtils {
    private int hour;
    private int minute;
    private int second;

    public TimeUtils() {
    }

    public TimeUtils(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public long getSecondsBetweenTwoDay(DateUtils from, DateUtils to) {
        int days = new DateUtils().countDaysBetweenTwoDate(
                from.getYear(), from.getMonth(), from.getDay(), to.getYear(), to.getMonth(), to.getDay()
        );
        return days * 86400;
    }

    public long getMinutesBetweenTwoDay(DateUtils from, DateUtils to) {
        int days = new DateUtils().countDaysBetweenTwoDate(
                from.getYear(), from.getMonth(), from.getDay(), to.getYear(), to.getMonth(), to.getDay()
        );
        return days * 1440;
    }

    public long getHoursBetweenTwoDay(DateUtils from, DateUtils to) {
        int days = new DateUtils().countDaysBetweenTwoDate(
                from.getYear(), from.getMonth(), from.getDay(), to.getYear(), to.getMonth(), to.getDay()
        );
        return days * 24;
    }

}
