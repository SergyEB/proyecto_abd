package grupo05abd;

import grupo05abd.modelo.User;
import grupo05abd.modeloDAO.UserDAO;

import java.util.List;

public class App {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // 🔍 1️⃣ Leer usuarios
        System.out.println("🔍 Lista de usuarios:");
        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            System.out.println(u.getC_user() + " - " + u.getD_first_name() + " " + u.getD_last_name());
        }
 
         // ➕ 2️⃣ Insertar usuario
        User nuevo = new User();
        nuevo.setD_first_name("Ana");
        nuevo.setD_last_name("Pérez");
        nuevo.setD_email("ana.perez@example.com");
        nuevo.setD_password("1234");
        nuevo.setT_role(1);
        userDAO.insertUser(nuevo);
        System.out.println("✅ Usuario insertado.");

        // 🔄 3️⃣ Actualizar usuario (ajusta el C_user según prueba)
        nuevo.setC_user(5); // Cambiar al ID real
        nuevo.setD_first_name("Ana María");
        userDAO.updateUser(nuevo);
        System.out.println("♻️ Usuario actualizado.");

        // ❌ 4️⃣ Eliminar usuario (ajusta el C_user según prueba)
         userDAO.deleteUser(5); // Cambiar al ID real
        System.out.println("🗑️ Usuario eliminado.");
    }
}
