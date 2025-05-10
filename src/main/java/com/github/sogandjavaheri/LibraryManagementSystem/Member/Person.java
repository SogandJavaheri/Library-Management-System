package com.github.sogandjavaheri.LibraryManagementSystem.Member;


import com.github.sogandjavaheri.LibraryManagementSystem.Book.Entity;

public class Person extends Entity {
    private String name;
    private Gender gender;

    public Person(String name, Gender gender) {
        super();
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String printInfo() {
        return "ID: " + getId() + ", Name: " + name + ", Gender: " + gender;
    }
}

