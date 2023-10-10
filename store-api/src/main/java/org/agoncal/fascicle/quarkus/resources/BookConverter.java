package org.agoncal.fascicle.quarkus.resources;

import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.fascicle.quarkus.book.Book;
import org.agoncal.fascicle.quarkus.book.Language;
import org.agoncal.fascicle.quarkus.models.Books;
import org.agoncal.fascicle.quarkus.models.CreateBookRequest;
import org.agoncal.fascicle.quarkus.models.CreateBookRequest.LanguageEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookConverter {

    private static final Logger log = LoggerFactory.getLogger(BookConverter.class);

    public Book toInternalModel(CreateBookRequest request) {
        return new Book(
                request.getIsbn(),
                request.getPages(),
                request.getPublicationDate().toInstant(),
                toInternalModel(request.getLanguage())
        );
    }

    private Language toInternalModel(LanguageEnum language) {
        switch (language) {
            case AR:
                return Language.AR;
            case EN:
                return Language.EN;
        }
        log.warn("Unexpected language {}, defaulting to En.", language);
        return Language.EN;
    }

    public Books toPayloads(List<Book> books) {
        return Books.builder()
                .value(books.stream().map(this::toPayload).collect(Collectors.toList()))
                .build();
    }

    private org.agoncal.fascicle.quarkus.models.Book toPayload(Book book) {
        return org.agoncal.fascicle.quarkus.models.Book.builder()
                .isbn(book.getIsbn())
                .language(toPayload(book.getLanguage()))
                .publicationDate(Date.from(book.getPublicationDate()))
                .pages(book.getNumberOfPages())
                .build();
    }

    private org.agoncal.fascicle.quarkus.models.Book.LanguageEnum toPayload(Language language) {
        if (language == Language.AR) {
            return org.agoncal.fascicle.quarkus.models.Book.LanguageEnum.AR;
        }
        return org.agoncal.fascicle.quarkus.models.Book.LanguageEnum.EN;
    }
}