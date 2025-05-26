package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.TransactionType;

public class TransactionTypeDAO {

    public void insertTransactionType(TransactionType type) {
        String sql = "{CALL dbo.sp_InsertTransactionType(?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, type.getTypeName());
            if (type.getTransactionTypeDescription() != null) {
                stmt.setString(2, type.getTransactionTypeDescription());
            } else {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<TransactionType> getTransactionTypes() {
        List<TransactionType> types = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetTransactionTypes()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                types.add(new TransactionType(
                    rs.getInt("C_transaction_type"),
                    rs.getString("D_type_name"),
                    rs.getString("D_transaction_type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    // UPDATE
    public void updateTransactionType(TransactionType type) {
        String sql = "{CALL dbo.sp_UpdateTransactionType(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, type.getTransactionTypeId());
            stmt.setString(2, type.getTypeName());
            if (type.getTransactionTypeDescription() != null) {
                stmt.setString(3, type.getTransactionTypeDescription());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteTransactionType(int transactionTypeId) {
        String sql = "{CALL dbo.sp_DeleteTransactionType(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, transactionTypeId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
