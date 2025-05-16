package com.github.sogandjavaheri.LibraryManagementSystem.manager;

import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Member;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;

import java.io.*;

public class TextFileLibraryManager implements LibraryFileManager {

    @Override
    public void saveData(CustomLinkedList<Member> members, CustomLinkedList<Book> books) {
        try {
            BufferedWriter bookWriter = new BufferedWriter(new FileWriter("books.txt"));
            for (int i = 0; i < books.size(); i++) {
                bookWriter.write(books.get(i).toString() + "\n");
            }
            bookWriter.close();

            BufferedWriter memberWriter = new BufferedWriter(new FileWriter("members.txt"));
            for (int i = 0; i < members.size(); i++) {
                memberWriter.write(members.get(i).toString() + "\n");
            }
            memberWriter.close();
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public void loadData(CustomLinkedList<Member> members, CustomLinkedList<Book> books) {
        System.out.println("Text-based manager does not support loading yet.");
    }
}