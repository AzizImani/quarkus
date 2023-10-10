package org.agoncal.fascicle.quarkus.resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.agoncal.fascicle.quarkus.api.BooksApi;
import org.agoncal.fascicle.quarkus.book.Book;
import org.agoncal.fascicle.quarkus.book.BookFinder;
import org.agoncal.fascicle.quarkus.book.BookSaver;
import org.agoncal.fascicle.quarkus.models.CreateBookRequest;
import org.agoncal.fascicle.quarkus.models.UpdateBookRequest;

@ApplicationScoped
public class BookResource implements BooksApi {

    @Inject
    BookFinder bookFinder;
    @Inject
    BookSaver bookSaver;
    @Inject
    BookConverter bookConverter;
    @Inject
    BookValidator bookValidator;

    @Override
    public Response addBook(CreateBookRequest createBookRequest) {
        bookValidator.validate(createBookRequest);
        Book book = bookConverter.toInternalModel(createBookRequest);
        bookSaver.persist(book);
        return Response.ok()
                .build();
    }

    @Override
    public Response findAllBooks() {
        return Response.ok(bookConverter.toPayloads(bookFinder.findAll()))
                .build();
    }

    @Override
    public Response findBookByIsbn(String isbn) {
        return Response.ok().build();
    }

    @Override
    public Response updateBook(String isbn, UpdateBookRequest book) {
        return Response.ok().build();
    }
}