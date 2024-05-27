package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Propietario {
    
    /*
     * Atributos propios de la clase propietario
     */
    private String nombre;
    private String identificacion;
    private Collection <Vehiculo> vehiculos;

    /**
     * Metodo constructor de la clase propietario
     * @param nombre
     * @param identificacion
     */
    public Propietario(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.vehiculos = new LinkedList<>();
        assert nombre != null && !nombre.isBlank();
        assert identificacion != null && !identificacion.isBlank();
    }

    /**
     * Metodo get para obtener el nombre de un propietario
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo get para obtener la identificación de un propietario
     * @return
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Método get para obtener los vehiculos de un propietario
     * @return
     */
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Metodo set para modificar el nombre de un propietario
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo set para modificar la identificación de un propietario
     * @param identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /*
     * Metodo toString para mostrar el propietario y su identificación de un vehículo
     */
    @Override
    public String toString() {
        return "Propietario: " + nombre + " - Identificacion: " + identificacion;
    }

    /*
     * Método para agregar un vehículo a un propietario
     */
    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
}
