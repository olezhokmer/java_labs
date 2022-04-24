package com.company.repositories;

import com.company.models.IndustrialProduct;

import java.util.ArrayList;

public class Repository<Type> {
    private ArrayList<Type> data;

    public Repository(ArrayList<Type> data) {
        this.data = data;
    }

    public ArrayList<Type> findAll() {
        return data;
    }
}
