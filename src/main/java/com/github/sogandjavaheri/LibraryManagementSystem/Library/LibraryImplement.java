package com.github.sogandjavaheri.LibraryManagementSystem.Library;


import com.github.sogandjavaheri.LibraryManagementSystem.Book.Book;
import com.github.sogandjavaheri.LibraryManagementSystem.LinkedList.CustomLinkedList;
import com.github.sogandjavaheri.LibraryManagementSystem.Exception.InvalidEntityException;
import com.github.sogandjavaheri.LibraryManagementSystem.Member.Member;
import com.github.sogandjavaheri.LibraryManagementSystem.LinkedList.Node;

public class LibraryImplement {
    private CustomLinkedList<Member> members = new CustomLinkedList<Member>();
    private CustomLinkedList<Book> books = new CustomLinkedList<Book>();


    public void addMember(Member member) {
        members.add(member);
    }

    public void displayMembers() {
        members.displayAll();
    }

    public boolean updateMember(int id, Member updatedMember) {
        return members.update(id, updatedMember);
    }

    public boolean deleteMember(int id) {
        return members.delete(id);
    }

    public Member getMemberById(int id) {
        return members.getById(id);
    }


    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        books.displayAll();
    }

    public boolean updateBook(int id, Book updatedBook) {
        return books.update(id, updatedBook);
    }

    public boolean deleteBook(int id) {
        return books.delete(id);
    }

    public Book getBookById(int id) {
        return books.getById(id);
    }

    public void borrowBook(int memberId, int bookId) {
        Member member = members.getById(memberId);
        Book book = books.getById(bookId);

        if (!book.isAvailable()) {
            throw new InvalidEntityException("Book is already borrowed.");
        }
        if (member.hasBorrowedBook()) {
            throw new InvalidEntityException("Member already borrowed a book.");
        }

        book.borrow();
        member.borrowBook(book);
        System.out.println("Book borrowed successfully.");
    }

    public void giveBackBook(int memberId) {
        Member member = members.getById(memberId);
        if (!member.hasBorrowedBook()) {
            throw new InvalidEntityException("This member has no borrowed book.");
        }

        Book book = member.getBorrowedBook();
        book.giveBack();
        member.returnBook();
        System.out.println("Book returned successfully.");
    }

    public void searchBooksByTitle(String title) {
        System.out.println("Books with title containing \"" + title + "\":");
        boolean found = false;
        Node<Book> current = books.getHead();
        while (current != null) {
            if (current.data.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(current.data.printInfo());
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found.");
        }
    }

    public void searchMembersByName(String name) {
        System.out.println("Members with name containing \"" + name + "\":");
        boolean found = false;
        Node<Member> current = members.getHead();
        while (current != null) {
            if (current.data.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(current.data.printInfo());
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No members found.");
        }
    }

    public CustomLinkedList<Member> getMemberList() {
        return members;
    }

    public CustomLinkedList<Book> getBookList() {
        return books;
    }
}


