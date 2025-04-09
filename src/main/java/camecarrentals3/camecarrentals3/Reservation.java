package camecarrentals3.camecarrentals3;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

// Class representing a reservation made by a customer for a vehicle
public class Reservation implements Serializable {

    // Instance variables
    private final Customer customer;   // Customer making the reservation
    private final Vehicle vehicle;     // Vehicle being reserved
    private final LocalDate date;      // Date when the reservation is made
    private double totalCost;    // Total cost of the reservation
    private double advancePayment;  // Advance payment made for the reservation
    private final int reservationId;   // Unique reservation identifier
    private int days;                   // Number of days for the reservation
    private boolean returned = false;   // Flag indicating if the vehicle has been returned
    private LocalDate returnDate;       // Date when the vehicle is returned
    transient Random random = new Random();       // Random generator for reservationId
    private Employee employee;

    // Constructor to initialize reservation details
    public Reservation(Customer customer, Vehicle vehicle, double totalCost,Employee employee) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.date = LocalDate.now();
        this.totalCost = totalCost;
        this.employee = employee;
        this.reservationId = random.nextInt(111, 999);  // Generate a random reservationId
    }

    // Getter methods for reservation details
    public int getReservationId() {
        return reservationId;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
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

    // Getter method for the return date
    public LocalDate getReturnDate() {
        return returnDate;
    }

    // Setter method for the return date
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Employee getEmployee() {
        return employee;
    }

}
