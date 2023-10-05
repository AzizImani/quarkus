package org.agoncal.fascicle.quarkus;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.agoncal.fascicle.quarkus.entities.Book;
import org.agoncal.fascicle.quarkus.entities.Language;
import org.agoncal.fascicle.quarkus.repositories.BookRepository;

import java.time.Instant;
//import javax.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @Inject
    BookRepository bookRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/create")
    public Response create() {
        Book book = new Book();
        book.setIsbn("isbn");
        book.setLanguage(Language.EN);
        book.setNbOfPage(256);
        book.setPublicationDate(Instant.now());
        bookRepository.save(book);
        return Response.ok().build();
    }

    @GET
    @Path("/list")
    public Response list() {
        return Response.ok(bookRepository.findAll().list()).build();
    }
}
