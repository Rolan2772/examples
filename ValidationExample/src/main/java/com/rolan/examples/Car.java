package com.rolan.examples;

import javax.validation.constraints.NotNull;

public class Car {

    @NotNull(message = "{com.rolan.examples.NullCarName}")
    String name;

    @FerrariManufacturer
    String manufacturer;

    public Car(String name, String manufacterer) {
        this.name = name;
        this.manufacturer = manufacterer;
    }

    public Car() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
