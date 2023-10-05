package org.agoncal.fascicle.quarkus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book extends Item {
    @Column(length = 15)
    private String isbn;
    @Column(name = "nb_of_pages")
    private Integer nbOfPage;
    @Column(name = "publication_date")
    private Instant publicationDate;
    @Enumerated(EnumType.STRING)
    private Language language;
    /*@OneToMany
    @JoinTable(name = "book_author",
      joinColumns = @JoinColumn(name = "book_fk"),
      inverseJoinColumns = @JoinColumn(name = "author_fk")
    )
    private Set<Author> authors = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "publisher_pk")
    private Publisher publisher;
    // Constructors, getters, setters*/

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Instant getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Instant publicationDate) {
        this.publicationDate = publicationDate;
    }
}