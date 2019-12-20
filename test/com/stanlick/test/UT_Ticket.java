package com.stanlick.test;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class UT_Ticket {

    LocalDate Dec_01_2019 = LocalDate.of(2019,12,1);
    LocalDate Dec_13_2019 = LocalDate.of(2019,12,13);
    LocalDate Dec_16_2019 = LocalDate.of(2019,12,16);
    LocalDate Dec_20_2019 = LocalDate.of(2019,12,20);
    LocalDate Dec_31_2019 = LocalDate.of(2019,12,31);

    @Test
    public void test_over_weekend() {
        ElapsedUtil.setMockToday(Dec_20_2019);
        Ticket ticket = new Ticket(Dec_13_2019);
        assertEquals(5, ticket.getWorkingDaysOpen());
    }

    @Test
    public void test_without_weekend() {
        ElapsedUtil.setMockToday(Dec_20_2019);
        Ticket ticket = new Ticket(Dec_16_2019);
        assertEquals(4, ticket.getWorkingDaysOpen());
    }

    @Test
    public void test_entire_month_of_december() {
        ElapsedUtil.setMockToday(Dec_31_2019);
        Ticket ticket = new Ticket(Dec_01_2019);
        assertEquals(21, ticket.getWorkingDaysOpen());
    }

    @Test
    public void test_across_weekends() {
        ElapsedUtil.setMockToday(Dec_31_2019);
        Ticket ticket = new Ticket(Dec_20_2019);
        assertEquals(7, ticket.getWorkingDaysOpen());
    }

    @Test
    public void test_closed_ticket() {
        ElapsedUtil.setMockToday(Dec_31_2019);
        Ticket ticket = new Ticket(Dec_20_2019);
        ticket.close();
        assertEquals(7, ticket.getWorkingDaysOpen());
    }
}
