package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            FileReader reader1 = new FileReader(bfr.readLine());
            FileReader reader2 = new FileReader(bfr.readLine());
            BufferedReader bfrFile1 = new BufferedReader(reader1);
            BufferedReader bfrFile2 = new BufferedReader(reader2)){

            List<String> listFile1 = new ArrayList<>();
            List<String> listFile2 = new ArrayList<>();

            while (bfrFile1.ready()){
                listFile1.add(bfrFile1.readLine());
            }
            while (bfrFile2.ready()){
                listFile2.add(bfrFile2.readLine());
            }


        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
