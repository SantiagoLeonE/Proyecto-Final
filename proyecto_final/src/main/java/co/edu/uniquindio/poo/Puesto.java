package co.edu.uniquindio.poo;

public class Puesto {
    private int i;
    private int j;
    private Vehiculo vehiculo;

    /**
     * Metodo constructor de la clase puesto
     * @param i  
     * @param j  
     */
    public Puesto(int i, int j) {
        this.i = i;
        this.j = j;
        this.vehiculo = null;
    }

    /**
     * 
     * @return
     */
    public int getI() {
        return i;
    }

    
    public int getJ() {
        return j;
    }

    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
 
    public boolean estaOcupado() {
        return vehiculo != null;
    }
}

    

