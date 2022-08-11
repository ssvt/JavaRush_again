package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        try (FileInputStream fis = new FileInputStream(file1); FileOutputStream fos = new FileOutputStream(file2)){

            byte[] inArray = new byte[fis.available()];
            fis.read(inArray);

//            for (byte b: inArray ) { System.out.print(String.format("%02x ", b)); }
//            System.out.println();

            for (int i = 0; i < inArray.length / 2 ; i++) {
                byte temp = inArray[i];
                inArray[i] = inArray[inArray.length - 1 - i];
                inArray[inArray.length - 1 - i] = temp;
            }
//            for (byte b: inArray ) { System.out.print(String.format("%02x ", b)); }
            fos.write(inArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
