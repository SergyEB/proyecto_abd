package grupo05abd;

import java.util.Scanner;

import grupo05abd.escenarios.Escenario1;
import grupo05abd.escenarios.Escenario2;
import grupo05abd.escenarios.Escenario3;
import grupo05abd.escenarios.Escenario4;
import grupo05abd.escenarios.Escenario5;
import grupo05abd.servicio.CargaCrypto;



public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Ejecutar Escenario 1");
            System.out.println("2. Ejecutar Escenario 2");
            System.out.println("3. Ejecutar Escenario 3");
            System.out.println("4. Ejecutar Escenario 4");
            System.out.println("5. Ejecutar Escenario 5");
            System.out.println("6. Cargar historial de criptomonedas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Escenario1 escenario1 = new Escenario1();
                    escenario1.ejecutarEscenario1();
                    break;
                case 2:
                    Escenario2 escenario2 = new Escenario2();
                    escenario2.ejecutarEscenario2();
                    break;
                case 3:
                    Escenario3 escenario3 = new Escenario3();
                    escenario3.ejecutarEscenario3();
                    break;
                case 4:
                    Escenario4 escenario4 = new Escenario4();
                    escenario4.ejecutarEscenario4();
                    break;
                case 5:
                    Escenario5 escenario5 = new Escenario5();
                    escenario5.ejecutarEscenario5();
                    break;
                case 6:
                    // Llama al método para cargar historial de criptomonedas
                    CargaCrypto cargaCrypto = new CargaCrypto();
                    cargaCrypto.cargarDatos("solana");  // Puedes personalizar la moneda aquí
                    break;
                case 7:
                    System.out.println("Cerrando el programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }

            System.out.println();  // Salto de línea para separar iteraciones

        } while (opcion != 7);

        scanner.close();
    }





}
