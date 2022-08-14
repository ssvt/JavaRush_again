package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
/*        IncomeDataAdapter test = new IncomeDataAdapter(null);
        test.getPhoneNumber();*/

    }

    public static class IncomeDataAdapter implements Customer, Contact{

        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }


        @Override
        public String getName() {
            String name = String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
            return name;
        }

        @Override
        public String getPhoneNumber() {
            String counryCode = String.valueOf(data.getCountryPhoneCode());
            String rawPhoneNumber = String.valueOf(data.getPhoneNumber());
            if (rawPhoneNumber.length() < 10) {
                rawPhoneNumber = String.format("%010d",Integer.parseInt(rawPhoneNumber));
            }
            String finalNum = "+"+counryCode
                    +"(" + rawPhoneNumber.substring( 0,3 )+ ")"
                    + rawPhoneNumber.substring( 3,6 )
                    + "-" + rawPhoneNumber.substring( 6,8)
                    + "-" + rawPhoneNumber.substring( 8,10);
            return finalNum;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}