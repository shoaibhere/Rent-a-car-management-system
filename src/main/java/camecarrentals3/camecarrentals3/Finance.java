package camecarrentals3.camecarrentals3;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

// Abstract class representing an account
public abstract class Finance implements Serializable {

    // Static variable to store the account balance
    public static ArrayList<Transaction> transactionsList = new ArrayList<>();
    private static long accountBalance=0;

    // Getter method to retrieve the account balance
    public static long getAccountBalance() {
        return accountBalance;
    }

    // Setter method to set the account balance
    public static void setAccountBalance(long accountBalance) {
        Finance.accountBalance = accountBalance;
        FileHandler.writeFinanceDataOnFile();
    }

    // Method to withdraw a specified amount from the account
    public static void withdrawAmount(double amount,String transactionInfo) {
        if (amount <= accountBalance) {
            accountBalance-=(long) amount;
            InventoryManager.addTransaction(new Transaction(transactionInfo,LocalDate.now(),Double.parseDouble(RentACarManagementSystem.formatter.format(amount)),false));
            FileHandler.writeFinanceDataOnFile();
        }
        else if(amount > accountBalance)
        {
            throw new InsufficientAmountException();
        }
        if (amount<0)
        {
            throw new InvalidAmountException();
        }
        if(transactionInfo.equals(""))
        {
            throw new TransactionInfoNotPresentException();
        }
    }

    // Method to deposit a specified amount into the account
    public static void depositAmount(double amount, String transactionInfo) {
        if(transactionInfo.equals(""))
        {
            throw new TransactionInfoNotPresentException();
        }
        if (amount<0)
        {
            throw new InvalidAmountException();
        }
        else
        {
            accountBalance+=(long) amount;
            if (amount>0)
            {
                InventoryManager.addTransaction(new Transaction(transactionInfo,LocalDate.now(),Double.parseDouble(RentACarManagementSystem.formatter.format(amount)),true));
            }
            FileHandler.writeFinanceDataOnFile();
        }
    }
}