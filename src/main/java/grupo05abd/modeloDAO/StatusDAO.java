package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.Status;

public class StatusDAO {

public void insertStatus(Status status) {
        String sql = "{CALL dbo.sp_InsertStatus(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, status.getStatusId());
            stmt.setString(2, status.getName());
            if (status.getStatusDescription() != null) {
                stmt.setString(3, status.getStatusDescription());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Status> getStatuses() {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_GetStatus()";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                statuses.add(new Status(
                    rs.getInt("C_status"),
                    rs.getString("D_name"),
                    rs.getString("D_status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    // UPDATE
    public void updateStatus(Status status) {
        String sql = "{CALL dbo.sp_UpdateStatus(?, ?, ?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, status.getStatusId());
            stmt.setString(2, status.getName());
            if (status.getStatusDescription() != null) {
                stmt.setString(3, status.getStatusDescription());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteStatus(int statusId) {
        String sql = "{CALL dbo.sp_DeleteStatus(?)}";
        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, statusId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
