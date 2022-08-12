package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();

        FileInputStream fis = new FileInputStream(file1);
        byte[] byteArray = new  byte[fis.available()];
        fis.read(byteArray);

        FileInputStream fis2 = new FileInputStream(file2);
        byte[] array2 = new byte[fis2.available()];
        fis2.read(array2);

        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(array2);
        fos.write(byteArray);


        fos.close();
        fis2.close();
        fis.close();

    }
}
