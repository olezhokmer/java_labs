package com.company.controllers;

import com.company.enums.ControllerName;
import com.company.exceptions.EmptyManufacturerException;
import com.company.exceptions.EmptyProductNameException;
import com.company.exceptions.SystemException;
import com.company.models.IndustrialProduct;
import com.company.repositories.IndustrialProductRepository;
import com.company.services.IndustrialProductService;
import com.company.views.View;

import java.util.ArrayList;

public class IndustrialProductController {
    IndustrialProductService productService;
    View view;
    public IndustrialProductController() {
        this.productService = new IndustrialProductService();
        this.view = new View();
    }

    public ArrayList<String> getManufacturersByProductName() throws EmptyProductNameException {
        try {
            view.enterProductNameMessage();
            String productName = view.readString();

            ArrayList<String> manufacturers = this.productService.getManufacturersByProductName(productName);
            view.outputStringArray(manufacturers);

            return manufacturers;
        } catch (EmptyProductNameException exception) {
            throw exception;
        }
    }

    public ArrayList<IndustrialProduct> getProductsByManufacturer() throws EmptyManufacturerException {
        try {
            view.enterManufacturerNameMessage();
            String manufacturer = view.readString();

            ArrayList<IndustrialProduct> products = this.productService.getProductsByManufacturer(manufacturer);
            view.outputProducts(products);

            return products;
        } catch (EmptyManufacturerException exception) {
            throw exception;
        }
    }
}
