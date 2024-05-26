package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    
    /*
     * Atríbutos de la clase Moto que extiende de la clase Vehículo
     */
    private final double velocidadMaxima; 
    private static double tarifaPorHoraMotoClasica, tarifaPorHoraMotoHibrida;
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
     * Método para obtener la tarifa por hora de las motos dependiendo de su tipo
     */
    @Override
    public double getTarifaPorHoraVehiculo() {
        if (tipoMoto == TipoMoto.MOTOCLASICA) {
            return tarifaPorHoraMotoClasica;
        }
        else if(tipoMoto == TipoMoto.MOTOHIBRIDA) {
            return tarifaPorHoraMotoHibrida;
        }
        else {
            return 0;
        }
    }

    /**
     * Método set para modificar la tarifa por hora de una moto clásica
     * @param tarifa
     */
    public static void setTarifaPorHoraMotoClasica(double tarifa) {
        assert tarifa > 0;
        tarifaPorHoraMotoClasica = tarifa;
    }

    /**
     * Método set para modificar la tarifa por hora de una moto clásica
     * @param tarifa
     */
    public static void setTarifaPorHoraMotoHibrida(double tarifa) {
        assert tarifa > 0;
        tarifaPorHoraMotoHibrida = tarifa;
    }

    /*
     * Método get para obtener un string con el tipo de vehículo
     */
    @Override
    public String getTipo() {
        return tipoMoto.toString();
    }
}
