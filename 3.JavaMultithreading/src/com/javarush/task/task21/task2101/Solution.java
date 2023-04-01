package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] newArray = new byte[4];
        for (int i = 0; i < ip.length; i++) {
            newArray[i] = (byte) (ip[i] & mask[i]);
        }
        return newArray;
    }

    public static void print(byte[] bytes) {

        for (byte bt: bytes) {
            String btStr = String.format("%8s", Integer.toBinaryString(bt & 0xFF)).replace(" ", "0");
            System.out.print(btStr + " ");
        }
        System.out.println();
    }
}
