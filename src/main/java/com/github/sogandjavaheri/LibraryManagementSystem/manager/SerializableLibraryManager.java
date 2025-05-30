package com.github.sogandjavaheri.LibraryManagementSystem.manager;

import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Member;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;
import java.io.*;


public class SerializableLibraryManager implements LibraryFileManager, Serializable {
    String fileName1 = "membersFile.txt";
    String fileName2 = "booksFile.txt";

    @Override
    public void saveMembers(CustomLinkedList<Member> members) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName1))) {
            out.writeObject(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveBooks(CustomLinkedList<Book> books) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName2))) {
            out.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomLinkedList<Member> loadMembers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName1))) {
            return (CustomLinkedList<Member>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new CustomLinkedList<>();
        }
    }

    @Override
    public CustomLinkedList<Book> loadBooks() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName2))) {
            return (CustomLinkedList<Book>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new CustomLinkedList<>();
        }
    }
}
