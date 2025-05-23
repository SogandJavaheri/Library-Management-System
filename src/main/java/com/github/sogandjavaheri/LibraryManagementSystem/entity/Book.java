package com.github.sogandjavaheri.LibraryManagementSystem.entity;
import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;

import java.io.Serializable;


public class Book extends Entity implements Serializable {
    private static int counter = 1000000;
    private String name;
    private CustomLinkedList<Member> borrowers;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        super(id);
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, int bookCounter) {
        super(bookCounter);
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public Book(int id, String author) {
        super(id);
        this.author = author;
    }

    public Book(String name) {
        super(counter++);
        this.name = name;
        this.borrowers = new CustomLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addBorrower(Member member) {
        borrowers.add(member);
    }

    public void removeBorrower(Member member) {
        for (int i = 0; i < borrowers.size(); i++) {
            if (borrowers.get(i).getId() == member.getId()) {
                borrowers.remove(i);
                break;
            }
        }
    }

    public CustomLinkedList<Member> getBorrowers() {
        return borrowers;
    }

    public String toString() {
        return getId() + "," + name;
    }

    public String getTitle() {
        return getName();
    }
}
