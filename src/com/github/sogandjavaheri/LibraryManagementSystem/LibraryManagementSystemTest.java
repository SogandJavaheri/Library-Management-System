package com.github.sogandjavaheri.LibraryManagementSystem;

import java.util.Scanner;

public class LibraryManagementSystemTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Member member = new Member();
        Book book = new Book();


        System.out.println("Choose between 1.Book and 2.Member");
        int choice = scanner.nextInt();

        if (choice == 1) {
                System.out.println("Choose the operation: ");
                System.out.println("1.Create  2.Read  3.Update  4.Delete  5.Exit ");
                int choice2 = scanner.nextInt();
                scanner.nextLine();

                if (choice2 == 1)
                    library.createBook(scanner);

                else if (choice2 == 2)
                    library.readBook(scanner);

                else if (choice2 == 3)
                    library.updateBook(scanner);

                else if (choice2 == 4)
                    library.deleteBook(scanner);

                else
                    System.out.println("Invalid choice. Try again.");
            }


        else if (choice == 2) {
                System.out.println("Choose the operation: ");
                System.out.println("1.Create  2.Read  3.Update  4.Delete  5.Exit ");
                int choice2 = scanner.nextInt();
                scanner.nextLine();

                if (choice2 == 1)
                    library.createMember(scanner);

                else if (choice2 == 2)
                    library.readMember(scanner);

                else if (choice2 == 3)
                    library.updateMember(scanner);

                else if (choice2 == 4)
                    library.deleteMember(scanner);

                else
                    System.out.println("Invalid choice. Try again.");
        }
    }
}

//        library.createMember(scanner);
//        System.out.println();
//
//        library.readMember(scanner);
//        System.out.println();
//
//        library.updateMember(scanner);
//        System.out.println();
//
//        library.deleteMember(scanner);
//        System.out.println();
//        System.out.println("*****************");