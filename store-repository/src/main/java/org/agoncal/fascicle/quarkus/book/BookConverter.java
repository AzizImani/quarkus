package org.agoncal.fascicle.quarkus.book;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookConverter {

    public BookEntity toEntity(Book book) {
        BookEntity entity = new BookEntity();
        entity.setId(book.getId());
        entity.setIsbn(book.getIsbn());
        entity.setLanguage(book.getLanguage());
        return entity;
    }

    public Book toInternalModel(BookEntity entity) {
        return new Book(
                entity.getId(),
                entity.getIsbn(),
                entity.getLanguage()
        );
    }

    public List<Book> toInternalModels(List<BookEntity> entities) {
        return entities.stream()
                .map(this::toInternalModel)
                .collect(Collectors.toList());
    }
}
