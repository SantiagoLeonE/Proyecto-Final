package co.edu.uniquindio.poo;
 

public abstract class Vehiculo {
    
    /*
     * Atríbutos de la clase vehículo
     */
    private final String modelo; 
    private final String placa;
    private final Propietario propietario;
 


    /**
     * Método constructor de la clase abstracta Vehiculo
     * @param modelo
     * @param placa
     * @param propietario
     */
    public Vehiculo(String modelo, String placa, Propietario propietario) {
        this.modelo = modelo;
        this.placa = placa;
        this.propietario = propietario;
        assert modelo != null && !modelo.isBlank();
        assert placa != null && !placa.isBlank();
    }

    /**
     * Método get para obtener el modelo del vehículo
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método get para obtener la placa del vehículo
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Método get para obtener el propietario del vehiculo
     * @return
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /* */
    public String toString() {
        return "Vehiculo [modelo=" + modelo + ", placa=" + placa + ", propietario=" + propietario + "]";
    }

    /**
     * Método abstracto para obtener la tarifa por hora de cada vehículo
     * @return
     */
    public abstract double getTarifaPorHoraVehiculo();


    
}
