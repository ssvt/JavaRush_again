package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int id = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        FileReader fileReader = new FileReader(fileName);
        Scanner scanFile = new Scanner(fileReader);
        while (scanFile.hasNext()){
            String line = scanFile.nextLine();
            String[] compon = line.split(" ");
            int idLine = Integer.parseInt(compon[0].trim());
            if (idLine == id) System.out.println(line);

        }
        fileReader.close();
        scanner.close();
    }
}
