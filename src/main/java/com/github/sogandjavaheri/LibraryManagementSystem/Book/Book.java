package com.github.sogandjavaheri.LibraryManagementSystem.Book;


public class Book extends Entity {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        this.isAvailable = false;
    }

    public void giveBack() {
        this.isAvailable = true;
    }

    @Override
    public String printInfo() {
        return "ID: " + getId() + ", Title: " + title + ", Author: " + author +
                ", Status: " + (isAvailable ? "Available" : "Borrowed");
    }
}
