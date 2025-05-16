package com.github.sogandjavaheri.LibraryManagementSystem.manager;

import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Member;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;

import java.io.*;

public class SerializableLibraryManager implements LibraryFileManager {

    @Override
    public void saveData(CustomLinkedList<Member> members, CustomLinkedList<Book> books) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("library_data.ser"))) {
            out.writeObject(members);
            out.writeObject(books);
            System.out.println("Library data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public void loadData(CustomLinkedList<Member> members, CustomLinkedList<Book> books) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("library_data.ser"))) {
            CustomLinkedList<Member> loadedMembers = (CustomLinkedList<Member>) in.readObject();
            CustomLinkedList<Book> loadedBooks = (CustomLinkedList<Book>) in.readObject();

            for (int i = 0; i < loadedMembers.size(); i++) {
                members.add(loadedMembers.get(i));
            }
            for (int i = 0; i < loadedBooks.size(); i++) {
                books.add(loadedBooks.get(i));
            }

            System.out.println("Library data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}