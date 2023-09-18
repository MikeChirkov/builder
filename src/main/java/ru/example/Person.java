package ru.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    public Boolean hasAge() {
        return getAge().isPresent();
    }

    public Boolean hasAddress() {
        return Objects.nonNull(this.address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age == 0)
            return OptionalInt.empty();
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person {");
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        if (this.getAge().isPresent())
            sb.append(", age='").append(age).append('\'');
        if (Objects.nonNull(this.getAddress()))
            sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
