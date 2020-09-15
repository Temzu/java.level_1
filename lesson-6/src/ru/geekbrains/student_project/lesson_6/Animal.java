package ru.geekbrains.student_project.lesson_6;

import java.util.Random;

public class Animal {
    public Random random = new Random();
    private String name;
    private float jumpHeight;
    private int runningDistance;
    private int swimmingDistance;

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

    void run(int obstacleLength) {
        if (obstacleLength > runningDistance) {
            System.out.println(name + " run: " + false);
        } else {
            System.out.println(name + " run: " + true);
        }
    }

    void swim(int obstacleLength) {
        if (swimmingDistance == 0) {
            System.out.println(name + " swim: The cat cannot swim.");
        } else if (obstacleLength > swimmingDistance){
            System.out.println(name + " swim: " + false);
        } else {
            System.out.println(name + " swim: " + true);
        }
    }

    void jump(float obstacleHeight) {
        if (obstacleHeight > jumpHeight) {
            System.out.println(name + " jump: " + false);
        } else {
            System.out.println(name + " jump: " + true);
        }
    }
}
