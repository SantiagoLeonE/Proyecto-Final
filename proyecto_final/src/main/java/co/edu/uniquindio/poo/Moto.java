package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    
    /*
     * Atríbutos de la clase Moto que extiende de la clase Vehículo
     */
    private final double velocidadMaxima; 
    private double tarifaPorHoraMotoClasica, tarifaPorHoraMotoHibrida;
    private TipoMoto tipoMoto;

    /**
     * Método constructor de la clase Moto
     * @param modelo
     * @param placa
     * @param propietario
     * @param velocidadMaxima
     * @param tipoMoto
     */
    public Moto(String modelo, String placa, Propietario propietario, double velocidadMaxima, TipoMoto tipoMoto) {
        super(modelo, placa, propietario);
        this.velocidadMaxima = velocidadMaxima;
        assert velocidadMaxima > 0;
        this.tipoMoto = tipoMoto;
    }

    /**
     * Método get para obtener la velocidad máxima de una moto
     * @return
     */
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Método get para obtener el tipo de moto(CLASICA ó HÍBRIDA)
     * @return
     */
    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    /**
     * Método set para modificar la tarifa por hora de una moto clásica
     * @param tarifa
     */
    public void setTarifaMotoClasica(double tarifa) {
        assert tarifaPorHoraMotoClasica > 0;
        this.tarifaPorHoraMotoClasica = tarifa;
    }

    /**
     * Método set para modificar la tarifa por hora de una moto clásica
     * @param tarifa
     */
    public void setTarifaMotoHibrida(double tarifa) {
        assert tarifaPorHoraMotoHibrida > 0;
        this.tarifaPorHoraMotoHibrida = tarifa;
    }

    /*
     * Método para obtener la tarifa por hora de las motos dependiendo de su tipo 
     */
    @Override
    public double getTarifaPorHora() {
        if (tipoMoto == TipoMoto.MOTOCLASICA) {
            return tarifaPorHoraMotoClasica;
        }
        else {
            return tarifaPorHoraMotoHibrida;
        }
    }
}
