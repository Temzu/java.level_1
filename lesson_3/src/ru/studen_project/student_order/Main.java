package ru.studen_project.student_order;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    /**
     * 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
     * каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше. После
     * победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     *
     * 2. Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
     * "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
     *
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые
     * стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно, можно пользоваться:
     * String str = "apple";
     * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово
     * Используем только маленькие буквы
     */

    //Задание 1
    static void guessNumber() {
        System.out.println("Угадай число от 0 до 9");
        Random random = new Random();
        int attempts = 3;
        int randomNumber = random.nextInt(10);
        for (int i = 0; i <= attempts; i++) {
            Scanner scanner = new Scanner(System.in);
            if (attempts == i) {
                System.out.println("Ты проиграл :(");
                askUser(scanner);
            } else if (randomNumber == scanner.nextInt()) {
                System.out.println("Ты выиграл!!!");
                askUser(scanner);
            } else {
                System.out.println("Не угадал -_-    Осталось " + (attempts - i - 1) + " попытки");
            }
        }
    }

    static void askUser(Scanner scanner) {
        System.out.println("Повторить игру еще раз? 1 - да / 0 - нет");
        if (scanner.nextInt() == 1) {
            guessNumber();
        } else {
            System.out.println("Game over");
            scanner.close();
        }
    }
}
