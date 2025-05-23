package com.github.sogandjavaheri.LibraryManagementSystem.linkedList;


import com.github.sogandjavaheri.LibraryManagementSystem.entity.Entity;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }
}

