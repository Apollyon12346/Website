package com.project.budget.exception;

import java.util.UUID;
//this class trigger when trying to access a category that does not exist
public class CategoryNotFoundException extends RuntimeException {
    private final UUID id;
    //this creates a custom error message when triggered
    public CategoryNotFoundException(UUID id) {
        super(
                String.format("Category with id %s does not exist", id)
        );
        this.id = id;
    }
    public UUID getId() {
        return id;
    }
}
