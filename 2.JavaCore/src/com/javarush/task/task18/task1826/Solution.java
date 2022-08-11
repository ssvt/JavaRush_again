package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        switch (args[0]){
            case "-e":
                encrypt(args[1], args[2]);
                break;
            case "-d":
                decrypt(args[1], args[2]);
                break;
            default:
                System.out.println("unknow key!!");
        }
/*        encrypt("D:\\COMMON\\OUT\\in.txt", "D:\\COMMON\\OUT\\out_1.txt");
        decrypt("D:\\COMMON\\OUT\\out_1.txt", "D:\\COMMON\\OUT\\out_2.txt");*/
    }



    private static void encrypt(String fileName, String outFileName) {
        try (FileInputStream fis = new FileInputStream(fileName); FileOutputStream fos = new FileOutputStream(outFileName)){
            byte[] inArray = new byte[fis.available()];
            fis.read(inArray);
            byte[] outArray = Base64.getUrlEncoder().encode(inArray);
            fos.write(outArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decrypt(String fileName, String outFileName) {
        try (FileInputStream fis = new FileInputStream(fileName); FileOutputStream fos = new FileOutputStream(outFileName)){
            byte[] inArray = new byte[fis.available()];
            fis.read(inArray);
            byte[] outArray = Base64.getDecoder().decode(inArray);
            fos.write(outArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
