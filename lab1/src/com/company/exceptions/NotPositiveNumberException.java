package com.company.exceptions;

public class NotPositiveNumberException extends SystemException {
    public NotPositiveNumberException() {
        super("Number shoul me more then zero.");
    }
}
