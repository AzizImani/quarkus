package org.agoncal.fascicle.quarkus.book;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookConverter {

    public BookEntity toEntity(Book book) {
        BookEntity entity = new BookEntity();
        entity.setIsbn(book.getIsbn());
        entity.setLanguage(book.getLanguage());
        entity.setNumberOfPages(book.getNumberOfPages());
        entity.setPublicationDate(book.getPublicationDate());
        return entity;
    }

    public Book toInternalModel(BookEntity entity) {
        return new Book(
                entity.getIsbn(),
                entity.getNumberOfPages(),
                entity.getPublicationDate(),
                entity.getLanguage()
        );
    }

    public List<Book> toInternalModels(List<BookEntity> entities) {
        return entities.stream()
                .map(this::toInternalModel)
                .collect(Collectors.toList());
    }
}