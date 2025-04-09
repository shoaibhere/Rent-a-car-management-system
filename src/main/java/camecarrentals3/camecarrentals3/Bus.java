package camecarrentals3.camecarrentals3;

// Class representing a bus, extending the Vehicle class
public class Bus extends Vehicle {

    // Constructor to initialize bus properties
    public Bus(String companyName, String vehicleName, int modelYear, double dailyRate, int engineSize, String numberPlate) {
        super(companyName, vehicleName, modelYear, dailyRate, engineSize, numberPlate);
    }

    // Override method to calculate tax for a bus
    @Override
    public void calculateTax() {
        setTax(0.0125 * getDailyRate());
    }
}
