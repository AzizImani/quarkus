package org.agoncal.fascicle.quarkus.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.agoncal.fascicle.quarkus.entities.BookEntity;
import org.agoncal.fascicle.quarkus.models.Book;
import org.agoncal.fascicle.quarkus.repositories.BookRepository;

import java.util.List;


@ApplicationScoped
public class BookService implements BookFinder, BookSaver
{

    @Inject
    BookRepository bookRepository;
    @Inject
    BookConverter bookConverter;

    @Override
    public List<Book> findAll() {
        List<BookEntity> entities = bookRepository.findAll().list();
        return bookConverter.toInternalModels(entities);
    }

    @Override
    public void save(Book book) {
        BookEntity entity = bookConverter.toEntity(book);
        bookRepository.save(entity);
    }
}
