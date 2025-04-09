module camecarrentals3.camecarrentals3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens camecarrentals3.camecarrentals3 to javafx.fxml;
    exports camecarrentals3.camecarrentals3;
}