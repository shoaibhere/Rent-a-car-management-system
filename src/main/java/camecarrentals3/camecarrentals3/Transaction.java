package camecarrentals3.camecarrentals3;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    private String transactionInfo;
    private LocalDate transactionDate;
    private long credit;
    private long debit;

    public Transaction(String transactionInfo, LocalDate transactionDate, double amount, boolean isDebit) {
        this.transactionInfo = transactionInfo;
        this.transactionDate = transactionDate;
        if (isDebit)
        this.debit = (long) amount;
        else
            this.credit = (long) amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionInfo='" + transactionInfo + '\'' +
                ", transactionDate=" + transactionDate +
                ", credit=" + credit +
                ", debit=" + debit +
                '}';
    }

    public String getTransactionInfo() {
        return transactionInfo;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public long getCredit() {
        return credit;
    }

    public long getDebit() {
        return debit;
    }
}
