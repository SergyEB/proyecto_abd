package grupo05abd.escenarios;
import grupo05abd.modelo.Debt;
import grupo05abd.modelo.Transaction;
import grupo05abd.modeloDAO.DebtDAO;
import grupo05abd.modeloDAO.TransactionDAO;
import java.sql.Date;
import java.time.LocalDate;


public class Escenario3 {

    public void ejecutarEscenario3() {

        double principal = 20000;
        double annualRate = 0.24; // 24% anual
        int years = 5;

        double interest = principal * annualRate * years;
        double totalDebt = principal + interest;
        TransactionDAO transactionDAO = new TransactionDAO();

        Date startDate = Date.valueOf(LocalDate.of(LocalDate.now().getYear(), 2, 1)); 

        Debt debt = new Debt(
                0, // Hay que cambiar el ID
                totalDebt,
                totalDebt,
                annualRate,
                startDate,
                "Simple interest debt at 24% annually for 5 years",
                4,  
                19   
        );

        DebtDAO debtDAO = new DebtDAO();
        int generatedDebtId = debtDAO.insertDebt(debt);
        debt.setDebtId(generatedDebtId);

        System.out.println("✅ Debt successfully inserted.");

        int months = 60;
        double monthlyPayment = totalDebt / months;

        insertMonthlyPayment(transactionDAO, debt, monthlyPayment, "Loan payment March", "2025-03-01", 19, 3);
        insertMonthlyPayment(transactionDAO, debt, monthlyPayment, "Loan payment April", "2025-04-01", 19, 3);
    }

    private static void insertMonthlyPayment(TransactionDAO dao, Debt debt, double amount, String description,
                                             String date, int accountId, int userId) {
        Transaction payment = new Transaction(
                0,
                amount,
                Date.valueOf(date),
                description,
                accountId,
                2, 
                userId
        );

        dao.insertTransaction(payment);

        double newBalance = debt.getPendingBalance() - amount;
        System.out.println("New pending balance: " + newBalance);
        System.out.println("Debt " + debt.getDebtId() + " updated with new pending balance: " + newBalance);

        debt.setPendingBalance(newBalance);
        DebtDAO debtDAO = new DebtDAO();
        debtDAO.updateDebt(debt);
    }
}