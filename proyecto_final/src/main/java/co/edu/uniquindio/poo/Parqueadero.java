package co.edu.uniquindio.poo;

public class Parqueadero {
    /**
     * Atributos propios de la clase parqueadero
     */
     private int numPuestos;
     private Puesto puesto;
     private Registro registro;
    private double recaudoDiario,recaudoMensual;
 
    /**
     * Metodo constructor de la clase parqueadero
     * @param numPuestos
     * @param puesto
     * @param registro
     * @param recaudoDiario
     * @param recaudoMensual
     */
    public Parqueadero(int numPuestos, Puesto puesto, Registro registro, double recaudoDiario, double recaudoMensual) {
        this.numPuestos = numPuestos;
        this.puesto = puesto;
        this.registro = registro;
        this.recaudoDiario = recaudoDiario;
        this.recaudoMensual = recaudoMensual;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public int getNumPuestos() {
        return numPuestos;
    }

    public void setNumPuestos(int numPuestos) {
        this.numPuestos = numPuestos;
    }

    public double getRecaudoDiario() {
        return recaudoDiario;
    }

    public void setRecaudoDiario(double recaudoDiario) {
        this.recaudoDiario = recaudoDiario;
    }

    public double getRecaudoMensual() {
        return recaudoMensual;
    }

    public void setRecaudoMensual(double recaudoMensual) {
        this.recaudoMensual = recaudoMensual;
    }
    

    
}
