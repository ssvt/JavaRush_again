package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bfr.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bfr.readLine()))){
            String line = fileReader.readLine();
            line = line.replace(".", "!");
            fileWriter.write(line);
        }
    }
}
