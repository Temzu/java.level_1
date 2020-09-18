package ru.geekbrains.student_project.lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    int getAppetite() {
        return appetite;
    }

    String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    void eat(Plate plate) {
        if (!(canCatEat(plate))) {
            System.out.println(name + " cannot eat. There is little food in this plate.");
            return;
        }
        plate.decreaseFood(getAppetite());
        satiety = true;
        System.out.println(name + " ate and asleep.");
    }

    boolean canCatEat(Plate plate) {
        return plate.getFood() >= appetite;
    }

}
