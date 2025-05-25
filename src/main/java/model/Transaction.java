package model;

import java.sql.Timestamp;

public class Transaction {
    private int id;
    private int accountId;
    private String transactionType; // "DEPOSIT" or "WITHDRAW"
    private double amount;
    private Timestamp transactionDate;

    public Transaction(int accountId, String transactionType, double amount) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }
}
