package com.company;

import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        IndustrialProduct[] products = new IndustrialProduct[] {
                new IndustrialProduct(651, "Meat", "Chicken stake", 350,"Megamarket Inc.", new Date()),
                new IndustrialProduct(2765, "Car", "Model S", 25,"Tesla", new Date()),
                new IndustrialProduct(365, "TV", "TV Model", 150,"Samsung", new Date()),
                new IndustrialProduct(344, "Car", "Model X", 50,"Tesla", new Date()),
                new IndustrialProduct(231, "Car", "Land Cruiser", 40,"Toyota", new Date()),
                new IndustrialProduct(1778, "Table", "wooden", 10,"Furniture Inc.", new Date()),
                new IndustrialProduct(6651, "Meat", "stake", 10090,"Megamarket Inc.", new Date()),
                new IndustrialProduct(89061, "Table", "desc5436", 50,"Megamarket Inc.", new Date()),
                new IndustrialProduct(5671, "Meat", "beef", 5000,"Beef Inc.", new Date()),
                new IndustrialProduct(41, "TV", "LG5345345", 1000,"LG", new Date())
        };
        output(products);

        String[] manufactures = getManufacturersByProductName("Meat", products);
        IndustrialProduct[] filteredProducts = getProductsByManufacturer("Megamarket Inc.", products);

        output(manufactures);
        output(filteredProducts);
    }

    public static String[] getManufacturersByProductName(String name, IndustrialProduct[] products) {
        String[] manufactures = new String[] {};
        for(IndustrialProduct product: products) {
            if(product.getName() == name) {
                manufactures = push(product.getManufacturer(), manufactures);
            }
        }
        return manufactures;
    }

    public static IndustrialProduct[] getProductsByManufacturer(String manufacturer, IndustrialProduct[] products) {
        IndustrialProduct[] filteredProducts = new IndustrialProduct[] {};
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

    public static void output(IndustrialProduct[] products) {
        for(IndustrialProduct product: products) {
            System.out.println(product.toString());
        }
    }

    public static void output(String[] arr) {
        for(String str: arr) {
            System.out.println(str);
        }
    }
}
