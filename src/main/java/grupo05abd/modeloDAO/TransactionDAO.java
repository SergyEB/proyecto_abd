package grupo05abd.modeloDAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.Transaction;

public class TransactionDAO {

public void insertTransaction(Transaction tx) {
    String sql = "{CALL dbo.sp_InsertTransaction(?, ?, ?, ?, ?, ?)}";
    try (Connection conn = Conexion.getConnection();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setDouble(1, tx.getAmount());
        stmt.setDate(2, tx.getTransactionDate());
        if (tx.getDescription() != null) {
            stmt.setString(3, tx.getDescription());
        } else {
            stmt.setNull(3, java.sql.Types.VARCHAR);
        }
        stmt.setInt(4, tx.getAccountId());
        stmt.setInt(5, tx.getTransactionTypeId());
        if (tx.getTransactionSubcategoryId() != null) {
            stmt.setInt(6, tx.getTransactionSubcategoryId());
        } else {
            stmt.setNull(6, java.sql.Types.INTEGER);
        }
        stmt.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



    // READ
    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetTransactions()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(new Transaction(
                    rs.getInt("C_transaction"),
                    rs.getDouble("M_transaction"),
                    rs.getDate("F_transaction"),
                    rs.getString("D_transaction"),
                    rs.getInt("C_account"),
                    rs.getInt("C_transaction_type"),
                    rs.getObject("C_transaction_subcategory") != null ? rs.getInt("C_transaction_subcategory") : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    // UPDATE
    public void updateTransaction(Transaction tx) {
        String sql = "{CALL dbo.sp_UpdateTransaction(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, tx.getTransactionId());
            stmt.setDouble(2, tx.getAmount());
            stmt.setDate(3, tx.getTransactionDate());
            if (tx.getDescription() != null) {
                stmt.setString(4, tx.getDescription());
            } else {
                stmt.setNull(4, java.sql.Types.VARCHAR);
            }
            stmt.setInt(5, tx.getAccountId());
            stmt.setInt(6, tx.getTransactionTypeId());
            if (tx.getTransactionSubcategoryId() != null) {
                stmt.setInt(7, tx.getTransactionSubcategoryId());
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteTransaction(int transactionId) {
        String sql = "{CALL dbo.sp_DeleteTransaction(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, transactionId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
