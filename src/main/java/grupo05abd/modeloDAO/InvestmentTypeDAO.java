package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.InvestmentType;

public class InvestmentTypeDAO {


    public void insertInvestmentType(InvestmentType type) {
        String sql = "{CALL dbo.sp_InsertInvestmentType(?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, type.getTypeName());
            if (type.getInvestmentTypeDescription() != null) {
                stmt.setString(2, type.getInvestmentTypeDescription());
            } else {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<InvestmentType> getInvestmentTypes() {
        List<InvestmentType> types = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetInvestmentTypes()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                types.add(new InvestmentType(
                    rs.getInt("C_investment_type"),
                    rs.getString("D_type_name"),
                    rs.getString("D_investment_type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    // UPDATE
    public void updateInvestmentType(InvestmentType type) {
        String sql = "{CALL dbo.sp_UpdateInvestmentType(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, type.getInvestmentTypeId());
            stmt.setString(2, type.getTypeName());
            if (type.getInvestmentTypeDescription() != null) {
                stmt.setString(3, type.getInvestmentTypeDescription());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteInvestmentType(int investmentTypeId) {
        String sql = "{CALL dbo.sp_DeleteInvestmentType(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, investmentTypeId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
