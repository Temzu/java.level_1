package ru.geekbrains.level_1.lesson_2;

public class Main {

    public static void main(String[] args) {
	    int[] arrayForFirstTask = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
	    int[] arrayForSecondTask = new int[8];
	    int[] arrayForThirdTask = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Задание 1");
        outputArrayToConsole(arrayForFirstTask);
        replace0And1(arrayForFirstTask);
        System.out.println();

        System.out.println("Задание 2");
        fillAnArrayWithMultiplesOf3(arrayForSecondTask);
        System.out.println();

        System.out.println("Задание 3");
        outputArrayToConsole(arrayForThirdTask);
        multiplyElementsOfAnArrayBy2(arrayForThirdTask);
        System.out.println();
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

    /** First task
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

    /** Second task
     * Fills an array with multiples of 3, but first element is 0.
     */
    static void fillAnArrayWithMultiplesOf3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                array[i] = 0;
            } else {
                array[i] = array[i - 1] + 3;
            }
        }
        outputArrayToConsole(array);
    }

    /** Third task
     *  Multiplies all elements of an array less than 6 by 2
     */
    static void multiplyElementsOfAnArrayBy2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        outputArrayToConsole(array);
    }

}
