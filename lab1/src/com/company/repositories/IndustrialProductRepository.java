package com.company.repositories;

import com.company.models.IndustrialProduct;

import java.util.Date;

public class IndustrialProductRepository extends Repository<IndustrialProduct> {
    public IndustrialProductRepository() {
        super(new IndustrialProduct[] {
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
        });
    }
}
