package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException, CorruptedDataException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();

        Scanner fileScanner = new Scanner(new FileReader(file1));
        while (fileScanner.hasNext()){
            allLines.add(fileScanner.nextLine());
        }
        Scanner fileScanner2 = new Scanner(new FileReader(file2));
        while (fileScanner2.hasNext()){
            forRemoveLines.add(fileScanner2.nextLine());
        }

        Solution solution = new Solution();
        solution.joinData();

        scanner.close();
        fileScanner.close();
        fileScanner2.close();
    }

    public void joinData() throws CorruptedDataException {
/*        boolean job = false;

        for (String lineSecond: forRemoveLines) {
            if (allLines.contains(lineSecond)){
                allLines.remove(lineSecond);
                job = true;
            }
        }

        if (!job) {
            allLines.clear();
            allLines.clear();
            throw new CorruptedDataException();
        }*/

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }else {
            allLines.clear();
            throw new CorruptedDataException();
        }

//        allLines.stream().forEach(System.out::println);


    }
}
