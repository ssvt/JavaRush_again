package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] querryArrays = url.split("\\?");
        String[] paramArrays = querryArrays[1].split("&");
        List<String> listParam = new ArrayList<>();
        AtomicReference<String> doublValue = new AtomicReference<>();
        Arrays.stream(paramArrays).forEach(param -> {
            listParam.add(param.split("=")[0]);
            if (param.split("=")[0].equals("obj")) {
                doublValue.set(param.split("=")[1]);
            }

        });
        listParam.stream().forEach(pr -> System.out.print(pr + " "));
        System.out.println();
        if (doublValue.get() != null){
            try {
                double value = Double.parseDouble(doublValue.get());
                alert(value);
            }catch (Exception ex){
                alert(doublValue.get());
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
