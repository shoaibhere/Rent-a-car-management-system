package camecarrentals3.camecarrentals3;

import java.io.Serializable;
import java.util.Random;

public class Employee implements Serializable {
    private String employeeName;
    private int employeeId;
    private String cnic;
    private int age;
    private String phoneNumber;
    private double commission;
    private Login login;
    private boolean isManager = false;
    transient Random random = new Random();

    public Employee(String employeeName, String cnic, int age, String phoneNumber, Login login) {
        this.employeeName = employeeName;
        this.cnic = cnic;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.employeeId = random.nextInt(10, 99);
    }

    public Employee() {
    }

    public void changePassword(String oldPass, String newPass) {
        // Check if the old password matches the current password
        if (oldPass.equals(login.getPassword())) {
            // If matched, update the password
            login.setPassword(newPass);
        } else {
            // If not matched, throw an exception
            throw new IncorrectPasswordException();
        }
    }

    public Login getLogin() {
        return login;
    }
    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getCnic() {
        return cnic;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
}
