// Class representing a customer
public class Customer {

    // Private fields to store customer information
    private final String customerName;
    private final String cnic;
    private final int licenceNumber;
    private final int age;
    private final String phoneNumber;

    // Constructor to initialize customer properties
    public Customer(String customerName, String cnic, int licenceNumber, int age, String phoneNumber) {
        this.customerName = customerName;
        this.cnic = cnic;
        this.licenceNumber = licenceNumber;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods to access customer information
    public String getCustomerName() {
        return customerName;
    }

    public String getCnic() {
        return cnic;
    }

    public int getLicenceNumber() {
        return licenceNumber;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
