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
     * @param vehiculo
     * @param puesto
     * @param ingreso
     */
    public Registro(Vehiculo vehiculo, Puesto puesto, LocalDateTime ingreso) {
        this.ingreso = LocalDateTime.now();
        this.vehiculo = vehiculo;
        assert vehiculo != null;
        this.puesto = puesto;
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

    /**
     * Método para el valor a pagar de un vehículo dependiendo de su tiempo en el parqueadero y del tipo de
     * vehículo
     * @return
     */
    public double calcularCosto() {   
        double costo = 0;
        double minutos = java.time.Duration.between(ingreso, salida).toMinutes();
        if (minutos < 60) {
            costo = vehiculo.getTarifaPorHoraVehiculo();
        }
        else {
            double horas = minutos / 60;
            costo = Math.ceil(horas) * vehiculo.getTarifaPorHoraVehiculo();
        }
        return costo;
    }
    
    /*
     * Método toString para mostrar la información de un registro como el tipo de vehiculo, la placa, el modelo,
     * una fecha y hora de ingreso y salida
     */
    @Override
    public String toString() {
        return "Registro [ TipoVehículo: " + vehiculo.getTipo() + ", Placa: " + vehiculo.getPlaca() + ", Modelo: " + vehiculo.getModelo() + ", Ingreso: " + ingreso + ", Salida: " + salida + " ]";
    }
}