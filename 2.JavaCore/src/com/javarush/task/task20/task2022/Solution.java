package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
/*        Solution solution1 = new Solution("d:/home/test.txt");
        solution1.writeObject("MegaJAck-1");
        solution1.close();

        FileOutputStream fileOutputStream = new FileOutputStream("d:/home/test.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution1);
        outputStream.flush();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("d:/home/test.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution solution2 = (Solution) inputStream.readObject();
        inputStream.close();
        solution2.writeObject("Katapulta");
        solution2.writeObject("Amplua");
        solution2.close();*/
    }
}
