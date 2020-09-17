package ru.geekbrains.student_project.lesson_6;

import java.util.Random;

public class Animal {
    public Random random = new Random();
    private String name;
    private float jumpHeight;
    private float runningDistance;
    private float swimmingDistance;

    public Animal(String name) {
        this.name = name;
    }

    public void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public void setRunningDistance(int runningDistance) {
        this.runningDistance = runningDistance;
    }

    public void setSwimmingDistance(int swimmingDistance) {
        this.swimmingDistance = swimmingDistance;
    }

    void run(float obstacleLength) {
        System.out.println(name + " run: " + check(obstacleLength));
    }

    void swim(float obstacleLength) {
        System.out.println(name + " swim: " + check(obstacleLength));
    }

    void jump(float obstacleHeight) {
        System.out.println(name + " jump: " + check(obstacleHeight));
    }

    private String check(float a) {
        return a > jumpHeight ? "false" : "true";
    }
}
