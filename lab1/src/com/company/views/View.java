package com.company.views;

import com.company.models.IndustrialProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    Scanner scanner;
    public View() {
        this.scanner = new Scanner(System.in);
    }

    public String readString() {
        String value = this.scanner.nextLine();

        return value;
    }

    public void outputProducts(IndustrialProduct[] products) {
        for(IndustrialProduct product: products) {
            this.outputString(product.toString());
        }
    }

    public void outputProducts(ArrayList<IndustrialProduct> products) {
        for(IndustrialProduct product: products) {
            this.outputString(product.toString());
        }
    }

    public void outputString(String value) {
        System.out.println(value);
    }

    public void outputStringArray(String[] arr) {
        for(String str: arr) {
            this.outputString(str);
        }
    }

    public void outputStringArray(ArrayList<String> list) {
        for(String str: list) {
            this.outputString(str);
        }
    }

    public void enterProductNameMessage() {
        this.outputString("Enter a product name below.");
    }

    public void enterManufacturerNameMessage() {
        this.outputString("Enter a manufacturer name below");
    }

    public void errorNotification() {
        this.outputString("Error occurred");
    }
}
