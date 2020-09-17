package ru.geekbrains.student_project.lesson_6;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        setJumpHeight(random.nextFloat() + 0.1f);
        setRunningDistance(random.nextInt(100) + 450);
        setSwimmingDistance(random.nextInt(10) + 5);
    }
}
