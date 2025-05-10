package com.github.sogandjavaheri.LibraryManagementSystem.FileManager;

import com.github.sogandjavaheri.LibraryManagementSystem.Book.Book;
import com.github.sogandjavaheri.LibraryManagementSystem.LinkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.LinkedList.Node;
import com.github.sogandjavaheri.LibraryManagementSystem.Member.Member;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class LibraryFileManager {

    private static final String MEMBER_FILE = "members.txt";
    private static final String BOOK_FILE = "books.txt";


    public static void saveAllMembers(CustomLinkedList<Member> members) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBER_FILE))) {
            Node<Member> current = members.getHead();
            while (current != null) {
                Member m = current.data;
                String line = m.getId() + "," + m.getName() + "," + m.getGender() + "," +
                        m.hasBorrowedBook() + "," +
                        (m.hasBorrowedBook() ? m.getBorrowedBook().getId() : "null") + "," +
                        m.printInfo();
                writer.write(line);
                writer.newLine();
                current = current.next;
            }
            System.out.println("Members saved to " + MEMBER_FILE);
        } catch (IOException e) {
            System.err.println("Error saving members: " + e.getMessage());
        }
    }


    public static void saveAllBooks(CustomLinkedList<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            Node<Book> current = books.getHead();
            while (current != null) {
                Book b = current.data;
                String line = b.getId() + "," + b.getTitle() + "," + b.getAuthor() + "," + b.isAvailable();
                writer.write(line);
                writer.newLine();
                current = current.next;
            }
            System.out.println("Books saved to " + BOOK_FILE);
        } catch (IOException e) {
            System.err.println("Error saving books: " + e.getMessage());
        }
    }
}
