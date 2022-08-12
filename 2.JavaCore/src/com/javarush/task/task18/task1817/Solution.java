package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileReader fileReader = new FileReader(args[0]);
             BufferedReader bf = new BufferedReader(fileReader);) {

            double sumAllSymbols = 0;
            double sumProbel = 0;

            while (bf.ready()) {
                char letter = (char) bf.read();
                String buka = String.valueOf(letter);
                sumAllSymbols++;
                if (buka.contains(" ")) sumProbel++;
            }
            double perc = sumProbel / sumAllSymbols * 100;
            System.out.println(String.format("%.2f", perc ));
        }
    }
}
