package com.github.sogandjavaheri.LibraryManagementSystem.controller;

import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;
import com.github.sogandjavaheri.LibraryManagementSystem.enumeration.Gender;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Member;
import com.github.sogandjavaheri.LibraryManagementSystem.manager.SerializableLibraryManager;
import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;

import java.util.Scanner;


public class LibrarySystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library(new SerializableLibraryManager());

    public static void main(String[] args) {
        library.loadData();
        boolean exit = false;

        while (!exit) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addBook();
                case "2" -> addMember();
                case "3" -> borrowBook();
                case "4" -> returnBook();
                case "5" -> viewBooks();
                case "6" -> viewMembers();
                case "7" -> saveData();
                case "0" -> exit = true;
                default -> System.out.println("Invalid option!");
            }
        }

        System.out.println("Exiting system. Goodbye!");
    }

    private static void printMainMenu() {
        System.out.println("\n--- Library System Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. View All Books");
        System.out.println("6. View All Members");
        System.out.println("7. Save Data");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() {
        System.out.print("Enter book name: ");
        String name = scanner.nextLine();
        library.addBook(name);
        System.out.println("Book added.");
    }

    private static void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        library.addMember(name, gender);
        System.out.println("Member added.");
    }

    private static void borrowBook() {
        try {
            int memberId = getId("member");
            int bookId = getId("book");
            library.borrowBook(memberId, bookId);
            System.out.println("Book borrowed.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void returnBook() {
        try {
            int memberId = getId("member");
            int bookId = getId("book");
            library.returnBook(memberId, bookId);
            System.out.println("Book returned.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewBooks() {
        CustomLinkedList<Book> books = library.getBooks();
        System.out.println("\n--- Book List ---");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println("ID: " + b.getId() + " | Name: " + b.getName() +
                    " | Borrowers: " + b.getBorrowers().size());
        }
    }

    private static void viewMembers() {
        CustomLinkedList<Member> members = library.getMembers();
        System.out.println("\n--- Member List ---");
        for (int i = 0; i < members.size(); i++) {
            Member m = members.get(i);
            System.out.println("ID: " + m.getId() + " | Name: " + m.getName() +
                    " | Borrowed Books: " + m.getBorrowedBooks().size());
        }
    }

    private static void saveData() {
        library.saveData();
        System.out.println("Data saved.");
    }

    private static int getId(String entityName) {
        System.out.print("Enter " + entityName + " ID: ");
        return Integer.parseInt(scanner.nextLine());
    }
}