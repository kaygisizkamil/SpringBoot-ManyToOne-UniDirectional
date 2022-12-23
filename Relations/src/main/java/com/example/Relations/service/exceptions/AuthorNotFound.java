package com.example.Relations.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
//ugly and not detailed way of exception handling but it works
public class AuthorNotFound extends RuntimeException{
    public AuthorNotFound(String message){
        super(message);
    }
}
