package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/* 
Самый богатый
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

        Double max = map.get(map.firstKey());

        for (Double dbl: map.values()) {
            if (dbl > max) max = dbl;
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue().equals(max)) System.out.println(pair.getKey());
        }

    }
}
