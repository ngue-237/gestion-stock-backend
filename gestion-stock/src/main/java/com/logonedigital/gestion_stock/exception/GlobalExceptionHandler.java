package com.logonedigital.gestion_stock.exception;

import com.logonedigital.gestion_stock.dto.ErrorMessage;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorMessage resourceNotFoundHandler(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                HttpStatus.NOT_FOUND.getReasonPhrase()
        );
       return errorMessage;
    }

    @ExceptionHandler(ResourceExistException.class)
    public ErrorMessage resourceExistExceptionHandler(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                HttpStatus.BAD_REQUEST.getReasonPhrase()
        );
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



}
