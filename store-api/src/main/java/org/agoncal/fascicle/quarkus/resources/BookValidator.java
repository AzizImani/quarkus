package org.agoncal.fascicle.quarkus.resources;

import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.fascicle.quarkus.exceptions.ValidationException;
import org.agoncal.fascicle.quarkus.models.CreateBookRequest;
import org.apache.commons.lang3.StringUtils;

@ApplicationScoped
public class BookValidator {

    public void validate(CreateBookRequest request) {
        if (StringUtils.isEmpty(request.getIsbn())) {
            throw new ValidationException("Book's Isbn is not valid");
        }
    }
}