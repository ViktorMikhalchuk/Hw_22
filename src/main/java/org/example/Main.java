package org.example;

public class Main {
    public static void main(String[] args) {
        TestRunner.start(TestClass1.class);
        System.out.println("--------------------");
        TestRunner.start(TestClass2.class);
    }
}