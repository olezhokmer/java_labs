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

    public Integer readInteger() {
        Integer value = this.scanner.nextInt();

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

    public void outputCollection(ArrayList<Integer> list) {
        for(Integer number: list) {
            System.out.print(number.toString() + "; ");
        }
        System.out.println("");
    }

    public void enterProductNameMessage() {
        this.outputString("Enter a product name below.");
    }

    public void enterDividerNumber() {
        this.outputString("Enter divider value.");
    }

    public void enterCollectionLength() {
        this.outputString("Enter collection length.");
    }

    public void enterBoundValue() {
        this.outputString("Enter bound value.");
    }
    public void enterManufacturerNameMessage() {
        this.outputString("Enter a manufacturer name below");
    }

    public void errorNotification() {
        this.outputString("Error occurred");
    }
}
