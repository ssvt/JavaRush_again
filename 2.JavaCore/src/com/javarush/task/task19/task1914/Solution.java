package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream olsStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(olsStream);

        String rez = byteArrayOutputStream.toString();

        int rezultAriph = 0;
        Pattern pAr = Pattern.compile("[\\+\\-\\*]");
        Pattern pDigit = Pattern.compile("[\\d]+");
        Matcher matcher = pAr.matcher(rez);
        Matcher digitMatcher = pDigit.matcher(rez);
        Integer x1 = null;
        Integer x2 = null;
        while (digitMatcher.find()){
            if (x1 == null) x1 = Integer.parseInt(digitMatcher.group());
            else if (x1 != null && x2 == null) x2 = Integer.parseInt(digitMatcher.group());
        }

        if (matcher.find()){
            if (matcher.group(0).equals("+")){
                rezultAriph = x1 + x2;
            }else if (matcher.group(0).equals("-")){
                rezultAriph = x1 - x2;
            }else if (matcher.group(0).equals("*")){
                rezultAriph = x1 * x2;
            }
        }

        rez = rez.replace("\r\n", "") + rezultAriph;
        System.out.println(rez);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

