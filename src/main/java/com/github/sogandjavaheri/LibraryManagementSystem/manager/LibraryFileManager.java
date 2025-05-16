package com.github.sogandjavaheri.LibraryManagementSystem.manager;

import com.github.sogandjavaheri.LibraryManagementSystem.linkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Member;
import com.github.sogandjavaheri.LibraryManagementSystem.entity.Book;

public interface LibraryFileManager {
    void saveData(CustomLinkedList<Member> members, CustomLinkedList<Book> books);
    void loadData(CustomLinkedList<Member> members, CustomLinkedList<Book> books);
}

