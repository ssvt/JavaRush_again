package com.javarush.task.task18.task1808;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            String file1 = scanner.nextLine();
            String file2 = scanner.nextLine();
            String file3 = scanner.nextLine();
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos2 = new FileOutputStream(file2);
            FileOutputStream fos3 = new FileOutputStream(file3);

            byte[] inArray = new byte[fis.available()];
            fis.read(inArray);


//            for (byte bt : inArray ) { System.out.print(String.format("%02x ", bt)); }

            int center = inArray.length / 2;
            byte[] firstHalt = new byte[inArray.length %2 == 0 ? center : center + 1];
            firstHalt = Arrays.copyOf(inArray, firstHalt.length);


            byte[] secondHalt = inArray.length %2 == 0 ? Arrays.copyOfRange(inArray, center,inArray.length) :
                    Arrays.copyOfRange(inArray, center + 1,inArray.length);

/*
            System.out.println();
            for (byte bt : firstHalt ) { System.out.print(String.format("%02x ", bt)); }
            System.out.println();
            for (byte bt : secondHalt ) { System.out.print(String.format("%02x ", bt)); }*/

            fos2.write(firstHalt);
            fos3.write(secondHalt);


            fos3.close();
            fos2.close();
            fis.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
