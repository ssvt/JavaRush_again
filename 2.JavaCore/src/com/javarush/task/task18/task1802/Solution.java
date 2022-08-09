package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int minByte = 0;
        try (InputStreamReader is = new InputStreamReader(new FileInputStream(new Scanner(System.in).nextLine()))){
            minByte = is.read();
            while (is.ready()){
                int currentByte = is.read();
                if (currentByte < minByte) minByte = currentByte;
            }

        }
        System.out.println(minByte);
    }
}
