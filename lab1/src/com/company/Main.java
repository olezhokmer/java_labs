package com.company;

import com.company.controllers.IndustrialProductController;
import com.company.enums.ControllerName;
import com.company.exceptions.EmptyManufacturerException;
import com.company.exceptions.EmptyProductNameException;
import com.company.models.IndustrialProduct;
import com.company.views.View;

import java.util.Date;

public class Main {
    private static IndustrialProductController productController = new IndustrialProductController();
    private static View view = new View();
    public static void main(String[] args) {
        try {
            for (ControllerName controllerName : ControllerName.values()) {
                callController(controllerName);
            }
        } catch (Exception exception) {
            view.outputString(exception.getMessage());
        }
    }

    private static void callController(ControllerName controllerName) {
        while(true) {
            try {
                if(controllerName == ControllerName.getManufacturersByProductName) {
                    callGetManufacturersByProductName();
                } else if(controllerName == ControllerName.getProductsByManufacturer) {
                    callGetProductsByManufacturer();
                }

                break;
            } catch (EmptyProductNameException exception) {
                view.outputString(exception.getMessage());
                continue;
            } catch (EmptyManufacturerException exception) {
                view.outputString(exception.getMessage());
                continue;
            } catch (Exception exception) {
                view.errorNotification();
                view.outputString(exception.getMessage());
            }
        }
    }

    private static void callGetProductsByManufacturer() throws EmptyManufacturerException {
        try {
            view.enterManufacturerNameMessage();
            String manufacturer = view.readString();

            IndustrialProduct[] products = productController.getProductsByManufacturer(manufacturer);
            view.outputProducts(products);
        } catch (EmptyManufacturerException exception) {
            throw exception;
        }
    }

    private static void callGetManufacturersByProductName() throws EmptyProductNameException {
        try {
            view.enterProductNameMessage();
            String productName = view.readString();

            String[] manufacturers = productController.getManufacturersByProductName(productName);
            view.outputStringArray(manufacturers);
        } catch (EmptyProductNameException exception) {
            throw exception;
        }
    }
}
