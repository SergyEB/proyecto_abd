package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.Budget;

public class BudgetDAO {

public void insertBudget(Budget budget) {
        String sql = "{CALL dbo.sp_InsertBudget(?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, budget.getName());
            stmt.setDouble(2, budget.getTotalAllocated());
            stmt.setDate(3, budget.getStartBudget());
            if (budget.getEndBudget() != null) {
                stmt.setDate(4, budget.getEndBudget());
            } else {
                stmt.setNull(4, java.sql.Types.DATE);
            }
            stmt.setInt(5, budget.getUserId());
            if (budget.getBudgetStatus() != null) {
                stmt.setInt(6, budget.getBudgetStatus());
            } else {
                stmt.setNull(6, java.sql.Types.INTEGER);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Budget> getBudgets() {
        List<Budget> budgets = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetBudgets()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                budgets.add(new Budget(
                    rs.getInt("C_budget"),
                    rs.getString("D_name"),
                    rs.getDouble("M_total_allocated"),
                    rs.getDate("F_start_budget"),
                    rs.getObject("F_end_budget") != null ? rs.getDate("F_end_budget") : null,
                    rs.getInt("C_user"),
                    rs.getObject("C_budget_status") != null ? rs.getInt("C_budget_status") : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return budgets;
    }

    // UPDATE
    public void updateBudget(Budget budget) {
        String sql = "{CALL dbo.sp_UpdateBudget(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, budget.getBudgetId());
            stmt.setString(2, budget.getName());
            stmt.setDouble(3, budget.getTotalAllocated());
            stmt.setDate(4, budget.getStartBudget());
            if (budget.getEndBudget() != null) {
                stmt.setDate(5, budget.getEndBudget());
            } else {
                stmt.setNull(5, java.sql.Types.DATE);
            }
            stmt.setInt(6, budget.getUserId());
            if (budget.getBudgetStatus() != null) {
                stmt.setInt(7, budget.getBudgetStatus());
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteBudget(int budgetId) {
        String sql = "{CALL dbo.sp_DeleteBudget(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, budgetId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
