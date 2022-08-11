package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
*/

public class Solution {
    public static String fileName;

    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;

        if (args[0].equals("-u")){
            StringBuilder productName = new StringBuilder();
            for (int i = 2; i < args.length - 2;  i++) {
                productName.append(args[i]);
                if (i != args.length - 3 ) productName.append(" ");
            }
            double price = Double.parseDouble(args[args.length - 2]);
            int quantity = Integer.parseInt(args[args.length - 1]);

            char[] newLineChar = new char[50];
            Arrays.fill(newLineChar, ' ');

            char[] quantityChars = String.valueOf(quantity).toCharArray();
            char[] priceChars = String.valueOf(price).toCharArray();
            char[] productCrars = productName.toString().toCharArray();

            System.arraycopy(quantityChars, 0, newLineChar, 46, quantityChars.length);
            System.arraycopy(priceChars, 0, newLineChar, 38, priceChars.length);
            System.arraycopy(productCrars, 0, newLineChar, 8, productCrars.length);


            int idForUpdate = Integer.parseInt(args[1]);
            char[] idUpdatesChars = String.valueOf(idForUpdate).toCharArray();
            System.arraycopy(idUpdatesChars, 0, newLineChar, 0, idUpdatesChars.length);
            updateProduct(idForUpdate, newLineChar);
        }else if (args[0].equals("-d")){
            deleteProduct(Integer.parseInt(args[1]));
        }
    }



    private static void updateProduct(int idUpdate, char[] newLineChar) throws IOException {

        List<String> listLines = readListFromFile();

        for (int i = 0; i < listLines.size(); i++) {
            String str = listLines.get(i).substring(0, 8).replace(" ", "");
            int intTd = Integer.parseInt(str);
            if (intTd == idUpdate) listLines.set(i, new String(newLineChar));
        }

//        listLines.stream().forEach(System.out::println);

        FileWriter fileWriter = new FileWriter(fileName);
        for (String line : listLines) {
            fileWriter.write(line);
            fileWriter.write("\n");
        }

        fileWriter.close();

    }

    private static void deleteProduct(int deleteId) throws IOException {
        List<String> listLines = readListFromFile();
        List<String> newListLines = new ArrayList<>();

        for (int i = 0; i < listLines.size(); i++) {
            String str = listLines.get(i).substring(0, 8).replace(" ", "");
            int intTd = Integer.parseInt(str);
            if (intTd != deleteId) newListLines.add(listLines.get(i));
        }

        FileWriter fileWriter = new FileWriter(fileName);
        for (String line : newListLines) {
            fileWriter.write(line);
            fileWriter.write("\n");
        }

        fileWriter.close();

    }

    private static List<String> readListFromFile () throws IOException {
        Scanner scanner = new Scanner(System.in);
//        fileName = scanner.nextLine();
        fileName = "D:\\COMMON\\OUT\\in.txt";
        FileReader fileReader = new FileReader(fileName);

        Scanner scan = new Scanner(fileReader);
        List<String> listLines = new ArrayList<>();
        while (scan.hasNext()) {
            listLines.add(scan.nextLine());
        }

        fileReader.close();
        scan.close();
        scanner.close();
        return listLines;
    }
}
