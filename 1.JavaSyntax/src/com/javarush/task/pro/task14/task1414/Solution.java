package com.javarush.task.pro.task14.task1414;

/* 
Готовим коктейли
*/

import java.util.Arrays;

public class Solution {

    public static final String OUTPUT_FORMAT = "Метод %s вызван из строки %d класса %s в файле %s.\n";

    public static void main(String[] args) {
        makeScrewdriver();
    }

    public static void printStackTrace(StackTraceElement[] stackTrace) {
        Arrays.stream(stackTrace).forEach(element -> {
            System.out.printf("Метод %s вызван из строки %d класса %s в файле %s.\n", element.getMethodName(),
                    element.getLineNumber(), element.getClassName(), element.getFileName());
        });
    }

    static void makeScrewdriver() {
        addJuice();
    }

    static void addJuice() {
        addVodka();
    }

    static void addVodka() {
        printStackTrace(Thread.currentThread().getStackTrace());
    }
}
