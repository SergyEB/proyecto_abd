package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.SavingsGoal;

public class SavingsGoalDAO {

public void insertSavingsGoal(SavingsGoal goal) {
        String sql = "{CALL dbo.sp_InsertSavingsGoal(?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, goal.getGoalName());
            stmt.setDouble(2, goal.getTarget());
            stmt.setDate(3, goal.getStartSavingGoal());
            if (goal.getEndSavingGoal() != null) {
                stmt.setDate(4, goal.getEndSavingGoal());
            } else {
                stmt.setNull(4, java.sql.Types.DATE);
            }
            stmt.setInt(5, goal.getUserId());
            if (goal.getSavingGoalStatus() != null) {
                stmt.setInt(6, goal.getSavingGoalStatus());
            } else {
                stmt.setNull(6, java.sql.Types.INTEGER);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<SavingsGoal> getSavingsGoals() {
        List<SavingsGoal> goals = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetSavingsGoals()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                goals.add(new SavingsGoal(
                    rs.getInt("C_savings_goal"),
                    rs.getString("D_goal_name"),
                    rs.getDouble("M_target"),
                    rs.getDate("F_start_saving_goal"),
                    rs.getObject("F_end_saving_goal") != null ? rs.getDate("F_end_saving_goal") : null,
                    rs.getInt("C_user"),
                    rs.getObject("C_saving_goal_status") != null ? rs.getInt("C_saving_goal_status") : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goals;
    }

    // UPDATE
    public void updateSavingsGoal(SavingsGoal goal) {
        String sql = "{CALL dbo.sp_UpdateSavingsGoal(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, goal.getSavingsGoalId());
            stmt.setString(2, goal.getGoalName());
            stmt.setDouble(3, goal.getTarget());
            stmt.setDate(4, goal.getStartSavingGoal());
            if (goal.getEndSavingGoal() != null) {
                stmt.setDate(5, goal.getEndSavingGoal());
            } else {
                stmt.setNull(5, java.sql.Types.DATE);
            }
            stmt.setInt(6, goal.getUserId());
            if (goal.getSavingGoalStatus() != null) {
                stmt.setInt(7, goal.getSavingGoalStatus());
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteSavingsGoal(int savingsGoalId) {
        String sql = "{CALL dbo.sp_DeleteSavingsGoal(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, savingsGoalId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
