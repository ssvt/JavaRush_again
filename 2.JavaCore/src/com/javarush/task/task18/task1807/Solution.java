package com.javarush.task.task18.task1807;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream(new Scanner(System.in).nextLine())){
            int count = 0;
            if (fis.available() > 0) {
                byte[] inputArray = new byte[fis.available()];
                fis.read(inputArray, 0, fis.available());
                for (byte bt: inputArray) {
//                    System.out.print(bt + " ");
                    if (bt == (int)',') count = count +  1;
                }
            }

            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
