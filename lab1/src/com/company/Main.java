package com.company;

import com.company.controllers.IndustrialProductController;
import com.company.enums.ControllerName;
import com.company.exceptions.EmptyManufacturerException;
import com.company.exceptions.EmptyProductNameException;
import com.company.exceptions.SystemException;
import com.company.models.IndustrialProduct;
import com.company.views.View;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    private static IndustrialProductController productController = new IndustrialProductController();
    private static View view = new View();
    public static void main(String[] args) {
        for (ControllerName controllerName : ControllerName.values()) {
            callController(controllerName);
        }
    }

    private static void callController(ControllerName controllerName) {
        while(true) {
            try {
                if(controllerName == ControllerName.getManufacturersByProductName)
                    productController.getManufacturersByProductName();
                else if(controllerName == ControllerName.getProductsByManufacturer)
                    productController.getProductsByManufacturer();

                break;
            } catch (SystemException exception) {
                view.outputString(exception.getMessage());
                continue;
            } catch (Exception exception) {
                view.errorNotification();
                view.outputString(exception.getMessage());
                break;
            }
        }
    }
}
