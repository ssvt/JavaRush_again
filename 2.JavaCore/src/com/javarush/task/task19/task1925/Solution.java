package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try( BufferedReader bfReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter bfWriter = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bfReader.ready()){
                String line = bfReader.readLine();
                List<String> stringList = Arrays.asList(line.split(" "));
                for (String word: stringList) {
                    if (word.length() > 6){
                        if (stringBuilder.length() > 0) stringBuilder.append(",");
                        stringBuilder.append(word);
                    }
                }
            }
            bfWriter.write(stringBuilder.toString());

        }

    }
}
