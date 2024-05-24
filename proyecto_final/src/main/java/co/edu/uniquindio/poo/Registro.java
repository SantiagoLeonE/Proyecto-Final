package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

public class Registro {
    /*
     * Atributos propios de la clase registro
     */
    private LocalDateTime ingreso;
    private LocalDateTime salida;
    public Vehiculo vehiculo;
    public Puesto puesto;

    /**
     * Metodo constructor de la clase registro
     * @param ingreso
     * @param salida
     * @param vehiculo
     * @param puesto
     */
    public Registro(Vehiculo vehiculo, Puesto puesto, LocalDateTime ingreso) {
        this.ingreso = LocalDateTime.now();
        assert vehiculo != null;
        assert puesto != null;
    }

    /**
     * Metodo get para obtener el ingreso de un registro
     * @return
     */
    public LocalDateTime getIngreso() {
        return ingreso;
    }

    /**
     * Metodo get para obtener la salida de un registro
     * @return
     */
    public LocalDateTime getSalida() {
        return salida;
    }

    /**
     * Metodo get para obtener el vehiculo de un registro
     * @return
     * 
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Metodo get para obtener el puesto de un registro
     * @return
     */
    public Puesto getPuesto() {
        return puesto;
    }

    /**
     * Metodo set para modificar la salida de un registro
     * @param salida
     */
    public void setSalida(LocalDateTime salida) {
        assert salida != null;
        this.salida = salida;
    }

    public double calcularCosto() {
        double costo = 0;
        if(salida != null) {
            long minutos = java.time.Duration.between(ingreso, salida).toMinutes();
            double horas = Math.ceil(minutos / 60);
            costo = horas * vehiculo.getTarifaPorHora();
        }
        return costo;
    }
}
