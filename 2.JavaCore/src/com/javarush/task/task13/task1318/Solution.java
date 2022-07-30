package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
   /*     Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();

        FileInputStream fis = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }


        fis.close();
        reader.close();
    }
}