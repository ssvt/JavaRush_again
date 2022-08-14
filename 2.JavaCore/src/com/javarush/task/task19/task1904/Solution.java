package com.javarush.task.task19.task1904;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
/*        PersonScannerAdapter psr = new PersonScannerAdapter(new Scanner(new FileReader("D:\\COMMON\\OUT\\in.txt")));
        System.out.println(psr.read().toString());*/
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        // 0        1       2           3   4   5
        //Иванов    Иван    Иванович    31  12  1950
        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
//            String line = "Иванов Иван Иванович 31 12 1950";
            String[] strArray = line.split(" ");

            LocalDate ld = LocalDate.of(Integer.parseInt(strArray[5].trim()), Integer.parseInt(strArray[4].trim()), Integer.parseInt(strArray[3].trim()));
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(ld.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Person person = new Person(strArray[1], strArray[2], strArray[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
