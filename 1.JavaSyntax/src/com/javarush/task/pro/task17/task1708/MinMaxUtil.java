package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {

    public static int min(int x, int y){
        return Math.min(x, y);
    }

    public static int min(int x, int y, int a){
        return Math.min(Math.min(x, y), a);
    }

    public static  int min(int x, int y, int a, int b){
        return Math.min(Math.min(Math.min(x, y), a), b);
    }

    public static  int min(int x, int y, int a, int b, int c){
        return Math.min(Math.min(Math.min(Math.min(x, y), a), b), c);
    }

    public static int max(int x, int y){
        return Math.max(x, y);
    }

    public static int max(int x, int y, int a){
        return Math.max(Math.max(x, y), a);
    }

    public static  int max(int x, int y, int a, int b){
        return Math.max(Math.max(Math.max(x, y), a), b);
    }

    public static  int max(int x, int y, int a, int b, int c){
        return Math.max(Math.max(Math.max(Math.max(x, y), a), b), c);
    }
}
