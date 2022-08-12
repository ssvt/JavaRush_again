package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream(args[0])){
            Map<Byte, Integer> mapa = new HashMap<>();

            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);

            for (byte bt: bytes) {

                if (!mapa.containsKey(bt)) mapa.put(bt, 1);
                else {
                    int cnt = mapa.get(bt);
                    cnt++;
                    mapa.put(bt, cnt);
                }
            }
            Map<Byte, Integer> sortMap = new TreeMap<>(mapa);


            sortMap.forEach((k, v) -> {
                char ch = (char)k.byteValue();
                System.out.println(ch + " " + v);
            });
        }
    }
}
