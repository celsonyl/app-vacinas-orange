package com.example.zuporange.resource.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodValidation(MethodArgumentNotValidException error, HttpServletRequest request){
        ValidationError validationError = new ValidationError("Erro de validação",request.getRequestURI());

        for (FieldError x : error.getBindingResult().getFieldErrors()) {
            validationError.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityViolationException error,HttpServletRequest request){
        StandardError standardError = new StandardError("Email ou Cpf ja existente"+error.getMessage(),request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(standardError);
    }
}
