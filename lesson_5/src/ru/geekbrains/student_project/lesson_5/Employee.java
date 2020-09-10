package ru.geekbrains.student_project.lesson_5;

public class Employee {
    String fullName;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        String infoAboutEmployee = "";
        infoAboutEmployee += "Full name: " + this.fullName + ", ";
        infoAboutEmployee += "position: " + this.position + ", ";
        infoAboutEmployee += "email: " + this.email + ", ";
        infoAboutEmployee += "phoneNumber: " + this.phoneNumber + ", ";
        infoAboutEmployee += "salary: " + this.salary + ", ";
        infoAboutEmployee += "age: " + this.age;
        return infoAboutEmployee;
    }
}
