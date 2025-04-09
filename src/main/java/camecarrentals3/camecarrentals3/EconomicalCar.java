package camecarrentals3.camecarrentals3;

// Class representing an economical car, extending the Vehicle class
public class EconomicalCar extends Vehicle {

    // Constructor to initialize economical car properties
    public EconomicalCar(String companyName, String vehicleName, int modelYear, double dailyRate, int engineSize, String numberPlate) {
        super(companyName, vehicleName, modelYear, dailyRate, engineSize, numberPlate);
    }

    // Override method to calculate tax based on the engine size
    @Override
    public void calculateTax() {
        if (engineSize > 2500) {
            setTax(0.05 * getDailyRate());
        } else if (engineSize > 1300) {
            setTax(0.0225 * getDailyRate());
        } else if (engineSize > 1000) {
            setTax(0.0125 * getDailyRate());
        } else {
            setTax(0.01 * getDailyRate());
        }
    }
}

