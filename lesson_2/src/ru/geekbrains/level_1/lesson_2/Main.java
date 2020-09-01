package ru.geekbrains.level_1.lesson_2;

public class Main {

    public static void main(String[] args) {
	    int[] arrayForFirstTask = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
	    int[] arrayForSecondTask = new int[8];
	    int[] arrayForThirdTask = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
	    int[][] arrayForFourthTask = new int[10][10];
	    int[] arrayForSixthTask = {1, 2, 3, 6, 1, 2, 9, 1, 1};

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

        System.out.println("Задание 4");
        fillTheDiagonalElementsOfAnArray(arrayForFourthTask);
        System.out.println();

        System.out.println("Задание 5");
        findTheMaxAndMinEl(arrayForThirdTask);
        System.out.println();

        System.out.println("Задание 6");
        System.out.println(checkBalance(arrayForSixthTask));
        System.out.println();

        System.out.println("Задание 7");
        shiftArrayElements(arrayForSixthTask, 5);
        System.out.println();
    }

    /**
     * Outputs all elements of the specified one-dimensional array.
     */
    static void outputArrayToConsole(int[] array) {
        System.out.println("Выводим элементы массива");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    /**
     * Outputs all elements of the specified two-dimensional array.
     */
    static void outputTwoDimensionalArrayToConsole(int[][] array) {
        System.out.println("Выводим элементы массива");
        for (int[] i: array) {
            for (int j: i) {
                System.out.print(j + "  ");
            }
            System.out.println();
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
     * Multiplies all elements of an array less than 6 by 2.
     */
    static void multiplyElementsOfAnArrayBy2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        outputArrayToConsole(array);
    }

    /** Forth task
     * Fills the diagonal elements of a two-dimensional array with 1.
     */
    static void fillTheDiagonalElementsOfAnArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }
        for (int j = array.length - 1; j >= 0; j--) {
            array[j][array.length - j - 1] = 1;
        }
        outputTwoDimensionalArrayToConsole(array);
    }

    /** Fifth task
     * Finds the maximum and minimum element of an array.
     */
    static void findTheMaxAndMinEl(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i: array){
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        outputArrayToConsole(array);
        System.out.println(
                "Максимальный элемент равен: " + max +
                        "\nМинимальный элемен равен: " + min
        );
    }

    /** Sixth task
     * Returns true if there is a spot in the array
     * where the sum of the left and right sides of the array are equal.
     */
    static boolean checkBalance(int[] array){
        boolean check = false;
        int leftSum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int rightSum = 0;
            leftSum += array[i];
            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }
            if (leftSum == rightSum) {
                check = true;
            }
        }
        return check;
    }

    /** Seventh task
     * Shifts array elements by specified number of characters.
     */
    static void shiftArrayElements(int[] array, int n) {
        outputArrayToConsole(array);
        if (n > 0) {
            shiftArrayElToTheRight(array, n);
        } else if (n < 0){
            shiftArrayElToTheLeft(array, n);
        } else {
            System.out.println("! Смещение не произведено !");
        }
        outputArrayToConsole(array);
    }

    /** Seventh task
     * Shifts array elements to the right. Needs for method "shiftArrayElements"
     */
    static void shiftArrayElToTheRight(int[] array, int n) {
        int buff;
        System.out.println("* Смещение элементов массива вправо на " + n + "эл.");
        for (int m = 0; m < n; m++){
            for (int i = array.length - 1; i > 0; i--) {
                buff = array[i];
                array[i] = array[i - 1];
                array[i - 1] = buff;
            }
        }
    }

    /** Seventh task
     * Shifts array elements to the left. Needs for method "shiftArrayElements"
     */
    static void shiftArrayElToTheLeft(int[] array, int n) {
        int buff;
        System.out.println("* Смещение элементов массива влево на " + Math.abs(n) + " эл.");
        for (int m = 0; m < Math.abs(n); m++){
            for (int i = 0; i < array.length - 1; i++) {
                buff = array[i];
                array[i] = array[i + 1];
                array[i + 1] = buff;
            }
        }
    }

}
