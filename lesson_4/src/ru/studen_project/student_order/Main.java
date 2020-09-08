package ru.studen_project.student_order;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static final int SIZE = 3;
    static final char DOT_X = 'X';
    static final char DOT_0 = '0';
    static final char DOT_EMPTY = '.';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        createMap();
        while (true) {
            humanTurn();
            if (isWin()) {
                System.out.println("Победа человечества");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            if (isWin()) {
                System.out.println("Победа ИИ");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    //Создает поле для игры
    static void createMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = '.';
            }
        }
        outputMap();
    }

    //Выводит поле для игры
    static void outputMap() {
        for (int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Человек делает ход
    static void humanTurn() {
        int x;
        int y;
        do {
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isCoordinatesInputRight(y, x));
        map[y][x] = DOT_X;
        System.out.println("Человек походил " + (y + 1) + " " + (x + 1));
        outputMap();
    }

    // Проверка на правильность ввода координат
    static boolean isCoordinatesInputRight(int y, int x) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    // ИИ делает ход
    static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCoordinatesInputRight(y, x));
        map[y][x] = DOT_0;
        System.out.println("ИИ походил " + (y + 1) + " " + (x + 1));
        outputMap();
    }

    // Проверяет условия ничьи в игре
    static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    // Проверяет условия победы в игре
    static boolean isWin(){
        if (checkWinnerStrings()) {
            return true;
        }
        if (checkWinnerColumns()) {
            return true;
        }
        if (checkWinnerDiagonals()) {
            return true;
        }

        return false;
    }

    // Проверяет строки
    static boolean checkWinnerStrings() {
        int ifSumIndex;
        int sumIndex;
        for (int i = 0; i < SIZE; i++) {
            ifSumIndex = map[i][0];
            sumIndex = map[i][0];
            for (int j = 0; j < SIZE - 1; j++) {
                if (ifSumIndex / (j + 1) == map[i][j + 1] && ifSumIndex / (j + 1) != DOT_EMPTY) {
                    ifSumIndex += map[i][j + 1];
                }
                sumIndex += map[i][j + 1];
            }
            if (sumIndex == ifSumIndex){
                return true;
            }
        }
        return false;
    }

    // Проверяет столбцы
    static boolean checkWinnerColumns() {
        int ifSumIndex;
        int sumIndex;
        for (int i = 0; i < SIZE; i++) {
            ifSumIndex = map[0][i];
            sumIndex = map[0][i];
            for (int j = 0; j < SIZE - 1; j++) {
                if (ifSumIndex / (j + 1) == map[j + 1][i] && ifSumIndex / (j + 1) != DOT_EMPTY) {
                    ifSumIndex += map[j + 1][i];
                }
                sumIndex += map[j + 1][i];
            }
            if (sumIndex == ifSumIndex){
                return true;
            }
        }
        return false;
    }

    // Проверяет диагонали
    static boolean checkWinnerDiagonals() {
        int ifSumIndexLeftDiagonal = map[0][0];
        int sumIndexLeftDiagonal = map[0][0];

        int ifSumIndexRightDiagonal = map[0][SIZE - 1];
        int sumIndexRightDiagonal = map[0][SIZE - 1];

        for (int i = 0; i < SIZE - 1; i++) {
            // Проверка левой диагонали
            sumIndexLeftDiagonal += map[i + 1][i + 1];

            if (ifSumIndexLeftDiagonal / (i + 1) == map[i + 1][i + 1] && ifSumIndexLeftDiagonal / (i + 1) != DOT_EMPTY) {
                ifSumIndexLeftDiagonal += map[i + 1][i + 1];
            }
            if (sumIndexLeftDiagonal == ifSumIndexLeftDiagonal && i == SIZE - 2){
                return true;
            }
            // Проверка правой диагонали
            sumIndexRightDiagonal += map[i + 1][SIZE - i - 2];

            if ((ifSumIndexRightDiagonal / (i + 1) == map[i + 1][SIZE - i - 2])
                    && (ifSumIndexRightDiagonal / (i + 1) != DOT_EMPTY)) {
                ifSumIndexRightDiagonal += map[i + 1][SIZE - i - 2];
            }
            if (sumIndexRightDiagonal == ifSumIndexRightDiagonal && i == SIZE - 2){
                return true;
            }
        }
        return false;
    }
}
