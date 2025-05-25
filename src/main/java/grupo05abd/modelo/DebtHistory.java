package grupo05abd.modelo;

import java.sql.Date;


public class DebtHistory {

private int debtHistoryId;
    private Date movementDate;
    private String debtHistoryDescription; // Nullable
    private int debtId;
    private Integer transactionId; // Nullable

    public DebtHistory(int debtHistoryId, Date movementDate, String debtHistoryDescription, int debtId, Integer transactionId) {
        this.debtHistoryId = debtHistoryId;
        this.movementDate = movementDate;
        this.debtHistoryDescription = debtHistoryDescription;
        this.debtId = debtId;
        this.transactionId = transactionId;
    }

    public int getDebtHistoryId() {
        return debtHistoryId;
    }

    public void setDebtHistoryId(int debtHistoryId) {
        this.debtHistoryId = debtHistoryId;
    }

    public Date getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(Date movementDate) {
        this.movementDate = movementDate;
    }

    public String getDebtHistoryDescription() {
        return debtHistoryDescription;
    }

    public void setDebtHistoryDescription(String debtHistoryDescription) {
        this.debtHistoryDescription = debtHistoryDescription;
    }

    public int getDebtId() {
        return debtId;
    }

    public void setDebtId(int debtId) {
        this.debtId = debtId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    

}
