package grupo05abd.modelo;

import java.sql.Date;

public class InvestmentHistory {

private int investmentHistoryId;
    private Date recordDate;
    private double value;
    private int investmentId;

    public InvestmentHistory(int investmentHistoryId, Date recordDate, double value, int investmentId) {
        this.investmentHistoryId = investmentHistoryId;
        this.recordDate = recordDate;
        this.value = value;
        this.investmentId = investmentId;
    }

    public int getInvestmentHistoryId() {
        return investmentHistoryId;
    }

    public void setInvestmentHistoryId(int investmentHistoryId) {
        this.investmentHistoryId = investmentHistoryId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(int investmentId) {
        this.investmentId = investmentId;
    }

    

}
