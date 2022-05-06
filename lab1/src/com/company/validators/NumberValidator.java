package com.company.validators;

import com.company.exceptions.NotPositiveNumberException;

public class NumberValidator {
    public void validatePositiveNumber(Integer number) throws NotPositiveNumberException {
        if(number <= 0) throw new NotPositiveNumberException();
    }
}
