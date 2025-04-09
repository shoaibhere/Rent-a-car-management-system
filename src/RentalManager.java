import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

// Abstract class managing vehicle rentals and returns
public abstract class RentalManager {

    // Scanner for user input
    private static Scanner input = new Scanner(System.in);

    // List to store reservations
    public static ArrayList<Reservation> reservationsList = new ArrayList<>();

    // Method for renting a vehicle
    public static void rentCar(Vehicle vehicle, Customer customer, int days) {
        if((vehicle!=null)&&(customer!=null)) {
            if (vehicle.isAvailable()) {
                double totalCost = days * vehicle.getDailyTotal();
                double advancePayment = 0.7 * totalCost;
                Account.depositAmount(advancePayment);
                Reservation reservation = new Reservation(customer, vehicle, totalCost, advancePayment);
                reservation.setDays(days);
                reservationsList.add(reservation);
                vehicle.setAvailable(false);

                System.out.println("Reservation Id: " + reservation.getReservationId());
                System.out.println("CAR RENTED SUCCESSFULLY!!!");

                // Prompt user to print the invoice
                System.out.print("DO YOU WANT TO PRINT THE INVOICE? (Y/N): ");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")) {
                    Invoice.generateInvoice(reservation);
                }
            } else {
                System.out.println("The Requested Vehicle is Not Available");
            }
        }
        else if(customer==null)
        {
            System.out.println("The Requested Customer does not exist in our Record");
        }
        else
        {
            System.out.println("The Requested Vehicle does not exist in our Inventory");
        }
    }

    // Method for returning a rented vehicle
    public static void returnCar(Reservation reservation) {
        if (reservation != null) {
            if (reservation.getDate().plusDays(reservation.getDays()).isEqual(LocalDate.now())) {
                // Calculate and deposit the refundable amount
                Account.depositAmount(reservation.getTotalCost() - reservation.getAdvancePayment());
            }
            else if (reservation.getDate().plusDays(reservation.getDays()).isAfter(LocalDate.now())) {
                // Calculate remaining days and refund the remaining balance to the customer
                long remainingDays = ChronoUnit.DAYS.between(LocalDate.now(), reservation.getDate().plusDays(reservation.getDays()));
                double remainingRefund = remainingDays * reservation.getVehicle().getDailyTotal();

                System.out.println("CAR RETURNED BEFORE DEADLINE SUCCESSFULLY!!!");

                // Print the refund details
                System.out.println("Remaining Days: " + remainingDays);
                System.out.println("Remaining Refund Amount: " + remainingRefund);
                Account.depositAmount(reservation.getTotalCost() - reservation.getAdvancePayment());
                Account.withdrawAmount(remainingRefund);
            } else {
                // Calculate extra days, extra amount, and new total cost for late returns
                long extraDays = ChronoUnit.DAYS.between(reservation.getDate().plusDays(reservation.getDays()), LocalDate.now());
                System.out.println("Extra Days: " + extraDays);
                System.out.println("Extra Amount to be Paid: " + extraDays * reservation.getVehicle().getDailyTotal());
                System.out.println("New Total Cost: " + (reservation.getTotalCost() + extraDays * reservation.getVehicle().getDailyTotal()));

                // Deposit the total amount including extra days
                Account.depositAmount((reservation.getTotalCost() + extraDays * reservation.getVehicle().getDailyTotal()) - reservation.getAdvancePayment());

                // Mark the vehicle as available
                reservation.getVehicle().setAvailable(true);
                System.out.println("CAR RETURNED SUCCESSFULLY!!!");
            }
            // Mark the vehicle as available
            reservation.getVehicle().setAvailable(true);
            // Prompt user to print the invoice
            System.out.print("DO YOU WANT TO PRINT THE INVOICE? (Y/N): ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")) {
                Invoice.generateInvoice(reservation);
            }
        } else {
            System.out.println("We Could not find the requested Reservation");
        }
    }

}
