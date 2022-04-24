package com.company.services;

import com.company.exceptions.EmptyManufacturerException;
import com.company.exceptions.EmptyProductNameException;
import com.company.models.IndustrialProduct;
import com.company.repositories.IndustrialProductRepository;
import com.company.validators.IndustrialProductValidator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class IndustrialProductService {
    private IndustrialProductRepository productRepository;
    private IndustrialProductValidator productValidator;

    public IndustrialProductService() {
        this.productRepository = new IndustrialProductRepository();
        this.productValidator = new IndustrialProductValidator();
    }

    public ArrayList<String> getManufacturersByProductName(String name) throws EmptyProductNameException {
        try {
            this.productValidator.validateProductName(name);

            return new ArrayList<String>(
                this.productRepository
                .findAll()
                .stream()
                .filter(product -> product.getName().equals(name))
                .map(product -> product.getManufacturer()).collect(Collectors.toList())
            );
        } catch (EmptyProductNameException exception) {
            throw exception;
        }
    }

    public ArrayList<IndustrialProduct> getProductsByManufacturer(String manufacturer) throws EmptyManufacturerException {
        try {
            this.productValidator.validateManufacturer(manufacturer);

            return new ArrayList<IndustrialProduct>(
                this.productRepository
                .findAll()
                .stream()
                .filter(product -> product.getManufacturer().equals(manufacturer))
                .collect(Collectors.toList())
            );
        } catch (EmptyManufacturerException exception) {
            throw exception;
        }
    }
}
