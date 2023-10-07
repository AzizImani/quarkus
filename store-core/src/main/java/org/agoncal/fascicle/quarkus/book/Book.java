package org.agoncal.fascicle.quarkus.book;

public class Book {

    private final Long id;
    private final String isbn;
    private final Language language;

    public Book(Long id, String isbn, Language language) {
        this.id = id;
        this.isbn = isbn;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public Language getLanguage() {
        return language;
    }
}
