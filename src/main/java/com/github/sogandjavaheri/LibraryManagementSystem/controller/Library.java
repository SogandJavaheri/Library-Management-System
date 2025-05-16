package com.github.sogandjavaheri.LibraryManagementSystem.controller;


import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;
import com.github.sogandjavaheri.LibraryManagementSystem.enumeration.Gender;
import com.github.sogandjavaheri.LibraryManagementSystem.exception.EntityNotFoundException;
import com.github.sogandjavaheri.LibraryManagementSystem.manager.LibraryFileManager;
import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.exception.InvalidEntityException;
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

    public void loadData() {
        fileManager.loadData(members, books);
    }

    public void saveData() {
        fileManager.saveData(members, books);
    }

    public void addBook(String name) {
        books.add(new Book(name));
    }

    public void addMember(String name, Gender gender) {
        members.add(new Member(name, gender));
    }

    public void borrowBook(int memberId, int bookId)
            throws InvalidEntityException, EntityNotFoundException {
        Member member = getMemberById(memberId);
        Book book = getBookById(bookId);

        if (book.getBorrowers().size() >= 1) {
            throw new InvalidEntityException("Book is already borrowed.");
        }

        book.addBorrower(member);
        member.addBorrowedBook(book);
    }

    public void returnBook(int memberId, int bookId)
            throws InvalidEntityException, EntityNotFoundException {
        Member member = getMemberById(memberId);
        Book book = getBookById(bookId);

        book.removeBorrower(member);
        member.removeBorrowedBook(book);
    }

    public CustomLinkedList<Book> getBooks() {
        return books;
    }

    public CustomLinkedList<Member> getMembers() {
        return members;
    }

    public Member getMemberById(int id) throws EntityNotFoundException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == id) return members.get(i);
        }
        throw new EntityNotFoundException("Member with ID " + id + " not found.");
    }

    public Book getBookById(int id) throws EntityNotFoundException {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) return books.get(i);
        }
        throw new EntityNotFoundException("Book with ID " + id + " not found.");
    }
}