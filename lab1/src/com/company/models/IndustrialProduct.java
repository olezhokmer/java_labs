package com.company.models;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IndustrialProduct {
    private long registrationNumber;
    private String name;
    private String model;
    private long amount;
    private String manufacturer;
    private Date creationDate;

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public long getAmount() {
        return amount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public IndustrialProduct(long registrationNumber, String name, String model, long amount, String manufacturer, Date creationDate) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.model = model;
        this.amount = amount;
        this.manufacturer = manufacturer;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return
        "RegNumber: " + String.valueOf(this.registrationNumber) +
        ", Name: " + this.name +
        ", Model: " + this.model +
        ", Amount: " + String.valueOf(this.amount) +
        ", Manufacturer: " + this.manufacturer +
        ", Creation date: " + this.creationDate.toString();
    }
}
