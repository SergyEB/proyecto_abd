package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.DebtHistory;

public class DebtHistoryDAO {

    public void insertDebtHistory(DebtHistory history) {
        String sql = "{CALL dbo.sp_InsertDebtHistory(?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setDate(1, history.getMovementDate());
            if (history.getDebtHistoryDescription() != null) {
                stmt.setString(2, history.getDebtHistoryDescription());
            } else {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }
            stmt.setInt(3, history.getDebtId());
            if (history.getTransactionId() != null) {
                stmt.setInt(4, history.getTransactionId());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<DebtHistory> getDebtHistories() {
        List<DebtHistory> histories = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetDebtHistory()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                histories.add(new DebtHistory(
                    rs.getInt("C_debt_history"),
                    rs.getDate("F_movement"),
                    rs.getString("D_debt_history"),
                    rs.getInt("C_debt"),
                    rs.getObject("C_transaction") != null ? rs.getInt("C_transaction") : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }

    // UPDATE
    public void updateDebtHistory(DebtHistory history) {
        String sql = "{CALL dbo.sp_UpdateDebtHistory(?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, history.getDebtHistoryId());
            stmt.setDate(2, history.getMovementDate());
            if (history.getDebtHistoryDescription() != null) {
                stmt.setString(3, history.getDebtHistoryDescription());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            stmt.setInt(4, history.getDebtId());
            if (history.getTransactionId() != null) {
                stmt.setInt(5, history.getTransactionId());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteDebtHistory(int debtHistoryId) {
        String sql = "{CALL dbo.sp_DeleteDebtHistory(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, debtHistoryId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
