package com.github.sogandjavaheri.LibraryManagementSystem.linkedList;


import com.github.sogandjavaheri.LibraryManagementSystem.entity.Entity;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
