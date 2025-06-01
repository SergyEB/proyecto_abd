package grupo05abd.modeloDAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.Account;

public class AccountDAO {

    public void insertAccount(Account account) {
        String sql = "{CALL dbo.sp_InsertAccount(?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
                CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, account.getAccountName());
            stmt.setDouble(2, account.getBalance());
            stmt.setInt(3, account.getAccountType());
            stmt.setInt(4, account.getCurrencyType());
            stmt.setInt(5, account.getUserId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetAccounts()";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("C_account"),
                        rs.getString("D_account_name"),
                        rs.getDouble("M_balance"),
                        rs.getInt("C_account_type"),
                        rs.getInt("C_currency_type"),
                        rs.getInt("C_user")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // UPDATE
    public void updateAccount(Account account) {
        String sql = "{CALL dbo.sp_UpdateAccount(?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
                CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, account.getAccountId());
            stmt.setString(2, account.getAccountName());
            stmt.setDouble(3, account.getBalance());
            stmt.setInt(4, account.getAccountType());
            stmt.setInt(5, account.getCurrencyType());
            stmt.setInt(6, account.getUserId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteAccount(int accountId) {
        String sql = "{CALL dbo.sp_DeleteAccount(?)}";
        try (Connection conn = Conexion.getConnection();
                CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, accountId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getAccountIdByNameAndUser(String nameContains, int userId) {
        int accountId = -1; // Valor por defecto
        try (Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT C_account FROM Accounts WHERE D_account_name LIKE ? AND C_user = ?")) {
            stmt.setString(1, "%" + nameContains + "%");
            stmt.setInt(2, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                accountId = rs.getInt("C_account"); // Corregido aquí
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountId;
    }

}
