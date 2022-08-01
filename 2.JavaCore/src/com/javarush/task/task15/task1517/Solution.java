package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

import java.time.DateTimeException;

public class Solution {
    public static int A = 0;

    static {
        int x = 5 / 0;
//        throw new NumberFormatException();
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
