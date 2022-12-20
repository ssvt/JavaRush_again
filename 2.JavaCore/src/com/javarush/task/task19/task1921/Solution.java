package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

/**
 * @author Seregy Svyatoha
 */
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
//        String fileName = "d:/fl";
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()){

            String line = bufferedReader.readLine();
            String[] array = line.split("\\s");
            String name = line.substring(0, line.indexOf(array[array.length - 3])).trim();
            Date bithDate = new Date();
            bithDate.setDate(Integer.parseInt(array[array.length - 3]));
            bithDate.setMonth(Integer.parseInt(array[array.length - 2]) - 1);
            bithDate.setYear(Integer.parseInt(array[array.length - 1]) - 1900);
            Person person = new Person(name, bithDate);
            PEOPLE.add(person);
        }

//        PEOPLE.forEach(p -> System.out.println(p.getName() + " " + p.getBirthDate()));
        bufferedReader.close();
        fileReader.close();
    }
}
