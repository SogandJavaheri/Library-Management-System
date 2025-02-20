package com.github.sogandjavaheri.LibraryManagementSystem;

import java.util.Scanner;

public class LibraryManagementSystem {

    private Member[] members;
    private int memberCounter;
    private int memberIdCounter;


    public LibraryManagementSystem() {
        members = new Member[1000];
        memberCounter = 0;
        memberIdCounter = 0000;
    }


    public void create(Scanner scanner) {

        if (memberCounter >= members.length) {
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


        members[memberCounter++] = new Member(memberIdCounter++, name, age, gender);
        System.out.println(name + "'s ID is: " + memberIdCounter);

    }

    public void read(Scanner scanner) {
        if (memberCounter == 0) {
            System.out.println("No members found.");
            return;
        }

        System.out.println("\nEnter the ID you want to read: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < memberCounter; i++) {
            if (members[i].getId() == id-1) {
                System.out.println("\nDetails are below: ");
                members[i].printMemberInfo();
            }
            else
                System.out.println(id + " not found.");
        }
    }

    public void update(Scanner scanner) {
        System.out.println("Enter the ID you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        updateName(id);
        updateAge(id);
        updateGender(id);

        System.out.println("Member updated successfully.");

    }

    public void updateName(int id) {
        for (int i = 0; i < memberCounter; i++) {
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
        for (int i = 0; i < memberCounter; i++) {
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
        for (int i = 0; i < memberCounter; i++) {
            if (members[i].getId() == id-1) {
                System.out.println("Enter new gender: ");
                Scanner gender1 = new Scanner(System.in);
                members[i].setGender(gender1.nextLine());
            }
            else
                System.out.println(id + " not found.");
        }
    }

    public void delete(Scanner scanner) {
        System.out.println("Enter the ID you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < memberCounter; i++) {
            if (members[i].getId() == id) {
                members[i] = members[memberCounter-1];
                members[memberCounter--] = null;
                System.out.println("Member deleted successfully.");
                return;
            }
            else
                System.out.println(id + " not found.");
        }
    }
}
