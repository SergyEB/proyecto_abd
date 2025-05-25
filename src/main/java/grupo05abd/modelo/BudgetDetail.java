package grupo05abd.modelo;

public class BudgetDetail {

private int budgetDetailId;
    private double estimatedBudget;
    private int budgetId;
    private Integer transactionSubcategoryId; // Nullable

    public BudgetDetail(int budgetDetailId, double estimatedBudget, int budgetId, Integer transactionSubcategoryId) {
        this.budgetDetailId = budgetDetailId;
        this.estimatedBudget = estimatedBudget;
        this.budgetId = budgetId;
        this.transactionSubcategoryId = transactionSubcategoryId;
    }

    public int getBudgetDetailId() {
        return budgetDetailId;
    }

    public void setBudgetDetailId(int budgetDetailId) {
        this.budgetDetailId = budgetDetailId;
    }

    public double getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(double estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public Integer getTransactionSubcategoryId() {
        return transactionSubcategoryId;
    }

    public void setTransactionSubcategoryId(Integer transactionSubcategoryId) {
        this.transactionSubcategoryId = transactionSubcategoryId;
    }

    
}
