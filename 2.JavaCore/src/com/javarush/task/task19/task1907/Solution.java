package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bfr.readLine();
        FileReader fileReader = new FileReader(fileName);

        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            stringBuilder.append((char) fileReader.read());
        }
        String allLine = stringBuilder.toString();

        Pattern p = Pattern.compile("\\bworld\\b");
        Matcher m = p.matcher(allLine);
        int cnt = 0;
        while (m.find()){
            cnt++;
        }

        System.out.println(cnt);


//        System.out.println(stringBuilder);

        fileReader.close();
        bfr.close();
    }
}
