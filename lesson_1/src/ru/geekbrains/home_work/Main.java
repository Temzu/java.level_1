package ru.geekbrains.home_work;

public class Main {
    public static void main(String[] args) {
        // целочисленные
        byte b = setByte((byte) 1);
        short s = setShort((short) 2);
        int integer = setInt(3);
        long l = setLong(4);

        // с плавающей точкой
        float f = setFloat((float) 1.2);
        double d = setDouble(12.3);

        // символьный
        char c = setChar('a');

        // логический
        boolean logic = setBoolean(true);

        System.out.println(calculate(1,2,3,4));

        System.out.println(checkNumbers(2,18));

        positiveOrNegative(5);

        System.out.println(isNegativeNumber(-1));

        helloName("Artem");
    }

    static void helloName(String name) {
        System.out.println("Hello " + name + "!");
    }

    static boolean isNegativeNumber (int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    static void positiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }

    static boolean checkNumbers(int number_1, int number_2){
        if (number_1 + number_2 >= 10 && number_1 + number_2 <= 20) {
            return true;
        } else {
            return false;
        }
    }

    static double calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    static byte setByte(Byte b) {
        return b;
    }

    static short setShort(Short s) {
        return s;
    }

    static int setInt(int integer) {
        return integer;
    }

    static long setLong(long l) {
        return l;
    }

    static float setFloat(Float f) {
        return f;
    }

    static double setDouble(double d) {
        return d;
    }

    static char setChar(char c) {
        return c;
    }

    static boolean setBoolean(boolean logic) {
        return logic;
    }
}
