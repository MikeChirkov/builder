package ru.example;

import java.util.Objects;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Недопустимый возраст");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (Objects.isNull(this.name) || Objects.isNull(this.surname)) {
            throw new IllegalStateException("Не хватает обязательных полей");
        }

        if (this.age != 0 && Objects.nonNull(this.address)) {
            return new Person(name, surname, age, address);
        } else if (this.age != 0) {
            return new Person(name, surname, age);
        } else if (Objects.nonNull(this.address)) {
            return new Person(name, surname, address);
        } else {
            return new Person(name, surname);
        }

    }

}
