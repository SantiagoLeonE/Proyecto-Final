package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Parqueadero {
    /**
     * Atributos propios de la clase parqueadero
     */
     private int numPuestos;
     private Puesto puesto[][];
     private Collection<Registro>registro;
    private double recaudoDiario,recaudoMensual;
 
    /**
     * Metodo constructor de la clase parqueadero
     * @param numPuestos
     * @param puesto
     * @param registro
     * @param recaudoDiario
     * @param recaudoMensual
     */
    public Parqueadero(int numPuestos, Puesto[][] puesto, Registro registro, double recaudoDiario, double recaudoMensual) {
        this.numPuestos = numPuestos;
        this.puesto = puesto;
        this.registro = new LinkedList<>();
        this.recaudoDiario = recaudoDiario;
        this.recaudoMensual = recaudoMensual;
    }

    public Parqueadero(Puesto[][] puesto) {
        this.puesto = puesto;
    }


    public Puesto[][] getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto[][] puesto) {
        this.puesto = puesto;
    }

    public Collection<Registro> getRegistro() {
        return registro;
    }

    public void setRegistro(Collection<Registro> registro) {
        this.registro = registro;
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
    /**
     * Metodo para verificar si hay puestos disponibles en el parqueadero
     */
    public boolean hayPuestosDisponibles() {
        for(int i=0;i<puesto.length;i++){
            for(int j=0;j<puesto[i].length;j++){
                if(!puesto[i][j].estaOcupado()){/**Si encuentra al menos un puesto que no esta acupado retorna true */
                    return true;
                }
        }
    }
    return false;/** de lo contrario retornara false indicando qeu no se encuentra disponibilidad de puestos
    
    */
    

    
}
}
