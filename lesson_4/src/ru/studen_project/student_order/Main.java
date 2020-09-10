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

            aiStep();
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
    static void aiStep() {
        int maxSumIndexesColumn = aiCheckSumPlayerColumns()[0];
        int maxSumIndexesString = aiCheckSumPlayerStrings()[0];
        int maxSumIndexesDiagonal = aiCheckSumPlayerDiagonals()[0];
        checkConditionForStep(maxSumIndexesColumn,maxSumIndexesString,maxSumIndexesDiagonal);
    }

    // Проверяет условия, при которых возможно сделать шаг.
    static void checkConditionForStep(int maxSumIndexesColumn, int maxSumIndexesString, int maxSumIndexesDiagonal) {
        boolean checkColumnInputRight = isCoordinatesInputRight(aiCheckSumPlayerColumns()[1], aiCheckSumPlayerColumns()[2]);
        boolean checkStringInputRight = isCoordinatesInputRight(aiCheckSumPlayerStrings()[1], aiCheckSumPlayerStrings()[2]);
        boolean checkDiagonalInputRight = isCoordinatesInputRight(aiCheckSumPlayerDiagonals()[1], aiCheckSumPlayerDiagonals()[2]);
        int x;
        int y;
        if (maxSumIndexesDiagonal >= maxSumIndexesColumn && maxSumIndexesDiagonal >= maxSumIndexesString && checkDiagonalInputRight) {

            makeStepAndOutput(aiCheckSumPlayerDiagonals()[1], aiCheckSumPlayerDiagonals()[2]);

        } else if (maxSumIndexesString >= maxSumIndexesColumn && maxSumIndexesString >= maxSumIndexesDiagonal && checkStringInputRight) {

            makeStepAndOutput(aiCheckSumPlayerStrings()[1], aiCheckSumPlayerStrings()[2]);

        } else if (maxSumIndexesColumn >= maxSumIndexesString && maxSumIndexesColumn >= maxSumIndexesDiagonal && checkColumnInputRight){

            makeStepAndOutput(aiCheckSumPlayerColumns()[1], aiCheckSumPlayerColumns()[2]);

        } else if (checkColumnInputRight) {

            makeStepAndOutput(aiCheckSumPlayerColumns()[1], aiCheckSumPlayerColumns()[2]);

        } else if (checkDiagonalInputRight) {

            makeStepAndOutput(aiCheckSumPlayerStrings()[1], aiCheckSumPlayerStrings()[2]);

        } else if (checkStringInputRight) {
            makeStepAndOutput(aiCheckSumPlayerStrings()[1], aiCheckSumPlayerStrings()[2]);
        } else {
            do {
                y = random.nextInt(SIZE);
                x = random.nextInt(SIZE);
            } while (!isCoordinatesInputRight(y, x));
            map[y][x] = DOT_0;
            System.out.println("ИИ походил " + (y + 1) + " " + (x + 1));
            outputMap();
        }
    }

    // Выводит данные о шаге ИИ и производит непосредтсвенное выполнение этого шага
    static void makeStepAndOutput(int yPosition, int xPosition) {
        map[yPosition][xPosition] = DOT_0;
        System.out.println("ИИ походил " + (yPosition + 1) + " " + (xPosition + 1));
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
                    &&
                    (ifSumIndexRightDiagonal / (i + 1) != DOT_EMPTY)) {
                ifSumIndexRightDiagonal += map[i + 1][SIZE - i - 2];
            }
            if (sumIndexRightDiagonal == ifSumIndexRightDiagonal && i == SIZE - 2){
                return true;
            }
        }
        return false;
    }

    //
    static int[] aiCheckSumPlayerColumns() {
        int sumIndex;
        int maxSum = 0;
        int indexColumn = 0;
        int[] allParameters = new int[3];
        for (int i = 0; i < SIZE; i++) {
            sumIndex = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == DOT_X) {
                    sumIndex += map[j][i];
                }
            }
            if (sumIndex > maxSum) {
                maxSum = sumIndex;
                indexColumn = i;
            }
        }
        allParameters[0] = maxSum;
        allParameters[2] = indexColumn;
        return aiCheckIndexForColumn(allParameters, indexColumn);
    }

    static int[] aiCheckIndexForColumn(int[] allParameters, int indexColumn) {
        for (int i = 0; i < SIZE; i++) {
            if (map[i][indexColumn] == DOT_X && i == 0) {
                if (map[i + 1][indexColumn] == DOT_EMPTY) {
                    allParameters[1] = i + 1;
                    break;
                }
            }
            if (map[i][indexColumn] == DOT_X && i != 0 && i != SIZE - 1) {
                if (map[i + 1][indexColumn] == DOT_EMPTY) {
                    allParameters[1] = i + 1;
                    break;
                } else if (map[i - 1][indexColumn] == DOT_EMPTY){
                    allParameters[1] = i - 1;
                    break;
                }
            }
            if (map[i][indexColumn] == DOT_X && i == SIZE - 1) {
                if (map[i - 1][indexColumn] == DOT_EMPTY) {
                    allParameters[1] = i - 1;
                    break;
                }
            }
        }
        return allParameters;
    }

    static int[] aiCheckSumPlayerStrings() {
        int sumIndex;
        int maxSum = 0;
        int indexString = 0;
        int[] allParameters = new int[3];
        for (int i = 0; i < SIZE; i++) {
            sumIndex = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    sumIndex += map[i][j];
                }
            }
            if (sumIndex > maxSum) {
                maxSum = sumIndex;
                indexString = i;
            }
        }
        allParameters[0] = maxSum;
        allParameters[1] = indexString;
        return aiCheckIndexForString(allParameters, indexString);
    }

    static int[] aiCheckIndexForString(int[] allParameters, int indexString) {
        for (int i = 0; i < SIZE; i++) {
            if (map[indexString][i] == DOT_X && i == 0) {
                if (map[indexString][i + 1] == DOT_EMPTY) {
                    allParameters[2] = i + 1;
                    break;
                }
            }
            if (map[indexString][i] == DOT_X && i != 0 && i != SIZE - 1) {
                if (map[indexString][i + 1] == DOT_EMPTY) {
                    allParameters[2] = i + 1;
                    break;
                } else if (map[indexString][i - 1] == DOT_EMPTY){
                    allParameters[2] = i - 1;
                    break;
                }
            }
            if (map[indexString][i] == DOT_X && i == SIZE - 1) {
                if (map[indexString][i - 1] == DOT_EMPTY) {
                    allParameters[2] = i - 1;
                    break;
                }
            }
        }
        return allParameters;
    }

    static int[] aiCheckSumPlayerDiagonals() {
        int sumIndexLeftDiagonal = 0;
        int sumIndexRightDiagonal = 0;
        int maxSum = 0;
        int indexRightDiagonal = 0;
        int indexLeftDiagonal = 0;
        int[] allParameters = new int[3];
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == DOT_X) {
                sumIndexLeftDiagonal += map[i][i];
            }
            if (map[i][SIZE - i - 1] == DOT_X) {
                sumIndexRightDiagonal += map[i][SIZE - i - 1];
            }

            if (sumIndexLeftDiagonal > maxSum) {
                maxSum = sumIndexLeftDiagonal;
                indexLeftDiagonal = i;
            } else if (sumIndexRightDiagonal > maxSum) {
                maxSum = sumIndexRightDiagonal;
                indexRightDiagonal = i;
            }
        }
        allParameters[0] = maxSum;
        if (sumIndexLeftDiagonal > sumIndexRightDiagonal) {
            return aiCheckIndexesForDiagonals(allParameters, indexLeftDiagonal, -1);
        } else {
            return aiCheckIndexesForDiagonals(allParameters, -1, indexRightDiagonal);
        }
    }

    static int[] aiCheckIndexesForDiagonals(int[] allParameters, int indexLeftDiagonal, int indexRightDiagonal) {
        if (indexRightDiagonal == -1) {
            return aiCheckIndexesForLeftDiagonal(allParameters);
        } else {
            return aiCheckIndexesForRightDiagonal(allParameters);
        }
    }

    static int[] aiCheckIndexesForLeftDiagonal(int[] allParameters) {
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == DOT_X && i == 0) {
                if (map[i + 1][i + 1] == DOT_EMPTY) {
                    allParameters[1] = i + 1;
                    allParameters[2] = i + 1;
                    break;
                }
            }
            if (map[i][i] == DOT_X && i != 0 && i != SIZE - 1) {
                if (map[i + 1][i + 1] == DOT_EMPTY) {
                    allParameters[1] = i + 1;
                    allParameters[2] = i + 1;
                    break;
                } else if (map[i - 1][i - 1] == DOT_EMPTY){
                    allParameters[1] = i - 1;
                    allParameters[2] = i - 1;
                    break;
                }
            }
            if (map[i][i] == DOT_X && i == SIZE - 1) {
                if (map[i - 1][i - 1] == DOT_EMPTY) {
                    allParameters[1] = i - 1;
                    allParameters[2] = i - 1;
                    break;
                }
            }
        }
        return allParameters;
    }

    static int[] aiCheckIndexesForRightDiagonal(int[] allParameters) {
        for (int i = 0; i < SIZE; i++) {
            if (map[i][SIZE - i - 1] == DOT_X && i == 0) {
                if (map[i + 1][SIZE - i - 2] == DOT_EMPTY) {
                    allParameters[1] = i + 1;
                    allParameters[2] = SIZE - i - 2;
                    break;
                }
            }
            if (map[i][SIZE - i - 1] == DOT_X && i != 0 && i != SIZE - 1) {
                if (map[i + 1][SIZE - i - 2] == DOT_EMPTY) {
                    allParameters[1] = i + 1;
                    allParameters[2] = SIZE - i - 2;
                    break;
                } else if (map[i - 1][SIZE - i] == DOT_EMPTY){
                    allParameters[1] = i - 1;
                    allParameters[2] = SIZE - i;
                    break;
                }
            }
            if (map[i][SIZE - i - 1] == DOT_X && i == SIZE - 1) {
                if (map[i - 1][SIZE - i + 1] == DOT_EMPTY) {
                    allParameters[1] = i - 1;
                    allParameters[2] = SIZE - i + 1;
                    break;
                }
            }
        }
        return allParameters;
    }
}
