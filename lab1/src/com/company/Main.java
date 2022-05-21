package com.company;

import com.company.controllers.CollectionsController;
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
    private static CollectionsController collectionController = new CollectionsController();
    private static View view = new View();
    private static ErrorHandler errorHandler = new ErrorHandler();
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
                else if(controllerName == ControllerName.sortCollection)
                    collectionController.sortCollection();

                break;
            } catch (SystemException exception) {
                errorHandler.handleError(exception);
                continue;
            } catch (Exception exception) {
                view.errorNotification();
                errorHandler.handleError(exception);
                break;
            }
        }
    }
}
