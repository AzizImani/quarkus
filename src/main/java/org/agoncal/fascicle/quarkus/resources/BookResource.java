package org.agoncal.fascicle.quarkus.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.agoncal.fascicle.quarkus.api.BooksApi;
import org.agoncal.fascicle.quarkus.api.models.Book;
import org.agoncal.fascicle.quarkus.repositories.BookRepository;
import org.agoncal.fascicle.quarkus.services.BookFinder;
import org.agoncal.fascicle.quarkus.services.BookSaver;

public class BookResource implements BooksApi {

    @Inject
    BookFinder bookFinder;
    @Inject
    BookSaver bookSaver;
    @Inject
    BookConverter bookConverter;

    @Override
    public Response addBook(Book book) {
        bookSaver.save(bookConverter.toInternalModel(book));
        return Response.ok().build();
    }

    @Override
    public Response findAllBooks() {
        return Response.ok(bookConverter.toPayloads(bookFinder.findAll()))
                .build();
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
