package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(bfr.readLine()));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bfr.readLine()))){
            while (fileReader.ready()){
                String line = fileReader.readLine();
                line = line.replaceAll("\\p{Punct}", "");
                fileWriter.write(line);
            }
        }
    }
}
