package com.github.sogandjavaheri.LibraryManagementSystem;

import java.util.Scanner;

public class LibraryManagementSystemTest {

    public static void main(String[] args) {

//        Member[] members = new Member[2];
//
//        members[0] = new Member("Sogand Javaheri", 26, "F");
//        members[0].setId(0001);
//        members[0].printMemberInfo();
//        members[0].printId();
//
//        System.out.println("*****************");
//
//        members[1] = new Member("Leyla Mansoori", 26, "F");
//        members[1].setId(0002);
//        members[1].printMemberInfo();
//        members[1].printId();
//
//        System.out.println("*****************");

        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();
        Member member = new Member();

        library.create(scanner);
        System.out.println();

        library.read(scanner);
        System.out.println();

        library.update(scanner);
        System.out.println();

        library.delete(scanner);
        System.out.println();
        System.out.println("*****************");


//        while (true){
//            System.out.print("\n1.Create Member \t2. Read Members \t3. Update Members \t4. Delete Members \t5. Exit ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:library.create(scanner);
//                case 2:library.read(scanner);
//                case 3:library.update(scanner);
//                case 4:library.delete(scanner);
//                break;
//            }
//        }
    }
}
