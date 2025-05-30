package com.github.sogandjavaheri.LibraryManagementSystem.controller;

import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;
import com.github.sogandjavaheri.LibraryManagementSystem.exception.EntityNotFoundException;
import com.github.sogandjavaheri.LibraryManagementSystem.manager.LibraryFileManager;
import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Member;


public class Library {
    private final CustomLinkedList<Book> books;
    private final CustomLinkedList<Member> members;
    private final LibraryFileManager fileManager;

    public Library(LibraryFileManager fileManager) {
        this.books = new CustomLinkedList<>();
        this.members = new CustomLinkedList<>();
        this.fileManager = fileManager;
    }

    public void saveMembers() {
        fileManager.saveMembers(members);
    }

    public void saveBooks() {
        fileManager.saveBooks(books);
    }

    public void loadMembers() {
        CustomLinkedList<Member> loadedMembers = fileManager.loadMembers();
        if (loadedMembers != null) {
            this.members.clear();
            for (int i = 0; i < loadedMembers.size(); i++) {
                members.add(loadedMembers.get(i));
            }
        }
    }

    public void loadBooks() {
        CustomLinkedList<Book> loadedBooks = fileManager.loadBooks();
        if (loadedBooks != null) {
            this.books.clear();
            for (int i = 0; i < loadedBooks.size(); i++) {
                books.add(loadedBooks.get(i));
            }
        }
    }

    public void addBook(String title) {
        books.add(new Book(title));
        System.out.println("Book added: " + title);
    }

    public void addMember(String name) {
        members.add(new Member(name));
        System.out.println("Member added: " + name);
    }

    public void borrowBook(String bookTitle) {
        try {
            Book book = findBookByTitle(bookTitle);
            if (book.getBorrowers().size() >= 1) {
                System.out.println("Book is already borrowed.");
                return;
            }

            if (members.size() == 0) {
                System.out.println("No members available to borrow the book.");
                return;
            }
            Member member = members.get(0);

            book.addBorrower(member);
            member.addBorrowedBook(book);
            System.out.println("Book borrowed: " + bookTitle + " by " + member.getName());

        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(String bookTitle) {
        try {
            Book book = findBookByTitle(bookTitle);
            if (book.getBorrowers().size() == 0) {
                System.out.println("Book is not borrowed.");
                return;
            }

            Member member = book.getBorrowers().get(0);
            book.removeBorrower(member);
            member.removeBorrowedBook(book);
            System.out.println("Book returned: " + bookTitle + " by " + member.getName());

        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Book findBookByTitle(String title) throws EntityNotFoundException {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                return books.get(i);
            }
        }
        throw new EntityNotFoundException("Book with title '" + title + "' not found.");
    }

    public void printAllMembers() {
        System.out.println("All Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }
    }

    public void printAllBooks() {
        System.out.println("All Books:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}