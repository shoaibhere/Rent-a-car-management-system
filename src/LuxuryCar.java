// Class representing a luxury car, extending the Vehicle class
public class LuxuryCar extends Vehicle {

    // Constructor to initialize luxury car properties
    public LuxuryCar(String companyName, String vehicleName, int modelYear, double dailyRate, int engineSize, String numberPlate) {
        super(companyName, vehicleName, modelYear, dailyRate, engineSize, numberPlate);
    }

    // Override method to calculate tax based on the engine size
    @Override
    public void calculateTax() {
        if (engineSize > 2500) {
            setTax(0.1 * getDailyRate());
        } else if (engineSize > 1300) {
            setTax(0.05 * getDailyRate());
        } else if (engineSize > 1000) {
            setTax(0.0225 * getDailyRate());
        } else {
            setTax(0.0125 * getDailyRate());
        }
    }
}
