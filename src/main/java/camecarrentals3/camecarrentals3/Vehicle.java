package camecarrentals3.camecarrentals3;

import java.io.Serializable;

// Abstract class representing a generic Vehicle, implementing the Taxable interface
public abstract class Vehicle implements Taxable, Serializable {
    protected String companyName;    // Company name of the vehicle
    protected String vehicleName;    // Name of the vehicle
    protected String numberPlate;    // Vehicle's number plate
    protected int modelYear;         // Model year of the vehicle
    protected boolean available = true;  // Availability status
    protected double dailyRate;      // Daily rental rate
    protected double tax;            // Tax amount
    protected final double dailyTotal; // Total daily cost including tax
    protected int engineSize;         // Engine size of the vehicle

    // Constructor to initialize vehicle properties
    public Vehicle(String companyName, String vehicleName, int modelYear, double dailyRate, int engineSize, String numberPlate) {
        this.companyName = companyName;
        this.vehicleName = vehicleName;
        this.modelYear = modelYear;
        this.dailyRate = dailyRate;
        this.engineSize = engineSize;
        this.numberPlate = numberPlate;

        calculateTax();  // Calculate tax based on the vehicle's characteristics
        dailyTotal = tax + dailyRate;  // Calculate total daily cost
    }

    // Getter methods for various vehicle properties
    public double getDailyTotal() {
        return dailyTotal;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public double getTax() {
        return tax;
    }

    // Setter method for tax amount
    public void setTax(double tax) {
        this.tax = tax;
    }

    // Getter and setter methods for availability status
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Getter method for daily rental rate
    public double getDailyRate() {
        return dailyRate;
    }

    public String getAvailability()
    {
        if(available)
        {return "Available";}
        else
        {return "Unavailable";}
    }
}

