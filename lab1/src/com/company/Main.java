package com.company;

import com.company.controllers.IndustrialProductController;
import com.company.models.IndustrialProduct;
import com.company.views.View;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        IndustrialProductController productController = new IndustrialProductController();
        View view = new View();

        String[] manufacturers = productController.getManufacturersByProductName("Meat");
        IndustrialProduct[] products = productController.getProductsByManufacturer("Megamarket Inc.");

        view.outputProducts(products);
        view.outputStringArray(manufacturers);
    }
}
