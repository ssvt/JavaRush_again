package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true){
            line = scanner.nextLine();
            if ("exit".equals(line)) break;
            try {
                if (line.contains(".")) {
                    double dbl = Double.parseDouble(line);
                    print(dbl);
                }else {
                    throw new IllegalArgumentException();
                }
            }catch (Exception e){
                try {
                    int x = Integer.parseInt(line);
                    if (x > 0 && x < 128) print(Short.valueOf(line));
                    else print(x);

                }catch (Exception ex){
                    print(line);
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
