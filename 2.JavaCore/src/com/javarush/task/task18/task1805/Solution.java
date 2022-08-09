package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> mapByte = new HashMap<>();
        try (InputStreamReader is = new InputStreamReader(new FileInputStream(new Scanner(System.in).nextLine()))) {
            while (is.ready()) {
                int current = is.read();
                if (!mapByte.containsKey(current)) mapByte.put(current, 1);
                else {
                    int count = mapByte.get(current) + 1;
                    mapByte.put(current, count);
                }
            }

        }
//        mapByte.entrySet().stream().forEach(System.out::println);

        Map<Integer, Integer> topMap = mapByte.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));

//        topMap.entrySet().stream().forEach(System.out::println);
/*        AtomicInteger minValue = new AtomicInteger();
        minValue.set(Collections.min(mapByte.values()));*/

/*        mapByte.forEach((k, v) -> {
            if (minValue.get() < v) minValue.set(v);
        });*/
        topMap.forEach((k, v) -> {
            System.out.print(k + " ");
        });
    }
}
