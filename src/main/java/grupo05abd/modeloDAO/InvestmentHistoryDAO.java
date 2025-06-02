package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.InvestmentHistory;

public class InvestmentHistoryDAO {

    public void insertInvestmentHistory(InvestmentHistory history) {
        String sql = "{CALL dbo.sp_InsertInvestmentHistory(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setDate(1, history.getRecordDate());
            stmt.setDouble(2, history.getValue());
            stmt.setInt(3, history.getInvestmentId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<InvestmentHistory> getInvestmentHistories() {
        List<InvestmentHistory> histories = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetInvestmentHistory()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                histories.add(new InvestmentHistory(
                    rs.getInt("C_investment_history"),
                    rs.getDate("F_record"),
                    rs.getDouble("M_value"),
                    rs.getInt("C_investment")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }

    // UPDATE
    public void updateInvestmentHistory(InvestmentHistory history) {
        String sql = "{CALL dbo.sp_UpdateInvestmentHistory(?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, history.getInvestmentHistoryId());
            stmt.setDate(2, history.getRecordDate());
            stmt.setDouble(3, history.getValue());
            stmt.setInt(4, history.getInvestmentId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteInvestmentHistory(int investmentHistoryId) {
        String sql = "{CALL dbo.sp_DeleteInvestmentHistory(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, investmentHistoryId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

}
