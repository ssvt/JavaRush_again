package com.javarush.task.task18.task1828;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
*/

public class Solution {
//    public static String fileName = "D:\\COMMON\\OUT\\in.txt";
    public static String fileName;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        fileName = scanner.nextLine();

        if (args.length == 0) return;

        switch (args[0]){
            case "-u":
                updateProduct(Integer.parseInt(args[1]), getProductFromArgs(args));
                break;
            case "-d":
                deleteProduct(Integer.parseInt(args[1]));
                break;
            default:
                System.out.println("Команда не распознана");
        }

    }



    public static void updateProduct(int id, String product) throws IOException {
        List<String> listProductFromFile = getListFromFile();
        for (int i = 0; i < listProductFromFile.size(); i++) {
            int idProd = Integer.parseInt(listProductFromFile.get(i).substring(0, 8).trim());
            if (idProd == id){
                listProductFromFile.set(i, product);
            }
        }

        writelistToFile(listProductFromFile);

    }

    private static void deleteProduct(int id) throws IOException {
        List<String> listLines = getListFromFile();
        List<String> newList = new ArrayList<>();
        for (String line: listLines) {
            int idProd = Integer.parseInt(line.substring(0, 8).trim());
            if (id != idProd) newList.add(line);
        }

        writelistToFile(newList);
    }

    /**
     * получаем список строк из файла
     * @return
     * @throws IOException
     */
    public static List<String> getListFromFile () throws IOException {
        FileReader fileReader = new FileReader(fileName);
        List<String> listProductFromFile = new ArrayList<>();
        Scanner fileScan = new Scanner(fileReader);
        while (fileScan.hasNext()) {
            String readingLine = fileScan.nextLine();
            listProductFromFile.add(readingLine);
        }
        fileReader.close();
        fileScan.close();
        return listProductFromFile;
    }

    /**
     * метод записывает список в файл
     * @param list
     * @throws IOException
     */
    public static void writelistToFile (List<String> list) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        for (int i = 0; i < list.size(); i++) {
            fileWriter.write(list.get(i));
            if (i != list.size() - 1) fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static String getProductFromArgs(String[] args) {

        int quantity = Integer.parseInt(args[args.length - 1]);
        char[] quantityChars = String.valueOf(quantity).toCharArray();

        double price = Double.parseDouble(args[args.length - 2]);
        char[] priceChars = args[args.length - 2].toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i < args.length - 2; i++) {
            stringBuilder.append(args[i]);
            if (1 != args.length - 3) stringBuilder.append(" ");
        }
        String pdoductLine = stringBuilder.length() > 30 ? stringBuilder.substring(0, 30) : stringBuilder.toString();
        char[] productNameChars = pdoductLine.toCharArray();

        int id = Integer.parseInt(args[1]);
        char[] idChars = String.valueOf(id).toCharArray();

        char[] productChars = new char[50];
        Arrays.fill(productChars, ' ');
        System.arraycopy(idChars, 0, productChars, 0, idChars.length);
        System.arraycopy(productNameChars, 0, productChars, 8, productNameChars.length);
        System.arraycopy(priceChars, 0, productChars, 38, priceChars.length);
        System.arraycopy(quantityChars, 0, productChars, 46, quantityChars.length);

        return new String(productChars);
    }

}
