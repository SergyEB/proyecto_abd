package grupo05abd.modelo;

public class TransactionCategory {

private int categoryTransactionId;
    private int category;
    private String categoryName;

    public TransactionCategory(int categoryTransactionId, int category, String categoryName) {
        this.categoryTransactionId = categoryTransactionId;
        this.category = category;
        this.categoryName = categoryName;
    }

    public int getCategoryTransactionId() {
        return categoryTransactionId;
    }

    public void setCategoryTransactionId(int categoryTransactionId) {
        this.categoryTransactionId = categoryTransactionId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    

}
