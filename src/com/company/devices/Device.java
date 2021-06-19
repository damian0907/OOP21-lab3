package com.company.devices;

import com.company.animals.Human;


public abstract class Device implements Sellable {
    String producer;
    String model;
    Integer yearOfProduction;
    Double value;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public final void Sell(Human seller, Human buyer, Double price) throws Exception {
        throw new Exception();

    }

    public abstract void turnOn();


}
