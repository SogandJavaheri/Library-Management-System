package com.github.sogandjavaheri.LibraryManagementSystem;

class LibraryImpl implements Library {
    private Entity[] entities = new Entity[200];
    private int count = 0;

    public void save(Entity entity) {
        entities[count++] = entity;
    }

    public void update(Entity entity) {
        for (int i = 0; i < count; i++) {
            if (entities[i].getId() == entity.getId() && entities[i].getClass() == entity.getClass()) {
                entities[i] = entity;
                return;
            }
        }
        System.out.println("Entity not found.");
    }

    public void delete(Entity entity) {
        for (int i = 0; i < count; i++) {
            if (entities[i].getId() == entity.getId() && entities[i].getClass() == entity.getClass()) {
                for (int j = i; j < count - 1; j++) {
                    entities[j] = entities[j + 1];
                }
                count--;
                return;
            }
        }
        System.out.println("Entity not found.");
    }

    public Entity[] find(Entity example) {
        Entity[] result = new Entity[count];
        int found = 0;

        for (int i = 0; i < count; i++) {
            if ((example instanceof Member && entities[i] instanceof Member) ||
                    (example instanceof Book && entities[i] instanceof Book)) {
                result[found++] = entities[i];
            }
        }

        Entity[] finalResult = new Entity[found];
        for (int i = 0; i < found; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }

    public void borrow(Member member, Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void giveBack(Member member, Book book) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book wasn't borrowed.");
        }
    }
}
