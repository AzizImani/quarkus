package org.agoncal.fascicle.quarkus.services;

import org.agoncal.fascicle.quarkus.models.Book;

import java.util.List;

public interface BookFinder {
    List<Book> findAll();
}