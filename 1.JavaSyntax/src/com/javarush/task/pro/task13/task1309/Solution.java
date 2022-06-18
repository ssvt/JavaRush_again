package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Антон Пирожков", 2.56);
        grades.put("Борис Годунов", 5.76);
        grades.put("Владимир Борецкий", 2.6);
        grades.put("Павел Катюхов", 8.6);
        grades.put("Кристофер Шизиков", 8.1);

    }
}
