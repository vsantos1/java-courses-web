package com.vsanto1.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ResourceAlreadyExistException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceAlreadyExistException(String message) {
        super(message);
    }
}
