package grupo05abd.modelo;

public class AccountType {

    private int accountTypeId;
    private String typeName;
    private String accountTypeDescription;

    // Constructor
    public AccountType(int accountTypeId, String typeName, String accountTypeDescription) {
        this.accountTypeId = accountTypeId;
        this.typeName = typeName;
        this.accountTypeDescription = accountTypeDescription;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAccountTypeDescription() {
        return accountTypeDescription;
    }

    public void setAccountTypeDescription(String accountTypeDescription) {
        this.accountTypeDescription = accountTypeDescription;
    }



}
