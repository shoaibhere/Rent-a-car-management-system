// Abstract class for searching vehicles in the inventory
public abstract class Search {

    // Search for vehicles by name
    public static void searchByVehicleName(String name) {
        boolean isAvailable = false;

        // Iterate through the vehicles list in the inventory
        for (int i = 0; i < InventoryManager.vehiclesList.size(); i++) {
            if (InventoryManager.vehiclesList.get(i).getVehicleName().equals(name)) {
                GetData.printVehicleData(InventoryManager.vehiclesList.get(i));
                // Check and display availability status
                if (InventoryManager.vehiclesList.get(i).isAvailable()) {
                    System.out.println("This Car is Available");
                } else {
                    System.out.println("This Car is Not Available");
                }
                isAvailable = true;
            }
        }

        // Display a message if no vehicles with the specified name are found
        if (!isAvailable) {
            System.out.println("There are no Vehicles with this name in Inventory");
        }
    }

    // Search for vehicles by company name
    public static void searchByCompanyName(String name) {
        boolean isAvailable = false;

        // Iterate through the vehicles list in the inventory
        for (int i = 0; i < InventoryManager.vehiclesList.size(); i++) {
            if (InventoryManager.vehiclesList.get(i).getCompanyName().equals(name)) {
                GetData.printVehicleData(InventoryManager.vehiclesList.get(i));
                // Check and display availability status
                if (InventoryManager.vehiclesList.get(i).isAvailable()) {
                    System.out.println("This Car is Available");
                } else {
                    System.out.println("This Car is Not Available");
                }
                isAvailable = true;
            }
        }

        // Display a message if no vehicles from the specified company are found
        if (!isAvailable) {
            System.out.println("There are no Vehicles of this Company in Inventory");
        }
    }
}
