package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();

        FileInputStream fis = new FileInputStream(file1);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);

        String all = new String(bytes);
        String[] dbl= all.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String c : dbl) {
            double x = Double.parseDouble(c);
            double y = Math.round(x);
            String z = String.format("%.0f", y);

            stringBuilder.append(z).append(" ");
        }

        FileWriter fileWriter = new FileWriter(file2);
        fileWriter.write(stringBuilder.toString());

        fileWriter.close();
        fis.close();
        scanner.close();
    }


}
