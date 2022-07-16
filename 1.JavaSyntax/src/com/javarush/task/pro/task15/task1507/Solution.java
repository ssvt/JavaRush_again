package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)){
            List<String> listLines = Files.readAllLines(Paths.get(scanner.nextLine()));
            int lineCnt = 1;

            for (String line : listLines) {
                if (lineCnt % 2 != 0) {
                    System.out.println(line);
                }
                lineCnt++;
            }
        }
    }
}

