package grupo05abd.escenarios;

import grupo05abd.modelo.Transaction;
import grupo05abd.modeloDAO.TransactionDAO;

import java.sql.Date;

public class Escenario1 {

    public void ejecutarEscenario1() {
        // Usuario 1, cuenta 17
        insertar(new Transaction(0, 7000, Date.valueOf("2025-01-01"), "Ingreso enero usuario 1", 17, 1, 1));
        insertar(new Transaction(0, 7100, Date.valueOf("2025-02-01"), "Ingreso febrero usuario 1", 17, 1, 1));
        insertar(new Transaction(0, 7200, Date.valueOf("2025-03-01"), "Ingreso marzo usuario 1", 17, 1, 1));
        insertar(new Transaction(0, 7300, Date.valueOf("2025-04-01"), "Ingreso abril usuario 1", 17, 1, 1));
        insertar(new Transaction(0, 7400, Date.valueOf("2025-05-01"), "Ingreso mayo usuario 1", 17, 1, 1));

        // Usuario 2, cuenta 18
        insertar(new Transaction(0, 8000, Date.valueOf("2025-01-01"), "Ingreso enero usuario 2", 18, 1, 1));
        insertar(new Transaction(0, 8100, Date.valueOf("2025-02-01"), "Ingreso febrero usuario 2", 18, 1, 1));
        insertar(new Transaction(0, 8200, Date.valueOf("2025-03-01"), "Ingreso marzo usuario 2", 18, 1, 1));
        insertar(new Transaction(0, 8300, Date.valueOf("2025-04-01"), "Ingreso abril usuario 2", 18, 1, 1));
        insertar(new Transaction(0, 8400, Date.valueOf("2025-05-01"), "Ingreso mayo usuario 2", 18, 1, 1));

        // Usuario 3, cuenta 19
        insertar(new Transaction(0, 9000, Date.valueOf("2025-01-01"), "Ingreso enero usuario 3", 19, 1, 1));
        insertar(new Transaction(0, 9100, Date.valueOf("2025-02-01"), "Ingreso febrero usuario 3", 19, 1, 1));
        insertar(new Transaction(0, 9200, Date.valueOf("2025-03-01"), "Ingreso marzo usuario 3", 19, 1, 1));
        insertar(new Transaction(0, 9300, Date.valueOf("2025-04-01"), "Ingreso abril usuario 3", 19, 1, 1));
        insertar(new Transaction(0, 9400, Date.valueOf("2025-05-01"), "Ingreso mayo usuario 3", 19, 1, 1));

        // Usuario 4, cuenta 20
        insertar(new Transaction(0, 10000, Date.valueOf("2025-01-01"), "Ingreso enero usuario 4", 20, 1, 1));
        insertar(new Transaction(0, 10100, Date.valueOf("2025-02-01"), "Ingreso febrero usuario 4", 20, 1, 1));
        insertar(new Transaction(0, 10200, Date.valueOf("2025-03-01"), "Ingreso marzo usuario 4", 20, 1, 1));
        insertar(new Transaction(0, 10300, Date.valueOf("2025-04-01"), "Ingreso abril usuario 4", 20, 1, 1));
        insertar(new Transaction(0, 10400, Date.valueOf("2025-05-01"), "Ingreso mayo usuario 4", 20, 1, 1));

        System.out.println("Escenario 1 completado con 20 transacciones.");
    }

    private void insertar(Transaction tx) {
        TransactionDAO dao = new TransactionDAO();
        dao.insertTransaction(tx);
    }
}

