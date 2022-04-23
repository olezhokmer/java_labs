package com.company.views;

import com.company.models.IndustrialProduct;

public class View {
    public View() {

    }

    public void outputProducts(IndustrialProduct[] products) {
        for(IndustrialProduct product: products) {
            System.out.println(product.toString());
        }
    }

    public void outputStringArray(String[] arr) {
        for(String str: arr) {
            System.out.println(str);
        }
    }
}
