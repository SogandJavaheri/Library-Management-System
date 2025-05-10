package com.github.sogandjavaheri.LibraryManagementSystem;

import com.github.sogandjavaheri.LibraryManagementSystem.Book.Book;
import com.github.sogandjavaheri.LibraryManagementSystem.Exception.EntityNotFoundException;
import com.github.sogandjavaheri.LibraryManagementSystem.Exception.InvalidEntityException;
import com.github.sogandjavaheri.LibraryManagementSystem.FileManager.LibraryFileManager;
import com.github.sogandjavaheri.LibraryManagementSystem.Library.LibraryImplement;
import com.github.sogandjavaheri.LibraryManagementSystem.Member.Gender;
import com.github.sogandjavaheri.LibraryManagementSystem.Member.Member;

import java.util.Scanner;


public class LibrarySystemTest {
    public static void main(String[] args) {
        LibraryImplement library = new LibraryImplement();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        try {
            while (!exit) {
                System.out.println("\n--- LIBRARY MENU ---");
                System.out.println("1. Add Member");
                System.out.println("2. Add Book");
                System.out.println("3. View All Members");
                System.out.println("4. View All Books");
                System.out.println("5. Borrow a Book");
                System.out.println("6. Return a Book");
                System.out.println("7. Search Member by Name");
                System.out.println("8. Search Book by Title");
                System.out.println("9. Save and Exit");
                System.out.print("Enter your choice (1–9): ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1": // Add Member
                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Gender (MALE/FEMALE/OTHER): ");
                        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

                        System.out.print("Membership ID: ");
                        int type = scanner.nextInt();

                        Member member = new Member(name, gender, type);
                        library.addMember(member);
                        break;

                    case "2": // Add Book
                        System.out.print("Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Author: ");
                        String author = scanner.nextLine();

                        Book book = new Book(title, author);
                        library.addBook(book);
                        break;

                    case "3": // View Members
                        library.displayMembers();
                        break;

                    case "4": // View Books
                        library.displayBooks();
                        break;

                    case "5": // Borrow Book
                        System.out.print("Enter Member ID: ");
                        int memId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Book ID: ");
                        int bookId = Integer.parseInt(scanner.nextLine());

                        library.borrowBook(memId, bookId);
                        break;

                    case "6": // Return Book
                        System.out.print("Enter Member ID: ");
                        int returnId = Integer.parseInt(scanner.nextLine());

                        library.giveBackBook(returnId);
                        break;

                    case "7": // Search Member
                        System.out.print("Enter name to search: ");
                        String memberName = scanner.nextLine();
                        library.searchMembersByName(memberName);
                        break;

                    case "8": // Search Book
                        System.out.print("Enter title to search: ");
                        String bookTitle = scanner.nextLine();
                        library.searchBooksByTitle(bookTitle);
                        break;

                    case "9": // Save and Exit
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }

        } catch (EntityNotFoundException | InvalidEntityException e) {
            System.err.println("Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input (e.g. wrong gender or number format).");

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());

        } finally {
            // Save all data
            LibraryFileManager.saveAllMembers(library.getMemberList());
            LibraryFileManager.saveAllBooks(library.getBookList());
            scanner.close();

            System.out.println("Library session ended. Data saved successfully.");
        }
    }
}

