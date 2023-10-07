package org.agoncal.fascicle.quarkus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.agoncal.fascicle.quarkus.models.Language;

import java.time.Instant;

@Entity
public class BookEntity extends ItemEntity {
    @Column(length = 15)
    private String isbn;
    @Column(name = "nb_of_pages")
    private Integer nbOfPage;
    @Column(name = "publication_date")
    private Instant publicationDate;
    @Enumerated(EnumType.STRING)
    private Language language;

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