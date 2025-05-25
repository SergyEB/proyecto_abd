package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.BudgetDetail;

public class BudgetDetailDAO {

public void insertBudgetDetail(BudgetDetail detail) {
        String sql = "{CALL dbo.sp_InsertBudgetDetail(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setDouble(1, detail.getEstimatedBudget());
            stmt.setInt(2, detail.getBudgetId());
            if (detail.getTransactionSubcategoryId() != null) {
                stmt.setInt(3, detail.getTransactionSubcategoryId());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<BudgetDetail> getBudgetDetails() {
        List<BudgetDetail> details = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetBudgetDetails()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                details.add(new BudgetDetail(
                    rs.getInt("C_budget_detail"),
                    rs.getDouble("M_estimated_budget"),
                    rs.getInt("C_budget"),
                    rs.getObject("C_transaction_subcategory") != null ?
                        rs.getInt("C_transaction_subcategory") : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

    // UPDATE
    public void updateBudgetDetail(BudgetDetail detail) {
        String sql = "{CALL dbo.sp_UpdateBudgetDetail(?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, detail.getBudgetDetailId());
            stmt.setDouble(2, detail.getEstimatedBudget());
            stmt.setInt(3, detail.getBudgetId());
            if (detail.getTransactionSubcategoryId() != null) {
                stmt.setInt(4, detail.getTransactionSubcategoryId());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteBudgetDetail(int budgetDetailId) {
        String sql = "{CALL dbo.sp_DeleteBudgetDetail(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, budgetDetailId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
