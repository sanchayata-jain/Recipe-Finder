package com.RecipeFinderBackend.RecipeFinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED) //401
public class IncorrectCredentialException extends RuntimeException {
    public IncorrectCredentialException(String message) {
        super(message);
    }
}