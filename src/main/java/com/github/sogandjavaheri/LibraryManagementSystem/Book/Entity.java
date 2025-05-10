package com.github.sogandjavaheri.LibraryManagementSystem.Book;


public abstract class Entity {
    private int id;
    private static int counter = 0;

    public Entity() {
        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    public abstract String printInfo();
}
