package com.github.sogandjavaheri.LibraryManagementSystem;

import java.util.Scanner;

public class Library {

    private Member[] members;
    private int memberCount;
    private int memberIdCounter;
    private Book[] books;
    private int bookCount;
    private int bookIdCounter;


    public Library() {
        members = new Member[1000];
        memberCount = 0;
        memberIdCounter = 0;
        books = new Book[10000];
        bookCount = 0;
        bookIdCounter = 0;
    }


    public void createMember(Scanner scanner) {

        if (memberCount >= members.length) {
            System.out.println("The library is full");
            return;
        }

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your gender: ");
        String gender = scanner.nextLine();


        members[memberCount++] = new Member(memberIdCounter++, name, age, gender);
        System.out.println(name + "'s ID is: " + memberIdCounter);

    }

    public void readMember(Scanner scanner) {
        if (memberCount == 0) {
            System.out.println("No members found.");
            return;
        }

        System.out.println("Enter the ID you want to read: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId() == id-1) {
                System.out.println("\nDetails are below: ");
                members[i].printMemberInfo();
            }
            else
                System.out.println(id + " not found.");
        }
    }

    public void updateMember(Scanner scanner) {
        System.out.println("Enter the ID you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        updateName(id);
        updateAge(id);
        updateGender(id);

        System.out.println("Member updated successfully.");

    }

    public void updateName(int id) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId() == id-1) {
                System.out.println("Enter new name: ");
                Scanner name1 = new Scanner(System.in);
                members[i].setName(name1.nextLine());
            }
            else
                System.out.println(id + " not found.");
        }
    }

    public void updateAge(int id) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId() == id-1) {
                System.out.println("Enter new age: ");
                Scanner age1 = new Scanner(System.in);
                members[i].setAge(age1.nextInt());
            }
            else
                System.out.println(id + " not found.");
        }
    }

    public void updateGender(int id) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId() == id-1) {
                System.out.println("Enter new gender: ");
                Scanner gender1 = new Scanner(System.in);
                members[i].setGender(gender1.nextLine());
            }
            else
                System.out.println(id + " not found.");
        }
    }

    public void deleteMember(Scanner scanner) {
        System.out.println("Enter the ID you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId() == id) {
                members[i] = members[memberCount -1];
                members[memberCount--] = null;
                System.out.println("Member deleted successfully.");
                return;
            }
            else
                System.out.println(id + " not found.");
        }
    }

    public void createBook(Scanner scanner) {
        if (bookCount >= books.length) {
            System.out.println("Library is full, cannot add more books.");
            return;
        }
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        System.out.println("Enter book author: ");
        String author = scanner.nextLine();

        books[bookCount++] = new Book(bookIdCounter++, title, author);
        System.out.println("Book added successfully!");
    }

    public void readBook(Scanner scanner) {
        if (bookCount == 0) {
            System.out.println("No books found.");
            return;
        }

        System.out.println("Enter book ID: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getCode() == code-1) {
                System.out.println("Details are below: ");
                books[i].printBookInfo();
            }
            else
                System.out.println(code + " not found.");
        }
    }

    public void updateBook(Scanner scanner) {
        System.out.println("Enter the book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        updateTitle(id);
        updateAuthor(id);
        System.out.println("Book updated successfully!");
    }

    public void updateTitle(int id) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getCode() == id) {
                System.out.println("Enter new title: ");
                Scanner title1 = new Scanner(System.in);
                books[i].setTitle(title1.nextLine());
            }
        }
        System.out.println("Book not found.");
    }

    public void updateAuthor(int id) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getCode() == id) {
                System.out.println("Enter new author: ");
                Scanner author1 = new Scanner(System.in);
                books[i].setAuthor(author1.nextLine());
            }
        }
        System.out.println("Book not found.");
    }

    public void deleteBook(Scanner scanner) {
        System.out.println("Enter the book ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getCode() == id) {
                books[i] = books[bookCount - 1];
                books[--bookCount] = null;
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void borrowBook(Scanner scanner) {
        System.out.println("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getCode() == bookId) {
                if (!books[i].isBorrowed()) {
                    books[i].setBorrowed(true);
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(Scanner scanner) {
        System.out.println("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getCode() == bookId) {
                if (books[i].isBorrowed()) {
                    books[i].setBorrowed(false);
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void listOverdueMembers() {
        System.out.println("Members with overdue books:");
        for (int i = 0; i < memberCount; i++) {
            if (members[i].hasOverdueBook()) {
                members[i].printMemberInfo();
            }
        }
    }
}
