package com.javarush.task.pro.task13.task1320;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMonthByIndex(4));
        System.out.println(getMonthByIndex(8));
        System.out.println(getMonthByIndex(12));
    }

    public static String getMonthByIndex(int monthIndex) {
        switch (monthIndex){
            case 1: return "Январь";
            case 2: return "Февраль";
            case 3: return "Март";
            case 4: return "Апрель";
            case 5: return "Май";
            case 6: return"Июнь";
            case 7: return"Июль";
            case 8: return"Август";
            case 9: return"Сентябрь";
            case 10: return"Октябрь";
            case 11: return"Ноябрь";
            case 12: return"Декабрь";
            default: return "Недействительный месяц";
        }

        /*String monthString;
        if (monthIndex == 1) {
            monthString = "Январь";
        } else if (monthIndex == 2) {
            monthString = "Февраль";
        } else if (monthIndex == 3) {
            monthString = "Март";
        } else if (monthIndex == 4) {
            monthString = "Апрель";
        } else if (monthIndex == 5) {
            monthString = "Май";
        } else if (monthIndex == 6) {
            monthString = "Июнь";
        } else if (monthIndex == 7) {
            monthString = "Июль";
        } else if (monthIndex == 8) {
            monthString = "Август";
        } else if (monthIndex == 9) {
            monthString = "Сентябрь";
        } else if (monthIndex == 10) {
            monthString = "Октябрь";
        } else if (monthIndex == 11) {
            monthString = "Ноябрь";
        } else if (monthIndex == 12) {
            monthString = "Декабрь";
        } else {
            monthString = "Недействительный месяц";
        }
        return monthString;*/
    }
}
