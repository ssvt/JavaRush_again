package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.*;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length == 0) return;

       StringBuilder productName = new StringBuilder();
        for (int i = 1; i < args.length - 2;  i++) {
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



        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
//        String fileName = "D:\\COMMON\\OUT\\in.txt";
        FileReader fileReader = new FileReader(fileName);

        Scanner scan = new Scanner(fileReader);
        List<String> listLines = new ArrayList<>();
        while (scan.hasNext()) {
            listLines.add(scan.nextLine());
        }

        int maxId = 0;
        for (String idNumberLine : listLines ) {
            String str = idNumberLine.substring(0, 8).replace(" ", "");
            int intTd = Integer.parseInt(str);
            if (intTd > maxId) maxId = intTd;

        }
//        int lastIndexFromFile = Integer.parseInt(listLines.get(listLines.size() - 1).substring(0, 8).replace(" ", "")) + 1;
        int lastIndexFromFile = maxId + 1;
        char[] newIdChars = String.valueOf(lastIndexFromFile).toCharArray();
        System.arraycopy(newIdChars, 0, newLineChar, 0,  newIdChars.length);

        listLines.add(new String(newLineChar));

//        listLines.stream().forEach(System.out::println);

        FileWriter fileWriter = new FileWriter(fileName);
        for (String line : listLines) {
            fileWriter.write(line);
            fileWriter.write("\n");
        }

        fileWriter.close();
        fileReader.close();
        scan.close();
        scanner.close();

    }
}
