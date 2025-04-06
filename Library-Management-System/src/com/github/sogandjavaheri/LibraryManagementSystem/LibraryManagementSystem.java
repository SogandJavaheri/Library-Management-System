package com.github.sogandjavaheri.LibraryManagementSystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryImpl library = new LibraryImpl();

        Member m1 = new Member(1, "Ali", 21, "Male");
        Member m2 = new Member(2, "Sara", 24, "Female");
        Book b1 = new Book(1, "Java Fundamentals");
        Book b2 = new Book(2, "Clean Code");

        library.save(m1);
        library.save(m2);
        library.save(b1);
        library.save(b2);

        library.borrow(m1, b1);
        library.giveBack(m1, b1);

        Entity[] foundBooks = library.find(new Book(0, ""));
        for (Entity e : foundBooks) {
            e.show();
        }

        Entity[] foundMembers = library.find(new Member(0, "", 0, ""));
        for (Entity e : foundMembers) {
            e.show();
        }
    }
}
