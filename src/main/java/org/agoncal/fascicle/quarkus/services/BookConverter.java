package org.agoncal.fascicle.quarkus.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.fascicle.quarkus.entities.BookEntity;
import org.agoncal.fascicle.quarkus.models.Book;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
class BookConverter {

    BookEntity toEntity(Book book) {
        BookEntity entity = new BookEntity();
        entity.setIsbn(book.getIsbn());
        entity.setLanguage(book.getLanguage());
        entity.setNbOfPage(book.getNumberOfPages());
        entity.setPublicationDate(book.getPublicationDate());
        return entity;
    }

    Book toInternalModel(BookEntity entity) {
        return new Book(
                entity.getIsbn(),
                entity.getNbOfPage(),
                entity.getPublicationDate(),
                entity.getLanguage()
        );
    }

    List<Book> toInternalModels(List<BookEntity> entities) {
        return entities.stream()
                .map(this::toInternalModel)
                .collect(Collectors.toList());
    }
}