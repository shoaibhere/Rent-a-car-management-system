package camecarrentals3.camecarrentals3;

import java.io.Serializable;

// Abstract class managing login-related functionality
public class Login implements Serializable {

    // Default login credentials
    private String password;
    private String schoolName;
    private String birthPlace;

    public Login(String password, String schoolName, String birthPlace) {
        this.password = password;
        this.schoolName = schoolName;
        this.birthPlace = birthPlace;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        InventoryManager.updateEmployeeInformation();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
        InventoryManager.updateEmployeeInformation();
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
        InventoryManager.updateEmployeeInformation();
    }
}
