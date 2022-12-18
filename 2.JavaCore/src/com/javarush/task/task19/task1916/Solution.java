package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
             FileReader reader1 = new FileReader(bfr.readLine());
             FileReader reader2 = new FileReader(bfr.readLine());


             List<String> original = new BufferedReader(reader1).lines().collect(Collectors.toList());
             List<String> modified = new BufferedReader(reader2).lines().collect(Collectors.toList());

            while (original.size() != 0 & modified.size() != 0) {
                if (original.get(0).equals(modified.get(0))) {
                    lines.add(new LineItem(Type.SAME, original.remove(0)));
                    modified.remove(0);
                } else if (modified.size() != 1 && original.get(0).equals(modified.get(1))) {
                    lines.add(new LineItem(Type.ADDED, modified.remove(0)));
                } else if (original.size() != 1 && original.get(1).equals(modified.get(0))) {
                    lines.add(new LineItem(Type.REMOVED, original.remove(0)));
                }
            }
            if (original.size() != 0) {
                lines.add(new LineItem(Type.REMOVED, original.remove(0)));
            } else if (modified.size() != 0) {
                lines.add(new LineItem(Type.ADDED, modified.remove(0)));
            }

            reader1.close();
            reader2.close();
            lines.forEach(System.out::println);
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
        @Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }
    }


}
