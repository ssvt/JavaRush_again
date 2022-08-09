package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int max = 0;
        try ( InputStreamReader is = new InputStreamReader(new FileInputStream(new Scanner(System.in).nextLine()));){
            while (is.ready()){
                int cirrentBute = is.read();
                if (max < cirrentBute) max = cirrentBute;
            }
        }
        System.out.println(max);
    }
}
