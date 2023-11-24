package com.example.laborator5.exceptionhandling;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class BankAccountExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleBankAccountNotFound(RuntimeException e){
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleFieldValidation(MethodArgumentNotValidException e){
        List<String> errors = e.getBindingResult()
                .getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        return ResponseEntity.badRequest().body(errors);
    }
}
