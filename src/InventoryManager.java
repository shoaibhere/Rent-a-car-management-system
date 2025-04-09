import java.util.ArrayList;
import java.util.Scanner;

// Abstract class managing the inventory of vehicles and customers
public abstract class InventoryManager {

    // Scanner for user input
    static Scanner input = new Scanner(System.in);
    static Scanner inputString = new Scanner(System.in);

    // Lists to store vehicles and customers
    public static ArrayList<Vehicle> vehiclesList = new ArrayList<>();
    public static ArrayList<Customer> customersList = new ArrayList<>();

    // Method for purchasing a vehicle
    public static void purchaseVehicle(double vehiclePrice) {
        if (vehiclePrice <= Account.getAccountBalance()) {
            while (true) {
                System.out.println("What is the type of Vehicle?");
                System.out.println("1: Luxury Car");
                System.out.println("2: Economical Car");
                System.out.println("3: Bus");
                System.out.print("Enter your Choice: ");
                int choice = input.nextInt();
                System.out.print("Enter the Vehicle Company Name: ");
                String companyName = inputString.nextLine();
                System.out.print("Enter the Vehicle Name: ");
                String vehicleName = inputString.nextLine();
                System.out.print("Enter the Vehicle Number Plate: ");
                String numberPlate = inputString.nextLine();
                System.out.print("Enter the Vehicle Model Year: ");
                int year = input.nextInt();
                System.out.print("Enter Car Daily Rental Rate: ");
                double dailyRate = input.nextDouble();
                System.out.print("Enter the Vehicle Engine Size: ");
                int engineNumber = input.nextInt();

                if (choice == 1) {
                    vehiclesList.add(new LuxuryCar(companyName, vehicleName, year, dailyRate, engineNumber, numberPlate));
                    Account.withdrawAmount(vehiclePrice);
                    System.out.println("VEHICLE PURCHASED SUCCESSFULLY!!!");
                    break;
                } else if (choice == 2) {
                    vehiclesList.add(new EconomicalCar(companyName, vehicleName, year, dailyRate, engineNumber, numberPlate));
                    Account.withdrawAmount(vehiclePrice);
                    System.out.println("VEHICLE PURCHASED SUCCESSFULLY!!!");
                    break;
                } else if (choice == 3) {
                    vehiclesList.add(new Bus(companyName, vehicleName, year, dailyRate, engineNumber, numberPlate));
                    Account.withdrawAmount(vehiclePrice);
                    System.out.println("VEHICLE PURCHASED SUCCESSFULLY!!!");
                    break;
                } else {
                    System.out.println("Invalid Input!!!");
                }
            }
        } else {
            System.out.println("Not Enough Balance in the Account to make this purchase");
        }
    }

    // Method for selling a vehicle
    public static void sellVehicle(String numberPlate, double vehiclePrice) {
        boolean isAvailable = false;
        for (int i = 0; i < vehiclesList.size(); i++) {
            if (vehiclesList.get(i).getNumberPlate().equals(numberPlate)) {
                vehiclesList.remove(vehiclesList.get(i));
                Account.depositAmount(vehiclePrice);
                System.out.println("VEHICLE SOLD SUCCESSFULLY!!!");
                isAvailable = true;
                break;
            }
        }
        if (!isAvailable)
        {
            System.out.println("The Vehicle does not exist in the Inventory");
        }
    }

    // Method for adding a new customer
    public static void addCustomer() {
        System.out.print("Enter Customer Name: ");
        String customerName = inputString.nextLine();
        System.out.print("Enter Customer CNIC: ");
        String cnic = inputString.nextLine();
        System.out.print("Enter Customer's Licence Number: ");
        int licenceNumber = input.nextInt();
        System.out.print("Enter Customer's Age: ");
        int age = input.nextInt();
        System.out.print("Enter Customer Phone Number: ");
        String phoneNumber = inputString.nextLine();
        customersList.add(new Customer(customerName, cnic, licenceNumber, age, phoneNumber));
        System.out.print("CUSTOMER ADDED TO THE DATABASE SUCCESSFULLY!!!");
    }

    // Method for removing a customer
    public static void removeCustomer(String cnic) {
        boolean isAvailable = false;
        for (int i = 0; i < customersList.size(); i++) {
            if (InventoryManager.customersList.get(i).getCnic().equals(cnic)) {
                customersList.remove(customersList.get(i));
                System.out.println("CUSTOMER REMOVED FROM DATABASE SUCCESSFULLY!!!");
                isAvailable = true;
                break;
            }
        }
        if (!isAvailable)
        {
            System.out.println("This Customer does not exist in the Record");
        }
    }
}
