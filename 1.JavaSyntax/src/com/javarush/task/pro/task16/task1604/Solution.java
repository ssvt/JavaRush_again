package com.javarush.task.pro.task16.task1604;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1978, Calendar.APRIL, 9);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
//        return DayOfWeek.of(calendar.get(Calendar.DAY_OF_WEEK) - 1 ).getDisplayName(TextStyle.FULL, new Locale("ru","ru"));
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1: return "воскресенье";
            case 2: return "понедельник";
            case 3: return "вторник";
            case 4: return "среда";
            case 5: return "четверг";
            case 6: return "пятница";
            case 7: return "суббота";
            default: return null;
        }

    }
}
