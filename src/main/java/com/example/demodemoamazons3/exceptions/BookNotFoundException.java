package com.example.demodemoamazons3.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
