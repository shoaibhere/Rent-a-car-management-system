import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        double vehiclePrice;

        //Adding sample data in the inventory

        InventoryManager.vehiclesList.add(new LuxuryCar("Audi","Etron GT",2022,15000,2000,"LEC965"));
        InventoryManager.vehiclesList.add(new EconomicalCar("Honda","Civic",2019,8000,1800,"LEC101"));
        InventoryManager.vehiclesList.add(new LuxuryCar("Rolls Royce","Phantom",2010,50000,2500,"LAC895"));
        InventoryManager.vehiclesList.add(new Bus("Mazda","Bus",2022,10000,3000,"IAU891"));
        InventoryManager.vehiclesList.add(new EconomicalCar("Suzuki","Alto",2020,4000,660,"ABC789"));

        InventoryManager.customersList.add(new Customer("Muhammad Shoaib Akhter", "3240338854759", 170383, 18,"03346880464"));
        InventoryManager.customersList.add(new Customer("Muhammad Ali Leghari", "3240115379428", 185978, 18,"03345278912"));
        InventoryManager.customersList.add(new Customer("Mian Danial Wajid", "4251063489572", 657952, 18,"03412357928"));
        InventoryManager.customersList.add(new Customer("Muhammad Abdullah", "34562774456928", 625981, 18,"03344125678"));
        InventoryManager.customersList.add(new Customer("Huzaifa Zafar", "3250448896579", 798952, 18,"03145279534"));

        // Set the initial account balance
        Account.setAccountBalance(70000000);

        System.out.println("\n------WELCOME TO RENT A CAR MANAGEMENT SYSTEM------\n");

        while (true) {
            // Display the main menu
            System.out.println("\n------MAIN MENU------\n");
            System.out.println("1. Inventory Management Menu");
            System.out.println("2. Reservation Menu");
            System.out.println("3. View Data Menu");
            System.out.println("4. Search Menu");
            System.out.println("5. Account Menu");
            System.out.println("6. Generate Invoice");
            System.out.println("7. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                // Inventory Management Menu
                while (true) {
                    System.out.println("\n------INVENTORY MANAGEMENT MENU------\n");
                    System.out.println("1. Purchase Vehicle");
                    System.out.println("2. Sell Vehicle");
                    System.out.println("3. Add Customer");
                    System.out.println("4. Remove Customer");
                    System.out.println("5. Back To Main Menu");
                    System.out.print("Enter Your Choice: ");
                    int choice1 = input.nextInt();
                    if (choice1 == 1) {
                        // Purchase Vehicle
                        System.out.println("\n------BUY VEHICLE------\n");
                        System.out.print("Enter the Price of the Vehicle: ");
                        vehiclePrice = input.nextDouble();
                        InventoryManager.purchaseVehicle(vehiclePrice);
                    } else if (choice1 == 2) {
                        // Sell Vehicle
                        System.out.println("\n------SELL VEHICLE------\n");
                        System.out.print("Enter the Number Plate of the Vehicle: ");
                        String numberPlate = inputString.nextLine();
                        System.out.print("Enter the Price of the Vehicle: ");
                        vehiclePrice = input.nextDouble();
                        InventoryManager.sellVehicle(numberPlate, vehiclePrice);
                    } else if (choice1 == 3) {
                        // Add Customer
                        System.out.println("\n------ADD CUSTOMER------\n");
                        InventoryManager.addCustomer();
                    } else if (choice1 == 4) {
                        // Remove Customer
                        System.out.println("\n------REMOVE CUSTOMER------\n");
                        System.out.print("Enter Customer CNIC: ");
                        String cnic = inputString.nextLine();
                        InventoryManager.removeCustomer(cnic);
                    } else if (choice1 == 5) {
                        // Back to Main Menu
                        break;
                    } else {
                        System.out.println("INVALID INPUT!!!");
                    }
                }
            } else if (choice == 2) {
                // Reservation Menu
                while (true) {
                    System.out.println("\n------RESERVATION MENU------\n");
                    System.out.println("1. Rent Vehicle");
                    System.out.println("2. Return Vehicle");
                    System.out.println("3. Back To Main Menu");
                    System.out.print("Enter Your Choice: ");
                    int choice1 = input.nextInt();
                    if (choice1 == 1) {
                        // Rent Vehicle
                        System.out.println("\n------RENT VEHICLE------\n");
                        System.out.print("Enter Customer CNIC: ");
                        String cnic = inputString.nextLine();
                        System.out.print("Enter the Number Plate of the Vehicle: ");
                        String numberPlate = inputString.nextLine();
                        System.out.print("Enter The Number of Days: ");
                        int days = input.nextInt();
                        RentalManager.rentCar(GetData.findVehicle(numberPlate), GetData.findCustomer(cnic), days);
                    } else if (choice1 == 2) {
                        // Return Vehicle
                        System.out.println("\n------RETURN VEHICLE------\n");
                        System.out.print("Enter The Reservation Id: ");
                        int reservationId = input.nextInt();
                        RentalManager.returnCar(GetData.findReservation(reservationId));
                    } else if (choice1 == 3) {
                        // Back to Main Menu
                        break;
                    }
                }
            } else if (choice == 3) {
                // View Data Menu
                while (true) {
                    System.out.println("\n------PRINT DATA MENU------\n");
                    System.out.println("1. Print All Vehicles");
                    System.out.println("2. Print All Luxury Cars");
                    System.out.println("3. Print All Economical Cars");
                    System.out.println("4. Print All Buses");
                    System.out.println("5. Print All Customers");
                    System.out.println("6. Back To Main Menu");
                    System.out.print("Enter Your Choice: ");
                    int choice1 = input.nextInt();
                    if (choice1 == 1) {
                        // Print All Vehicles
                        System.out.println("\n------PRINTING ALL VEHICLES------\n");
                        GetData.printAllVehicles();
                    } else if (choice1 == 2) {
                        // Print All Luxury Cars
                        System.out.println("\n------PRINTING ALL LUXURY CARS------\n");
                        GetData.printAllLuxuryCars();
                    } else if (choice1 == 3) {
                        // Print All Economical Cars
                        System.out.println("\n------PRINTING ALL ECONOMICAL CARS------\n");
                        GetData.printAllEconomicalCars();
                    } else if (choice1 == 4) {
                        // Print All Buses
                        System.out.println("\n------PRINTING ALL BUSES------\n");
                        GetData.printAllBuses();
                    } else if (choice1 == 5) {
                        // Print All Customers
                        System.out.println("\n------PRINTING ALL CUSTOMERS------\n");
                        GetData.printAllCustomers();
                    } else if (choice1 == 6) {
                        // Back to Main Menu
                        break;
                    } else {
                        System.out.println("INVALID INPUT!!!");
                    }
                }
            } else if (choice == 4) {
                // Search Menu
                while (true) {
                    System.out.println("\n------SEARCH MENU------\n");
                    System.out.println("1. Search by Vehicle Name");
                    System.out.println("2. Search by Company Name");
                    System.out.println("3. Back To Main Menu");
                    System.out.print("Enter Your Choice: ");
                    int choice1 = input.nextInt();
                    if (choice1 == 1) {
                        // Search by Vehicle Name
                        System.out.println("\n------SEARCH BY VEHICLE NAME------\n");
                        System.out.print("Enter the Vehicle Name: ");
                        String vehicleName = inputString.nextLine();
                        Search.searchByVehicleName(vehicleName);
                    } else if (choice1 == 2) {
                        // Search by Company Name
                        System.out.println("\n------SEARCH BY VEHICLE COMPANY NAME------\n");
                        System.out.print("Enter the Vehicle Company Name: ");
                        String companyName = inputString.nextLine();
                        Search.searchByCompanyName(companyName);
                    } else if (choice1 == 3) {
                        // Back to Main Menu
                        break;
                    }
                }
            } else if (choice == 5) {
                while (true) {
                    // Account Menu
                    double amount;
                    System.out.println("\n------ACCOUNT MENU------\n");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Update Balance");
                    System.out.println("3. Withdraw Amount");
                    System.out.println("4. Deposit Amount");
                    System.out.println("5. Back To Main Menu");
                    System.out.print("Enter Your Choice: ");
                    int choice1 = input.nextInt();
                    if (choice1 == 1) {
                        // Check Balance
                        System.out.println("Account Balance = Rs. " + Account.getAccountBalance());
                    } else if (choice1 == 2) {
                        // Update Balance
                        System.out.println("\n------UPDATE BALANCE------\n");
                        System.out.print("Enter New Balance: ");
                        long balance = input.nextLong();
                        Account.setAccountBalance(balance);
                    } else if (choice1 == 3) {
                        // Withdraw Amount
                        System.out.println("\n------WITHDRAW AMOUNT------\n");
                        System.out.print("Enter Amount: ");
                        amount = input.nextDouble();
                        Account.withdrawAmount(amount);
                    } else if (choice1 == 4) {
                        // Deposit Amount
                        System.out.println("\n------DEPOSIT AMOUNT------\n");
                        System.out.print("Enter Amount: ");
                        amount = input.nextDouble();
                        Account.depositAmount(amount);
                    } else if (choice1 == 5) {
                        // Back to Main Menu
                        break;
                    } else {
                        System.out.println("INVALID INPUT!!!");
                    }
                }

            } else if (choice == 6) {
                // Generate Invoice
                System.out.println("\n------GENERATE INVOICE------\n");
                System.out.print("Enter The Reservation Id: ");
                int reservationId = input.nextInt();
                Invoice.generateInvoice(GetData.findReservation(reservationId));
            } else if (choice == 7) {
                // Exit
                System.out.println("\n------GOOD BYE!!!------\n");
                break;
            } else {
                System.out.println("INVALID INPUT!!!");
            }
        }
    }
}