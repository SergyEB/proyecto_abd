package grupo05abd.modeloDAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.TransactionCategory;

public class TransactionCategoryDAO {

public void insertTransactionCategory(TransactionCategory category) {
    String sql = "{CALL dbo.sp_InsertTransactionCategory(?, ?)}";
    try (Connection conn = Conexion.getConnection();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setInt(1, category.getCategory());
        stmt.setString(2, category.getCategoryName());
        stmt.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // READ
    public List<TransactionCategory> getTransactionCategories() {
        List<TransactionCategory> categories = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetTransactionCategories()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categories.add(new TransactionCategory(
                    rs.getInt("C_category_transaction"),
                    rs.getInt("T_category"),
                    rs.getString("D_category_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    // UPDATE
    public void updateTransactionCategory(TransactionCategory category) {
        String sql = "{CALL dbo.sp_UpdateTransactionCategory(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, category.getCategoryTransactionId());
            stmt.setInt(2, category.getCategory());
            stmt.setString(3, category.getCategoryName());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteTransactionCategory(int categoryTransactionId) {
        String sql = "{CALL dbo.sp_DeleteTransactionCategory(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, categoryTransactionId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
