package co.edu.uniquindio.poo;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Parqueadero parqueadero = new Parqueadero(2, 2);

    public static void main(String[] args) {
        int opcion = 0;
        while(opcion != 9) {
            System.out.println("Menu del parqueadero");
            System.out.println("1. Configurar tarifas por hora");
            System.out.println("2. Ubicar un vehículo");
            System.out.println("3. Liberar un puesto");
            System.out.println("4. Verificar disponibilidad del parqueadero");
            System.out.println("5. Identificar propietario de un vehículo en el parqueadero");
            System.out.println("6. Obtener el registro de un vehículo");
            System.out.println("7. Generar reporte diario");
            System.out.println("8. Generar reporte mensual");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    parqueadero.configurarTarifasPorHora();
                    break;
                case 2:
                    parqueadero.ingresoVehiculo();
                    break;
                case 3:
                    parqueadero.salidaVehiculo();
                    break;
                case 4:
                    parqueadero.verificarDisponibilidadParqueadero();
                    break;   
                case 5:
                    parqueadero.buscarPropietario();
                    break;
                case 6:
                    parqueadero.registroVehiculoSalida();
                    break;
                case 7:
                    parqueadero.generarReporteDiario();
                    break;
                case 8:
                    parqueadero.generarReporteMensual();
                    break;
                case 9:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}       