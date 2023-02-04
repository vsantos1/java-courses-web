package com.vsanto1.courses.exceptions;

import com.vsanto1.courses.dtos.ExceptionDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class CustomExceptionResponseHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionDTO> handleNotFoundException(Exception ex, HttpServletRequest request) {
        ExceptionDTO exception = new ExceptionDTO(ex.getMessage(), HttpStatus.NOT_FOUND, request.getRequestURI(), new Date());

        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public final ResponseEntity<ExceptionDTO> handleConflictException(Exception ex, HttpServletRequest request) {
        ExceptionDTO exception = new ExceptionDTO(ex.getMessage(), HttpStatus.BAD_REQUEST, request.getRequestURI(), new Date());

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }


}
