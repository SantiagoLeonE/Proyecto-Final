package co.edu.uniquindio.poo;

public class Main {
    public static void main(String[] args) {
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
