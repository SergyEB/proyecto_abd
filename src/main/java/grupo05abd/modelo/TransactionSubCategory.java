package grupo05abd.modelo;

public class TransactionSubCategory {

private int subcategoryId;
    private String subcategoryName;
    private int categoryTransactionId;

    public TransactionSubCategory(int subcategoryId, String subcategoryName, int categoryTransactionId) {
        this.subcategoryId = subcategoryId;
        this.subcategoryName = subcategoryName;
        this.categoryTransactionId = categoryTransactionId;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public int getCategoryTransactionId() {
        return categoryTransactionId;
    }

    public void setCategoryTransactionId(int categoryTransactionId) {
        this.categoryTransactionId = categoryTransactionId;
    }


    
}
