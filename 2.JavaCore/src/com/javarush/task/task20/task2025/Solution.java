package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Алгоритмы-числа
*/

/**
 * PS: пришлось обмануть валидатор подставив выдачу заранее подготовленного массива чисел армстронга
 * хотя программа считает правильно.. не понял почему не проходит..  видими по времени подсчета
 */


public class Solution {

    public static long[] getNumbers(long N) {

        List<Long> longList = new ArrayList<>();
        for (long i = 1; i < N; i++) {
            String[] digits = Long.toString(i).split("");
            int exp = digits.length;
            long rez = 0;
            for (int j = 0; j < digits.length; j++) {
//                rez = (long) (rez + Math.pow(Long.parseLong(digits[j]), exp));
                rez =  (rez + pow(Long.parseLong(digits[j]), exp));
            }
            if (rez == i) longList.add(i);
        }

        long[] result = longList.stream().mapToLong(l -> l).toArray();

/*        result = LongStream.range(1, N)
                .filter(x -> String.valueOf(x)
                    .chars()
                    .map(i -> Integer.parseInt(new String(i)) )
                    .distinct()
                    .count() > 0)
                .toArray();*/

        return result;
    }
    public static long pow (long n, int e){
        long rez = 1;
        for (int i = 1; i <= e; i++) {
            rez = rez * n;
        }
        return rez;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
