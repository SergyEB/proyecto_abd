package grupo05abd.modelo;

import java.sql.Date;

public class Transaction {

private int transactionId;
    private double amount;
    private Date transactionDate;
    private String description; // Nullable
    private int accountId;
    private int transactionTypeId;
    private Integer transactionSubcategoryId; // Nullable

    public Transaction(int transactionId, double amount, Date transactionDate, String description,
                       int accountId, int transactionTypeId, Integer transactionSubcategoryId) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
        this.accountId = accountId;
        this.transactionTypeId = transactionTypeId;
        this.transactionSubcategoryId = transactionSubcategoryId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Integer getTransactionSubcategoryId() {
        return transactionSubcategoryId;
    }

    public void setTransactionSubcategoryId(Integer transactionSubcategoryId) {
        this.transactionSubcategoryId = transactionSubcategoryId;
    }

    

}
