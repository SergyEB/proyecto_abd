package grupo05abd.modeloDAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.Debt;

public class DebtDAO {

    // INSERT
    public int insertDebt(Debt debt) {
    String sql = "{CALL dbo.sp_InsertDebt(?, ?, ?, ?, ?, ?, ?)}";
    try (Connection conn = Conexion.getConnection();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setDouble(1, debt.getTotalDebt());
        stmt.setDouble(2, debt.getPendingBalance());
        stmt.setDouble(3, debt.getInterestRate());
        stmt.setDate(4, debt.getStartDate());
        if (debt.getDebtDescription() != null) {
            stmt.setString(5, debt.getDebtDescription());
        } else {
            stmt.setNull(5, java.sql.Types.VARCHAR);
        }
        stmt.setInt(6, debt.getDebtTypeId());
        stmt.setInt(7, debt.getAccountId());

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("NewDebtId"); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;  // Si falla
}

    // READ
    public List<Debt> getDebts() {
        List<Debt> debts = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetDebts()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                debts.add(new Debt(
                    rs.getInt("C_debt"),
                    rs.getDouble("M_total_debt"),
                    rs.getDouble("M_pending_balance"),
                    rs.getDouble("M_interest_rate"),
                    rs.getDate("F_start"),
                    rs.getString("D_debt"),
                    rs.getInt("C_debt_type"),
                    rs.getInt("C_account")  // CAMBIO
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return debts;
    }

    // UPDATE
    public void updateDebt(Debt debt) {
        String sql = "{CALL dbo.sp_UpdateDebt(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, debt.getDebtId());
            stmt.setDouble(2, debt.getTotalDebt());
            stmt.setDouble(3, debt.getPendingBalance());
            stmt.setDouble(4, debt.getInterestRate());
            stmt.setDate(5, debt.getStartDate());
            if (debt.getDebtDescription() != null) {
                stmt.setString(6, debt.getDebtDescription());
            } else {
                stmt.setNull(6, java.sql.Types.VARCHAR);
            }
            stmt.setInt(7, debt.getDebtTypeId());
            stmt.setInt(8, debt.getAccountId());  // CAMBIO
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteDebt(int debtId) {
        String sql = "{CALL dbo.sp_DeleteDebt(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, debtId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
