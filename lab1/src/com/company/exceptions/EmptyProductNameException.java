package com.company.exceptions;

public class EmptyProductNameException extends Exception {
    public EmptyProductNameException() {
        super("Empty product name.");
    }
}
