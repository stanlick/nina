package com.stanlick.test;

import java.time.LocalDate;

public class Ticket {

    LocalDate receivedOn;
    long daysToComplete;


    public Ticket(LocalDate receivedOn) {
        this.receivedOn = receivedOn;
    }

    public long getWorkingDaysOpen(){
        return (daysToComplete>0) ? daysToComplete : ElapsedUtil.calcWeekDaysBetweenTodayAnd(receivedOn);
    }

    public void close(){
        daysToComplete = ElapsedUtil.calcWeekDaysBetweenTodayAnd(receivedOn);
    }
}
