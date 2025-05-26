package grupo05abd.modelo;

public class InterestType {

private int interestTypeId;
    private String interestName;
    private String interestTypeDescription; // Nullable

    public InterestType(int interestTypeId, String interestName, String interestTypeDescription) {
        this.interestTypeId = interestTypeId;
        this.interestName = interestName;
        this.interestTypeDescription = interestTypeDescription;
    }

    public int getInterestTypeId() {
        return interestTypeId;
    }

    public void setInterestTypeId(int interestTypeId) {
        this.interestTypeId = interestTypeId;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public String getInterestTypeDescription() {
        return interestTypeDescription;
    }

    public void setInterestTypeDescription(String interestTypeDescription) {
        this.interestTypeDescription = interestTypeDescription;
    }

    
}
