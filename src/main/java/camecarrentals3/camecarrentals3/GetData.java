package camecarrentals3.camecarrentals3;

import java.io.Serializable;

// Abstract class for retrieving and printing data related to vehicles, reservations, and customers
public abstract class GetData implements Serializable {

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

    public static Employee getEmployee(String cnic)
    {
        Employee employee = new Employee();
        for (int i=0; i<InventoryManager.employeesList.size(); i++)
        {
            if (InventoryManager.employeesList.get(i).getCnic().equals(cnic))
            {
                employee = InventoryManager.employeesList.get(i);
                break;
            }
        }
        return employee;
    }
}

