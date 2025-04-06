package com.github.sogandjavaheri.LibraryManagementSystem;

public abstract class Person implements Entity {
    protected int id;
    protected String name;
    protected int age;
    protected String gender;

    public Person(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void show() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }
}
