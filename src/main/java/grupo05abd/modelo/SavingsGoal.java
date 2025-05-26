package grupo05abd.modelo;

import java.sql.Date;

public class SavingsGoal {

private int savingsGoalId;
    private String goalName;
    private double target;
    private Date startSavingGoal;
    private Date endSavingGoal; // Nullable
    private int userId;
    private Integer savingGoalStatus; // Nullable

    public SavingsGoal(int savingsGoalId, String goalName, double target, Date startSavingGoal, Date endSavingGoal, int userId, Integer savingGoalStatus) {
        this.savingsGoalId = savingsGoalId;
        this.goalName = goalName;
        this.target = target;
        this.startSavingGoal = startSavingGoal;
        this.endSavingGoal = endSavingGoal;
        this.userId = userId;
        this.savingGoalStatus = savingGoalStatus;
    }

    public int getSavingsGoalId() {
        return savingsGoalId;
    }

    public void setSavingsGoalId(int savingsGoalId) {
        this.savingsGoalId = savingsGoalId;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public Date getStartSavingGoal() {
        return startSavingGoal;
    }

    public void setStartSavingGoal(Date startSavingGoal) {
        this.startSavingGoal = startSavingGoal;
    }

    public Date getEndSavingGoal() {
        return endSavingGoal;
    }

    public void setEndSavingGoal(Date endSavingGoal) {
        this.endSavingGoal = endSavingGoal;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getSavingGoalStatus() {
        return savingGoalStatus;
    }

    public void setSavingGoalStatus(Integer savingGoalStatus) {
        this.savingGoalStatus = savingGoalStatus;
    }

    
}
