package co.edu.uniquindio.poo;

public class Propietario {
    
    /*
     * Atributos propios de la clase propietario
     */
    private String nombre;
    private String identificacion;

    /**
     * Metodo constructor de la clase propietario
     * @param nombre
     * @param identificacion
     */
    public Propietario(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
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

}
