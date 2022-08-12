package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> mapa = new HashMap<>();
        String outFileName = null;
        while (true){
            String fileName = scanner.nextLine();
            if (fileName.equals("end")) break;

            char[] ch = fileName.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < ch.length; i++) {
                if (Character.isDigit(ch[i])) {
                    stringBuilder.append(ch[i]);
                }
            }
            int partNumber = Integer.parseInt(stringBuilder.toString().trim());
            outFileName = fileName.substring(0, fileName.indexOf("part") - 1);


            try (FileInputStream fis = new FileInputStream(fileName)) {
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);

                mapa.put(partNumber, new String(bytes));
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName, true));){
            List sortedKeys = new ArrayList(mapa.keySet());
            Collections.sort(sortedKeys);
            sortedKeys.forEach(k -> {
                try {
                    writer.write(mapa.get(k));
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println(k + " | " + mapa.get(k));
            });

        }
    }
}
