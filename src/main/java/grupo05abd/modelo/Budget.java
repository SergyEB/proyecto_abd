package grupo05abd.modelo;
import java.sql.Date;

public class Budget {

private int budgetId;
    private String name;
    private double totalAllocated;
    private Date startBudget;
    private Date endBudget; // Nullable
    private int userId;
    private Integer budgetStatus; // Nullable

    public Budget(int budgetId, String name, double totalAllocated, Date startBudget, Date endBudget, int userId, Integer budgetStatus) {
        this.budgetId = budgetId;
        this.name = name;
        this.totalAllocated = totalAllocated;
        this.startBudget = startBudget;
        this.endBudget = endBudget;
        this.userId = userId;
        this.budgetStatus = budgetStatus;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalAllocated() {
        return totalAllocated;
    }

    public void setTotalAllocated(double totalAllocated) {
        this.totalAllocated = totalAllocated;
    }

    public Date getStartBudget() {
        return startBudget;
    }

    public void setStartBudget(Date startBudget) {
        this.startBudget = startBudget;
    }

    public Date getEndBudget() {
        return endBudget;
    }

    public void setEndBudget(Date endBudget) {
        this.endBudget = endBudget;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getBudgetStatus() {
        return budgetStatus;
    }

    public void setBudgetStatus(Integer budgetStatus) {
        this.budgetStatus = budgetStatus;
    }

}
