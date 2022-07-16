package com.javarush.task.pro.task15.task1516;

import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {

       try(Scanner scanner = new Scanner(new InputStreamReader(System.in))){
           while (true){
               String line = scanner.nextLine();
               if (Files.isRegularFile(Path.of(line))){
                   System.out.println(line + " - это файл");
               }else if (Files.isDirectory(Path.of(line))){
                   System.out.println(line + " - это директория");
               }else {
                    return;
               }
           }
       }
    }
}

