package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.InterestType;

public class InterestTypeDAO {

public void insertInterestType(InterestType type) {
        String sql = "{CALL dbo.sp_InsertInterestType(?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, type.getInterestName());
            if (type.getInterestTypeDescription() != null) {
                stmt.setString(2, type.getInterestTypeDescription());
            } else {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<InterestType> getInterestTypes() {
        List<InterestType> types = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetInterestTypes()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                types.add(new InterestType(
                    rs.getInt("C_interest_type"),
                    rs.getString("D_interest_name"),
                    rs.getString("D_interest_type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    // UPDATE
    public void updateInterestType(InterestType type) {
        String sql = "{CALL dbo.sp_UpdateInterestType(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, type.getInterestTypeId());
            stmt.setString(2, type.getInterestName());
            if (type.getInterestTypeDescription() != null) {
                stmt.setString(3, type.getInterestTypeDescription());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteInterestType(int interestTypeId) {
        String sql = "{CALL dbo.sp_DeleteInterestType(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, interestTypeId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
