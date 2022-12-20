package com.javarush.task.task19.task1919;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        String file = "d:/fl";
        String file = args[0];
        SortedMap<String, Double> map = new TreeMap<>();
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()){
                String line = bufferedReader.readLine();
                String[] array = line.split(" ");

                String surName = array[0];
                Double x = Double .parseDouble(array[1]);
                if (map.containsKey(surName)){
                    map.put(surName, map.get(surName) + x);
                }else {
                    map.put(surName, x);
                }
            }
        }



//        map.forEach((k, x) -> System.out.println(k + " : " + x));
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey()+" "+pair.getValue()); // - Так проходит
        }
    }

}
