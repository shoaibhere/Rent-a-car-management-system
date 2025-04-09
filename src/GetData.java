// Abstract class for retrieving and printing data related to vehicles, reservations, and customers
public abstract class GetData {

    // Method to get the type of vehicle
    public static String getVehicleType(Vehicle vehicle) {
        if (vehicle instanceof LuxuryCar) {
            return "Luxury Car";
        } else if (vehicle instanceof EconomicalCar) {
            return "Economical Car";
        } else {
            return "Bus";
        }
    }

    // Method to print details of a vehicle
    public static void printVehicleData(Vehicle vehicle) {
        System.out.println("VEHICLE TYPE: " + GetData.getVehicleType(vehicle));
        System.out.println("VEHICLE COMPANY: " + vehicle.getCompanyName());
        System.out.println("VEHICLE NUMBER PLATE: " + vehicle.getNumberPlate());
        System.out.println("VEHICLE NAME: " + vehicle.getVehicleName());
        System.out.println("VEHICLE MODEL YEAR: " + vehicle.getModelYear());
        System.out.println("DAILY RATE: Rs. " + vehicle.getDailyRate());
        System.out.println("DAILY TAX: Rs. " + vehicle.getTax());
        System.out.println("DAILY RATE AFTER TAX: Rs. " + vehicle.getDailyTotal());
        System.out.println("VEHICLE ENGINE SIZE: " + vehicle.getEngineSize() + " CC");
    }

    // Method to print details of a reservation
    public static void printReservationData(Reservation reservation) {
        System.out.println("RESERVATION ID: " + reservation.getReservationId());
        System.out.println("CAR ISSUANCE DATE: " + reservation.getDate());
        System.out.println("NUMBER OF DAYS: " + reservation.getDays());
        System.out.println("TOTAL COST: Rs. " + reservation.getTotalCost());
        System.out.println("ADVANCE PAYMENT: Rs. " + reservation.getAdvancePayment());
    }

    // Method to print details of a customer
    public static void printCustomerData(Customer customer) {
        System.out.println("CUSTOMER NAME: " + customer.getCustomerName());
        System.out.println("CUSTOMER CNIC: " + customer.getCnic());
        System.out.println("CUSTOMER LICENCE NUMBER: " + customer.getLicenceNumber());
        System.out.println("CUSTOMER AGE: " + customer.getAge());
        System.out.println("CUSTOMER PHONE NUMBER: " + customer.getPhoneNumber());
    }

    // Method to print details of all vehicles
    public static void printAllVehicles() {
        for (int i = 0; i < InventoryManager.vehiclesList.size(); i++) {
            printVehicleData(InventoryManager.vehiclesList.get(i));
            System.out.println();
        }
    }

    // Method to print details of all luxury cars
    public static void printAllLuxuryCars() {
        for (int i = 0; i < InventoryManager.vehiclesList.size(); i++) {
            if (InventoryManager.vehiclesList.get(i) instanceof LuxuryCar) {
                printVehicleData(InventoryManager.vehiclesList.get(i));
                System.out.println();
            }
        }
    }

    // Method to print details of all economical cars
    public static void printAllEconomicalCars() {
        for (int i = 0; i < InventoryManager.vehiclesList.size(); i++) {
            if (InventoryManager.vehiclesList.get(i) instanceof EconomicalCar) {
                printVehicleData(InventoryManager.vehiclesList.get(i));
                System.out.println();
            }
        }
    }

    // Method to print details of all buses
    public static void printAllBuses() {
        for (int i = 0; i < InventoryManager.vehiclesList.size(); i++) {
            if (InventoryManager.vehiclesList.get(i) instanceof Bus) {
                printVehicleData(InventoryManager.vehiclesList.get(i));
                System.out.println();
            }
        }
    }

    // Method to print details of all customers
    public static void printAllCustomers() {
        for (int i = 0; i < InventoryManager.customersList.size(); i++) {
            System.out.print((i + 1) + ". ");
            printCustomerData(InventoryManager.customersList.get(i));
        }
    }

    // Method to find a customer by CNIC
    public static Customer findCustomer(String cnic) {
        Customer customer = null;
        for (int i = 0; i < InventoryManager.customersList.size(); i++) {
            if (InventoryManager.customersList.get(i).getCnic().equals(cnic)) {
                customer = InventoryManager.customersList.get(i);
                break;
            }
        }
        return customer;
    }

    // Method to find a vehicle by number plate
    public static Vehicle findVehicle(String numberPlate) {
        Vehicle vehicle = null;
        for (int i = 0; i < InventoryManager.vehiclesList.size(); i++) {
            if (InventoryManager.vehiclesList.get(i).getNumberPlate().equals(numberPlate)) {
                vehicle = InventoryManager.vehiclesList.get(i);
                break;
            }
        }
        return vehicle;
    }

    // Method to find a reservation by reservation ID
    public static Reservation findReservation(int reservationId) {
        Reservation reservation = null;
        for (int i = 0; i < RentalManager.reservationsList.size(); i++) {
            if (RentalManager.reservationsList.get(i).getReservationId() == reservationId) {
                reservation = RentalManager.reservationsList.get(i);
                break;
            }
        }
        return reservation;
    }
}
