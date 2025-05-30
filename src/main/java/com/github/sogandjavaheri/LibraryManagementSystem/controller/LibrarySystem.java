package com.github.sogandjavaheri.LibraryManagementSystem.controller;

import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;
import com.github.sogandjavaheri.LibraryManagementSystem.enumeration.Gender;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Member;
import com.github.sogandjavaheri.LibraryManagementSystem.manager.LibraryFileManager;
import com.github.sogandjavaheri.LibraryManagementSystem.manager.SerializableLibraryManager;
import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.manager.TextLibraryFileManager;

import java.util.Scanner;


public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose File Manager: 1. Text  2. Serializable");
        int choice = Integer.parseInt(scanner.nextLine());

        LibraryFileManager fileManager;
        if (choice == 2) {
            fileManager = new SerializableLibraryManager();
        } else {
            fileManager = new TextLibraryFileManager();
        }

        Library library = new Library(fileManager);
        library.loadMembers();
        library.loadBooks();

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Member");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Members");
            System.out.println("6. Show All Books");
            System.out.println("7. Save Members");
            System.out.println("8. Save Books");
            System.out.println("9. Load Members");
            System.out.println("10. Load Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    library.addMember(memberName);
                    library.saveMembers();
                }
                case 2 -> {
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    library.addBook(bookTitle);
                    library.saveBooks();
                }
                case 3 -> {
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    library.saveMembers();
                    library.saveBooks();
                }
                case 4 -> {
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    library.saveMembers();
                    library.saveBooks();
                }
                case 5 -> library.printAllMembers();
                case 6 -> library.printAllBooks();
                case 7 -> library.saveMembers();
                case 8 -> library.saveBooks();
                case 9 -> library.loadMembers();
                case 10 -> library.loadBooks();
                case 0 -> {
                    System.out.println("Exiting program...");
                    library.saveMembers();
                    library.saveBooks();
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}