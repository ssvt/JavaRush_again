package com.javarush.task.task14.task1419;

import javax.swing.undo.CannotUndoException;
import java.io.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.List;

/* 
Нашествие исключений

*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception

        exceptions.add(new ArithmeticException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new ClassCastException());
        exceptions.add(new NullPointerException());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new ConcurrentModificationException());


    }
}
