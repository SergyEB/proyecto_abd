package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.TransactionSubCategory;

public class TransactionSubCategoryDAO {

public void insertTransactionSubCategory(TransactionSubCategory subcategory) {
    String sql = "{CALL dbo.sp_InsertTransactionSubCategory(?, ?)}";
    try (Connection conn = Conexion.getConnection();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setString(1, subcategory.getSubcategoryName());
        stmt.setInt(2, subcategory.getCategoryTransactionId());
        stmt.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public List<TransactionSubCategory> getTransactionSubCategories() {
        List<TransactionSubCategory> subcategories = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetTransactionSubCategories()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                subcategories.add(new TransactionSubCategory(
                    rs.getInt("C_subcategory"),
                    rs.getString("D_subcategory_name"),
                    rs.getInt("C_category_transaction")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subcategories;
    }

    // UPDATE
    public void updateTransactionSubCategory(TransactionSubCategory subcategory) {
        String sql = "{CALL dbo.sp_UpdateTransactionSubCategory(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, subcategory.getSubcategoryId());
            stmt.setString(2, subcategory.getSubcategoryName());
            stmt.setInt(3, subcategory.getCategoryTransactionId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteTransactionSubCategory(int subcategoryId) {
        String sql = "{CALL dbo.sp_DeleteTransactionSubCategory(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, subcategoryId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
