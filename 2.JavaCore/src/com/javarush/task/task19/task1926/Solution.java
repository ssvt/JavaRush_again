package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bfReader = new BufferedReader(new FileReader(consoleReader.readLine()))){
            while (bfReader.ready()){
                String line = bfReader.readLine();
                String reversStr = new StringBuilder(line).reverse().toString();
                System.out.println(reversStr);
            }
        }
    }
}
