package com.javarush.task.pro.task16.task1601;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date("Apr 07 1978");

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        return DayOfWeek.of(date.getDay()).getDisplayName(TextStyle.FULL, new Locale("ru","ru"));
    }
}
