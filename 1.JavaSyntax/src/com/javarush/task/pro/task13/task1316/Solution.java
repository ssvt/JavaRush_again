package com.javarush.task.pro.task13.task1316;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        JavarushQuest[] jvrq = JavarushQuest.values();
        for (JavarushQuest jj : jvrq ) {
            System.out.println(jj.ordinal());
        }
    }
}
