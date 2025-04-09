    package camecarrentals3.camecarrentals3;

    import javafx.application.Application;
    import javafx.collections.FXCollections;
    import javafx.geometry.Pos;
    import javafx.scene.Group;
    import javafx.scene.Scene;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.*;
    import javafx.scene.paint.Color;
    import javafx.scene.text.Font;
    import javafx.scene.text.FontWeight;
    import javafx.stage.Stage;

    import java.io.Serializable;
    import java.text.DecimalFormat;
    import java.text.NumberFormat;
    import java.time.LocalDate;
    import java.time.temporal.ChronoUnit;
    import java.util.stream.Stream;

    // RentACarManagementSystem class extending Application
    public class RentACarManagementSystem extends Application implements Serializable {
        static NumberFormat formatter = new DecimalFormat("#0.00");
        // Image for the logo
        Image logo = new Image("file:C://Users//DELL//OneDrive//Desktop//CameCarRentals3//src//main//java//camecarrentals3//camecarrentals3//logo.png");
        @Override
        public void start(Stage stage) throws Exception {
            //Call the Test Values
//            InventoryManager.test();
            FileHandler.readFinanceDataOnFile();
            FileHandler.readData(Finance.transactionsList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Transaction.txt");
            FileHandler.readData(InventoryManager.employeesList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Employee.txt");
            FileHandler.readData(InventoryManager.vehiclesList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Vehicle.txt");
            FileHandler.readData(InventoryManager.customersList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Customer.txt");
            FileHandler.readData(RentalManager.reservationsList,"C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Reservation.txt");
            // Set stage properties
            stage.setResizable(false);
            stage.getIcons().add(logo);

            // Create logo view
            ImageView logoView = new ImageView(logo);
            logoView.setOpacity(0.2);
            Group root = new Group();

            stage.setTitle("CAMELCAR RENTALS MANAGEMENT");

            // Create text fields, labels, and buttons
            TextField cnicField = new TextField();
            cnicField.setPromptText("CNIC ");
            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("Password ");
            Label cnicLabel = new Label("CNIC");
            Label passwordLabel = new Label("Password");
            Button loginButton = new Button("Login");
            Button forgotPasswordButton = new Button("Forgot Password");

            //DO THE STYLING OF BUTTONS
            setStyling(loginButton,100,25);
            setStyling(forgotPasswordButton,100,25);

            //ADD NODES TO PANE
            HBox hBox1 = new HBox(35);
            hBox1.getChildren().addAll(cnicLabel,cnicField);
            HBox hBox2 = new HBox(10);
            hBox2.getChildren().addAll(passwordLabel,passwordField);
            HBox hBox3 = new HBox(10);
            hBox3.getChildren().addAll(loginButton,forgotPasswordButton);
            VBox loginPane = new VBox(15);

            //PANE PROPERTIES
            loginPane.setAlignment(Pos.CENTER);
            loginPane.getChildren().addAll(hBox1,hBox2,hBox3);
            logoView.setFitHeight(750);
            logoView.setFitWidth(800);
            loginPane.setLayoutX(300);
            loginPane.setLayoutY(350);
            root.getChildren().addAll(logoView,loginPane);

            //CREATE SCENE AND SET IT ON STAGE
            Scene loginScene = new Scene(root,810,750);
            stage.setScene(loginScene);

            //FUNCTIONALITY OF CHANGE PASSWORD BUTTON
            forgotPasswordButton.setOnAction(e->
                {
                    //FIELDS LABELS AND BUTTONS
                    TextField cnicField1 = new TextField();
                    cnicField1.setPromptText("CNIC");
                    Label cnicLabel1 = new Label("CNIC");
                    Label schoolQuestionLabel = new Label("What was the name of your School?");
                    TextField schoolQuestionTf = new TextField();
                    schoolQuestionTf.setPromptText("School Name");
                    Label birthPlaceQuestionLabel = new Label("Where were you born?");
                    TextField birthPlaceQuestionTf = new TextField();
                    birthPlaceQuestionTf.setPromptText("Birth Place");
                    Button nextButton = new Button("Next");
                    Button backToMenuButton = new Button("Back");
                    setStyling(nextButton,100,25);
                    setStyling(backToMenuButton,100,25);

                    GridPane securityQuestionsPane = new GridPane();
                    securityQuestionsPane.setAlignment(Pos.CENTER);
                    securityQuestionsPane.setHgap(5);
                    securityQuestionsPane.setVgap(5);
                    securityQuestionsPane.add(cnicLabel1,0,0);
                    securityQuestionsPane.add(cnicField1,1,0);
                    securityQuestionsPane.add(schoolQuestionLabel,0,1);
                    securityQuestionsPane.add(schoolQuestionTf,1,1);
                    securityQuestionsPane.add(birthPlaceQuestionLabel,0,2);
                    securityQuestionsPane.add(birthPlaceQuestionTf,1,2);
                    securityQuestionsPane.add(backToMenuButton,0,3);
                    securityQuestionsPane.add(nextButton,1,3);

                    ImageView logoView1 = new ImageView(logo);
                    logoView1.setOpacity(0.2);
                    Group root1 = new Group();
                    logoView1.setFitHeight(750);
                    logoView1.setFitWidth(800);
                    root1.getChildren().addAll(logoView1,securityQuestionsPane);
                    securityQuestionsPane.setLayoutX(225);
                    securityQuestionsPane.setLayoutY(350);
                    Scene securityScene = new Scene(root1,810,750);
                    stage.setScene(securityScene);

                    nextButton.setOnAction(a->
                    {
                        //CHECKING IF ANSWERS ARE CORRECT AND WITHOUT ANY EXCEPTION
                        try {
                        if ((schoolQuestionTf.getText().equalsIgnoreCase(GetData.getEmployee(cnicField1.getText()).getLogin().getSchoolName())) & (birthPlaceQuestionTf.getText().equalsIgnoreCase(GetData.getEmployee(cnicField1.getText()).getLogin().getBirthPlace()))) {
                            //FIELDS LABELS AND BUTTONS
                            PasswordField newPassword = new PasswordField();
                            newPassword.setPromptText("New Password");
                            PasswordField confirmNewPassword = new PasswordField();
                            confirmNewPassword.setPromptText("Confirm New Password");
                            Label newPassLabel = new Label("New Password");
                            Label confirmPassLabel = new Label("Confirm New Password");
                            Button changeButton = new Button("Change Password");
                            Button backButton = new Button("Back");

                            //CREATING LAYOUT
                            GridPane passwordPane = new GridPane();
                            passwordPane.setAlignment(Pos.CENTER);
                            passwordPane.setVgap(5);
                            passwordPane.setHgap(5);
                            passwordPane.add(newPassLabel, 0, 0);
                            passwordPane.add(confirmPassLabel, 0, 1);
                            passwordPane.add(newPassword, 1, 0);
                            passwordPane.add(confirmNewPassword, 1, 1);
                            passwordPane.add(changeButton, 1, 2);
                            passwordPane.add(backButton, 0, 2);

                            //STYLING THE BUTTONS
                            setStyling(changeButton, 100, 25);
                            setStyling(backButton, 100, 25);

                            passwordPane.setLayoutX(250);
                            passwordPane.setLayoutY(350);

                            ImageView logoView2 = new ImageView(logo);
                            logoView2.setOpacity(0.2);
                            Group root2 = new Group();
                            logoView2.setFitHeight(750);
                            logoView2.setFitWidth(800);
                            root2.getChildren().addAll(logoView2, passwordPane);

                            //CREATING SCENE AND SETTING ON STAGE
                            Scene passwordScene = new Scene(root2, 810, 750);
                            stage.setScene(passwordScene);

                            //BACK BUTTON FUNCTIONALITY TO BRING BACK TO LOGIN PAGE
                            backButton.setOnAction(b ->
                            {
                                stage.setScene(loginScene);
                            });

                            //CHANGE BUTTON FUNCTIONALITY
                            changeButton.setOnAction(b ->
                            {
                                    if (newPassword.getText().equals(confirmNewPassword.getText())) {
                                        GetData.getEmployee(cnicField1.getText()).getLogin().setPassword(newPassword.getText());
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setContentText("Password Changed Successfully");
                                        alert.setTitle("Password Changed");
                                        alert.show();
                                    } else {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Password Do not Match");
                                        alert.setContentText("Passwords Do not Match");
                                        alert.show();
                                    }
                                //EMPTYING THE FIELDS
                                newPassword.setText("");
                                confirmNewPassword.setText("");
                            });
                            cnicField.setText("");
                            passwordField.setText("");
                        }
                    else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Wrong Answers");
                            alert.setContentText("Answers Were Not Correct");
                            alert.show();
                        }}
                    catch (NullPointerException o)
                        {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Employee Not Found");
                            alert.setContentText("Employee with this CNIC does not Exist");
                            alert.show();
                        }
                        finally {
                            birthPlaceQuestionTf.setText("");
                            schoolQuestionTf.setText("");
                        }
                    });
                    backToMenuButton.setOnAction(b->
                            {stage.setScene(loginScene);});
                });

            //LOGIN BUTTON FUNCTIONALITY
            loginButton.setOnAction(e->
            {
                try {
                    if (passwordField.getText().equals(GetData.getEmployee(cnicField.getText()).getLogin().getPassword()) & cnicField.getText().equals(GetData.getEmployee(cnicField.getText()).getCnic())) {
                        Employee employee = GetData.getEmployee(cnicField.getText());
                        //CREATING NODES, LAYOUT AND STYLING THEM
                        Pane mainMenuPane = new Pane();
                        Label welcomeLabel = new Label();
                        if (employee.isManager()) {
                            welcomeLabel.setText("Welcome To Manager Portal of CamelCar Rentals Management System");
                        }
                        else
                        {
                            welcomeLabel.setText("Welcome To Employee Portal of CamelCar Rentals Management System, " + employee.getEmployeeName());
                        }
                        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                        Button vehicleButton = new Button("Vehicles Management");
                        Button customersButton = new Button("Customers Management");
                        Button reservationsButton = new Button("Reservations Management");
                        Button financeButton = new Button("Finance Management");
                        Button employeesButton = new Button("Employees Management");
                        Button changeAccountInfoButton = new Button("Change Account Info");
                        changeAccountInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                        Button logOutButton = new Button("Log Out");
                        setStyling(vehicleButton, 150, 75);
                        setStyling(changeAccountInfoButton, 100, 25);
                        setStyling(customersButton, 150, 75);
                        setStyling(reservationsButton, 150, 75);
                        setStyling(financeButton, 150, 75);
                        setStyling(logOutButton, 150, 75);
                        setStyling(employeesButton, 150, 75);
                        mainMenuPane.getChildren().addAll(welcomeLabel,changeAccountInfoButton, vehicleButton, customersButton, reservationsButton, financeButton, logOutButton,employeesButton);


                        vehicleButton.setLayoutX(170);
                        customersButton.setLayoutX(330);
                        reservationsButton.setLayoutX(490);
                        financeButton.setLayoutX(170);
                        employeesButton.setLayoutX(330);
                        logOutButton.setLayoutX(490);

                        vehicleButton.setLayoutY(295);
                        customersButton.setLayoutY(295);
                        reservationsButton.setLayoutY(295);
                        financeButton.setLayoutY(380);
                        employeesButton.setLayoutY(380);
                        logOutButton.setLayoutY(380);
                        changeAccountInfoButton.setLayoutY(30);

                        if (!employee.isManager())
                        {
                            financeButton.setVisible(false);
                            employeesButton.setVisible(false);
                            vehicleButton.setLayoutX(260);
                            vehicleButton.setLayoutY(260);

                            customersButton.setLayoutX(425);
                            customersButton.setLayoutY(260);

                            reservationsButton.setLayoutX(260);
                            reservationsButton.setLayoutY(355);

                            logOutButton.setLayoutX(425);
                            logOutButton.setLayoutY(355);
                        }

                        ImageView logoView1 = new ImageView(logo);
                        logoView1.setOpacity(0.2);
                        logoView1.setFitHeight(750);
                        logoView1.setFitWidth(800);
                        Group root1 = new Group();
                        logoView1.setFitHeight(750);
                        logoView1.setFitWidth(800);
                        root1.getChildren().addAll(logoView1, mainMenuPane);

                        //CREATING SCENE AND SETTING ON STAGE
                        Scene mainMenuScene = new Scene(root1, 810, 750);
                        stage.setScene(mainMenuScene);

                        //BUTTON TO BRING BACK TO LOGIN PAGE FUNCTIONALITY
                        logOutButton.setOnAction(a ->
                        {
                            stage.setScene(loginScene);
                        });

                        //VEHICLE BUTTON SHOWS ALL VEHICLES
                        vehicleButton.setOnAction(a ->
                        {
                            displayVehicles(stage, mainMenuScene, employee);
                        });

                        //CUSTOMER BUTTON SHOWS ALL CUSTOMERS
                        customersButton.setOnAction(a ->
                        {
                            displayCustomers(stage, mainMenuScene);
                        });

                        //RESERVATION BUTTON SHOWS ALL RESERVATIONS
                        reservationsButton.setOnAction((a ->
                        {
                            displayReservations(stage, mainMenuScene,employee);
                        }));

                        employeesButton.setOnAction(actionEvent ->
                        {
                            displayEmployees(stage,mainMenuScene);
                        });
                        changeAccountInfoButton.setOnAction(actionEvent ->
                        {
                            Button changePassword = new Button("Change Password");
                            Button changeSecurityAnswers = new Button("Change Security Answers");
                            Button backButton = new Button("Back To Menu");

                            setStyling(changePassword, 150, 75);
                            setStyling(changeSecurityAnswers, 150, 75);
                            setStyling(backButton, 150, 75);

                            backButton.setLayoutX(170);
                            changePassword.setLayoutX(330);
                            changeSecurityAnswers.setLayoutX(490);

                            backButton.setLayoutY(295);
                            changePassword.setLayoutY(295);
                            changeSecurityAnswers.setLayoutY(295);

                            Pane changeInfoPane = new Pane();
                            changeInfoPane.getChildren().addAll(changePassword,changeSecurityAnswers,backButton);

                            ImageView logoView2 = new ImageView(logo);
                            logoView2.setOpacity(0.2);
                            logoView2.setFitHeight(750);
                            logoView2.setFitWidth(800);
                            Group root2 = new Group();
                            logoView2.setFitHeight(750);
                            logoView2.setFitWidth(800);
                            root2.getChildren().addAll(logoView2, changeInfoPane);

                            //CREATING SCENE AND SETTING ON STAGE
                            Scene changeInfoScene = new Scene(root2, 810, 750);
                            stage.setScene(changeInfoScene);

                            backButton.setOnAction(c->
                            {
                                stage.setScene(mainMenuScene);
                            });

                            changeSecurityAnswers.setOnAction(c->
                            {

                                PasswordField oldPassword = new PasswordField();
                                oldPassword.setPromptText("Old Password");
                                Label oldPassLabel = new Label("Old Password");
                                Label schoolQuestionLabel = new Label("What was the name of your School?");
                                TextField schoolQuestionTf = new TextField();
                                schoolQuestionTf.setPromptText("School Name");
                                Label birthPlaceQuestionLabel = new Label("Where were you born?");
                                TextField birthPlaceQuestionTf = new TextField();
                                birthPlaceQuestionTf.setPromptText("Birth Place");
                                Button change = new Button("Change");
                                Button back = new Button("Back");
                                setStyling(change,100,25);
                                setStyling(back,100,25);

                                GridPane securityQuestionsPane = new GridPane();
                                securityQuestionsPane.setAlignment(Pos.CENTER);
                                securityQuestionsPane.setHgap(5);
                                securityQuestionsPane.setVgap(5);
                                securityQuestionsPane.add(oldPassLabel,0,0);
                                securityQuestionsPane.add(oldPassword,1,0);
                                securityQuestionsPane.add(schoolQuestionLabel,0,1);
                                securityQuestionsPane.add(schoolQuestionTf,1,1);
                                securityQuestionsPane.add(birthPlaceQuestionLabel,0,2);
                                securityQuestionsPane.add(birthPlaceQuestionTf,1,2);
                                securityQuestionsPane.add(back,0,3);
                                securityQuestionsPane.add(change,1,3);

                                ImageView logoView3 = new ImageView(logo);
                                logoView3.setOpacity(0.2);
                                Group root3 = new Group();
                                logoView3.setFitHeight(750);
                                logoView3.setFitWidth(800);
                                root3.getChildren().addAll(logoView3,securityQuestionsPane);
                                securityQuestionsPane.setLayoutX(225);
                                securityQuestionsPane.setLayoutY(350);
                                Scene securityScene = new Scene(root3,810,750);
                                stage.setScene(securityScene);
                                back.setOnAction(d->
                                {
                                    stage.setScene(changeInfoScene);
                                });
                                change.setOnAction(d->
                                {
                                    if (employee.getLogin().getPassword().equals(oldPassword.getText())) {
                                        employee.getLogin().setBirthPlace(birthPlaceQuestionTf.getText());
                                        employee.getLogin().setSchoolName(schoolQuestionTf.getText());
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setContentText("Recovery Questions Changed Successfully");
                                        alert.setTitle("Information Changed");
                                        stage.setScene(changeInfoScene);
                                        alert.show();
                                    }
                                    else
                                    {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Incorrect Old Password");
                                        alert.setContentText("Incorrect Old Password Entered");
                                        alert.show();
                                        oldPassword.setText("");
                                        birthPlaceQuestionTf.setText("");
                                        schoolQuestionTf.setText("");
                                    }
                                });
                            });
                            changePassword.setOnAction(d->
                            {
                                //FIELDS LABELS AND BUTTONS
                                PasswordField oldPassword = new PasswordField();
                                oldPassword.setPromptText("Old Password");
                                Label oldPassLabel = new Label("Old Password");
                                PasswordField newPassword = new PasswordField();
                                newPassword.setPromptText("New Password");
                                PasswordField confirmNewPassword = new PasswordField();
                                confirmNewPassword.setPromptText("Confirm New Password");
                                Label newPassLabel = new Label("New Password");
                                Label confirmPassLabel = new Label("Confirm New Password");
                                Button changeButton = new Button("Change Password");
                                Button backBtn = new Button("Back");

                                //CREATING LAYOUT
                                GridPane passwordPane = new GridPane();
                                passwordPane.setAlignment(Pos.CENTER);
                                passwordPane.setVgap(5);
                                passwordPane.setHgap(5);
                                passwordPane.add(oldPassLabel,0,0);
                                passwordPane.add(newPassLabel,0,1);
                                passwordPane.add(confirmPassLabel,0,2);
                                passwordPane.add(oldPassword,1,0);
                                passwordPane.add(newPassword,1,1);
                                passwordPane.add(confirmNewPassword,1,2);
                                passwordPane.add(changeButton,1,3);
                                passwordPane.add(backBtn,0,3);

                                //STYLING THE BUTTONS
                                setStyling(changeButton,100,25);
                                setStyling(backBtn,100,25);

                                passwordPane.setLayoutX(250);
                                passwordPane.setLayoutY(350);
                                ImageView logoView3 = new ImageView(logo);
                                logoView3.setOpacity(0.2);
                                Group root3 = new Group();
                                logoView3.setFitHeight(750);
                                logoView3.setFitWidth(800);
                                root3.getChildren().addAll(logoView3,passwordPane);

                                //CREATING SCENE AND SETTING ON STAGE
                                Scene passwordScene = new Scene(root3,810,750);
                                stage.setScene(passwordScene);

                                //BACK BUTTON FUNCTIONALITY TO BRING BACK TO LOGIN PAGE
                                backBtn.setOnAction(a->
                                {
                                    stage.setScene(changeInfoScene);
                                });

                                //CHANGE BUTTON FUNCTIONALITY
                                changeButton.setOnAction(a->
                                {
                                    //EXCEPTION HANDLING FOR INCORRECT AND INVALID INPUTS
                                    try {
                                        if (newPassword.getText().equals(confirmNewPassword.getText())) {
                                            employee.changePassword(oldPassword.getText(), newPassword.getText());
                                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                            alert.setContentText("Password Changed Successfully");
                                            alert.setTitle("Password Changed");
                                            alert.show();
                                        }
                                        else
                                        {
                                            Alert alert = new Alert(Alert.AlertType.ERROR);
                                            alert.setTitle("Password Do not Match");
                                            alert.setContentText("Passwords Do not Match");
                                            alert.show();
                                        }
                                    }
                                    catch (IncorrectPasswordException o)
                                    {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Incorrect Old Password");
                                        alert.setContentText("Incorrect Old Password Entered");
                                        alert.show();
                                    }
                                    //EMPTYING THE FIELDS
                                    oldPassword.setText("");
                                    newPassword.setText("");
                                    confirmNewPassword.setText("");
                                });
                            });

                        });

                        //Finance BUTTON GIVES CONTROL OVER FINANCES
                        financeButton.setOnAction(a ->
                        {
                            //CREATING NODES, LAYOUT AND STYLING THEM
                            Pane FinancePane = new Pane();
                            Button depositButton = new Button("Deposit Amount");
                            Button withdrawButton = new Button("Withdraw Amount");
                            Button checkBalance = new Button("Check Balance");
                            Button transactionsButton = new Button("View Statement");
                            Button backToMenuButton = new Button("Back To Menu");
                            setStyling(depositButton, 150, 75);
                            setStyling(withdrawButton, 150, 75);
                            setStyling(checkBalance, 150, 75);
                            setStyling(transactionsButton, 150, 75);
                            setStyling(backToMenuButton, 150, 75);
                            FinancePane.getChildren().addAll(depositButton, withdrawButton, checkBalance, transactionsButton, backToMenuButton);


                            depositButton.setLayoutX(170);
                            withdrawButton.setLayoutX(330);
                            checkBalance.setLayoutX(490);
                            transactionsButton.setLayoutX(250);
                            backToMenuButton.setLayoutX(410);

                            depositButton.setLayoutY(295);
                            withdrawButton.setLayoutY(295);
                            checkBalance.setLayoutY(295);
                            transactionsButton.setLayoutY(380);
                            backToMenuButton.setLayoutY(380);

                            ImageView logoView2 = new ImageView(logo);
                            logoView2.setOpacity(0.2);
                            logoView2.setFitHeight(750);
                            logoView2.setFitWidth(800);
                            Group root2 = new Group();
                            logoView2.setFitHeight(750);
                            logoView2.setFitWidth(800);
                            root2.getChildren().addAll(logoView2, FinancePane);

                            //CREATING SCENE AND SETTING ON STAGE
                            Scene FinanceScene = new Scene(root2, 810, 750);
                            stage.setScene(FinanceScene);

                            //TRANSACTIONS STATEMENT
                            transactionsButton.setOnAction(b ->
                            {
                                displayTransactions(stage, FinanceScene);
                            });

                            //DEPOSIT BUTTON FUNCTIONALITY
                            depositButton.setOnAction(b ->
                            {
                                //CREATING NODES, LAYOUT AND STYLING THEM
                                TextField depositAmountField = new TextField();
                                depositAmountField.setPromptText("Amount ");
                                Label amountLabel = new Label("Enter Amount to Deposit");
                                Label transactionInfoLabel = new Label("Enter the Transaction Info");
                                TextField transactionInfoField = new TextField();
                                transactionInfoField.setPromptText("Transaction Info");
                                Button deposit = new Button("Deposit");
                                Button backButton = new Button("Back to Finance");
                                setStyling(deposit, 100, 25);
                                setStyling(backButton, 100, 25);
                                GridPane depositPane = new GridPane();
                                depositPane.setVgap(10);
                                depositPane.setHgap(10);
                                depositPane.setAlignment(Pos.CENTER);
                                depositPane.add(amountLabel, 0, 0);
                                depositPane.add(depositAmountField, 1, 0);
                                depositPane.add(transactionInfoLabel, 0, 1);
                                depositPane.add(transactionInfoField, 1, 1);
                                depositPane.add(deposit, 1, 2);
                                depositPane.add(backButton, 0, 2);
                                ImageView logoView3 = new ImageView(logo);
                                logoView3.setOpacity(0.2);
                                logoView3.setFitHeight(750);
                                logoView3.setFitWidth(800);
                                Group root3 = new Group();
                                logoView3.setFitHeight(750);
                                logoView3.setFitWidth(800);
                                depositPane.setLayoutX(250);
                                depositPane.setLayoutY(350);
                                root3.getChildren().addAll(logoView3, depositPane);

                                //CREATING SCENE AND SETTING ON STAGE
                                stage.setScene(new Scene(root3, 810, 750));

                                //DEPOSIT BUTTON FUNCTIONALITY
                                deposit.setOnAction(c ->
                                {
                                    //EXCEPTION HANDLING FOR INVALID AND INCORRECT INPUTS
                                    try {
                                        Finance.depositAmount(Double.parseDouble(depositAmountField.getText()), transactionInfoField.getText());
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setContentText("Amount Deposited Successfully");
                                        alert.setTitle("Amount Deposited");
                                        alert.show();
                                    } catch (NumberFormatException o) {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Invalid Input");
                                        alert.setContentText("Incorrect Datatype Entered or a Field left Empty");
                                        alert.show();
                                    } catch (InvalidAmountException o) {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Invalid Amount");
                                        alert.setContentText("Invalid Amount Entered");
                                        alert.show();
                                    }
                                    catch (TransactionInfoNotPresentException o) {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Transaction Information");
                                        alert.setContentText("Please Enter Transaction Information");
                                        alert.show();
                                    }
                                    finally {
                                        transactionInfoField.setText("");
                                        depositAmountField.setText("");
                                    }

                                });

                                //BACK BUTTON FUNCTIONALITY
                                backButton.setOnAction(c ->
                                        stage.setScene(FinanceScene));
                            });

                            //WITHDRAW BUTTON FUNCTIONALITY
                            withdrawButton.setOnAction(b ->
                            {
                                //CREATING NODES, LAYOUT AND STYLING THEM
                                TextField amountField = new TextField();
                                amountField.setPromptText("Amount");
                                Label amountLabel = new Label("Enter Amount to Withdraw");
                                Label transactionInfoLabel = new Label("Enter the Transaction Info");
                                TextField transactionInfoField = new TextField();
                                transactionInfoField.setPromptText("Transaction Info");
                                Button withdraw = new Button("Withdraw");
                                Button backButton = new Button("Back to Finance");
                                setStyling(withdraw, 100, 25);
                                setStyling(backButton, 100, 25);
                                GridPane withdrawPane = new GridPane();
                                withdrawPane.setVgap(10);
                                withdrawPane.setHgap(10);
                                withdrawPane.setAlignment(Pos.CENTER);
                                withdrawPane.add(amountLabel, 0, 0);
                                withdrawPane.add(amountField, 1, 0);
                                withdrawPane.add(transactionInfoLabel, 0, 1);
                                withdrawPane.add(transactionInfoField, 1, 1);
                                withdrawPane.add(withdraw, 1, 2);
                                withdrawPane.add(backButton, 0, 2);
                                ImageView logoView3 = new ImageView(logo);
                                logoView3.setOpacity(0.2);
                                logoView3.setFitHeight(750);
                                logoView3.setFitWidth(800);
                                Group root3 = new Group();
                                logoView3.setFitHeight(750);
                                logoView3.setFitWidth(800);
                                withdrawPane.setLayoutX(250);
                                withdrawPane.setLayoutY(350);
                                root3.getChildren().addAll(logoView3, withdrawPane);

                                //CREATING SCENE AND SETTING ON STAGE
                                stage.setScene(new Scene(root3, 810, 750));

                                //WITHDRAW BUTTON FUNCTIONALITY
                                withdraw.setOnAction(c ->
                                {
                                    //EXCEPTIONAL HANDLING FOR INVALID AND INCORRECT INPUTS
                                    try {
                                        Finance.withdrawAmount(Double.parseDouble(amountField.getText()), transactionInfoField.getText());
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setContentText("Amount Withdrawn Successfully");
                                        alert.setTitle("Amount Withdrawn");
                                        alert.show();
                                    } catch (NumberFormatException o) {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Invalid Input");
                                        alert.setContentText("Incorrect Datatype Entered or a Field left Empty");
                                        alert.show();
                                    } catch (InvalidAmountException o) {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Invalid Amount");
                                        alert.setContentText("Invalid Amount Entered");
                                        alert.show();
                                    } catch (InsufficientAmountException o) {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Insufficient Amount");
                                        alert.setContentText("You have insufficient balance, Available Balance: Rs. " + formatter.format(Finance.getAccountBalance()));
                                        alert.show();
                                    }
                                    catch (TransactionInfoNotPresentException o) {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Transaction Information");
                                        alert.setContentText("Please Enter Transaction Information");
                                        alert.show();
                                    }
                                    finally {
                                        transactionInfoField.setText("");
                                        amountField.setText("");
                                    }

                                });
                                //BACK BUTTON FUNCTIONALITY
                                backButton.setOnAction(c ->
                                        stage.setScene(FinanceScene));
                            });

                            //BACK TO MAIN MENU FUNCTIONALITY
                            backToMenuButton.setOnAction(b ->
                            {
                                stage.setScene(mainMenuScene);
                            });

                            //CHECK BALANCE BUTTON FUNCTIONALITY
                            checkBalance.setOnAction(b ->
                            {
                                //CREATING NODES, LAYOUT AND STYLING THEM
                                Label balance = new Label("Current Balance: Rs. " + formatter.format(Finance.getAccountBalance()));
                                balance.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                                Button backButton = new Button("Back to Finance");
                                setStyling(backButton, 100, 25);
                                VBox checkBalancePane = new VBox(10);
                                checkBalancePane.setAlignment(Pos.CENTER);
                                checkBalancePane.getChildren().addAll(balance, backButton);

                                //CREATING SCENE AND SETTING ON STAGE
                                stage.setScene(new Scene(checkBalancePane, 810, 750));

                                //BACK TO Finance MENU
                                backButton.setOnAction(c ->
                                        stage.setScene(FinanceScene));
                            });
                        });
                    }

                    //CHECKS IF PASSWORD IS INCORRECT
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Incorrect Password");
                        alert.setContentText("Incorrect Password Entered");
                        alert.show();
                    }
                }
                catch (NullPointerException o)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Employee Not Found");
                    alert.setContentText("There is no Employee in our Record with this CNIC");
                    alert.show();
                }


                //EMPTYING THE FIELDS
                cnicField.setText("");
                passwordField.setText("");
            });

            //SHOWING THE STAGE
            stage.show();
        }

        //METHOD FOR VEHICLES BUTTON FUNCTIONALITY
        public void displayVehicles(Stage stage, Scene scene,Employee employee)
        {
            //CREATING NODES, LAYOUT AND STYLING THEM
            GridPane vehiclesPane = new GridPane();
            Label companyLabel1 = new Label("Company");
            companyLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label nameLabel1 = new Label("Name");
            nameLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label plateLabel1 = new Label("Number Plate");
            plateLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label dailyRateLabel1 = new Label("Daily Rate");
            dailyRateLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label dailyTaxLabel1 = new Label("Daily Tax");
            dailyTaxLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label dailyTotalLabel1 = new Label("Daily Total");
            dailyTotalLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label engineSizeLabel1 = new Label("Engine");
            engineSizeLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label modelYearLabel1 = new Label("Model");
            modelYearLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label vehicleTypeLabel1 = new Label("Type");
            vehicleTypeLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label availability1 = new Label("Availability");
            availability1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Button backToMenuButton = new Button("Back To Menu");
            Button buyNewCar = new Button("Buy New Car");
            if (!employee.isManager())
            {
                buyNewCar.setVisible(false);
            }
            setStyling(backToMenuButton,100,25);
            setStyling(buyNewCar,100,25);
    
    
            vehiclesPane.setVgap(5);
            vehiclesPane.setHgap(5);
            vehiclesPane.add(companyLabel1,1,0);
            vehiclesPane.add(nameLabel1,2,0);
            vehiclesPane.add(vehicleTypeLabel1,3,0);
            vehiclesPane.add(modelYearLabel1,4,0);
            vehiclesPane.add(plateLabel1,5,0);
            vehiclesPane.add(engineSizeLabel1,6,0);
            vehiclesPane.add(dailyRateLabel1,7,0);
            vehiclesPane.add(dailyTaxLabel1,8,0);
            vehiclesPane.add(dailyTotalLabel1,9,0);
            vehiclesPane.add(availability1,10,0);
            vehiclesPane.add(backToMenuButton,1,InventoryManager.vehiclesList.size()+1);
            vehiclesPane.add(buyNewCar,2,InventoryManager.vehiclesList.size()+1);
            ImageView logoView3 = new ImageView(logo);
            logoView3.setOpacity(0.2);
            logoView3.setFitHeight(750);
            logoView3.setFitWidth(800);
            Group root3 = new Group();
            logoView3.setFitHeight(750);
            logoView3.setFitWidth(800);
            root3.getChildren().addAll(logoView3,vehiclesPane);
            Scene vehicleScene = new Scene(root3,810,750);
            stage.setScene(vehicleScene);

            //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
            backToMenuButton.setOnAction(e->
            {
                stage.setScene(scene);
            });

            //LOOP FOR GETTING ALL THE VEHICLES IN INVENTORY
            for(int i=0; i<InventoryManager.vehiclesList.size(); i++)
            {
                //CREATING NODES, LAYOUT AND STYLING THEM
                Label companyLabel = new Label(InventoryManager.vehiclesList.get(i).getCompanyName());
                Label nameLabel = new Label(InventoryManager.vehiclesList.get(i).getVehicleName());
                Label plateLabel = new Label(InventoryManager.vehiclesList.get(i).getNumberPlate());
                Label dailyRateLabel = new Label("Rs. "+(formatter.format(InventoryManager.vehiclesList.get(i).getDailyRate())));
                Label dailyTaxLabel = new Label("Rs. "+(formatter.format(InventoryManager.vehiclesList.get(i).getTax())));
                Label dailyTotalLabel = new Label("Rs. "+(formatter.format(InventoryManager.vehiclesList.get(i).getDailyTotal())));
                Label engineSizeLabel = new Label((InventoryManager.vehiclesList.get(i).getEngineSize())+" CC");
                Label modelYearLabel = new Label(Integer.toString(InventoryManager.vehiclesList.get(i).getModelYear()));
                Label vehicleTypeLabel = new Label(GetData.getVehicleType(InventoryManager.vehiclesList.get(i)));
                Label availability = new Label(InventoryManager.vehiclesList.get(i).getAvailability());
                Button rentButton = new Button("Rent");
                Button sellButton = new Button("Sell");
                setStyling(rentButton,25,10);
                setStyling(sellButton,25,10);
    
                if(InventoryManager.vehiclesList.get(i).isAvailable())
                {
                    if (employee.isManager())
                    {
                        vehiclesPane.add(sellButton,11,i+1);
                    }
                    else
                    {
                        vehiclesPane.add(rentButton,11,i+1);
                    }
                    int finalI1 = i;

                    //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                    rentButton.setOnAction(a->
                    {
                        displayCustomersBooking(stage,scene,finalI1,employee);
                    });
                }
                int finalI = i;

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                sellButton.setOnAction(e->
                {
                    //CREATING NODES, LAYOUT AND STYLING THEM
                    TextField priceField = new TextField();
                    Label priceLabel = new Label("Vehicle Price");
                    GridPane sellPane = new GridPane();
                    Button sell = new Button("Sell");
                    Button backButton = new Button("Back");
                    setStyling(sell,100,25);
                    setStyling(backButton,100,25);
    
                    sellPane.setHgap(5);
                    sellPane.setVgap(5);
                    sellPane.setAlignment(Pos.CENTER);
                    sellPane.add(priceLabel,0,0);
                    sellPane.add(priceField,1,0);
                    sellPane.add(backButton,0,1);
                    sellPane.add(sell,1,1);
                    ImageView logoView2 = new ImageView(logo);
                    logoView2.setOpacity(0.2);
                    logoView2.setFitHeight(750);
                    logoView2.setFitWidth(800);
                    Group root2 = new Group();
                    logoView2.setFitHeight(750);
                    logoView2.setFitWidth(800);
                    sellPane.setLayoutX(300);
                    sellPane.setLayoutY(325);
                    root2.getChildren().addAll(logoView2,sellPane);
                    Scene sellScene = new Scene(root2,810,750);
                    stage.setScene(sellScene);

                    //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                    sell.setOnAction(a->
                    {
                        //EXCEPTION HANDLING FOR INVALID AND INCORRECT INPUTS
                        try {
                            InventoryManager.sellVehicle(InventoryManager.vehiclesList.get(finalI), Double.parseDouble(priceField.getText()));
                            displayVehicles(stage,scene,employee);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Car Sold Successfully");
                            alert.setTitle("Car Sold");
                            alert.show();
                        }
                        catch (NumberFormatException o)
                        {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Invalid Input");
                            alert.setContentText("Incorrect Datatype Entered or Field left empty");
                            alert.show();
                            priceField.setText("");
                        }
                        catch (InvalidAmountException o) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Invalid Amount");
                            alert.setContentText("Invalid Amount Entered");
                            alert.show();
                            priceField.setText("");
                        }
                    });

                    //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                    backButton.setOnAction(a->
                    {
                        displayVehicles(stage,scene,employee);
                    });
                });
                vehiclesPane.add(companyLabel,1,i+1);
                vehiclesPane.add(nameLabel,2,i+1);
                vehiclesPane.add(vehicleTypeLabel,3,i+1);
                vehiclesPane.add(modelYearLabel,4,i+1);
                vehiclesPane.add(plateLabel,5,i+1);
                vehiclesPane.add(engineSizeLabel,6,i+1);
                vehiclesPane.add(dailyRateLabel,7,i+1);
                vehiclesPane.add(dailyTaxLabel,8,i+1);
                vehiclesPane.add(dailyTotalLabel,9,i+1);
                vehiclesPane.add(availability,10,i+1);
            }

            //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
            buyNewCar.setOnAction(e->
            {
                //CREATING NODES, LAYOUT AND STYLING THEM
                Label typeLabel = new Label("Vehicle Type");
                Label companyNameLabel = new Label("Company Name");
                Label nameLabel = new Label("Vehicle Name");
                Label yearLabel = new Label("Model Year");
                Label dailyRateLabel = new Label("Daily Rate");
                Label engineSizeLabel = new Label("Engine Size");
                Label numberPlateLabel = new Label("Number Plate");
                Label priceLabel = new Label("Price");
    
                RadioButton luxury = new RadioButton("Luxury Car");
                RadioButton economical = new RadioButton("Economical Car");
                RadioButton bus = new RadioButton("Bus");
    
                ToggleGroup tg = new ToggleGroup();
                luxury.setToggleGroup(tg);
                economical.setToggleGroup(tg);
                bus.setToggleGroup(tg);
    
                TextField companyNameField = new TextField();
                companyNameField.setPromptText("Company Name");
                TextField nameField = new TextField();
                nameField.setPromptText("Vehicle Name");
                TextField yearField = new TextField();
                yearField.setPromptText("Model Year");
                TextField dailyRateField = new TextField();
                dailyRateField.setPromptText("Daily Rate ");
                TextField engineSizeField = new TextField();
                engineSizeField.setPromptText("Engine Size");
                TextField numberPlateField = new TextField();
                numberPlateField.setPromptText("Number Plate");
                TextField priceField = new TextField();
                priceField.setPromptText("Price ");
                Button buy = new Button("Buy");
                Button back = new Button("Back To Vehicle Window");
                setStyling(buy,100,25);
                setStyling(back,100,25);

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                buy.setOnAction(a->
                {
                    String type="";
                    if (luxury.isSelected()) {
                        type = "Luxury";
                    } else if (economical.isSelected()) {
                        type = "Economical";
                    } else if (bus.isSelected()) {
                        type = "Bus";
                    }

                    //EXCEPTION HANDLING FOR INVALID AND INCORRECT INPUTS
                    try {
                        double price = Double.parseDouble(priceField.getText());
                        String companyName = companyNameField.getText();
                        String name = nameField.getText();
                        int year = Integer.parseInt(yearField.getText());
                        double dailyRate = Double.parseDouble(dailyRateField.getText());
                        int engineSize = Integer.parseInt(engineSizeField.getText());
                        String numberPlate = numberPlateField.getText();
                        InventoryManager.purchaseVehicle(price,type,companyName,name,year,dailyRate,engineSize,numberPlate);
                        displayVehicles(stage,scene,employee);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Vehicle Bought Successfully");
                        alert.setTitle("Vehicle Bought");
                        alert.show();
                    }
                    catch (TypeNotEnteredException o)
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Type not selected");
                        alert.setContentText("Please Select Vehicle Type");
                        alert.show();
                    }
                    catch (NumberFormatException o) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Input");
                        alert.setContentText("Incorrect Datatype Entered or a Field left Empty");
                        alert.show();
                        companyNameField.setText("");
                        nameField.setText("");
                        yearField.setText("");
                        dailyRateField.setText("");
                        engineSizeField.setText("");
                        numberPlateField.setText("");
                        priceField.setText("");
                    }
                    catch (InsufficientAmountException o) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Insufficient Amount");
                        alert.setContentText("You do not have sufficient balance in your Account to make this purchase");
                        alert.show();
                        priceField.setText("");
                    }
                    catch (InvalidAmountException o) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Amount");
                        alert.setContentText("Invalid Amount Entered");
                        alert.show();
                        priceField.setText("");
                    }
                });

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                back.setOnAction(a->
                {
                    displayVehicles(stage,scene,employee);
                });
                GridPane buyPane = new GridPane();
                buyPane.setVgap(5);
                buyPane.setHgap(5);
                buyPane.setAlignment(Pos.CENTER);
    
                buyPane.add(companyNameLabel,0,0);
                buyPane.add(nameLabel,0,1);
                buyPane.add(typeLabel,0,2);
                buyPane.add(yearLabel,0,3);
                buyPane.add(engineSizeLabel,0,4);
                buyPane.add(numberPlateLabel,0,5);
                buyPane.add(dailyRateLabel,0,6);
                buyPane.add(priceLabel,0,7);
                buyPane.add(buy,1,8);
                buyPane.add(back,0,8);
    
                buyPane.add(companyNameField,1,0);
                buyPane.add(nameField,1,1);
                buyPane.add(luxury,1,2);
                buyPane.add(economical,2,2);
                buyPane.add(bus,3,2);
                buyPane.add(yearField,1,3);
                buyPane.add(engineSizeField,1,4);
                buyPane.add(numberPlateField,1,5);
                buyPane.add(dailyRateField,1,6);
                buyPane.add(priceField,1,7);
                ImageView logoView2 = new ImageView(logo);
                logoView2.setOpacity(0.2);
                logoView2.setFitHeight(750);
                logoView2.setFitWidth(800);
                Group root2 = new Group();
                logoView2.setFitHeight(750);
                logoView2.setFitWidth(800);
                buyPane.setLayoutX(250);
                buyPane.setLayoutY(280);
                root2.getChildren().addAll(logoView2,buyPane);
                Scene buyScene = new Scene(root2,810,750);
                stage.setScene(buyScene);
            });
        }
    
        public void displayCustomers(Stage stage, Scene scene)
        {
            //CREATING NODES, LAYOUT AND STYLING THEM
            GridPane customersPane = new GridPane();
            Label nameBarLabel = new Label("Name");
            nameBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label cnicBarLabel = new Label("CNIC");
            cnicBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label licenceBarLabel = new Label("Licence Number");
            licenceBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label phoneNumberBarLabel = new Label("Phone Number");
            phoneNumberBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label ageBarLabel = new Label("Age");
            ageBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Button backToMenuButton = new Button("Back To Menu");
            Button addCustomer = new Button("Add New Customer");
            setStyling(addCustomer,100,25);
            setStyling(backToMenuButton,100,25);
    
            customersPane.setVgap(5);
            customersPane.setHgap(5);
            customersPane.add(nameBarLabel,1,0);
            customersPane.add(cnicBarLabel,2,0);
            customersPane.add(licenceBarLabel,3,0);
            customersPane.add(ageBarLabel,4,0);
            customersPane.add(phoneNumberBarLabel,5,0);
            customersPane.add(backToMenuButton,1,InventoryManager.customersList.size()+1);
            customersPane.add(addCustomer,2,InventoryManager.customersList.size()+1);

            //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
            backToMenuButton.setOnAction(e->
            {
                stage.setScene(scene);
            });

            //LOOP FOR ALL THE CUSTOMERS IN THE RECORD
            for(int i=0; i<InventoryManager.customersList.size(); i++)
            {
                //CREATING NODES, LAYOUT AND STYLING THEM
                Label nameLabel = new Label(InventoryManager.customersList.get(i).getCustomerName());
                Label cnicLabel = new Label(InventoryManager.customersList.get(i).getCnic());
                Label licenceLabel = new Label(Integer.toString(InventoryManager.customersList.get(i).getLicenceNumber()));
                Label phoneNumberLabel = new Label(InventoryManager.customersList.get(i).getPhoneNumber());
                Label ageLabel = new Label(Integer.toString(InventoryManager.customersList.get(i).getAge()));
                Button removeCustomer = new Button("Remove");
                setStyling(removeCustomer,100,25);
    
    
                customersPane.add(nameLabel,1,i+1);
                customersPane.add(cnicLabel,2,i+1);
                customersPane.add(licenceLabel,3,i+1);
                customersPane.add(ageLabel,4,i+1);
                customersPane.add(phoneNumberLabel,5,i+1);
                customersPane.add(removeCustomer,6,i+1);
    
                int finalI = i;
                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                removeCustomer.setOnAction(e->
                {
                    InventoryManager.removeCustomer(InventoryManager.customersList.get(finalI));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Customer Removed Successfully");
                    alert.setTitle("Customer Removed");
                    alert.show();
                    displayCustomers(stage,scene);
                });
            }

            //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
            addCustomer.setOnAction(e->
            {
                //CREATING NODES, LAYOUT AND STYLING THEM
                Label nameLabel = new Label("Name");
                Label cnicLabel = new Label("CNIC");
                Label licenceLabel = new Label("Licence Number");
                Label phoneNumberLabel = new Label("Phone Number");
                Label ageLabel = new Label("Age");
    
                TextField nameField = new TextField();
                nameField.setPromptText("Name ");
                TextField cnicField = new TextField();
                cnicField.setPromptText("CNIC ");
                TextField licenceField = new TextField();
                licenceField.setPromptText("License Number");
                TextField phoneNumberField = new TextField();
                phoneNumberField.setPromptText("Phone Number");
                TextField ageField = new TextField();
                ageField.setPromptText("Age ");
    
                Button back = new Button("Back");
                Button addCustomerButton = new Button("Add Customer");
                setStyling(back,100,25);
                setStyling(addCustomerButton,100,25);
    
    
                GridPane addCustomerPane = new GridPane();
                addCustomerPane.setVgap(5);
                addCustomerPane.setHgap(5);
                addCustomerPane.setAlignment(Pos.CENTER);
    
                addCustomerPane.add(nameLabel,0,0);
                addCustomerPane.add(cnicLabel,0,1);
                addCustomerPane.add(licenceLabel,0,2);
                addCustomerPane.add(ageLabel,0,3);
                addCustomerPane.add(phoneNumberLabel,0,4);
                addCustomerPane.add(addCustomerButton,1,5);
                addCustomerPane.add(back,0,5);
    
                addCustomerPane.add(nameField,1,0);
                addCustomerPane.add(cnicField,1,1);
                addCustomerPane.add(licenceField,1,2);
                addCustomerPane.add(ageField,1,3);
                addCustomerPane.add(phoneNumberField,1,4);
                ImageView logoView2 = new ImageView(logo);
                logoView2.setOpacity(0.2);
                logoView2.setFitHeight(750);
                logoView2.setFitWidth(800);
                Group root2 = new Group();
                logoView2.setFitHeight(750);
                logoView2.setFitWidth(800);
                addCustomerPane.setLayoutX(250);
                addCustomerPane.setLayoutY(280);
                root2.getChildren().addAll(logoView2,addCustomerPane);
                Scene addCustomerScene = new Scene(root2,810,750);
                stage.setScene(addCustomerScene);

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                back.setOnAction(a->
                {
                    displayCustomers(stage,scene);
                });

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                addCustomerButton.setOnAction(a->
                {
                    //EXCEPTION HANDLING FOR INVALID AND INCORRECT INPUTS
                    try
                    {
                        InventoryManager.addCustomer(new Customer(nameField.getText(),cnicField.getText(),Integer.parseInt(licenceField.getText()),Integer.parseInt(ageField.getText()),phoneNumberField.getText()));
                        displayCustomers(stage,scene);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Customer Added Successfully");
                        alert.setTitle("Customer Added");
                        alert.show();
                    }
                    catch (UnderAgeException o)
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Under Age Customer");
                        alert.setContentText("Cannot add a customer below 18 Years Age");
                        alert.show();
                    }
                    nameField.setText("");
                    cnicField.setText("");
                    licenceField.setText("");
                    ageField.setText("");
                    phoneNumberField.setText("");
                });
            });
            ImageView logoView2 = new ImageView(logo);
            logoView2.setOpacity(0.2);
            logoView2.setFitHeight(750);
            logoView2.setFitWidth(800);
            Group root2 = new Group();
            logoView2.setFitHeight(750);
            logoView2.setFitWidth(800);
            root2.getChildren().addAll(logoView2,customersPane);
            Scene customersScene = new Scene(root2,810,750);
            stage.setScene(customersScene);
        }
    
        public void displayCustomersBooking(Stage stage, Scene scene,int index,Employee employee)
        {
            //CREATING NODES, LAYOUT AND STYLING THEM
            GridPane customersBookingPane = new GridPane();
            Label nameBarLabel = new Label("Name");
            Label cnicBarLabel = new Label("CNIC");
            Label licenceBarLabel = new Label("Licence Number");
            Label phoneNumberBarLabel = new Label("Phone Number");
            Label ageBarLabel = new Label("Age");
            Button backToVehiclesButton = new Button("Back To Vehicles");
            Button addCustomer = new Button("Add New Customer");
            setStyling(backToVehiclesButton,100,25);
            setStyling(addCustomer,100,25);
    
    
            customersBookingPane.setVgap(5);
            customersBookingPane.setHgap(5);
            customersBookingPane.add(nameBarLabel,1,0);
            customersBookingPane.add(cnicBarLabel,2,0);
            customersBookingPane.add(licenceBarLabel,3,0);
            customersBookingPane.add(ageBarLabel,4,0);
            customersBookingPane.add(phoneNumberBarLabel,5,0);
            customersBookingPane.add(backToVehiclesButton,1,InventoryManager.customersList.size()+1);
            customersBookingPane.add(addCustomer,2,InventoryManager.customersList.size()+1);

            //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
            backToVehiclesButton.setOnAction(e->
            {
                displayVehicles(stage,scene,employee);
            });

            //METHOD FOR ALL THE CUSTOMERS IN THE RECORD TO BE DISPLAYED IN VEHICLES TAB FOR BOOKING
            for(int i=0; i<InventoryManager.customersList.size(); i++)
            {
                //CREATING NODES, LAYOUT AND STYLING THEM
                Label nameLabel = new Label(InventoryManager.customersList.get(i).getCustomerName());
                Label cnicLabel = new Label(InventoryManager.customersList.get(i).getCnic());
                Label licenceLabel = new Label(Integer.toString(InventoryManager.customersList.get(i).getLicenceNumber()));
                Label phoneNumberLabel = new Label(InventoryManager.customersList.get(i).getPhoneNumber());
                Label ageLabel = new Label(Integer.toString(InventoryManager.customersList.get(i).getAge()));
                Button bookVehicle = new Button("Book");
                setStyling(bookVehicle,100,25);
    
    
                customersBookingPane.add(nameLabel,1,i+1);
                customersBookingPane.add(cnicLabel,2,i+1);
                customersBookingPane.add(licenceLabel,3,i+1);
                customersBookingPane.add(ageLabel,4,i+1);
                customersBookingPane.add(phoneNumberLabel,5,i+1);
                customersBookingPane.add(bookVehicle,6,i+1);
    
                int finalI = i;
                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                bookVehicle.setOnAction(e->
                {
                    //CREATING NODES, LAYOUT AND STYLING THEM
                    Label daysLabel = new Label("Number of Days");
                    TextField daysTf = new TextField();
                    daysTf.setPromptText("Number of Days");
                    GridPane bookPane = new GridPane();
                    Button bookButton = new Button("Book");
                    Button backButton = new Button("Back");
                    setStyling(bookButton,100,25);
                    setStyling(backButton,100,25);

                    //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                    backButton.setOnAction(a->
                    {
                        displayCustomersBooking(stage,scene,index,employee);
                    });

                    bookPane.setAlignment(Pos.CENTER);
                    bookPane.setHgap(5);
                    bookPane.setVgap(5);
                    bookPane.add(daysLabel,0,0);
                    bookPane.add(daysTf,1,0);
                    bookPane.add(bookButton,1,1);
                    bookPane.add(backButton,0,1);
                    ImageView logoView2 = new ImageView(logo);
                    logoView2.setOpacity(0.2);
                    logoView2.setFitHeight(750);
                    logoView2.setFitWidth(800);
                    Group root2 = new Group();
                    logoView2.setFitHeight(750);
                    logoView2.setFitWidth(800);
                    bookPane.setLayoutX(250);
                    bookPane.setLayoutY(350);
                    root2.getChildren().addAll(logoView2,bookPane);
                    Scene bookingScene = new Scene(root2,810,750);
                    stage.setScene(bookingScene);

                    //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                    bookButton.setOnAction(a->
                    {
                        //EXCEPTION HANDLING FOR INVALID AND INCORRECT INPUTS
                        try {
                            RentalManager.rentCar(InventoryManager.vehiclesList.get(index), InventoryManager.customersList.get(finalI), Integer.parseInt(daysTf.getText()),employee);
                            displayVehicles(stage,scene,employee);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Vehicle Rented Successfully");
                            alert.setTitle("Vehicle Rented");
                            alert.show();
                        }
                        catch (NumberFormatException o)
                        {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Invalid Input");
                            alert.setContentText("Incorrect Datatype Entered or a Field left Empty");
                            alert.show();
                            daysTf.setText("");
                        }
                    });
                }
                );
            }

            //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
            addCustomer.setOnAction(e->
            {
                //CREATING NODES, LAYOUT AND STYLING THEM
                Label nameLabel = new Label("Name");
                Label cnicLabel = new Label("CNIC");
                Label licenceLabel = new Label("Licence Number");
                Label phoneNumberLabel = new Label("Phone Number");
                Label ageLabel = new Label("Age");
    
                TextField nameField = new TextField();
                nameField.setPromptText("Name");
                TextField cnicField = new TextField();
                cnicField.setPromptText("CNIC ");
                TextField licenceField = new TextField();
                licenceField.setPromptText("Licence Number");
                TextField phoneNumberField = new TextField();
                phoneNumberField.setPromptText("Phone Number ");
                TextField ageField = new TextField();
                ageField.setPromptText("Age ");
    
                Button back = new Button("Back");
                Button addCustomerButton = new Button("Add Customer");
                setStyling(addCustomerButton,100,25);
                setStyling(back,100,25);
    
    
                GridPane addCustomerPane = new GridPane();
                addCustomerPane.setVgap(5);
                addCustomerPane.setHgap(5);
                addCustomerPane.setAlignment(Pos.CENTER);
    
                addCustomerPane.add(nameLabel,0,0);
                addCustomerPane.add(cnicLabel,0,1);
                addCustomerPane.add(licenceLabel,0,2);
                addCustomerPane.add(ageLabel,0,3);
                addCustomerPane.add(phoneNumberLabel,0,4);
                addCustomerPane.add(addCustomerButton,1,5);
                addCustomerPane.add(back,0,5);
    
                addCustomerPane.add(nameField,1,0);
                addCustomerPane.add(cnicField,1,1);
                addCustomerPane.add(licenceField,1,2);
                addCustomerPane.add(ageField,1,3);
                addCustomerPane.add(phoneNumberField,1,4);
    
                ImageView logoView2 = new ImageView(logo);
                logoView2.setOpacity(0.2);
                logoView2.setFitHeight(750);
                logoView2.setFitWidth(800);
                Group root2 = new Group();
                logoView2.setFitHeight(750);
                logoView2.setFitWidth(800);
                addCustomerPane.setLayoutX(250);
                addCustomerPane.setLayoutY(280);
                root2.getChildren().addAll(logoView2,addCustomerPane);
                Scene addCustomerScene = new Scene(root2,810,750);
                stage.setScene(addCustomerScene);

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                back.setOnAction(a->
                {
                    displayCustomersBooking(stage,scene,index,employee);
                });

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                addCustomerButton.setOnAction(a->
                {
                    //EXCEPTION HANDLING FOR INVALID AND INCORRECT INPUTS
                    try
                    {
                        InventoryManager.addCustomer(new Customer(nameField.getText(),cnicField.getText(),Integer.parseInt(licenceField.getText()),Integer.parseInt(ageField.getText()),phoneNumberField.getText()));
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Customer Added Successfully");
                        alert.setTitle("Customer Added");
                        alert.show();
                        displayCustomersBooking(stage,scene,index,GetData.getEmployee(cnicField.getText()));
                    }
                    catch (UnderAgeException o)
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Under Age Customer");
                        alert.setContentText("Cannot add a customer below 18 Years Age");
                        alert.show();
                    }
                    nameField.setText("");
                    cnicField.setText("");
                    licenceField.setText("");
                    ageField.setText("");
                    phoneNumberField.setText("");
                });
            });
            ImageView logoView2 = new ImageView(logo);
            logoView2.setOpacity(0.2);
            logoView2.setFitHeight(750);
            logoView2.setFitWidth(800);
            Group root2 = new Group();
            logoView2.setFitHeight(750);
            logoView2.setFitWidth(800);
            root2.getChildren().addAll(logoView2,customersBookingPane);
            Scene customersBookingScene = new Scene(root2,810,750);
            stage.setScene(customersBookingScene);
        }
    
        public void displayReservations(Stage stage, Scene scene,Employee employee)
        {
            //CREATING NODES, LAYOUT AND STYLING THEM
            GridPane reservationPane = new GridPane();
            Label reservationIdLabel = new Label("Reservation ID");
            reservationIdLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label issuanceDateLabel = new Label("Issuance Date");
            issuanceDateLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label issuedBy = new Label("Issued By");
            issuedBy.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label daysLabel = new Label("Number of Days");
            daysLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label totalCostLabel = new Label("Total Cost");
            totalCostLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label advancePaymentLabel = new Label("Advance Payment");
            advancePaymentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Button backToMenuButton = new Button("Back To Menu");
            setStyling(backToMenuButton,100,25);
            reservationPane.setVgap(5);
            reservationPane.setHgap(5);
            reservationPane.add(reservationIdLabel,1,0);
            reservationPane.add(issuanceDateLabel,2,0);
            reservationPane.add(daysLabel,3,0);
            reservationPane.add(issuedBy,4,0);
            reservationPane.add(totalCostLabel,5,0);
            reservationPane.add(advancePaymentLabel,6,0);
            reservationPane.add(backToMenuButton,1,RentalManager.reservationsList.size()+1);

            //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
            backToMenuButton.setOnAction(e->
            {
                stage.setScene(scene);
            });

            //METHOD FOR ALL THE PREVIOUS RESERVATIONS
            for(int i=0; i<RentalManager.reservationsList.size(); i++) {

                //CREATING NODES, LAYOUT AND STYLING THEM
                Label reservationId = new Label(Integer.toString(RentalManager.reservationsList.get(i).getReservationId()));
                Label issuanceDate = new Label(RentalManager.reservationsList.get(i).getDate().toString());
                Label days = new Label(Integer.toString(RentalManager.reservationsList.get(i).getDays()));
                Label totalCost = new Label("Rs. "+(formatter.format(RentalManager.reservationsList.get(i).getTotalCost())));
                Label advancePayment = new Label("Rs. "+(formatter.format(RentalManager.reservationsList.get(i).getAdvancePayment())));
                Label issuingEmployee = new Label(RentalManager.reservationsList.get(i).getEmployee().getEmployeeName());
                Button displayInvoice = new Button("Display Invoice");
                Button returnButton = new Button("Return");
                if (employee.isManager())
                {
                    returnButton.setVisible(false);
                }
                setStyling(displayInvoice,100,25);
                setStyling(returnButton,100,25);


                reservationPane.add(reservationId, 1, i + 1);
                reservationPane.add(issuanceDate, 2, i + 1);
                reservationPane.add(issuingEmployee, 4, i + 1);
                reservationPane.add(days, 3, i + 1);
                reservationPane.add(totalCost, 5, i + 1);
                reservationPane.add(advancePayment, 6, i + 1);
    
                if(!RentalManager.reservationsList.get(i).isReturned())
                {
                    reservationPane.add(returnButton,8,i+1);
                    reservationPane.add(displayInvoice, 7, i + 1);
                }
                else
                {
                    //IF THE CAR IS RETURNED, PRINT RETURN DATE
                    Label returnLabel = new Label("Return Date");
                    returnLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    Label returnDate = new Label(RentalManager.reservationsList.get(i).getReturnDate().toString());
                    reservationPane.add(returnDate,7,i+1);
                    reservationPane.add(returnLabel,7,0);
                    reservationPane.add(displayInvoice, 8, i + 1);
                }
    
                int finalI = i;

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                returnButton.setOnAction(a->
                {
                    //EXCEPTION HANDLING FOR INVALID AND INCORRECT INPUTS
                    try {
                        RentalManager.returnCar(RentalManager.reservationsList.get(finalI));
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Vehicle Returned Successfully");
                        alert.setTitle("Vehicle Returned");
                        alert.show();
                    }
                    catch (ReturnedBeforeDeadlineException o)
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        long remainingDays = ChronoUnit.DAYS.between(LocalDate.now(), RentalManager.reservationsList.get(finalI).getDate().plusDays(RentalManager.reservationsList.get(finalI).getDays()));
                        double remainingRefund = remainingDays * RentalManager.reservationsList.get(finalI).getVehicle().getDailyTotal();
                        alert.setContentText("Car returned Early"+"\n"+"Remaining Days: "+remainingDays+"\n"+"Remaining Refund: "+formatter.format(remainingRefund));
                        alert.setTitle("Early Return");
                        RentalManager.reservationsList.get(finalI).setDays((int) ((RentalManager.reservationsList.get(finalI).getDays())-remainingDays));
                        RentalManager.reservationsList.get(finalI).setTotalCost((RentalManager.reservationsList.get(finalI).getAdvancePayment()/0.7)*RentalManager.reservationsList.get(finalI).getDays());
                        Finance.depositAmount(RentalManager.reservationsList.get(finalI).getTotalCost(),"Total Rent of "+RentalManager.reservationsList.get(finalI).getVehicle().getCompanyName()+" "+RentalManager.reservationsList.get(finalI).getVehicle().getVehicleName()+" Reservation# "+RentalManager.reservationsList.get(finalI).getReservationId());
                        Finance.withdrawAmount(RentalManager.reservationsList.get(finalI).getAdvancePayment(),"Returning Advance of "+RentalManager.reservationsList.get(finalI).getVehicle().getCompanyName()+" "+RentalManager.reservationsList.get(finalI).getVehicle().getVehicleName()+" Reservation# "+RentalManager.reservationsList.get(finalI).getReservationId());
                        alert.show();
                    }
                    catch (LateReturnException o)
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        long extraDays = ChronoUnit.DAYS.between(RentalManager.reservationsList.get(finalI).getDate().plusDays(RentalManager.reservationsList.get(finalI).getDays()), LocalDate.now());
                        RentalManager.reservationsList.get(finalI).setDays((int) (extraDays+(RentalManager.reservationsList.get(finalI).getDays())));
                        Finance.depositAmount(RentalManager.reservationsList.get(finalI).getTotalCost() - RentalManager.reservationsList.get(finalI).getAdvancePayment(),"Remaining Payment For "+RentalManager.reservationsList.get(finalI).getVehicle().getCompanyName()+" "+RentalManager.reservationsList.get(finalI).getVehicle().getVehicleName()+" Reservation# "+RentalManager.reservationsList.get(finalI).getReservationId());
                        Finance.depositAmount((extraDays * RentalManager.reservationsList.get(finalI).getVehicle().getDailyTotal()),"Extra Days Late Submission Fee for "+RentalManager.reservationsList.get(finalI).getVehicle().getCompanyName()+" "+RentalManager.reservationsList.get(finalI).getVehicle().getVehicleName()+" Reservation# "+RentalManager.reservationsList.get(finalI).getReservationId());
                        RentalManager.reservationsList.get(finalI).setTotalCost((RentalManager.reservationsList.get(finalI).getTotalCost() + extraDays * RentalManager.reservationsList.get(finalI).getVehicle().getDailyTotal()));
                        alert.setContentText("Car returned Late"+"\n"+"Extra Days:"+extraDays+"\n"+"Extra Amount: "+formatter.format(extraDays * RentalManager.reservationsList.get(finalI).getVehicle().getDailyTotal())+"\n"+"New Total Cost: "+formatter.format(RentalManager.reservationsList.get(finalI).getTotalCost()));
                        alert.setTitle("Late Return");
                        alert.show();
                    }
                    finally {
                        double commission = RentalManager.reservationsList.get(finalI).getTotalCost()*0.2;
                        if(commission>0)
                        {
                            RentalManager.reservationsList.get(finalI).getEmployee().setCommission(commission+RentalManager.reservationsList.get(finalI).getEmployee().getCommission());
                            Finance.withdrawAmount(commission,"Commission to "+RentalManager.reservationsList.get(finalI).getEmployee().getEmployeeName()+" for Reservation# "+RentalManager.reservationsList.get(finalI).getReservationId());
                        }
                        RentalManager.reservationsList.get(finalI).setReturned(true);
                        RentalManager.reservationsList.get(finalI).setReturnDate(LocalDate.now());
                        RentalManager.reservationsList.get(finalI).getVehicle().setAvailable(true);
                        InventoryManager.updateReservation();
                        InventoryManager.updateVehicleInformation();
                        InventoryManager.updateEmployeeInformation();
                        displayReservations(stage,scene,employee);
                    }
                });
    
                int finalI1 = i;

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                displayInvoice.setOnAction(a->
                {
                    //CREATING NODES, LAYOUT AND STYLING THEM
                    Label Date = new Label("Date: "+LocalDate.now());
                    Label vehicleDataLabel = new Label("VEHICLE DATA");
                    Label typeLabel = new Label("Vehicle Type: "+GetData.getVehicleType(RentalManager.reservationsList.get(finalI1).getVehicle()));
                    Label companyNameLabel = new Label("Company Name: "+RentalManager.reservationsList.get(finalI1).getVehicle().getCompanyName());
                    Label nameLabel = new Label("Vehicle Name: "+RentalManager.reservationsList.get(finalI1).getVehicle().getVehicleName());
                    Label yearLabel = new Label("Model Year: "+RentalManager.reservationsList.get(finalI1).getVehicle().modelYear);
                    Label dailyRateLabel = new Label("Daily Rate: Rs. "+formatter.format(RentalManager.reservationsList.get(finalI1).getVehicle().getDailyRate()));
                    Label dailyTaxLabel = new Label("Daily Tax: Rs. "+formatter.format(RentalManager.reservationsList.get(finalI1).getVehicle().getTax()));
                    Label dailyTotalLabel = new Label("Total Daily Rate: Rs. "+formatter.format(RentalManager.reservationsList.get(finalI1).getVehicle().getDailyTotal()));
                    Label engineSizeLabel = new Label("Engine Size: "+RentalManager.reservationsList.get(finalI1).getVehicle().getEngineSize()+" CC");
                    Label numberPlateLabel = new Label("Number Plate: "+RentalManager.reservationsList.get(finalI1).getVehicle().getNumberPlate());

                    Label customerNameLabel = new Label("Name: "+RentalManager.reservationsList.get(finalI1).getCustomer().getCustomerName());
                    Label cnicLabel = new Label("CNIC: "+RentalManager.reservationsList.get(finalI1).getCustomer().getCnic());
                    Label licenceLabel = new Label("Licence Number: "+RentalManager.reservationsList.get(finalI1).getCustomer().getLicenceNumber());
                    Label ageLabel = new Label("Age: "+RentalManager.reservationsList.get(finalI1).getCustomer().getAge());
                    Label phoneNumberLabel = new Label("Phone Number: "+RentalManager.reservationsList.get(finalI1).getCustomer().getPhoneNumber());

                    Label reservationIdLabel1 = new Label("Reservation Id: "+RentalManager.reservationsList.get(finalI).getReservationId());
                    Label issueDateLabel = new Label("Issue Date: "+RentalManager.reservationsList.get(finalI).getDate());
                    Label daysLabel1 = new Label("Days Issued For: "+RentalManager.reservationsList.get(finalI).getDays());
                    Label totalCostLabel1 = new Label("Total Cost: Rs."+formatter.format(RentalManager.reservationsList.get(finalI).getTotalCost()));
                    Label advancePaymentLabel1 = new Label("Advance Payment: Rs."+formatter.format(RentalManager.reservationsList.get(finalI).getAdvancePayment()));
                    Button backButton = new Button("Back to Reservations");

                    Date.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                    vehicleDataLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));

                    Date.setTextFill(Color.rgb(92, 51, 51));
                    vehicleDataLabel.setTextFill(Color.rgb(245, 209, 131));

                    Label vehicleSectionLabel = new Label("VEHICLE INFORMATION");
                    Label customerSectionLabel = new Label("CUSTOMER INFORMATION");
                    Label reservationSectionLabel = new Label("RESERVATION DETAILS");

                    vehicleSectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                    customerSectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                    reservationSectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

                    Label employeeSectionLabel = new Label("EMPLOYEE INFORMATION");
                    employeeSectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                    Label employeeNameLabel = new Label("Name: " + RentalManager.reservationsList.get(finalI1).getEmployee().getEmployeeName());
                    Label employeeIdLabel = new Label("Employee ID: " + RentalManager.reservationsList.get(finalI1).getEmployee().getEmployeeId());
                    Label employeeCnicLabel = new Label("CNIC: " + RentalManager.reservationsList.get(finalI1).getEmployee().getCnic());
                    Label employeeAgeLabel = new Label("Age: " + RentalManager.reservationsList.get(finalI1).getEmployee().getAge());
                    Label employeePhoneNumberLabel = new Label("Phone Number: " + RentalManager.reservationsList.get(finalI1).getEmployee().getPhoneNumber());
                    Label employeeCommissionLabel = new Label("Commission: Rs. " + formatter.format(RentalManager.reservationsList.get(finalI).getTotalCost()*0.2));
                    Label invoiceGenerator = new Label("Invoice Generated By: " +employee.getEmployeeName());
                    invoiceGenerator.setFont(Font.font("Arial", FontWeight.BOLD, 14));

                    VBox vBox1 = new VBox(20,vehicleSectionLabel,
                            typeLabel, companyNameLabel, nameLabel, yearLabel, numberPlateLabel,
                            engineSizeLabel, dailyRateLabel, dailyTaxLabel, dailyTotalLabel);
                    VBox vBox2 = new VBox(20,customerSectionLabel,
                            customerNameLabel, cnicLabel, licenceLabel, ageLabel, phoneNumberLabel,backButton);
                    VBox vBox3 = new VBox(20,employeeSectionLabel,employeeIdLabel,employeeNameLabel,employeeCnicLabel,employeeAgeLabel,employeePhoneNumberLabel,employeeCommissionLabel);
                    VBox vBox4 = new VBox(20,reservationSectionLabel,
                            reservationIdLabel1, issueDateLabel, daysLabel1, totalCostLabel1, advancePaymentLabel1);

                    if (RentalManager.reservationsList.get(finalI).isReturned()) {

                        //IF THE CAR IS RETURNED, WE PRINT THE DATE ON INVOICE
                        Label returnDateLabel = new Label("Return Date: " + RentalManager.reservationsList.get(finalI).getReturnDate());
                        vBox4.getChildren().add(returnDateLabel);
                    }

                    //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                    backButton.setOnAction(b->
                    {
                        displayReservations(stage,scene,employee);
                    });
                    setStyling(backButton,150,75);

                    GridPane invoicePane = new GridPane();
                    invoicePane.setHgap(30);
                    invoicePane.setVgap(15);
                    invoicePane.add(Date,0,0);
                    invoicePane.add(invoiceGenerator,1,0);
                    invoicePane.add(vBox1,0,1);
                    invoicePane.add(vBox4,1,1);
                    invoicePane.add(vBox3,0,2);
                    invoicePane.add(vBox2,1,2);
                    invoicePane.setAlignment(Pos.CENTER);
                    Scene invoiceScene = new Scene(invoicePane, 810, 750);
    
                    stage.setScene(invoiceScene);
                });
            }

            //SETTING THE RESERVATION SCENE ON STAGE
            ImageView logoView2 = new ImageView(logo);
            logoView2.setOpacity(0.2);
            logoView2.setFitHeight(750);
            logoView2.setFitWidth(800);
            Group root2 = new Group();
            root2.getChildren().addAll(logoView2, reservationPane);
            Scene reservationScene = new Scene(root2,810,750);
            stage.setScene(reservationScene);
        }

        public void displayTransactions(Stage stage, Scene scene)
        {
            Button backButton = new Button("Back To Menu");
            setStyling(backButton,100,25);
            backButton.setOnAction(a->
            {
                stage.setScene(scene);
            });
            TableView transactionTableView = new TableView<>();

            TableColumn<Transaction , String> transactionDate = new TableColumn<>("Transaction Date");
            transactionDate.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));

            TableColumn<Transaction , String> transactionInfo = new TableColumn<>("Transaction Information");
            transactionInfo.setCellValueFactory(new PropertyValueFactory<>("transactionInfo"));

            TableColumn<Transaction , Double> credit = new TableColumn<>("Credit");
            credit.setCellValueFactory(new PropertyValueFactory<>("credit"));

            TableColumn<Transaction , Double> debit = new TableColumn<>("Debit");
            debit.setCellValueFactory(new PropertyValueFactory<>("debit"));

            transactionTableView.getColumns().addAll(transactionDate, transactionInfo, credit, debit);
            transactionTableView.setItems(FXCollections.observableArrayList(Finance.transactionsList));
            transactionTableView.prefWidthProperty().bind(stage.widthProperty());

            Label totalCostLabel = new Label("Current Balance = Rs. "+Finance.getAccountBalance());
            totalCostLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            HBox hbox = new HBox(5);
            hbox.getChildren().addAll(backButton,totalCostLabel);
            VBox transactionsPane = new VBox(5);
            transactionsPane.getChildren().addAll(transactionTableView,hbox);
            ImageView logoView2 = new ImageView(logo);
            logoView2.setOpacity(0.2);
            logoView2.setFitHeight(750);
            logoView2.setFitWidth(800);
            Group root2 = new Group();
            root2.getChildren().addAll(logoView2, transactionsPane);
            Scene transactionScene = new Scene(root2,810,750);
            stage.setScene(transactionScene);
        }

        public void displayEmployees(Stage stage, Scene scene)
        {
            //CREATING NODES, LAYOUT AND STYLING THEM
            GridPane employeesPane = new GridPane();
            Label nameBarLabel = new Label("Name");
            nameBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label cnicBarLabel = new Label("CNIC");
            cnicBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label phoneNumberBarLabel = new Label("Phone Number");
            phoneNumberBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label ageBarLabel = new Label("Age");
            ageBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label employeeIdLabel = new Label("Employee Id");
            employeeIdLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Label commisionBarLabel = new Label("Total Commission");
            commisionBarLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            Button backToMenuButton = new Button("Back To Menu");
            Button hireEmployee = new Button("Hire New Employee");
            setStyling(hireEmployee,100,25);
            setStyling(backToMenuButton,100,25);

            employeesPane.setVgap(5);
            employeesPane.setHgap(5);
            employeesPane.add(nameBarLabel,1,0);
            employeesPane.add(employeeIdLabel,2,0);
            employeesPane.add(cnicBarLabel,3,0);
            employeesPane.add(ageBarLabel,4,0);
            employeesPane.add(phoneNumberBarLabel,5,0);
            employeesPane.add(commisionBarLabel,6,0);
            employeesPane.add(backToMenuButton,1,InventoryManager.employeesList.size());
            employeesPane.add(hireEmployee,2,InventoryManager.employeesList.size());

            //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
            backToMenuButton.setOnAction(e->
            {
                stage.setScene(scene);
            });

            //LOOP FOR ALL THE employeeS IN THE RECORD
            for(int i=1; i<InventoryManager.employeesList.size(); i++)
            {
                //CREATING NODES, LAYOUT AND STYLING THEM
                Label nameLabel = new Label(InventoryManager.employeesList.get(i).getEmployeeName());
                Label cnicLabel = new Label(InventoryManager.employeesList.get(i).getCnic());
                Label employeeId = new Label(Integer.toString(InventoryManager.employeesList.get(i).getEmployeeId()));
                Label phoneNumberLabel = new Label(InventoryManager.employeesList.get(i).getPhoneNumber());
                Label ageLabel = new Label(Integer.toString(InventoryManager.employeesList.get(i).getAge()));
                Label commissionLabel = new Label(Double.toString(InventoryManager.employeesList.get(i).getCommission()));
                Button fireEmployee = new Button("Fire Employee");
                setStyling(fireEmployee,100,25);


                employeesPane.add(nameLabel,1,i);
                employeesPane.add(employeeId,2,i);
                employeesPane.add(cnicLabel,3,i);
                employeesPane.add(ageLabel,4,i);
                employeesPane.add(phoneNumberLabel,5,i);
                employeesPane.add(commissionLabel,6,i);
                employeesPane.add(fireEmployee,7,i);

                int finalI = i;
                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                fireEmployee.setOnAction(e->
                {
                    InventoryManager.removeEmployee(InventoryManager.employeesList.get(finalI));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Employee Fired");
                    alert.setTitle("Employee Fired");
                    alert.show();
                    displayEmployees(stage,scene);
                });
            }

            //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
            hireEmployee.setOnAction(e->
            {
                //CREATING NODES, LAYOUT AND STYLING THEM
                Label nameLabel = new Label("Name");
                Label cnicLabel = new Label("CNIC");
                Label phoneNumberLabel = new Label("Phone Number");
                Label ageLabel = new Label("Age");

                TextField nameField = new TextField();
                nameField.setPromptText("Name ");
                TextField cnicField = new TextField();
                cnicField.setPromptText("CNIC ");
                TextField phoneNumberField = new TextField();
                phoneNumberField.setPromptText("Phone Number");
                TextField ageField = new TextField();
                ageField.setPromptText("Age ");

                Button back = new Button("Back");
                Button addemployeeButton = new Button("Hire Employee");
                setStyling(back,100,25);
                setStyling(addemployeeButton,100,25);


                GridPane employeePane = new GridPane();
                employeePane.setVgap(5);
                employeePane.setHgap(5);
                employeePane.setAlignment(Pos.CENTER);

                employeePane.add(nameLabel,0,0);
                employeePane.add(cnicLabel,0,1);
                employeePane.add(ageLabel,0,2);
                employeePane.add(phoneNumberLabel,0,3);
                employeePane.add(addemployeeButton,1,4);
                employeePane.add(back,0,4);

                employeePane.add(nameField,1,0);
                employeePane.add(cnicField,1,1);
                employeePane.add(ageField,1,2);
                employeePane.add(phoneNumberField,1,3);
                ImageView logoView2 = new ImageView(logo);
                logoView2.setOpacity(0.2);
                logoView2.setFitHeight(750);
                logoView2.setFitWidth(800);
                Group root2 = new Group();
                logoView2.setFitHeight(750);
                logoView2.setFitWidth(800);
                employeePane.setLayoutX(250);
                employeePane.setLayoutY(280);
                root2.getChildren().addAll(logoView2,employeePane);
                stage.setScene(new Scene(root2,810,750));

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                back.setOnAction(a->
                {
                    displayEmployees(stage,scene);
                });

                //FUNCTIONALITY OF THE BUTTON BY LAMBDA EXPRESSION
                addemployeeButton.setOnAction(a->
                {
                    //EXCEPTION HANDLING FOR INVALID AND INCORRECT INPUTS
                    try
                    {
                        InventoryManager.addEmployee(new Employee(nameField.getText(),cnicField.getText(),Integer.parseInt(ageField.getText()),phoneNumberField.getText(),new Login("admin","","")));
                        displayEmployees(stage,scene);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Employee Hired Successfully");
                        alert.setTitle("Employee Hired");
                        alert.show();
                    }
                    catch (UnderAgeException o)
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Under Age Employee");
                        alert.setContentText("Cannot hire an Employee below 18 Years Age");
                        alert.show();
                    }
                    nameField.setText("");
                    cnicField.setText("");
                    ageField.setText("");
                    phoneNumberField.setText("");
                });
            });
            ImageView logoView2 = new ImageView(logo);
            logoView2.setOpacity(0.2);
            logoView2.setFitHeight(750);
            logoView2.setFitWidth(800);
            Group root2 = new Group();
            logoView2.setFitHeight(750);
            logoView2.setFitWidth(800);
            root2.getChildren().addAll(logoView2,employeesPane);
            Scene employeesScene = new Scene(root2,810,750);
            stage.setScene(employeesScene);
        }

        //METHOD FOR STYLING AND HOVERING EFFECT
        public void setStyling(Button button,int sizeX,int sizeY)
        {
            button.setStyle("-fx-background-color: #f5d183;");
            button.setTextFill(Color.web("#5c3333"));
            button.setMinSize(sizeX, sizeY);
            Stream.of(button)
                    .forEach(btn -> {
                        String originalColor = button.getStyle();
                        button.setOnMouseEntered(v -> button.setStyle("-fx-background-color: #fff9ee;"));
                        button.setOnMouseExited(v -> button.setStyle(originalColor));
                    });
        }
    }