package com.github.sogandjavaheri.LibraryManagementSystem;

public class Book implements Entity {

    private int id;
    private String title;
    private boolean isBorrowed = false;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }

    public void show() {
        System.out.println("ID: " + id + ", Title: " + title + ", Borrowed: " + (isBorrowed ? "Yes" : "No"));
    }
}