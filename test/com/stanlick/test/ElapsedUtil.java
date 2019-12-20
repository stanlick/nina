package com.stanlick.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ElapsedUtil {

    private static LocalDate today = LocalDate.now();

    public static long calcWeekDaysBetweenTodayAnd(final LocalDate start) {
        System.out.println("calcWeekDaysBetweenTodayAnd being calculated...");
        return calcWeekDaysBetweenTodayAnd(start, today);
    }

    public static long calcWeekDaysBetweenTodayAnd(final LocalDate start, final LocalDate end) {
        final DayOfWeek startW = start.getDayOfWeek();
        final DayOfWeek endW = (end==null) ? LocalDate.now().getDayOfWeek():end.getDayOfWeek();

        final long days = ChronoUnit.DAYS.between(start, end);
        final long daysWithoutWeekends = days - 2 * ((days + startW.getValue())/7);

        //adjust for starting and ending on a Sunday:
        return daysWithoutWeekends + (startW == DayOfWeek.SUNDAY ? 1 : 0) + (endW == DayOfWeek.SUNDAY ? 1 : 0);
    }

    /*
        For simulating current date in unit tests
     */
    public static void setMockToday(LocalDate what) {
        ElapsedUtil.today = what;
    }
}
