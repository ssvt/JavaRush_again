package com.javarush.task.task20.task2023;

/* 
Делаем правильный вывод
*/

/**
 * PS:  Вот этот момент нихера не понял!!!!!!!
 * подсмот рел как у других.. надо буде еще повнтиматель нее разобрать....
 */

public class Solution {

    public static void main(String[] s) {
        A a = new C();
        a.method2();
    }

    public static class A {
        private void method1() {
            System.out.println("A class, method1");
        }

        public void method2() {
            System.out.println("A class, method2");         //2. вызывается вторым
            method1();
        }
    }

    public static class B extends A {
        public void method1() {
            super.method2();
            System.out.println("B class, method1");
        }

        public void method2() {
            System.out.println("B class, method2");
        }
    }

    private static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
            System.out.println("C class, method2");         // 1.  вызывается в первую очередь
            super.method1();
        }
    }
}
