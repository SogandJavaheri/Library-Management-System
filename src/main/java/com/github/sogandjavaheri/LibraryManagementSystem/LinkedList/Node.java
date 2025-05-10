package com.github.sogandjavaheri.LibraryManagementSystem.LinkedList;


import com.github.sogandjavaheri.LibraryManagementSystem.Book.Entity;

public class Node<T extends Entity> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
