package com.javarush.task.pro.task15.task1506;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            List<String> listLines = Files.readAllLines(Paths.get(scanner.nextLine()));

            for (String line: listLines) {
                line = line.replaceAll("\\.", "");
                line = line.replaceAll(",", "");
                line = line.replaceAll(" ", "");
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Не могу найти такой файл");
        } catch (IOException e) {
            System.out.println("Ошибка ввода");;
        }
    }
}

