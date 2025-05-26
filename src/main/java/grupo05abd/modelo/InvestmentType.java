package grupo05abd.modelo;

public class InvestmentType {

private int investmentTypeId;
    private String typeName;
    private String investmentTypeDescription; // Nullable

    public InvestmentType(int investmentTypeId, String typeName, String investmentTypeDescription) {
        this.investmentTypeId = investmentTypeId;
        this.typeName = typeName;
        this.investmentTypeDescription = investmentTypeDescription;
    }

    public int getInvestmentTypeId() {
        return investmentTypeId;
    }

    public void setInvestmentTypeId(int investmentTypeId) {
        this.investmentTypeId = investmentTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getInvestmentTypeDescription() {
        return investmentTypeDescription;
    }

    public void setInvestmentTypeDescription(String investmentTypeDescription) {
        this.investmentTypeDescription = investmentTypeDescription;
    }



}
