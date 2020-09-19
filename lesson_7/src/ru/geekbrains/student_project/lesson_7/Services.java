package ru.geekbrains.student_project.lesson_7;

public class Services {
    static void eatFromPlate(Cat[] cats, Plate plate) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }
    }

    static void printWhoIsWellFed(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].getName() + " is well-fed: " + cats[i].isSatiety());
        }
    }
}
