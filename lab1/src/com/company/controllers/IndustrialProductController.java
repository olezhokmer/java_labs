package com.company.controllers;

import com.company.models.IndustrialProduct;
import com.company.repositories.IndustrialProductRepository;
import com.company.services.IndustrialProductService;

public class IndustrialProductController {
    IndustrialProductService productService;
    public IndustrialProductController() {
        this.productService = new IndustrialProductService();
    }

    public String[] getManufacturersByProductName(String productName) {
        return this.productService.getManufacturersByProductName(productName);
    }

    public IndustrialProduct[] getProductsByManufacturer(String manufacturer) {
        return this.productService.getProductsByManufacturer(manufacturer);
    }
}
