package org.agoncal.fascicle.quarkus.book;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class BookService implements BookFinder, BookSaver {

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
    public void persist(Book book) {
        BookEntity entity = bookConverter.toEntity(book);
        bookRepository.save(entity);
    }
}