package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);


    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }

    public static void main(String[] args) throws InterruptedException {
      threads.get(0) .start();
      threads.get(1).start();
      threads.get(2).start();
      threads.get(3).start();
      threads.get(4).start();



    }

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){

            }
        }
    }

    public static class MyThread2 extends Thread {

        @Override
        public void interrupt() {
            System.out.println("InterruptedException");
            super.interrupt();
        }
    }

    public static class MyThread3 extends Thread {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public static class MyThread4 extends Thread implements Message{

        @Override
        public void run() {
            while (!this.isInterrupted()){
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class MyThread5 extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            int sum = 0;
            while (true) {
                try {
                    String line = scanner.nextLine();
                    if (line.equals("N")) {
                        System.out.println(sum);
                        break;
                    }
                    sum = sum + Integer.parseInt(line);
                } catch (Exception ex) {
                    System.out.println("Вводите число или букву N");
                }
            }
        }
    }
}