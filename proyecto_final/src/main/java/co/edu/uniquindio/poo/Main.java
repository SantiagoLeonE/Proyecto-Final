package co.edu.uniquindio.poo;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Parqueadero parqueadero = new Parqueadero(2, 2);

    Vehiculo moto = new Moto("2020", "RHW56E", new Propietario("Santiago", "1096"), 120, TipoMoto.MOTOCLASICA);

    public static void main(String[] args) {
        String opcion = "0";
        while(!opcion.equals("9")) {
            System.out.println("Menu del parqueadero");
            System.out.println("1. Configurar tarifas por hora");
            System.out.println("2. Registrar el ingreso de un vehículo");
            System.out.println("3. Registrar la salida de un vehículo");
            System.out.println("4. Verificar disponibilidad del parqueadero");
            System.out.println("5. Obtener propietario de un vehículo que está en el parqueadero");
            System.out.println("6. Obtener el registro de un vehículo");
            System.out.println("7. Generar reporte diario");
            System.out.println("8. Generar reporte mensual");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    parqueadero.configurarTarifasPorHora();
                    break;
                case "2":
                    parqueadero.registrarIngresoVehiculo();
                    break;
                case "3":
                    parqueadero.registrarSalidaVehiculo();
                    break;
                case "4":
                    parqueadero.verificarDisponibilidadParqueadero();
                    break;   
                case "5":
                    parqueadero.obtenerPropietarioVehiculo();
                    break;
                case "6":
                    parqueadero.obtenerRegistroVehiculo();
                    break;
                case "7":
                    parqueadero.generarReporteDiario();
                    break;
                case "8":
                    parqueadero.generarReporteMensual();
                    break;
                case "9":
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
       