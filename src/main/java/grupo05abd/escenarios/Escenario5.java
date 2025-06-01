package grupo05abd.escenarios;

import java.sql.Date;
import java.time.LocalDate;
import grupo05abd.modelo.Account;
import grupo05abd.modelo.Transaction;
import grupo05abd.modeloDAO.AccountDAO;
import grupo05abd.modeloDAO.TransactionDAO;

public class Escenario5 {

    AccountDAO dao = new AccountDAO();
    TransactionDAO transactionDAO = new TransactionDAO();

    public void ejecutarEscenario5() {
        // Crear cuentas para usuario 1
        Account ahorroAnualUser1 = new Account(0, "Ahorro Anual Mari", 0.00, 6, 2, 1);
        Account fondoEmergenciaUser1 = new Account(0, "Fondo Emergencia Mari", 0.00, 6, 2, 1);

        // Crear cuentas para usuario 2
        Account ahorroAnualUser2 = new Account(0, "Ahorro Anual Ash", 0.00, 6, 2, 2);
        Account fondoEmergenciaUser2 = new Account(0, "Fondo Emergencia Ash", 0.00, 6, 2, 2);

        // Crear cuentas para usuario 3
        Account ahorroAnualUser3 = new Account(0, "Ahorro Anual Sergy", 0.00, 6, 2, 3);
        Account fondoEmergenciaUser3 = new Account(0, "Fondo Emergencia Sergy", 0.00, 6, 2, 3);

        // Crear cuentas para usuario 4
        Account ahorroAnualUser4 = new Account(0, "Ahorro Anual Nico", 0.00, 6, 2, 4);
        Account fondoEmergenciaUser4 = new Account(0, "Fondo Emergencia Nico", 0.00, 6, 2, 4);

        // Insertar cuentas
        dao.insertAccount(ahorroAnualUser1);
        dao.insertAccount(fondoEmergenciaUser1);
        dao.insertAccount(ahorroAnualUser2);
        dao.insertAccount(fondoEmergenciaUser2);
        dao.insertAccount(ahorroAnualUser3);
        dao.insertAccount(fondoEmergenciaUser3);
        dao.insertAccount(ahorroAnualUser4);
        dao.insertAccount(fondoEmergenciaUser4);

        System.out.println("Cuentas creadas e insertadas para usuarios.");

        // Crear transacciones (Ingreso nuevo) para Mari (usuario 1) y Ash (usuario 2)
        int idAhorroMari = dao.getAccountIdByNameAndUser("Anual", 1);
        int idEmergMari = dao.getAccountIdByNameAndUser("Emergencia", 1);

        int idAhorroAsh = dao.getAccountIdByNameAndUser("Anual", 2);
        int idEmergAsh = dao.getAccountIdByNameAndUser("Emergencia", 2);

        Transaction transAhorroMari = new Transaction(0, 1000.00, Date.valueOf(LocalDate.now()),
                "Ingreso inicial Ahorro Anual", idAhorroMari, 1, null);
        Transaction transEmergMari = new Transaction(0, 1500.00, Date.valueOf(LocalDate.now()),
                "Ingreso inicial Fondo Emergencia", idEmergMari, 1, null);

        Transaction transAhorroAsh = new Transaction(0, 1200.00, Date.valueOf(LocalDate.now()),
                "Ingreso inicial Ahorro Anual", idAhorroAsh, 1, null);
        Transaction transEmergAsh = new Transaction(0, 1800.00, Date.valueOf(LocalDate.now()),
                "Ingreso inicial Fondo Emergencia", idEmergAsh, 1, null);

        transactionDAO.insertTransaction(transAhorroMari);
        transactionDAO.insertTransaction(transEmergMari);
        transactionDAO.insertTransaction(transAhorroAsh);
        transactionDAO.insertTransaction(transEmergAsh);

        System.out.println("Transacciones de ingreso creadas para Mari y Ash.");
    }
}
