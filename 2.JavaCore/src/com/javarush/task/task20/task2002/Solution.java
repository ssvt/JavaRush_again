package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            Writer out = new OutputStreamWriter (outputStream, "UTF8");
            for (User user: users) {
                out.write(user.getFirstName() + "," + user.getLastName() + "," + user.getBirthDate().getTime() + "," +
                        user.isMale() + "," + user.getCountry().getDisplayName() + "\n");
            }
            out.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            while (in.ready()){
                String line = in.readLine();
                String[] arrayStr = line.split(",");
                User user = new User();
                user.setFirstName(arrayStr[0]);
                user.setLastName(arrayStr[1]);
                user.setBirthDate(new Date(Long.parseLong(arrayStr[2])));
                user.setMale(Boolean.parseBoolean(arrayStr[3]));
                if (arrayStr[4].equals(User.Country.UKRAINE.getDisplayName())) user.setCountry(User.Country.UKRAINE);
                if (arrayStr[4].equals(User.Country.RUSSIA.getDisplayName())) user.setCountry(User.Country.RUSSIA);
                if (arrayStr[4].equals(User.Country.OTHER.getDisplayName())) user.setCountry(User.Country.OTHER);
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
