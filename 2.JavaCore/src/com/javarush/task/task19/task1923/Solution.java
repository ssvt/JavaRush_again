package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Слова с цифрами
*/

/**
 * @author Sergey Svyatoha
 */

public class Solution {
    public static void main(String[] args) throws IOException {
/*        String fileInput = "d:/fl";
        String fileOut = "d:/flOut";*/
        String fileInput = args[0];
        String fileOut = args[1];
        FileReader fileReader = new FileReader(fileInput);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> listWords = new ArrayList<>();
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            List<String> arrayList = Arrays.asList(line.split("\\s"));

            for (String word : arrayList ) {
               char[] charArray = word.toCharArray();
                for (char ch : charArray ) {
                    if (Character.isDigit(ch)) {
                        listWords.add(word);
                        break;
                    }
                }
            }
        }

//        listWords.forEach(System.out::println);
        FileWriter fileWriter = new FileWriter(fileOut);
        for (String srt : listWords) {
            fileWriter.write(srt);
            fileWriter.write(" ");
        }

        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }
}
