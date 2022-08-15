package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bfr.readLine();
        String file2 = bfr.readLine();
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        int count = 0;
        while (fileReader.ready()){
            int ch = fileReader.read();
            count = count + 1;
            if (count % 2 == 0) fileWriter.write(ch);

        }


        fileReader.close();
        fileWriter.close();
        bfr.close();
    }
}
