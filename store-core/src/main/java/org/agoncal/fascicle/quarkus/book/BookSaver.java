package org.agoncal.fascicle.quarkus.book;

public interface BookSaver {
    void persist(Book book);
}