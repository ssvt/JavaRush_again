package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Ищем нужные строки
*/

/**
 * @author Sergey Svyatoha
 */
public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String  name = consoleReader.readLine();
//        String name = "d:/fl";
        FileReader fileReader = new FileReader(name);
        BufferedReader reader = new BufferedReader(fileReader);
        int count = 0;

        while (reader.ready()){
            String line = reader.readLine();
            List<String> list = Arrays.asList(line.split("\\s"));
            for (String str: list ) {
                if (words.contains(str)) count++;
            }

            if (count == 2) System.out.println(line);
            count = 0;
        }

        reader.close();
        fileReader.close();
        consoleReader.close();
    }
}
