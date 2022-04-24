package com.company.exceptions;

public class EmptyManufacturerException extends SystemException {
    public EmptyManufacturerException() {
        super("Empty manufacturer name.");
    }
}
