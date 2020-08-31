package ru.geekbrains.home_work;

public class Main {
    public static void main(String[] args) {

        System.out.println(calculate(1, 2, 3, 4));

        System.out.println(checkNumbers(2, 18));

        positiveOrNegative(5);

        System.out.println(isNegativeNumber(-1));

        outputGreeting("Artem");

        isLeapYearOrNot(1600);

        outputAllVariables((byte) 12, (short) 13, 125, 2312312312l, 12123.12f, 123213213.123123, 'A', true);
    }

    /**
     * Outputs all kinds of simple variables to the console.
     */
    static void outputAllVariables(byte b, short s, int integer, long l, float f, double d, char c, boolean logic) {
        System.out.println("Переменная типа byte: " + b);
        System.out.println("Переменная типа short: " + s);
        System.out.println("Переменная типа int: " + integer);
        System.out.println("Переменная типа long: " + l);
        System.out.println("Переменная типа float: " + f);
        System.out.println("Переменная типа double: " + d);
        System.out.println("Переменная типа char: " + c);
        System.out.println("Переменная типа boolean: " + logic);
    }

    /**
     * Outputs to the console what year: leap year or not.
     */
    static void isLeapYearOrNot(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || ((year % 4 == 0) && (year % 400 == 0))) {
            System.out.println("Високосный год");
        } else {
            System.out.println("Невисокосный год");
        }
    }

    /**
     * Outputs a greeting to the console
     */
    static void outputGreeting(String name) {
        System.out.println("Hello " + name + "!");
    }

    /**
     * Checks the number on negative then returns result
     */
    static boolean isNegativeNumber(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks the number then outputs whether it is positive or negative number
     */
    static void positiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }

    /**
     * Checks numbers to see if they are in the range from 10 to 20 then returns result
     */
    static boolean checkNumbers(int number_1, int number_2) {
        if ((number_1 + number_2 >= 10) && (number_1 + number_2 <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculates an expression then returns result
     */
    static double calculate(float a, float b, float c, float d) {
        return (a * (b + (c / d)));
    }

}
