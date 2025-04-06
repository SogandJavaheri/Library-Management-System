package com.github.sogandjavaheri.LibraryManagementSystem;

public class Member extends Person {

    private boolean hasOverdueBook = false;

    public Member(int id, String name, int age, String gender) {
        super(id, name, age, gender);
    }

    public boolean hasOverdueBook() {
        return hasOverdueBook;
    }

    public void setOverdueBook(boolean overdue) {
        hasOverdueBook = overdue;
    }
}