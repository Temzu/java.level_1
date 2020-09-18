package ru.geekbrains.student_project.lesson_7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    void info() {
        System.out.println("plate: " + food);
    }

    int decreaseFood(int appetite) {
        food -= appetite;
        return food;
    }

    void increaseFood(int value) {
        food += value;
    }


}
