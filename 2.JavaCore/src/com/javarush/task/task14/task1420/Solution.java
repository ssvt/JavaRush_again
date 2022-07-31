package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();

        System.out.println(nod(Math.max(x1, x2), Math.min(x1, x2)));
    }

    private static int nod(int a, int b) {
        if (b == 0 ) return a;
        return nod(b, a % b);
    }
}
