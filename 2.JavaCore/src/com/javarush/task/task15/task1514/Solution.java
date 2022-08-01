package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(0.123, "first");
        labels.put(0.25465, "second");
        labels.put(1.2656, "third");
        labels.put(2.14578, "fourth");
        labels.put(5.465, "fives");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
