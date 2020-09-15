package ru.geekbrains.student_project.lesson_6;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Ivasik");
        Dog dog = new Dog("Tolya");

        cat.jump(2);
        cat.run(200);
        cat.swim(5);

        dog.jump(1);
        dog.run(500);
        dog.swim(10);
    }
}
