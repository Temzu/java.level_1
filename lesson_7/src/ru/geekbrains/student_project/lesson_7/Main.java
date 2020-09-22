package ru.geekbrains.student_project.lesson_7;

public class Main {

    public static void main(String[] args) {
	    Plate plate = new Plate(50);
	    Cat cat1 = new Cat("Vasya", 25);
	    Cat cat2 = new Cat("Jora", 10);
	    Cat cat3 = new Cat("Dasha", 30);
	    Cat[] arrayOfCats = {cat1, cat2, cat3};

	    Services.eatFromPlate(arrayOfCats, plate);
		Services.printWhoIsWellFed(arrayOfCats);
		System.out.println();

		plate.increaseFood(15);
		cat3.eat(plate);
		System.out.println(cat3.getName() + " is well-fed: " + cat3.isSatiety());
    }
    
}
