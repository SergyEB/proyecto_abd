package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.DebtType;

public class DebtTypeDAO {

public void insertDebtType(DebtType type) {
        String sql = "{CALL dbo.sp_InsertDebtType(?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, type.getTypeName());
            if (type.getDebtTypeDescription() != null) {
                stmt.setString(2, type.getDebtTypeDescription());
            } else {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<DebtType> getDebtTypes() {
        List<DebtType> types = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetDebtTypes()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                types.add(new DebtType(
                    rs.getInt("C_debt_type"),
                    rs.getString("D_type_name"),
                    rs.getString("D_debt_type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    // UPDATE
    public void updateDebtType(DebtType type) {
        String sql = "{CALL dbo.sp_UpdateDebtType(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, type.getDebtTypeId());
            stmt.setString(2, type.getTypeName());
            if (type.getDebtTypeDescription() != null) {
                stmt.setString(3, type.getDebtTypeDescription());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteDebtType(int debtTypeId) {
        String sql = "{CALL dbo.sp_DeleteDebtType(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, debtTypeId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
