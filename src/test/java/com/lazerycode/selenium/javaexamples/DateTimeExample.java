package com.lazerycode.selenium.javaexamples;

import java.time.LocalDate;
import java.time.LocalTime;
import static java.time.temporal.TemporalAdjusters.*;

/**
 * Created by colmh on 04/06/2015.
 */
public class DateTimeExample {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate lastDayOfMonth = today.with(lastDayOfMonth());
        LocalDate firstDayOfMonth = today.with(firstDayOfMonth());

        System.out.println( "now: " + today );
        System.out.println( "First day of month: " + firstDayOfMonth );
        System.out.println( "Last day of month: " + lastDayOfMonth );
        System.out.println( "yest: " + yesterday );

        System.out.println("-----------------------------------------");

        LocalTime now = LocalTime.now();
        System.out.println("time: " + now);

    }
}
