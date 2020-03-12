package app.entities;

public class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }

    @Override
    public String toString() {
        return String.format("%s %s", name, surname);
    }
}
