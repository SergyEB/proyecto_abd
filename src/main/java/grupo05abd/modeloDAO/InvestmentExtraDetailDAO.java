package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.InvestmentExtraDetail;

public class InvestmentExtraDetailDAO {

    public void insertInvestmentExtraDetail(InvestmentExtraDetail detail) {
        String sql = "{CALL dbo.sp_InsertInvestmentExtraDetail(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, detail.getInvestmentId());
            if (detail.getTermMonths() != null) stmt.setInt(2, detail.getTermMonths()); else stmt.setNull(2, java.sql.Types.INTEGER);
            if (detail.getYieldFrequency() != null) stmt.setString(3, detail.getYieldFrequency()); else stmt.setNull(3, java.sql.Types.VARCHAR);
            if (detail.getMinimumInvestment() != null) stmt.setDouble(4, detail.getMinimumInvestment()); else stmt.setNull(4, java.sql.Types.DECIMAL);
            if (detail.getAdditionalInvestment() != null) stmt.setDouble(5, detail.getAdditionalInvestment()); else stmt.setNull(5, java.sql.Types.DECIMAL);
            if (detail.getMinimumWithdrawal() != null) stmt.setDouble(6, detail.getMinimumWithdrawal()); else stmt.setNull(6, java.sql.Types.DECIMAL);
            if (detail.getPenaltyDescription() != null) stmt.setString(7, detail.getPenaltyDescription()); else stmt.setNull(7, java.sql.Types.VARCHAR);
            if (detail.getShares() != null) stmt.setInt(8, detail.getShares()); else stmt.setNull(8, java.sql.Types.INTEGER);
            if (detail.getPricePerShare() != null) stmt.setDouble(9, detail.getPricePerShare()); else stmt.setNull(9, java.sql.Types.DECIMAL);
            if (detail.getCryptoQuantity() != null) stmt.setDouble(10, detail.getCryptoQuantity()); else stmt.setNull(10, java.sql.Types.DECIMAL);
            if (detail.getCryptoName() != null) stmt.setString(11, detail.getCryptoName()); else stmt.setNull(11, java.sql.Types.VARCHAR);
            if (detail.getUnitPrice() != null) stmt.setDouble(12, detail.getUnitPrice()); else stmt.setNull(12, java.sql.Types.DECIMAL);
            if (detail.getPropertyName() != null) stmt.setString(13, detail.getPropertyName()); else stmt.setNull(13, java.sql.Types.VARCHAR);
            if (detail.getPropertyExpenses() != null) stmt.setDouble(14, detail.getPropertyExpenses()); else stmt.setNull(14, java.sql.Types.DECIMAL);

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<InvestmentExtraDetail> getInvestmentExtraDetails() {
        List<InvestmentExtraDetail> details = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetInvestmentExtraDetails()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                details.add(new InvestmentExtraDetail(
                    rs.getInt("C_extra_detail"),
                    rs.getInt("C_investment"),
                    rs.getObject("N_term_months") != null ? rs.getInt("N_term_months") : null,
                    rs.getString("D_yield_frequency"),
                    rs.getObject("M_minimum_investment") != null ? rs.getDouble("M_minimum_investment") : null,
                    rs.getObject("M_additional_investment") != null ? rs.getDouble("M_additional_investment") : null,
                    rs.getObject("M_minimum_withdrawal") != null ? rs.getDouble("M_minimum_withdrawal") : null,
                    rs.getString("D_penalty_description"),
                    rs.getObject("N_shares") != null ? rs.getInt("N_shares") : null,
                    rs.getObject("M_price_per_share") != null ? rs.getDouble("M_price_per_share") : null,
                    rs.getObject("M_crypto_quantity") != null ? rs.getDouble("M_crypto_quantity") : null,
                    rs.getString("D_crypto_name"),
                    rs.getObject("M_unit_price") != null ? rs.getDouble("M_unit_price") : null,
                    rs.getString("D_property_name"),
                    rs.getObject("M_property_expenses") != null ? rs.getDouble("M_property_expenses") : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

    // UPDATE
    public void updateInvestmentExtraDetail(InvestmentExtraDetail detail) {
        String sql = "{CALL dbo.sp_UpdateInvestmentExtraDetail(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, detail.getExtraDetailId());
            stmt.setInt(2, detail.getInvestmentId());
            if (detail.getTermMonths() != null) stmt.setInt(3, detail.getTermMonths()); else stmt.setNull(3, java.sql.Types.INTEGER);
            if (detail.getYieldFrequency() != null) stmt.setString(4, detail.getYieldFrequency()); else stmt.setNull(4, java.sql.Types.VARCHAR);
            if (detail.getMinimumInvestment() != null) stmt.setDouble(5, detail.getMinimumInvestment()); else stmt.setNull(5, java.sql.Types.DECIMAL);
            if (detail.getAdditionalInvestment() != null) stmt.setDouble(6, detail.getAdditionalInvestment()); else stmt.setNull(6, java.sql.Types.DECIMAL);
            if (detail.getMinimumWithdrawal() != null) stmt.setDouble(7, detail.getMinimumWithdrawal()); else stmt.setNull(7, java.sql.Types.DECIMAL);
            if (detail.getPenaltyDescription() != null) stmt.setString(8, detail.getPenaltyDescription()); else stmt.setNull(8, java.sql.Types.VARCHAR);
            if (detail.getShares() != null) stmt.setInt(9, detail.getShares()); else stmt.setNull(9, java.sql.Types.INTEGER);
            if (detail.getPricePerShare() != null) stmt.setDouble(10, detail.getPricePerShare()); else stmt.setNull(10, java.sql.Types.DECIMAL);
            if (detail.getCryptoQuantity() != null) stmt.setDouble(11, detail.getCryptoQuantity()); else stmt.setNull(11, java.sql.Types.DECIMAL);
            if (detail.getCryptoName() != null) stmt.setString(12, detail.getCryptoName()); else stmt.setNull(12, java.sql.Types.VARCHAR);
            if (detail.getUnitPrice() != null) stmt.setDouble(13, detail.getUnitPrice()); else stmt.setNull(13, java.sql.Types.DECIMAL);
            if (detail.getPropertyName() != null) stmt.setString(14, detail.getPropertyName()); else stmt.setNull(14, java.sql.Types.VARCHAR);
            if (detail.getPropertyExpenses() != null) stmt.setDouble(15, detail.getPropertyExpenses()); else stmt.setNull(15, java.sql.Types.DECIMAL);

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteInvestmentExtraDetail(int extraDetailId) {
        String sql = "{CALL dbo.sp_DeleteInvestmentExtraDetail(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, extraDetailId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
