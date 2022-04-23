package com.company.services;

import com.company.models.IndustrialProduct;
import com.company.repositories.IndustrialProductRepository;

public class IndustrialProductService {
    private IndustrialProductRepository productRepository;
    public IndustrialProductService() {
        this.productRepository = new IndustrialProductRepository();
    }

    public String[] getManufacturersByProductName(String name) {
        String[] manufactures = new String[] {};
        IndustrialProduct[] products = this.productRepository.findAll();
        for(IndustrialProduct product: products) {
            if(product.getName() == name) {
                manufactures = push(product.getManufacturer(), manufactures);
            }
        }
        return manufactures;
    }

    public IndustrialProduct[] getProductsByManufacturer(String manufacturer) {
        IndustrialProduct[] filteredProducts = new IndustrialProduct[] {};
        IndustrialProduct[] products = this.productRepository.findAll();

        for(IndustrialProduct product: products) {
            if(product.getManufacturer() == manufacturer) {
                filteredProducts = push(product, filteredProducts);
            }
        }
        return filteredProducts;
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
