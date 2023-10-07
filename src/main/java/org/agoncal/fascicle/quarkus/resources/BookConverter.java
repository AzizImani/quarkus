package org.agoncal.fascicle.quarkus.resources;

import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.fascicle.quarkus.api.models.Book.LanguageEnum;
import org.agoncal.fascicle.quarkus.models.Book;
import org.agoncal.fascicle.quarkus.models.Language;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
class BookConverter {

    org.agoncal.fascicle.quarkus.api.models.Book toPayload(Book model) {
        return org.agoncal.fascicle.quarkus.api.models.Book.builder()
                .isbn(model.getIsbn())
                .pages((long) model.getNumberOfPages())
                .language(toPayload(model.getLanguage()))
                .publicationDate(Date.from(model.getPublicationDate()))
                .build();
    }

    private LanguageEnum toPayload(Language language) {
        switch (language) {
            case AR:
                return LanguageEnum.AR;
            case EN:
                return LanguageEnum.EN;
        }
        throw new IllegalArgumentException();
    }

    List<org.agoncal.fascicle.quarkus.api.models.Book> toPayloads(List<Book> entities) {
        return entities.stream()
                .map(this::toPayload)
                .collect(Collectors.toList());
    }

    public Book toInternalModel(org.agoncal.fascicle.quarkus.api.models.Book book) {
        return new Book(
                book.getIsbn(),
                book.getPages().intValue(),
                book.getPublicationDate().toInstant(),
                Language.valueOf(book.getLanguage().name())
        );
    }

    private Language toInternalModel(LanguageEnum language) {
        switch (language) {
            case AR:
                return Language.AR;
            case EN:
                return Language.EN;
        }
        throw new IllegalArgumentException();
    }
}