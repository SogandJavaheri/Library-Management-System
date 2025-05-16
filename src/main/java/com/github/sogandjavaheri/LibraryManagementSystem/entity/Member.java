package com.github.sogandjavaheri.LibraryManagementSystem.entity;

import com.github.sogandjavaheri.LibraryManagementSystem.enumeration.Gender;
import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;

import java.io.Serializable;


public class Member extends Person implements Serializable {
    private static int counter = 1000000;
    private CustomLinkedList<Book> borrowedBooks;

    public Member(String name, Gender gender) {
        super(counter++, name, gender);
        this.borrowedBooks = new CustomLinkedList<>();
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        for (int i = 0; i < borrowedBooks.size(); i++) {
            if (borrowedBooks.get(i).getId() == book.getId()) {
                borrowedBooks.remove(i);
                break;
            }
        }
    }

    public CustomLinkedList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + getGender();
    }
}