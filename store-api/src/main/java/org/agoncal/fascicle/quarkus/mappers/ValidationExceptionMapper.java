package org.agoncal.fascicle.quarkus.mappers;

import org.agoncal.fascicle.quarkus.exceptions.ValidationException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Date;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ApiError(new Date(), exception.getMessage()))
                .build();
    }
}
