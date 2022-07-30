package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        while (true){
            String line = scanner.nextLine();
            writer.write(line);
            writer.write("\n");
            if (line.equals("exit")) break;
        }

        writer.close();
    }
}
