package camecarrentals3.camecarrentals3;

import java.io.*;
import java.net.FileNameMap;
import java.util.ArrayList;

// Abstract class managing the inventory of vehicles and customers
public abstract class InventoryManager implements Serializable{

    // Lists to store vehicles and customers
    public static ArrayList<Vehicle> vehiclesList = new ArrayList<>();
    public static ArrayList<Customer> customersList = new ArrayList<>();
    public static ArrayList<Employee> employeesList = new ArrayList<>();

    // Test method to add sample data to the vehicles and customers lists
    public static void test() {
//        purchaseVehicle(15000000,"Luxury","Audi", "Etron GT", 2022, 15000, 2000, "LEC965");
//        purchaseVehicle(8000000,"Economical","Honda", "Civic", 2019, 8000, 1800, "LEC101");
//        purchaseVehicle(20000000,"Luxury","Rolls Royce", "Phantom", 2010, 50000, 2500, "LAC895");
//        purchaseVehicle(5000000,"Bus","Mazda", "Bus", 2022, 10000, 3000, "IAU891");
//        purchaseVehicle(2000000,"Economical","Suzuki", "Alto", 2020, 4000, 660, "ABC789");

        addCustomer(new Customer("Muhammad Shoaib Akhter", "3240338854759", 170383, 18, "03346880464"));
        addCustomer(new Customer("Muhammad Ali Leghari", "3240115379428", 185978, 19, "03345278912"));
        addCustomer(new Customer("Mian Danial Wajid", "4251063489572", 657952, 20, "03412357928"));
        addCustomer(new Customer("Muhammad Abdullah", "34562774456928", 625981, 25, "03344125678"));
        addCustomer(new Customer("Huzaifa Zafar", "3250448896579", 798952, 18, "03145279534"));

        addEmployee(new Employee("Manager","3240338854757",20,"01234567891",new Login("camel123","Government School kot addu","kot addu")));
        employeesList.get(0).setManager(true);
        addEmployee(new Employee("Ahmed","3240338854759",20,"01234567891",new Login("ABC","Govt School","Lahore")));
        addEmployee(new Employee("Ali","3240338854758",20,"01234561234",new Login("admin","APS", "Choti")));
        addEmployee(new Employee("Hasnain","3240753454759",20,"01234560214",new Login("123","DPS","Okara")));
    }

    // Method to purchase a vehicle and update the inventory and account
    public static void purchaseVehicle(double vehiclePrice, String type, String companyName, String vehicleName, int year, double dailyRate, int engineSize, String numberPlate) {
        if (type.equals("Luxury")) {
            Finance.withdrawAmount(vehiclePrice,"Bought "+companyName+" "+vehicleName+" Number Plate "+numberPlate);
            vehiclesList.add(new LuxuryCar(companyName, vehicleName, year, dailyRate, engineSize, numberPlate));
        } else if (type.equals("Economical")) {
            Finance.withdrawAmount(vehiclePrice,"Bought "+companyName+" "+vehicleName+" Number Plate "+numberPlate);
            vehiclesList.add(new EconomicalCar(companyName, vehicleName, year, dailyRate, engineSize, numberPlate));
        } else if (type.equals("Bus")) {
            Finance.withdrawAmount(vehiclePrice,"Bought "+companyName+" "+vehicleName+" Number Plate "+numberPlate);
            vehiclesList.add(new Bus(companyName, vehicleName, year, dailyRate, engineSize, numberPlate));
        } else {
            throw new TypeNotEnteredException();
        }
        updateVehicleInformation();
    }

    // Method to sell a vehicle and update the inventory and account
    public static void sellVehicle(Vehicle vehicle, double vehiclePrice) {
        Finance.depositAmount(vehiclePrice, "Sold " + vehicle.getCompanyName() + " " + vehicle.getVehicleName() + " Number Plate " + vehicle.numberPlate);
        vehiclesList.remove(vehicle);
        updateVehicleInformation();
    }

    // Method to add and Remove the customer
    public static void removeCustomer(Customer customer) {
       customersList.remove(customer);
       FileHandler.writeData(InventoryManager.customersList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Customer.txt");
    }
    public static void addCustomer(Customer customer) {
        customersList.add(customer);
        FileHandler.writeData(InventoryManager.customersList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Customer.txt");
    }

    public static void addTransaction(Transaction transaction) {
        Finance.transactionsList.add(transaction);
        FileHandler.writeData(Finance.transactionsList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Transaction.txt");
    }
    public static void addReservation(Reservation reservation)
    {
        RentalManager.reservationsList.add(reservation);
        updateReservation();
    }
    public static void updateReservation()
    {
        FileHandler.writeData(RentalManager.reservationsList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Reservation.txt");
    }
    public static void updateEmployeeInformation()
    {
        FileHandler.writeData(InventoryManager.employeesList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Employee.txt");
    }
    public static void updateVehicleInformation()
    {
        FileHandler.writeData(InventoryManager.vehiclesList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Vehicle.txt");
    }
    public static void addEmployee(Employee employee)
    {
        employeesList.add(employee);
        updateEmployeeInformation();
    }
    public static void removeEmployee(Employee employee)
    {
        employeesList.remove(employee);
        updateEmployeeInformation();
    }
}
