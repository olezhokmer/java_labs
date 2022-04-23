package com.company.controllers;

import com.company.exceptions.EmptyManufacturerException;
import com.company.exceptions.EmptyProductNameException;
import com.company.models.IndustrialProduct;
import com.company.repositories.IndustrialProductRepository;
import com.company.services.IndustrialProductService;
import com.company.views.View;

public class IndustrialProductController {
    IndustrialProductService productService;
    public IndustrialProductController() {
        this.productService = new IndustrialProductService();
    }

    public String[] getManufacturersByProductName(String productName) throws EmptyProductNameException {
        try {
            return this.productService.getManufacturersByProductName(productName);
        } catch (Exception exception) {
            throw exception;
        }
    }

    public IndustrialProduct[] getProductsByManufacturer(String manufacturer) throws EmptyManufacturerException {
        try {
            return this.productService.getProductsByManufacturer(manufacturer);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
