package com.javarush.task.task18.task1818;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        String file3 = scanner.nextLine();


        try (FileInputStream fis2 = new FileInputStream(file2); FileInputStream fis3 = new FileInputStream(file3) ){
            byte[] chars = new byte[fis2.available()];
            fis2.read(chars);
            writeToFile(file1, chars, false);
            byte[] array3 = new byte[fis3.available()];
            fis3.read(array3);
            writeToFile(file1, array3, true);
        }

    }

    /**
     * Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);
     * @param fileName
     * @param byteArray
     * @param append
     * @throws IOException
     */
    public static void writeToFile (String fileName, byte[] byteArray, boolean append) throws IOException {

        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(byteArray);

        fos.close();

/*        if (append) Files.write(Paths.get(fileName), byteArray, StandardOpenOption.APPEND);
        else Files.write(Paths.get(fileName), byteArray, StandardOpenOption.WRITE);*/
    }
}
