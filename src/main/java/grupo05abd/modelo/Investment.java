package grupo05abd.modelo;

import java.sql.Date;

public class Investment {

    private int investmentId;
    private double investedAmount;
    private double interestRate;
    private double currentValue;
    private Date startDate;
    private String investmentDescription; // Nullable
    private Integer investmentTypeId;     // Nullable
    private Integer interestTypeId;       // Nullable
    private int accountId;                // Reemplaza a userId

    public Investment(int investmentId, double investedAmount, double interestRate, double currentValue,
                      Date startDate, String investmentDescription, Integer investmentTypeId,
                      Integer interestTypeId, int accountId) {
        this.investmentId = investmentId;
        this.investedAmount = investedAmount;
        this.interestRate = interestRate;
        this.currentValue = currentValue;
        this.startDate = startDate;
        this.investmentDescription = investmentDescription;
        this.investmentTypeId = investmentTypeId;
        this.interestTypeId = interestTypeId;
        this.accountId = accountId;
    }

    public int getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(int investmentId) {
        this.investmentId = investmentId;
    }

    public double getInvestedAmount() {
        return investedAmount;
    }

    public void setInvestedAmount(double investedAmount) {
        this.investedAmount = investedAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getInvestmentDescription() {
        return investmentDescription;
    }

    public void setInvestmentDescription(String investmentDescription) {
        this.investmentDescription = investmentDescription;
    }

    public Integer getInvestmentTypeId() {
        return investmentTypeId;
    }

    public void setInvestmentTypeId(Integer investmentTypeId) {
        this.investmentTypeId = investmentTypeId;
    }

    public Integer getInterestTypeId() {
        return interestTypeId;
    }

    public void setInterestTypeId(Integer interestTypeId) {
        this.interestTypeId = interestTypeId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
