package com.company.exceptions;

public class EmptyProductNameException extends SystemException {
    public EmptyProductNameException() {
        super("Empty product name.");
    }
}
