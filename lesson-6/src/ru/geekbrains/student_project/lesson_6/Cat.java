package ru.geekbrains.student_project.lesson_6;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        setJumpHeight(random.nextFloat() + 2);
        setRunningDistance(random.nextInt(100) + 150);
        setSwimmingDistance(0);
    }
}
