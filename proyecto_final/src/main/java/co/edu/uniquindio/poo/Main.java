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
        /*
        Parqueadero parqueadero = new Parqueadero(2, 2);
            
        System.out.println(parqueadero.toString());

        Vehiculo carro1 = new Carro("2023", "RHW123", new Propietario("Migue", "098723"));
        Vehiculo carro2 = new Carro("2020", "KLO456", new Propietario("Jose", "134578"));
        Vehiculo moto1 = new Moto("2022", "NEM31D", new Propietario("Santiago", "198806"), 300, TipoMoto.MOTOCLASICA);
        Vehiculo moto2 = new Moto("2024", "UQR23M", new Propietario("Juan", "790148"), 200, TipoMoto.MOTOHIBRIDA);

        parqueadero.configurarTarifasPorHora(2000, 1000, 1500);

        parqueadero.ubicarVehiculo(0, 0, carro1);
        parqueadero.ubicarVehiculo(0, 1, carro2);
        parqueadero.ubicarVehiculo(1, 0, moto1);
        parqueadero.ubicarVehiculo(1, 1, moto2);

        System.out.println(parqueadero.obtenerRegistro(moto1));

        System.out.println(parqueadero.verificarDisponibilidadPuesto(0, 0));
        System.out.println(parqueadero.identificarPropietario(0, 1));

        parqueadero.verificarDisponibilidadParqueadero();

        parqueadero.liberarPuesto(0, 0);
        parqueadero.liberarPuesto(0, 1);
        parqueadero.liberarPuesto(1, 0);
        parqueadero.liberarPuesto(1, 1);

        System.out.println(parqueadero.obtenerRegistro(moto1));
        System.out.println(parqueadero.buscarVehiculoPorPlaca(moto1.getPlaca()));
        System.out.println(parqueadero.verificarDisponibilidadPuesto(0, 0));

        parqueadero.generarReporteDiario();
        parqueadero.generarReporteMensual();
         */

        