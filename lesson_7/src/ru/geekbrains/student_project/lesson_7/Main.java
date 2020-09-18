package ru.geekbrains.student_project.lesson_7;

public class Main {

    public static void main(String[] args) {
	    Plate plate = new Plate(50);
	    Cat cat1 = new Cat("Vasya", 25);
	    Cat cat2 = new Cat("Jora", 10);
	    Cat cat3 = new Cat("Dasha", 30);
	    Cat[] arrayOfCats = {cat1, cat2, cat3};

	    eatFromPlate(arrayOfCats, plate);
		printWhoIsWellFed(arrayOfCats);
		System.out.println();

		plate.increaseFood(15);
		cat3.eat(plate);
		System.out.println(cat3.getName() + " is well-fed: " + cat3.isSatiety());
    }

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
