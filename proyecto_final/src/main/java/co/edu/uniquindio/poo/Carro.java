package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {

    /*
     * Atributos propios de la clase carro
     */
    private double tarifaPorHora;

    /**
     * Metodo constructor de la clase carro que extiende y hereda atributos de la clase vehiculo
     * @param modelo
     * @param placa
     * @param propietario
     * @param tarifaPorHora
     */
    public Carro(String modelo, String placa, Propietario propietario, double tarifaPorHora) {
        super(modelo, placa, propietario);
        this.tarifaPorHora = tarifaPorHora;
    }

    /*
     * Metodo implementado por la clase abstracta de vehiculo para obtener la tarifa por hora de un carro
     */
    @Override
    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    /**
     * Metodo para modificar la tarifa por hora de un carro
     * @param tarifaPorHora
     */
    public void setTarifaPorHora(double tarifaPorHora) {
        assert tarifaPorHora > 0;
        this.tarifaPorHora = tarifaPorHora;
    }
}
