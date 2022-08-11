package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        while (true){
            try (FileInputStream fis = new FileInputStream(new Scanner(System.in).nextLine())){
                if (fis.available() < 1000) throw new DownloadException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
