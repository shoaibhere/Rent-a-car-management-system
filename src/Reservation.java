import java.time.LocalDate;
import java.util.Random;

// Class representing a reservation made by a customer for a vehicle
public class Reservation {

    // Instance variables
    private final Customer customer;   // Customer making the reservation
    private final Vehicle vehicle;     // Vehicle being reserved
    private final LocalDate date;      // Date when the reservation is made
    private final double totalCost;    // Total cost of the reservation
    private final double advancePayment;  // Advance payment made for the reservation
    private final int reservationId;   // Unique reservation identifier
    private int days;                   // Number of days for the reservation
    Random random = new Random();       // Random generator for reservationId

    // Constructor to initialize reservation details
    public Reservation(Customer customer, Vehicle vehicle, double totalCost, double advancePayment) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.date = LocalDate.now();
        this.totalCost = totalCost;
        this.advancePayment = advancePayment;
        this.reservationId = random.nextInt(111, 999);  // Generate a random reservationId
    }

    // Getter methods for reservation details
    public int getReservationId() {
        return reservationId;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    // Setter method for the number of days for the reservation
    public void setDays(int days) {
        this.days = days;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
