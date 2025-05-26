package grupo05abd.modelo;

import java.sql.Date;

public class Debt {

private int debtId;
    private double totalDebt;
    private double pendingBalance;
    private double interestRate;
    private Date startDate;
    private String debtDescription; // Nullable
    private int debtTypeId;
    private int userId;

    public Debt(int debtId, double totalDebt, double pendingBalance, double interestRate,
                Date startDate, String debtDescription, int debtTypeId, int userId) {
        this.debtId = debtId;
        this.totalDebt = totalDebt;
        this.pendingBalance = pendingBalance;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.debtDescription = debtDescription;
        this.debtTypeId = debtTypeId;
        this.userId = userId;
    }

    public int getDebtId() {
        return debtId;
    }

    public void setDebtId(int debtId) {
        this.debtId = debtId;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    public double getPendingBalance() {
        return pendingBalance;
    }

    public void setPendingBalance(double pendingBalance) {
        this.pendingBalance = pendingBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDebtDescription() {
        return debtDescription;
    }

    public void setDebtDescription(String debtDescription) {
        this.debtDescription = debtDescription;
    }

    public int getDebtTypeId() {
        return debtTypeId;
    }

    public void setDebtTypeId(int debtTypeId) {
        this.debtTypeId = debtTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
