package com.github.sogandjavaheri.LibraryManagementSystem.Member;


import com.github.sogandjavaheri.LibraryManagementSystem.Book.Book;

public class Member extends Person {
    private int membershipId;
    private Book borrowedBook;

    public Member(String name, Gender gender, int membershipId) {
        super(name, gender);
        this.membershipId = membershipId;
    }

    public boolean hasBorrowedBook() {
        return borrowedBook != null;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void borrowBook(Book book) {
        this.borrowedBook = book;
    }

    public void returnBook() {
        this.borrowedBook = null;
    }

    @Override
    public String printInfo() {
        return super.printInfo() + ", Membership: " + membershipId +
                (hasBorrowedBook() ? ", Borrowed: " + borrowedBook.getTitle() : "");
    }
}

