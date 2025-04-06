package com.github.sogandjavaheri.LibraryManagementSystem;

public interface Library {
    void save(Entity entity);
    void update(Entity entity);
    void delete(Entity entity);
    Entity[] find(Entity example);
    void borrow(Member member, Book book);
    void giveBack(Member member, Book book);
}