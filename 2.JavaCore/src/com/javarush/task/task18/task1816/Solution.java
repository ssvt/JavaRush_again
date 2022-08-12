package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int symbolSum = 0;
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bf = new BufferedReader(fileReader);
        while (bf.ready()){
            char lette = (char) bf.read();
//            if (Character.UnicodeBlock.of(lette).equals(Character.UnicodeBlock.BASIC_LATIN)) symbolSum++;
            String buka = String.valueOf(lette);
            if (buka.matches("[a-zA-Z]")) symbolSum++;
        }

        bf.close();
        fileReader.close();

        System.out.println(symbolSum);
    }
}
