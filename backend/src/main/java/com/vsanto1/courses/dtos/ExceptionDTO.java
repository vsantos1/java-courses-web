package com.vsanto1.courses.dtos;

import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class ExceptionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;

    private HttpStatus status;

    private String path;
    private Date timestamp;

    public ExceptionDTO(String message, HttpStatus status, String path, Date timestamp) {
        this.message = message;
        this.status = status;
        this.path = path;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status.value();
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
