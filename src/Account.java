// Abstract class representing an account
public abstract class Account {

    // Static variable to store the account balance
    private static long accountBalance;

    // Getter method to retrieve the account balance
    public static long getAccountBalance() {
        return accountBalance;
    }

    // Setter method to set the account balance
    public static void setAccountBalance(long accountBalance) {
        Account.accountBalance = accountBalance;
    }

    // Method to withdraw a specified amount from the account
    public static void withdrawAmount(double amount) {
        if (amount <= accountBalance) {
            setAccountBalance(getAccountBalance()-(long) amount);
        }
    }

    // Method to deposit a specified amount into the account
    public static void depositAmount(double amount) {
        setAccountBalance(getAccountBalance()+(long) amount);
    }
}