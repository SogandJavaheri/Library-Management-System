package com.github.sogandjavaheri.LibraryManagementSystem.manager;

import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Member;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;
import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.Node;
import java.io.*;


public class TextLibraryFileManager implements LibraryFileManager {
    String fileName1 = "membersFile.txt";
    String fileName2 = "booksFile.txt";


    @Override
    public void saveMembers(CustomLinkedList<Member> members) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1))) {
            Node<Member> current = members.getHead();
            while (current != null) {
                Member m = current.getData();
                writer.write(m.getId() + "," + m.getName() + "," + m.getGender());
                writer.newLine();
                current = current.getNext();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveBooks(CustomLinkedList<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            Node<Book> current = books.getHead();
            while (current != null) {
                Book b = current.getData();
                writer.write(b.getId() + "," + b.getAuthor());
                writer.newLine();
                current = current.getNext();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomLinkedList<Member> loadMembers() {
        CustomLinkedList<Member> members = new CustomLinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String genderStr = parts[2];
                members.add(new Member(id, name, Enum.valueOf(com.github.sogandjavaheri.LibraryManagementSystem.enumeration.Gender.class, genderStr)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public CustomLinkedList<Book> loadBooks() {
        CustomLinkedList<Book> books = new CustomLinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName2))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String author = parts[1];
                books.add(new Book(id, author));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
