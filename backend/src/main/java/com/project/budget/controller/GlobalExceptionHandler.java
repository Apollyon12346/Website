package com.project.budget.controller;


import com.project.budget.domain.dto.CategoryDto;
import com.project.budget.domain.dto.ErrorDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//This section handles exception from the whole program
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDto> handlevaildationException(MethodArgumentNotValidException ex) {
        //Gets the error message and place it in the variable
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation Failed");
        ErrorDto errorDto = new ErrorDto(errorMessage);
        //return an error HTTP 400 due to bad info given
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

}
