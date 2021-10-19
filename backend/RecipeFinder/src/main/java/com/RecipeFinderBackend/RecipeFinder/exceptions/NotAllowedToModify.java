package com.RecipeFinderBackend.RecipeFinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED) //404
public class NotAllowedToModify extends RuntimeException{
    public NotAllowedToModify(String message) {
        super(message);
    }
}
