package grupo05abd.modelo;

public class Account {

private int accountId;
    private String accountName;
    private double balance;
    private int accountType;
    private int currencyType;
    private int userId;

    // Constructor
    public Account(int accountId, String accountName, double balance, int accountType, int currencyType, int userId) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
        this.accountType = accountType;
        this.currencyType = currencyType;
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(int currencyType) {
        this.currencyType = currencyType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
