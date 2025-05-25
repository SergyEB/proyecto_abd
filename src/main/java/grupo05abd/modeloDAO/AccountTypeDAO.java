package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.AccountType;

public class AccountTypeDAO {


public void insertAccountType(AccountType type) {
        String sql = "{CALL dbo.sp_InsertAccountType(?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, type.getTypeName());
            stmt.setString(2, type.getAccountTypeDescription());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<AccountType> getAccountTypes() {
        List<AccountType> types = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetAccountTypes()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                types.add(new AccountType(
                    rs.getInt("C_account_type"),
                    rs.getString("D_type_name"),
                    rs.getString("D_account_type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    // UPDATE
    public void updateAccountType(AccountType type) {
        String sql = "{CALL dbo.sp_UpdateAccountType(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, type.getAccountTypeId());
            stmt.setString(2, type.getTypeName());
            stmt.setString(3, type.getAccountTypeDescription());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteAccountType(int accountTypeId) {
        String sql = "{CALL dbo.sp_DeleteAccountType(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, accountTypeId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
