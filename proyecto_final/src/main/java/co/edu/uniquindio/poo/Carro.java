package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {

    /*
     * Atributos propios de la clase carro
     */
    private static double tarifaPorHoraCarro;

    /**
     * Metodo constructor de la clase carro que extiende y hereda atributos de la clase vehiculo
     * @param modelo
     * @param placa
     * @param propietario
     */
    public Carro(String modelo, String placa, Propietario propietario) {
        super(modelo, placa, propietario);
    }

    /**
     * Metodo implementado por la clase abstracta de vehiculo para obtener la tarifa por hora de un carro
     */
    @Override
    public double getTarifaPorHoraVehiculo() {
        return tarifaPorHoraCarro;
    }

    /**
     * Metodo para modificar la tarifa por hora de un carro
     * @param tarifa
     */
    public static void setTarifaPorHoraCarro(double tarifa) {
        assert tarifa > 0;
        tarifaPorHoraCarro = tarifa;
    }
}
