package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static{
        firstFileName = new Scanner(System.in).nextLine();
        secondFileName = new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileNmae;
        private String fileContent = "";

        @Override
        public void setFileName(String fullFileName) {
            fileNmae = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public void run() {
//            while (!isInterrupted()){
                try(Scanner scanner = new Scanner(new FileReader(fileNmae))) {
                    while (scanner.hasNext()){
                        fileContent = fileContent + scanner.nextLine() + " ";
                    }
                    interrupt();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//            }
        }
    }
}
