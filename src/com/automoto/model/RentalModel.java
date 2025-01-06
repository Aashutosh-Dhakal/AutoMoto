/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automoto.model;

/**
 * Represents the rental details for a bike, storing customer and rental-related information.
 * 
 * @author aashutoshdhakal
 */

public class RentalModel {
    
    //Private Fields for RentalModel class
    private String firstName;
    private String lastName;
    private String dOB;
    private String gender;
    private String bikeModel;
    private long licenceNumber;
    private String documentType;
    private long documentNumber;
    private int durationOfRent;
    private long mobileNumber;
    
    
     /**
     * Constructor to initialize the RentalModel with all relevant rental and customer details.
     * 
     * @param firstName Customer's first name
     * @param lastName Customer's last name
     * @param dob Date of birth of the customer
     * @param gender Gender of the customer (e.g., 0 for Male, 1 for Female)
     * @param bikeModel Model of the rented bike
     * @param licenceNo Customer's driving license number
     * @param documentType Type of identification document
     * @param documentNumber Identification document number
     * @param durationOfRent Duration of the rental
     * @param mobileNumber Customer's mobile number
     */
    public RentalModel (String firstName, String lastName, String dob, String gender, String bikeModel, long licenceNo, 
            String documentType, long documentNumber, int durationOfRent, long mobileNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dOB = dob;
        this.gender = gender;
        this.bikeModel = bikeModel;
        this.licenceNumber = licenceNo;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.durationOfRent = durationOfRent;
        this.mobileNumber = mobileNumber;
    }

    // Gets First Name of the object of the class
    public String getFirstName() {
        return firstName;
    }

    // Sets First Name of the object of the class
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Gets Last Name of the object of the class
    public String getLastName() {
        return lastName;
    }

    // Sets Last Name of the object of the class
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Gets Date of birth of the object of the class
    public String getDob() {
        return dOB;
    }

    // Sets Date of Birth of the object of the class
    public void setDob(String dob) {
        this.dOB = dob;
    }

    // Gets Gender of the object of the class
    public String getGender() {
        return gender;
    }

    // Sets Gender of the object of the class
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Gets Bike Model of the object of the class
    public String getBikeModel() {
        return bikeModel;
    }

    // Sets Bike Model of the object of the class
    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    // Gets Licence Number of the object of the class
    public long getLicenceNumber() {
        return licenceNumber;
    }

    // Sets Licence Number of the object of the class
    public void setLicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    // Gets Document Type of the object of the class
    public String getDocumentType() {
        return documentType;
    }

    // Sets Document Type of the object of the class
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    // Gets Document Number of the object of the class
    public long getDocumentNumber() {
        return documentNumber;
    }

    // Sets Document Number of the object of the class
    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    // Gets Duration of Rent of the object of the class
    public int getDurationOfRent() {
        return durationOfRent;
    }

    // Sets Duration of Rent of the object of the class
    public void setDurationOfRent(int durationOfRent) {
        this.durationOfRent = durationOfRent;
    }

    // Gets Mobile Number of the object of the class
    public long getMobileNumber() {
        return mobileNumber;
    }

    // Sets Mobile Number of the object of the class
    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
}
