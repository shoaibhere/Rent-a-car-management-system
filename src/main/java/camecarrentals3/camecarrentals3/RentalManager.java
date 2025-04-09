package camecarrentals3.camecarrentals3;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;

// Abstract class managing vehicle rentals and returns
public abstract class RentalManager implements Serializable {

    // List to store reservations
    public static ArrayList<Reservation> reservationsList = new ArrayList<>();

    // Method to rent a vehicle
    public static void rentCar(Vehicle vehicle, Customer customer, int days,Employee employee) {
        // Calculate total cost and advance payment
        double totalCost = days * vehicle.getDailyTotal();
        double advancePayment = 0.7 * totalCost;

        // Create a new reservation and add it to the list
        Reservation reservation = new Reservation(customer, vehicle, totalCost,employee);
        // Deposit the advance payment to the account
        Finance.depositAmount(advancePayment,"Advance Payment For "+vehicle.getCompanyName()+" "+vehicle.getVehicleName()+" Reservation# "+reservation.getReservationId());
        reservation.setAdvancePayment(advancePayment);
        reservation.setDays(days);
        //Adding to ArrayList and file
        InventoryManager.addReservation(reservation);
        // Mark the vehicle as unavailable
        vehicle.setAvailable(false);
        InventoryManager.updateVehicleInformation();
    }

    // Method to return a vehicle
    public static void returnCar(Reservation reservation) {
        if (reservation.getDate().plusDays(reservation.getDays()).isEqual(LocalDate.now())) {
            // If returned on time, calculate and deposit the refundable amount
            double remainingPayment = reservation.getTotalCost() - reservation.getAdvancePayment();
            Finance.depositAmount(remainingPayment,"Remaining Payment For "+reservation.getVehicle().getCompanyName()+" "+reservation.getVehicle().getVehicleName()+" Reservation# "+reservation.getReservationId());
        } else if (reservation.getDate().plusDays(reservation.getDays()).isAfter(LocalDate.now())) {
            // If returned before the deadline, throw an exception
            throw new ReturnedBeforeDeadlineException();
        } else {
            // If returned late, throw an exception
            throw new LateReturnException();
        }
    }
}
