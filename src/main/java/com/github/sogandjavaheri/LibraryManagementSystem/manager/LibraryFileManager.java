package com.github.sogandjavaheri.LibraryManagementSystem.manager;

import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Member;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;

public interface LibraryFileManager {
    public void saveMembers(CustomLinkedList<Member> members);

    public void saveBooks(CustomLinkedList<Book> books);

    CustomLinkedList<Member> loadMembers();
    CustomLinkedList<Book> loadBooks();
}

