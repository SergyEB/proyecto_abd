package grupo05abd.modelo;

public class TransactionType {

private int transactionTypeId;
    private String typeName;
    private String transactionTypeDescription; // Nullable

    public TransactionType(int transactionTypeId, String typeName, String transactionTypeDescription) {
        this.transactionTypeId = transactionTypeId;
        this.typeName = typeName;
        this.transactionTypeDescription = transactionTypeDescription;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTransactionTypeDescription() {
        return transactionTypeDescription;
    }

    public void setTransactionTypeDescription(String transactionTypeDescription) {
        this.transactionTypeDescription = transactionTypeDescription;
    }



}
