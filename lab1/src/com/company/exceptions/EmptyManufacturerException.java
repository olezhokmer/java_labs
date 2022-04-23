package com.company.exceptions;

public class EmptyManufacturerException extends Exception {
    public EmptyManufacturerException() {
        super("Empty manufacturer name.");
    }
}
