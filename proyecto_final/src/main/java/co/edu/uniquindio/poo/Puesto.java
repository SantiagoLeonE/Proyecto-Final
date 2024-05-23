package co.edu.uniquindio.poo;

public class Puesto {
    private int i;
    private int j;
    private Vehiculo vehiculo;
    private boolean ocupado;

    /**
     * Metodo constructor de la clase puesto
     * @param i  
     * @param j  
     */
    public Puesto(int i, int j,boolean ocupado) {
        this.i = i;
        this.j = j;
        this.vehiculo = null;
        this.ocupado = ocupado;
    }



    /**

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
 
  
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public boolean isOcupado() {
        return ocupado;
    }



    public boolean estaOcupado() {
        return ocupado;
    }
}

    

