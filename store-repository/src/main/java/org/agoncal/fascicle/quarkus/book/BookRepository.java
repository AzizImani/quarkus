package org.agoncal.fascicle.quarkus.book;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
@Default
public class BookRepository implements PanacheRepository<BookEntity> {
    public Optional<BookEntity> findByIsbn(String isbn) {
        return find("isbn", isbn).firstResultOptional();
    }

    public long deleteByIsbn(String isbn) {
        return delete("isbn", isbn);
    }

    @Transactional
    public void save(BookEntity book) {
        persist(book);
    }
}