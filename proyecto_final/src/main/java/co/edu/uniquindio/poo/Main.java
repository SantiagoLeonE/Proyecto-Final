package co.edu.uniquindio.poo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(2, 2);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Menú del Parqueadero");
            System.out.println("1. Configurar tarifas por hora");
            System.out.println("2. Ubicar un vehículo");
            System.out.println("3. Liberar un puesto");
            System.out.println("4. Verificar disponibilidad del parqueadero");
            System.out.println("5. Identificar propietario de un vehículo en un puesto");
            System.out.println("6. Obtener el registro de un vehículo");
            System.out.println("7. Generar reporte diario");
            System.out.println("8. Generar reporte mensual");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese tarifa por hora para carros: ");
                    double tarifaCarro = scanner.nextDouble();
                    System.out.print("Ingrese tarifa por hora para motos clásicas: ");
                    double tarifaClasica = scanner.nextDouble();
                    System.out.print("Ingrese tarifa por hora para motos híbridas: ");
                    double tarifaHibrida = scanner.nextDouble();
                    parqueadero.configurarTarifasPorHora(tarifaCarro, tarifaClasica, tarifaHibrida);
                    break;
                case 2:
                    System.out.print("Ingrese fila: ");
                    int fila = scanner.nextInt();
                    System.out.print("Ingrese columna: ");
                    int columna = scanner.nextInt();
                    System.out.print("Ingrese tipo de vehículo (1. Carro, 2. Moto Clásica, 3. Moto Híbrida): ");
                    int tipoVehiculo = scanner.nextInt();

                    System.out.print("Ingrese el modelo del vehículo: ");
                    String modelo = scanner.next();
                    System.out.print("Ingrese la placa del vehículo: ");
                    String placa = scanner.next();
                    System.out.print("Ingrese el nombre del propietario: ");
                    String nombrePropietario = scanner.next();
                    System.out.print("Ingrese el número de contacto del propietario: ");
                    String contactoPropietario = scanner.next();

                    Vehiculo vehiculo;
                    if (tipoVehiculo == 1) {
                        vehiculo = new Carro(modelo, placa, new Propietario(nombrePropietario, contactoPropietario));
                    } else if (tipoVehiculo == 2) {
                        System.out.print("Ingrese la cilindrada de la moto: ");
                        int cilindrada = scanner.nextInt();
                        vehiculo = new Moto(modelo, placa, new Propietario(nombrePropietario, contactoPropietario), cilindrada, TipoMoto.MOTOCLASICA);
                    } else {
                        System.out.print("Ingrese la cilindrada de la moto: ");
                        int cilindrada = scanner.nextInt();
                        vehiculo = new Moto(modelo, placa, new Propietario(nombrePropietario, contactoPropietario), cilindrada, TipoMoto.MOTOHIBRIDA);
                    }
                    parqueadero.ubicarVehiculo(fila, columna, vehiculo);
                    break;
                case 3:
                    System.out.print("Ingrese fila: ");
                    fila = scanner.nextInt();
                    System.out.print("Ingrese columna: ");
                    columna = scanner.nextInt();
                    parqueadero.liberarPuesto(fila, columna);
                    break;
                case 4:
                    parqueadero.verificarDisponibilidadParqueadero();
                    break;
                case 5:
                    System.out.print("Ingrese fila: ");
                    fila = scanner.nextInt();
                    System.out.print("Ingrese columna: ");
                    columna = scanner.nextInt();
                    Propietario propietario = parqueadero.identificarPropietario(fila, columna);
                    if (propietario != null) {
                        System.out.println("Propietario: " + propietario);
                    } else {
                        System.out.println("El puesto está vacío o fuera de límites.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese placa del vehículo: ");
                    String placaVehiculo = scanner.next();
                    // Debes implementar un método para buscar el vehículo real en el parqueadero
                    Vehiculo vehiculoEncontrado = parqueadero.buscarVehiculoRealPorPlaca(placaVehiculo);
                    if (vehiculoEncontrado != null) {
                        Registro registro = parqueadero.obtenerRegistro(vehiculoEncontrado);
                        if (registro != null) {
                            System.out.println(registro);
                            
                        } else {
                            System.out.println("No se encontró registro para el vehículo.");
                        }
                    } else {
                        System.out.println("No se encontró vehículo con esa placa.");
                    }
                    break;
                case 7:
                    parqueadero.generarReporteDiario();
                    break;
                case 8:
                    parqueadero.generarReporteMensual();
                    break;
                case 9:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}


    /**public static void main(String[] args) {
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

        System.out.println(parqueadero.identificarPropietario(0, 1));

        parqueadero.verificarDisponibilidadParqueadero();

        parqueadero.liberarPuesto(0, 0);
        parqueadero.liberarPuesto(0, 1);
        parqueadero.liberarPuesto(1, 0);
        parqueadero.liberarPuesto(1, 1);

        parqueadero.generarReporteDiario();
        parqueadero.generarReporteMensual();

    
    }
}
**/