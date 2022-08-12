package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String fileName = scanner.nextLine();
            if (fileName.equals("exit")) break;
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();

            readThread.join();
            resultMap.forEach((k, v) -> {
                System.out.println(k + " | " + v);
            });
        }
    }

    public static class ReadThread extends Thread {
        private static String file;
        public ReadThread(String fileName) {
            file = fileName;
        }

        @Override
        public void run() {
            try (FileInputStream fileInputStream = new FileInputStream(file);) {
                Map<Integer, Integer> mapBytesFile = new HashMap<>();
                while (fileInputStream.available() > 0){
                    int data = fileInputStream.read();

                    if (mapBytesFile.containsKey(data))
                        mapBytesFile.put(data, mapBytesFile.get(data)+1);
                    else
                        mapBytesFile.put(data, 1);
                }

                int maxByte = Collections.max(mapBytesFile.entrySet(), Map.Entry.comparingByValue()).getKey();
//                    int maxByte = Collections.max(mapBytesFile.values());


                resultMap.put(file, maxByte);

                interrupt();
            } catch (FileNotFoundException e) {
                System.out.println("не могу найти это файл");
            } catch (IOException e) {
                e.printStackTrace();
            }
 /*           try {
                byte[] array = Files.readAllBytes(Paths.get(flN));
                IntStream.range(0, array.length).map(idx -> array[idx]).boxed()
                        .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                        .entrySet().stream()
                        .max(Comparator.comparingLong(e -> e.getValue()))
                        .ifPresent(e -> resultMap.put(flN, e.getKey()));
            } catch (IOException e) {
                e.printStackTrace();
            }*/

        }
    }
}
