package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
      reset();
    }

    public static CanFly result;

    public static void reset() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if ("helicopter".equals(line)) result = new Helicopter();
        else if ("plane".equals(line)){
            int cnt = scanner.nextInt();
            result = new Plane(cnt);
        }
    }
}
