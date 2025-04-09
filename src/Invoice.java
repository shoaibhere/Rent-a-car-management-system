import java.time.LocalDate;
import java.util.Random;

// Abstract class for generating rental invoices
public abstract class Invoice {

    // Random generator for invoice number
    static Random random = new Random();

    // Method to generate a rental invoice
    public static void generateInvoice(Reservation reservation) {
        if (reservation != null) {
            System.out.println("RENTING INVOICE");
            System.out.println("INVOICE NUMBER: " + random.nextInt(1111, 9999));

            System.out.println("\nVEHICLE DATA\n");
            GetData.printVehicleData(reservation.getVehicle());

            System.out.println("\nCUSTOMER DATA\n");
            GetData.printCustomerData(reservation.getCustomer());

            System.out.println("\nRESERVATION DETAILS\n");
            GetData.printReservationData(reservation);
            System.out.println("TODAY'S DATE: " + LocalDate.now());
        }
        else
        {
            System.out.println("We Could not find the requested Reservation");
        }
    }
}
