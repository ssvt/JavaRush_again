package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = bfr.readLine();
        String fileOut = bfr.readLine();
        bfr.close();
        try ( BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut));){
            while (fileReader.ready()){
                String line = fileReader.readLine();
                Pattern p = Pattern.compile("\\b[\\d]+\\b");
                Matcher m = p.matcher(line);

                while (m.find()){
//                    System.out.println(m.group(0));
                    bufferedWriter.write(m.group(0));
                    bufferedWriter.write(" ");
                }
            }

        }
    }
}
