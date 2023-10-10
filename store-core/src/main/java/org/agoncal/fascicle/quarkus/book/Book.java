package org.agoncal.fascicle.quarkus.book;

import java.time.Instant;

public class Book {

    private final String isbn;
    private final Integer numberOfPages;
    private final Instant publicationDate;
    private final Language language;

    public Book(String isbn, Integer numberOfPages, Instant publicationDate, Language language) {
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.publicationDate = publicationDate;
        this.language = language;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public Instant getPublicationDate() {
        return publicationDate;
    }

    public Language getLanguage() {
        return language;
    }
}