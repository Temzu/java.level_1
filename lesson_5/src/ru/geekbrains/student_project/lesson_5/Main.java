package ru.geekbrains.student_project.lesson_5;

public class Main {

    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee(
                "Ivanov Ivan Ivanovich",
                "Specialist",
                "ivan@mail.ru",
                "89042223311",
                35000,
                25
        );

        employeeArray[1] = new Employee(
                "Nazaryk Egor Sergeevich",
                "Junior",
                "egor@mail.ru",
                "89034552343",
                60000,
                23
        );

        employeeArray[2] = new Employee(
                "Tiron Sergey Vasillevich",
                "Middle",
                "tiron@mail.ru",
                "89034551232",
                100000,
                31
        );

        employeeArray[3] = new Employee(
                "Barybin Anatoliy Artemovich",
                "Senior",
                "tolyan@mail.ru",
                "89034552343",
                210000,
                42
        );

        employeeArray[4] = new Employee(
                "Rogulin Aleksey Anatollevich",
                "Architect",
                "lexa@mail.ru",
                "89012331522",
                340000,
                51
        );

        getInfoOver40YearsOld(employeeArray);

    }

    static void getInfoOver40YearsOld(Employee[] employeeArray) {
        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].age > 40) {
                System.out.println(i + 1 + ": " + employeeArray[i].toString());
                System.out.println();
            }
        }
    }
}
