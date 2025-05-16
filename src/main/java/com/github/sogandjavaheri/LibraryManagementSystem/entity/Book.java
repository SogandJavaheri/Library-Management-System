package com.github.sogandjavaheri.LibraryManagementSystem.entity;
import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;

import java.io.Serializable;


public class Book extends Entity implements Serializable {
    private static int counter = 1000000;
    private String name;
    private CustomLinkedList<Member> borrowers;

    public Book(String name) {
        super(counter++);
        this.name = name;
        this.borrowers = new CustomLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addBorrower(Member member) {
        borrowers.add(member);
    }

    public void removeBorrower(Member member) {
        for (int i = 0; i < borrowers.size(); i++) {
            if (borrowers.get(i).getId() == member.getId()) {
                borrowers.remove(i);
                break;
            }
        }
    }

    public CustomLinkedList<Member> getBorrowers() {
        return borrowers;
    }

    public String toString() {
        return getId() + "," + name;
    }
}
