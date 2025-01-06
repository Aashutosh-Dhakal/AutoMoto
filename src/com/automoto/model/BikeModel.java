
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automoto.model;

/**
 * Represents a bike model in the system, storing details such as the bike number,
 * model name, condition, price, type, and availability status.
 * 
 * @author aashutoshdhakal
 */

public class BikeModel {
    
    //Private Fields for BikeModel class
    private String bikeNumber;
    private String model;
    private String condition;
    private double price;
    private String type;
    private String status;

    
    /**
     * Constructor to initialize a BikeModel instance with specified details.
     * By default, the status is set to "Available".
     *
     * @param bikeNumber the unique identifier of the bike
     * @param model the model name of the bike
     * @param condition the condition of the bike
     * @param price the price of the bike
     * @param type the type of the bike
     */
    
    public BikeModel(String bikeNumber, String model, String condition, double price, String type) {
        this.bikeNumber = bikeNumber;
        this.model = model;
        this.condition = condition;
        this.price = price;
        this.type = type;
        this.status = "Available";
    }

    // Getters and Setters
    
    // Gets the bike Number
    public String getBikeNumber() {
        return bikeNumber;
    }

    // Sets the BikeNumber for object of this class
    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    // Gets the bike Model
    public String getModel() {
        return model;
    }

    // Sets the Bike Model for object of this class
    public void setModel(String model) {
        this.model = model;
    }

    // Gets the bike Condition
    public String getCondition() {
        return condition;
    }

    // Sets the Bike Condition for object of this class
    public void setCondition(String condition) {
        this.condition = condition;
    }

    // Gets the bike Price
    public double getPrice() {
        return price;
    }

    // Sets the Bike Price for object of this class
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Gets the bike Type
    public String getType() {
        return type;
    }
    
    // Sets the Bike Type for object of this class
    public void setType(String type) {
        this.type = type;
    }
    
    // Gets the bike Rental Status
    public String getStatus() {
        return status;
    }
    
    // Sets the Bike Status for object of this class
    public void setStatus(String status) {
        this.status = status;
    }

}
