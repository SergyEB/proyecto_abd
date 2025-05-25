package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.CurrencyType;

public class CurrencyTypeDAO {

public void insertCurrencyType(CurrencyType type) {
        String sql = "{CALL dbo.sp_InsertCurrencyType(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, type.getCurrencyName());
            if (type.getSymbol() != null) {
                stmt.setString(2, type.getSymbol());
            } else {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }
            if (type.getIsoCode() != null) {
                stmt.setString(3, type.getIsoCode());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<CurrencyType> getCurrencyTypes() {
        List<CurrencyType> types = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetCurrencyTypes()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                types.add(new CurrencyType(
                    rs.getInt("C_currency_type"),
                    rs.getString("D_currency_name"),
                    rs.getString("D_symbol"),
                    rs.getString("D_iso_code")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    // UPDATE
    public void updateCurrencyType(CurrencyType type) {
        String sql = "{CALL dbo.sp_UpdateCurrencyType(?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, type.getCurrencyTypeId());
            stmt.setString(2, type.getCurrencyName());
            if (type.getSymbol() != null) {
                stmt.setString(3, type.getSymbol());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            if (type.getIsoCode() != null) {
                stmt.setString(4, type.getIsoCode());
            } else {
                stmt.setNull(4, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteCurrencyType(int currencyTypeId) {
        String sql = "{CALL dbo.sp_DeleteCurrencyType(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, currencyTypeId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
