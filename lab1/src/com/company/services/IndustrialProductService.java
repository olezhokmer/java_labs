package com.company.services;

import com.company.exceptions.EmptyManufacturerException;
import com.company.exceptions.EmptyProductNameException;
import com.company.models.IndustrialProduct;
import com.company.repositories.IndustrialProductRepository;
import com.company.validators.IndustrialProductValidator;
import com.company.views.View;

public class IndustrialProductService {
    private View view;
    private IndustrialProductRepository productRepository;
    private IndustrialProductValidator productValidator;

    public IndustrialProductService() {
        this.productRepository = new IndustrialProductRepository();
        this.productValidator = new IndustrialProductValidator();
        this.view = new View();
    }

    public String[] getManufacturersByProductName(String name) throws EmptyProductNameException {
        try {
            this.productValidator.validateProductName(name);
            String[] manufactures = new String[] {};
            IndustrialProduct[] products = this.productRepository.findAll();
            for(IndustrialProduct product: products) {
                if(product.getName().equals(name)) {
                    manufactures = push(product.getManufacturer(), manufactures);
                }
            }
            return manufactures;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public IndustrialProduct[] getProductsByManufacturer(String manufacturer) throws EmptyManufacturerException {
        try {
            this.productValidator.validateManufacturer(manufacturer);
            IndustrialProduct[] filteredProducts = new IndustrialProduct[] {};
            IndustrialProduct[] products = this.productRepository.findAll();

            for(IndustrialProduct product: products) {
                if(product.getManufacturer().equals(manufacturer)) {
                    filteredProducts = push(product, filteredProducts);
                }
            }
            return filteredProducts;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public static IndustrialProduct[] push(IndustrialProduct product, IndustrialProduct[] products) {
        IndustrialProduct[] newProducts= new IndustrialProduct[products.length + 1];
        int index = 0;
        for (IndustrialProduct arrElement: products) {
            newProducts[index] = arrElement;
            index++;
        }
        newProducts[products.length] = product;
        return newProducts;
    }

    public static String[] push(String element, String[] arr)
    {
        String[] newArr= new String[arr.length + 1];
        int index = 0;
        for (String arrElement: arr) {
            newArr[index] = arrElement;
            index++;
        }
        newArr[arr.length] = element;
        return newArr;
    }
}
