package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.Investment;

public class InvestmentDAO {

public void insertInvestment(Investment investment) {
        String sql = "{CALL dbo.sp_InsertInvestment(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setDouble(1, investment.getInvestedAmount());
            stmt.setDouble(2, investment.getInterestRate());
            stmt.setDouble(3, investment.getCurrentValue());
            stmt.setDate(4, investment.getStartDate());
            if (investment.getInvestmentDescription() != null) {
                stmt.setString(5, investment.getInvestmentDescription());
            } else {
                stmt.setNull(5, java.sql.Types.VARCHAR);
            }
            if (investment.getInvestmentTypeId() != null) {
                stmt.setInt(6, investment.getInvestmentTypeId());
            } else {
                stmt.setNull(6, java.sql.Types.INTEGER);
            }
            if (investment.getInterestTypeId() != null) {
                stmt.setInt(7, investment.getInterestTypeId());
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER);
            }
            stmt.setInt(8, investment.getUserId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Investment> getInvestments() {
        List<Investment> investments = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetInvestments()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                investments.add(new Investment(
                    rs.getInt("C_investment"),
                    rs.getDouble("M_invested"),
                    rs.getDouble("N_interest_rate"),
                    rs.getDouble("M_current_value"),
                    rs.getDate("F_start"),
                    rs.getString("D_investment"),
                    rs.getObject("C_investment_type") != null ? rs.getInt("C_investment_type") : null,
                    rs.getObject("C_interest_type") != null ? rs.getInt("C_interest_type") : null,
                    rs.getInt("C_user")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return investments;
    }

    // UPDATE
    public void updateInvestment(Investment investment) {
        String sql = "{CALL dbo.sp_UpdateInvestment(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, investment.getInvestmentId());
            stmt.setDouble(2, investment.getInvestedAmount());
            stmt.setDouble(3, investment.getInterestRate());
            stmt.setDouble(4, investment.getCurrentValue());
            stmt.setDate(5, investment.getStartDate());
            if (investment.getInvestmentDescription() != null) {
                stmt.setString(6, investment.getInvestmentDescription());
            } else {
                stmt.setNull(6, java.sql.Types.VARCHAR);
            }
            if (investment.getInvestmentTypeId() != null) {
                stmt.setInt(7, investment.getInvestmentTypeId());
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER);
            }
            if (investment.getInterestTypeId() != null) {
                stmt.setInt(8, investment.getInterestTypeId());
            } else {
                stmt.setNull(8, java.sql.Types.INTEGER);
            }
            stmt.setInt(9, investment.getUserId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteInvestment(int investmentId) {
        String sql = "{CALL dbo.sp_DeleteInvestment(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, investmentId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
