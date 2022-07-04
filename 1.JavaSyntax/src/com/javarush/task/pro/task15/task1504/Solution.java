package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args)  {
        try (Scanner scanner = new Scanner(System.in);
             var inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
             var outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))
        ) {
            byte[] buffer =  new byte[inputStream.available()];
            byte[] outBuffer = new byte[buffer.length];
            int real = inputStream.read(buffer);

            if (real % 2 == 0) {
                for (int i = 0; i < buffer.length; i += 2) {
                    outBuffer[i] = buffer[i + 1];
                    outBuffer[i + 1] = buffer[i];
                }
            } else {
                for (int i = 0; i < buffer.length - 2; i += 2) {
                    outBuffer[i] = buffer[i + 1];
                    outBuffer[i + 1] = buffer[i];
                }
                outBuffer[buffer.length - 1] = buffer[buffer.length - 1];
            }
            outputStream.write(outBuffer);
        }catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }

    }
}

