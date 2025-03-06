package com.github.sogandjavaheri.LibraryManagementSystem;

public class Book {

    private String title;
    private String author;
    private int code;


    public Book() {
        this(0000, "Hamlet", "Shakespeare");
    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public Book(int code, String title, String author) {
        this.title = title;
        this.author = author;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void printBookInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ID: " + code);
    }
}
