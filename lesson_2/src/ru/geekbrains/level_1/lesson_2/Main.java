package ru.geekbrains.level_1.lesson_2;

public class Main {

    public static void main(String[] args) {
	    int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        outputArrayToConsole(array);
        replace0And1(array);
    }

    /**
     * Outputs all elements of the specified array.
     */
    static void outputArrayToConsole(int[] array) {
        System.out.println("Выводим элементы массива");
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Replaces all elements of an array (consisting of 0 and 1) with apposite values.
     * Then outputs all elements of the array.
     */
    static void replace0And1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        outputArrayToConsole(array);
    }

}
