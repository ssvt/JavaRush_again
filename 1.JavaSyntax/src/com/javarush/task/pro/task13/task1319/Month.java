package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    private static Month[] allArray = Month.values();

    public static Month[] getWinterMonths() {
        Month[] winter = {allArray[11], allArray[0], allArray[1]};
        return winter;
    }

    public static Month[] getSpringMonths() {
        Month[] winter = {allArray[2], allArray[3], allArray[4]};
        return winter;
    }

    public static Month[] getSummerMonths() {
        Month[] winter = {allArray[5], allArray[6], allArray[7]};
        return winter;
    }

    public static Month[] getAutumnMonths() {
        Month[] winter = {allArray[8], allArray[9], allArray[10]};
        return winter;
    }

}
