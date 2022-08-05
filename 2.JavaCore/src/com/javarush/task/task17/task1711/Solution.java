package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
            switch (args[0]){
                case "-c":
                    synchronized (allPeople){
                        addPeople(args);
                    }
                    break;
                case "-i":
                    synchronized (allPeople){
                        aboutPeople(args);
                    }
                    break;
                case "-u":
                    synchronized (allPeople){
                        updatePeople(args);
                    }
                    break;
                case "-d":
                    synchronized (allPeople){
                        deletePeople(args);
                    }
                    break;
               /* default:
                    System.out.println("Аргумент не понятен");*/
            }
    }

    private  static void addPeople(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i += 3) {

            Person person = args[i + 1].equals("м") ? Person.createMale(args[i], format.parse(args[i + 2])) :
                    Person.createFemale(args[i], format.parse(args[i + 2]));
            allPeople.add(person);
            System.out.println(allPeople.size() - 1);

        }
    }

    private static void aboutPeople(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length && i <= allPeople.size(); i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            String s = person.getSex() == Sex.MALE ? "м" : "ж";
            System.out.println(String.format("%s %s %s", person.getName(), s, format.format(person.getBirthDate())));
        }
    }
    private static void updatePeople(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i += 4) {

            Person person = args[i + 2].equals("м") ? Person.createMale(args[i + 1], format.parse(args[i + 3])) :
                    Person.createFemale(args[i + 1], format.parse(args[i + 3]));
            allPeople.set(Integer.parseInt(args[i]), person);
        }


        Date bithDay = format.parse(args[4]);

        Person person = args[3].equals("м") ? Person.createMale(args[2], bithDay) : Person.createFemale(args[1], bithDay);

        allPeople.set(Integer.parseInt(args[1]), person);
    }
    private static void deletePeople(String[] args) {
//        Solution.allPeople.removeIf(args[1]::equals);
        for (int i = 1; i < args.length && i < allPeople.size(); i++) {
            Person nullPeople = Person.createMale(null, null);
            nullPeople.setSex(null);
            allPeople.set(Integer.parseInt(args[i]), nullPeople);
        }


    }
}
