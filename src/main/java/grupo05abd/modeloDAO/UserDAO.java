package grupo05abd.modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.User;

public class UserDAO {

// Leer usuarios usando la función
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM dbo.fn_get_all_users()";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setC_user(rs.getInt("C_user"));
                user.setD_first_name(rs.getString("D_first_name"));
                user.setD_last_name(rs.getString("D_last_name"));
                user.setD_email(rs.getString("D_email"));
                user.setD_password(rs.getString("D_password"));
                user.setT_role(rs.getInt("T_role"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Insertar usuario usando stored procedure
    public void insertUser(User user) {
        String sql = "{CALL sp_insert_user(?, ?, ?, ?, ?)}";

        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, user.getD_first_name());
            stmt.setString(2, user.getD_last_name());
            stmt.setString(3, user.getD_email());
            stmt.setString(4, user.getD_password());
            stmt.setInt(5, user.getT_role());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar usuario usando stored procedure
    public void updateUser(User user) {
        String sql = "{CALL sp_update_user(?, ?, ?, ?, ?, ?)}";

        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, user.getC_user());
            stmt.setString(2, user.getD_first_name());
            stmt.setString(3, user.getD_last_name());
            stmt.setString(4, user.getD_email());
            stmt.setString(5, user.getD_password());
            stmt.setInt(6, user.getT_role());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar usuario usando stored procedure
    public void deleteUser(int C_user) {
        String sql = "{CALL sp_delete_user(?)}";

        try (Connection conn = Conexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, C_user);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
