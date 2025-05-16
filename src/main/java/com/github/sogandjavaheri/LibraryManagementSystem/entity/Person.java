package com.github.sogandjavaheri.LibraryManagementSystem.entity;

import com.github.sogandjavaheri.LibraryManagementSystem.enumeration.Gender;


public abstract class Person extends Entity {
    private String name;
    private Gender gender;

    public Person(int id, String name, Gender gender) {
        super(id);
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }
}
