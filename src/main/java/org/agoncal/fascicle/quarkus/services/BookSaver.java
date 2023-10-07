package org.agoncal.fascicle.quarkus.services;


import org.agoncal.fascicle.quarkus.models.Book;

public interface BookSaver {
    void save(Book book);
}