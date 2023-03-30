package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String file = consoleReader.readLine();
//        String file = "d:/home/test.txt";

        FileReader flReader = new FileReader(file);
        BufferedReader fbr = new BufferedReader(flReader);

        while (fbr.ready()){
            String line = fbr.readLine();
      /*      List<String> listWord = Arrays.asList(line.split(" "));

            for (String wrld:listWord) {
                wrld = wrld.replace(".", "");
               if (wrld.chars().allMatch(Character::isDigit)){
                   int key = Integer.parseInt(wrld);
                   if (map.containsKey(key)){
                       line = line.replaceFirst(wrld, map.get(key));
                   }
               }
            }
            System.out.println(line);*/
            for (Map.Entry pair : map.entrySet())
                line = line.replaceAll("\\b" + pair.getKey().toString() + "\\b", pair.getValue().toString());
            System.out.println(line);
        }

        fbr.close();
        flReader.close();
        consoleReader.close();
    }
}
