package com.company.validators;

import com.company.exceptions.EmptyManufacturerException;
import com.company.exceptions.EmptyProductNameException;

public class IndustrialProductValidator {
    public IndustrialProductValidator() {

    }

    public void validateManufacturer(String manufacturer) throws EmptyManufacturerException {
        if(manufacturer.length() == 0) throw new EmptyManufacturerException();
    }

    public void validateProductName(String productName) throws EmptyProductNameException {
        if(productName.length() == 0) throw new EmptyProductNameException();
    }
}
