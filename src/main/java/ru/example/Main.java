package ru.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setAge(5)
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        son.happyBirthday();
        System.out.println("День рождения у сына: " + son);

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        Person test = new PersonBuilder()
                .setName("Тест")
                .setSurname("Тестович")
                .build();

        System.out.println(test);

        System.out.println("Есть возраст? " + test.hasAge());
        System.out.println("Есть адрес? " + test.hasAddress());
    }
}