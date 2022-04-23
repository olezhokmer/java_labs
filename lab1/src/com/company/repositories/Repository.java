package com.company.repositories;

public class Repository<Type> {
    private Type[] data;

    public Repository(Type[] data) {
        this.data = data;
    }

    public Type[] findAll() {
        return data;
    }
}
