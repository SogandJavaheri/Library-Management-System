package com.github.sogandjavaheri.LibraryManagementSystem.LinkedList;


import com.github.sogandjavaheri.LibraryManagementSystem.Book.Entity;
import com.github.sogandjavaheri.LibraryManagementSystem.Exception.EntityNotFoundException;
import com.github.sogandjavaheri.LibraryManagementSystem.Exception.InvalidEntityException;

public class CustomLinkedList<T extends Entity> {
    private Node<T> head;


    public void add(T data) {
        if (data == null) {
            throw new InvalidEntityException("Cannot add null data to the list.");
        }

        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> current = head;
        while (current.next != null)
            current = current.next;
        current.next = newNode;
    }

    public T getById(int id) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.getId() == id)
                return current.data;
            current = current.next;
        }
        throw new EntityNotFoundException("Entity with ID " + id + " not found.");
    }

    public boolean update(int id, T newData) {
        if (newData == null) {
            throw new InvalidEntityException("Cannot update with null data.");
        }

        Node<T> current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                current.data = newData;
                return true;
            }
            current = current.next;
        }
        throw new EntityNotFoundException("Update failed. Entity with ID " + id + " not found.");
    }

    public boolean delete(int id) {
        if (head == null) {
            throw new EntityNotFoundException("Cannot delete. List is empty.");
        }

        if (head.data.getId() == id) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.getId() == id) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        throw new EntityNotFoundException("Delete failed. Entity with ID " + id + " not found.");
    }

    public void displayAll() {
        if (head == null) {
            throw new EntityNotFoundException("The list is empty. Nothing to display.");
        }

        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data.printInfo());
            current = current.next;
        }
    }

    public Node<T> getHead() {
        return head;
    }
}
