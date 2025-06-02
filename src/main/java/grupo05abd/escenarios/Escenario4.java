package grupo05abd.escenarios;

import java.sql.Date;
import java.time.LocalDate;
import grupo05abd.modelo.Investment;
import grupo05abd.modeloDAO.InvestmentDAO;
import grupo05abd.modelo.Transaction;
import grupo05abd.modeloDAO.TransactionDAO;
import grupo05abd.modelo.InvestmentHistory;
import grupo05abd.modeloDAO.InvestmentHistoryDAO;

public class Escenario4 {

    public void ejecutarEscenario4() {
        // Instancia de DAOs
        InvestmentDAO investmentDAO = new InvestmentDAO();
        TransactionDAO transactionDAO = new TransactionDAO();
        InvestmentHistoryDAO historyDAO = new InvestmentHistoryDAO();

        // Datos de la inversión
        int investmentId = 0;
        double investedAmount = 2000.00;
        double interestRate = 0.14;
        double currentValue = 0.00;
        Date startDate = Date.valueOf(LocalDate.of(2025, 5, 1));
        String investmentDescription = "Préstamo personal a Nicole";
        Integer investmentTypeId = 9;
        Integer interestTypeId = 1;
        int accountId = 19;

        // Crear la inversión
        Investment investment = new Investment(
                investmentId,
                investedAmount,
                interestRate,
                currentValue,
                startDate,
                investmentDescription,
                investmentTypeId,
                interestTypeId,
                accountId
        );
        investmentDAO.insertInvestment(investment);
        System.out.println("Inversión creada exitosamente para Escenario 4.");

        // Simular que obtenemos el C_investment real generado (reemplaza con método correcto)
        int investmentGeneratedId = investmentDAO.getLastInsertedInvestmentId();  // Ajusta según tu DAO

        // Interés mensual
        double monthlyInterest = investedAmount * (interestRate / 12);
        System.out.printf("Interés mensual: %.2f%n", monthlyInterest);

        // Generar transacciones y actualizar historial
        for (int month = 0; month < 12; month++) {
            LocalDate transactionDate = startDate.toLocalDate().plusMonths(month);
            Date sqlTransactionDate = Date.valueOf(transactionDate);
            String transactionDescription = "Pago mensual de intereses, mes " + (month + 1);

            // Insertar transacción
            Transaction transaction = new Transaction(
                    0,
                    monthlyInterest,
                    sqlTransactionDate,
                    transactionDescription,
                    accountId,
                    1,
                    null
            );
            transactionDAO.insertTransaction(transaction);

            // Actualizar M_current_value
            currentValue += monthlyInterest;
            investment.setCurrentValue(currentValue);
            investment.setInvestmentId(investmentGeneratedId);
            investmentDAO.updateInvestment(investment);

            // Insertar en InvestmentHistory
            InvestmentHistory history = new InvestmentHistory(
                    0,  // PK autogenerado
                    sqlTransactionDate,
                    currentValue,
                    investmentGeneratedId
            );
            historyDAO.insertInvestmentHistory(history);

            System.out.println("Mes " + (month + 1) + ": Transacción creada, M_current_value actualizado y registrado en InvestmentHistory.");
        }
    }
}
