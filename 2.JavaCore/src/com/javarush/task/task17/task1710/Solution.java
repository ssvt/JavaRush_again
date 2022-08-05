package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length > 0) {
            switch (args[0]){
                case "-c":
                    addPeople(args);
                    break;
                case "-r":
                    aboutPeople(args);
                    break;
                case "-u":
                    updatePeople(args);
                    break;
                case "-d":
                    deletePeople(args);
                    break;
                default:
                    System.out.println("Аргумент не понятен");
            }
        }

/*        Solution.allPeople.stream().forEach(pl -> {
            System.out.println(pl.getName() + " " + pl.getBirthDate().toString());
        });*/
    }

    private static void addPeople(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date bithDay = format.parse(args[3]);

        Person person = args[2].equals("м") ? Person.createMale(args[1], bithDay) : Person.createFemale(args[1], bithDay);
        Solution.allPeople.add(person);
        System.out.println(Solution.allPeople.size() - 1);
    }

    private static void aboutPeople(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = Solution.allPeople.get(Integer.parseInt(args[1]));
        String s = person.getSex() == Sex.MALE ? "м" : "ж";
        System.out.println(String.format("%s %s %s", person.getName(), s, format.format(person.getBirthDate())));
    }
    private static void updatePeople(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date bithDay = format.parse(args[4]);

        Person person = args[3].equals("м") ? Person.createMale(args[2], bithDay) : Person.createFemale(args[1], bithDay);

        Solution.allPeople.set(Integer.parseInt(args[1]), person);
    }
    private static void deletePeople(String[] args) {
//        Solution.allPeople.removeIf(args[1]::equals);
        Person nullPeople = Person.createMale(null, null);
        nullPeople.setSex(null);
        Solution.allPeople.set(Integer.parseInt(args[1]), nullPeople);
    }

}
