package org.agoncal.fascicle.quarkus;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.agoncal.fascicle.quarkus.api.BooksApi;
import org.agoncal.fascicle.quarkus.models.Book;
import org.agoncal.fascicle.quarkus.repositories.BookRepository;

public class BookResource implements BooksApi {

    @Inject
    BookRepository bookRepository;

    @Override
    public Response addBook(Book book) {
        return null;
    }

    @Override
    public Response findAllBooks() {
        return Response.ok(bookRepository.findAll().list()).build();
    }

    @Override
    public Response findBookByIsbn(String isbn) {
        return null;
    }

    @Override
    public Response updateBook(String isbn, Book book) {
        return null;
    }
}
