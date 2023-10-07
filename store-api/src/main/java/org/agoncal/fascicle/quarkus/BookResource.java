package org.agoncal.fascicle.quarkus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.agoncal.fascicle.quarkus.api.BooksApi;
import org.agoncal.fascicle.quarkus.book.BookFinder;
import org.agoncal.fascicle.quarkus.book.BookSaver;
import org.agoncal.fascicle.quarkus.models.Book;

@ApplicationScoped
public class BookResource implements BooksApi {

    @Inject
    BookFinder bookFinder;

    @Override
    public Response addBook(Book book) {
        return null;
    }

    @Override
    public Response findAllBooks() {
        return Response.ok(bookFinder.findAll()).build();
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
