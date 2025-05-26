package grupo05abd.modelo;

public class DebtType {

private int debtTypeId;
    private String typeName;
    private String debtTypeDescription; // Nullable

    public DebtType(int debtTypeId, String typeName, String debtTypeDescription) {
        this.debtTypeId = debtTypeId;
        this.typeName = typeName;
        this.debtTypeDescription = debtTypeDescription;
    }

    public int getDebtTypeId() {
        return debtTypeId;
    }

    public void setDebtTypeId(int debtTypeId) {
        this.debtTypeId = debtTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDebtTypeDescription() {
        return debtTypeDescription;
    }

    public void setDebtTypeDescription(String debtTypeDescription) {
        this.debtTypeDescription = debtTypeDescription;
    }


}
