package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        try(FileInputStream fis = new FileInputStream(filePath)) {
            Scanner scan = new Scanner(fis);
            List<Integer> list = new ArrayList<>();
            List<Integer> sortedList = new ArrayList<>();
            while (scan.hasNext()){
                list.add(Integer.parseInt(scan.nextLine()));
            }

            list.stream().forEach(ln -> {
                if (ln % 2 == 0) sortedList.add(ln);
            });

            sortedList.stream()
                    .sorted((i1, i2) -> i1.compareTo(i2))
                    .forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
