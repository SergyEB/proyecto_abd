package grupo05abd;

import grupo05abd.escenarios.Escenario1;
import grupo05abd.escenarios.Escenario2;
import grupo05abd.escenarios.Escenario5;
import grupo05abd.servicio.CargaCrypto;



public class App {

    public static void main(String[] args) {
            // Crear instancia del servicio de carga de criptomonedas
            //getCriptoHistory();

            //Escenario 1
            /*Escenario1 escenario = new Escenario1();
            escenario.ejecutarEscenario1();*/

            //Escenario 2
            /*Escenario2 escenario2 = new Escenario2();
            escenario2.ejecutarEscenario2();*/

            //Escenario5
            Escenario5 escenario5 = new Escenario5();
            escenario5.ejecutarEscenario5();



        }





    private static void getCriptoHistory() {
        CargaCrypto cargaCrypto = new CargaCrypto();

        // Probar con Solana (puedes cambiar a otra moneda admitida por CoinGecko)
        String coinId = "ethereum";  // CoinGecko ID, por ejemplo: "bitcoin", "ethereum", "solana"
        
        System.out.println("Iniciando carga de datos históricos para " + coinId + "...");

        // Llamar al método que carga solo fechas faltantes
        cargaCrypto.cargarDatos(coinId);

        System.out.println("Carga finalizada.");
    }
}
