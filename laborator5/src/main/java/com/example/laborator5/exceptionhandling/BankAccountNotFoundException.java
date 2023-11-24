package com.example.laborator5.exceptionhandling;

public class BankAccountNotFoundException extends RuntimeException{
    public BankAccountNotFoundException(String msg) {
        super(msg);
    }
}
