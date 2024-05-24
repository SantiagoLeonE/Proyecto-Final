package co.edu.uniquindio.poo;

public class Puesto {
    /*
     * Atributos de la clase Puesto
     */
    private int i;
    private int j;
    private Vehiculo vehiculo;
    //private boolean ocupado;

    /**
     * Metodo constructor de la clase puesto
     * @param i  
     * @param j  
     */
    public Puesto(int i, int j) {
        this.i = i;
        assert i >= 0;
        this.j = j;
        assert j >= 0;
        this.vehiculo = null;
    }


    /**
     * Método get para obtener el valor de la variable i que es la fila en la que se encuentra el puesto
     * @return
     */
    public int getI() {
        return i;
    }

    /**
     * Método get para obtener el valor de la variable j que es la columna en la que se encuentra el puesto
     * @return
     */
    public int getJ() {
        return j;
    }

    /**
     * Método get para obtener el vehículo que esta en un puesto
     * @return
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    /**
     * Método booleano para verificar si un puesto esta ocupado por un vehiculo
     * @return
     */
    public boolean estaOcupado() {
        return vehiculo != null;
    }

    /**
     * Método para ocupar un puesto con un determinado vehiculo
     * @param vehiculo
     */
    public void ocuparPuesto(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /*
     * Método para desocupar un puesto, dejandolo libre para otro vehículo
     */
    public void desocuparPuesto() {
        this.vehiculo = null;
    }
}

    

