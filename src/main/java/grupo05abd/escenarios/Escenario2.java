package grupo05abd.escenarios;

import grupo05abd.modelo.Transaction;
import grupo05abd.modeloDAO.TransactionDAO;
import java.sql.Date;

public class Escenario2 {

public void ejecutarEscenario2() {

    TransactionDAO dao = new TransactionDAO();

        dao.insertTransaction(new Transaction(0, 150.00, Date.valueOf("2025-04-02"), "Pago de alquiler", 17, 2, 26));
        dao.insertTransaction(new Transaction(0, 40.00, Date.valueOf("2025-04-05"), "Comida diaria", 17, 2, 11));
        dao.insertTransaction(new Transaction(0, 80.00, Date.valueOf("2025-04-07"), "Pago de agua", 17, 2, 13));
        dao.insertTransaction(new Transaction(0, 90.00, Date.valueOf("2025-04-10"), "Pago de luz", 17, 2, 14));
        dao.insertTransaction(new Transaction(0, 60.00, Date.valueOf("2025-04-12"), "Internet mensual", 17, 2, 15));
        dao.insertTransaction(new Transaction(0, 35.00, Date.valueOf("2025-04-15"), "Celular", 17, 2, 16));
        dao.insertTransaction(new Transaction(0, 50.00, Date.valueOf("2025-04-18"), "Netflix", 17, 2, 21));
        dao.insertTransaction(new Transaction(0, 100.00, Date.valueOf("2025-04-20"), "Ropa", 17, 2, 22));
        dao.insertTransaction(new Transaction(0, 70.00, Date.valueOf("2025-04-22"), "Comida fuera", 17, 2, 10));
        dao.insertTransaction(new Transaction(0, 25.00, Date.valueOf("2025-04-25"), "Hobby", 17, 2, 24));
        dao.insertTransaction(new Transaction(0, 30.00, Date.valueOf("2025-04-28"), "Comida del gato", 17, 2, 12));

        dao.insertTransaction(new Transaction(0, 120.00, Date.valueOf("2025-04-03"), "Pago de alquiler", 18, 2, 26));
        dao.insertTransaction(new Transaction(0, 50.00, Date.valueOf("2025-04-06"), "Comida diaria", 18, 2, 11));
        dao.insertTransaction(new Transaction(0, 75.00, Date.valueOf("2025-04-08"), "Pago de agua", 18, 2, 13));
        dao.insertTransaction(new Transaction(0, 85.00, Date.valueOf("2025-04-11"), "Pago de luz", 18, 2, 14));
        dao.insertTransaction(new Transaction(0, 65.00, Date.valueOf("2025-04-13"), "Internet mensual", 18, 2, 15));
        dao.insertTransaction(new Transaction(0, 40.00, Date.valueOf("2025-04-16"), "Celular", 18, 2, 16));
        dao.insertTransaction(new Transaction(0, 45.00, Date.valueOf("2025-04-19"), "Netflix", 18, 2, 21));
        dao.insertTransaction(new Transaction(0, 120.00, Date.valueOf("2025-04-21"), "Zapatos nuevos", 18, 2, 23));
        dao.insertTransaction(new Transaction(0, 90.00, Date.valueOf("2025-04-23"), "Comida fuera", 18, 2, 10));
        dao.insertTransaction(new Transaction(0, 40.00, Date.valueOf("2025-04-26"), "Juegos en línea", 18, 2, 25));
        dao.insertTransaction(new Transaction(0, 20.00, Date.valueOf("2025-04-29"), "Comida del gato", 18, 2, 12));

        System.out.println("Se agregaron los gastos para las cuentas de Mari y Ash...");
}
}
