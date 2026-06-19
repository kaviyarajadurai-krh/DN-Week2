package org.student;

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Singleton Pattern Example");

        System.out.println("Same instance: " + (logger1 == logger2));
    }
}