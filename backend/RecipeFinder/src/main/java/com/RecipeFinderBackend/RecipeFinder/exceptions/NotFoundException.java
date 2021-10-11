package com.RecipeFinderBackend.RecipeFinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //404
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
