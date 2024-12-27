
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automoto.model;

/**
 *
 * @author aashutoshdhakal
 */
public class BikeModel {
    private String bikeNumber;
    private String model;
    private String condition;
    private double price;

    // Constructor
    public BikeModel(String bikeNumber, String model, String condition, double price) {
        this.bikeNumber = bikeNumber;
        this.model = model;
        this.condition = condition;
        this.price = price;
    }

    // Getters and Setters
    public String getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
