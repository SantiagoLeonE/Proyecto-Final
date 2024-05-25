package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.List;
 
import java.util.ArrayList;

public class Parqueadero {

    /*
     * Atributos propios de la clase parqueadero
     */
    private int filas;
    private int columnas;
    private Puesto[][] puestos;
    private List <Registro> registros;
    private double totalRecaudadoDiario, totalRecaudadoMensual;
 
    /**
     * Metodo constructor de la clase parqueadero
     * @param filas
     * @param columnas
     * @param puestos
     * @param registros
     * @param totalRecaudadoDiario
     * @param totalRecaudadoMensual
     */
    public Parqueadero(int filas, int columnas) {
        this.filas = filas;
        assert filas > 0;
        this.columnas = columnas;
        assert columnas > 0;
        this.puestos = new Puesto[filas][columnas];
        this.registros = new ArrayList<>();
        this.totalRecaudadoDiario = 0;
        this.totalRecaudadoMensual = 0;

        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }

    /**
     * Método get para obtener la cantidad de filas que tiene el parqueadero
     * @return
     */
    public int getFilas() {
        return filas;  
    }

    /**
     * Método get para obtener la cantidad de columnas que tiene el parqueadero
     * @return
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Método set para modificar la cantidad de filas
     * @param filas
     */
    public void setFilas(int filas) {
        assert filas > 0;
        this.filas = filas;
    }

    /**
     * Método set para modificar la cantidad de columnas
     * @param columnas
     */
    public void setColumnas(int columnas) {
        assert columnas > 0;
        this.columnas = columnas;
    }

    /**
     * Método para obtener los puestos del parqueadero en forma de matriz
     * @return
     */
    public Puesto[][] getPuestos() {
        return puestos;
    }

    /**
     * Método para modificar los puestos del parqueadero
     * @param puestos
     */
    public void setPuestos(Puesto[][] puestos) {
        assert puestos != null;
        this.puestos = puestos;
    }

    /**
     * Método get para obtener la colección de registros
     * @return
     */
    public List<Registro> getRegistros() {
        return registros;
    }

    /**
     * Método set para modificar los registros que hay en el parqueadero
     * @param registros
     */
    public void setRegistros(List<Registro> registros) {
        assert registros != null;
        this.registros = registros;
    }

    /**
     * Método get para obtener el recaudo diario del parqueadero
     * @return
     */
    public double getTotalRecaudadoDiario() {
        return totalRecaudadoDiario;
    }

    /**
     * Método set para modificar el recaudo diario del parqueadero
     * @param totalRecaudadoDiario
     */
    public void setTotalRecaudadoDiario(double totalRecaudadoDiario) {
        this.totalRecaudadoDiario = totalRecaudadoDiario;
    }

    /**
     * Método get para obtener el recaudo mensual del parqueadero
     * @return
     */
    public double getTotalRecaudadoMensual() {
        return totalRecaudadoMensual;
    }

    /**
     * Método set para modificar el recaudo mensual del parqueadero
     * @param totalRecaudadoMensual
     */
    public void setTotalRecaudadoMensual(double totalRecaudadoMensual) {
        this.totalRecaudadoMensual = totalRecaudadoMensual;
    }

    /*
     * Método toString para obtener el número de filas y columnas del parqueadero
     */
    public String toString() {
        return "Número de filas: " + filas + " \nNúmero de columnas: " + columnas;
    }

    /**
     * Metodo para verificar la disponibilidad del parqueadero
     */
    public boolean verificarDisponibilidadParqueadero() {
        for(int i=0;i<puestos.length;i++){
            for(int j=0;j<puestos[i].length;j++) {
                if(!puestos[i][j].estaOcupado()) {/*Si encuentra al menos un puesto que no esta acupado retorna true*/
                    System.out.println("Hay disponibilidad en el parqueadero");
                    return true;
                }
            }
        }
        System.out.println("El parqueadero esta lleno");
        return false;/*Sino retornara false indicando que no se encuentra disponibilidad de puestos*/
    }

    /**
     * Método para verificar la disponibilidad de un puesto en específico 
     * @param i
     * @param j
     * @return
     */
    public boolean verificarDisponibilidadPuesto(int i, int j) {
        assert i >= 0 && i < filas;
        assert j >= 0 && j < columnas;
        return !puestos[i][j].estaOcupado();
    }

    /**
     * Método para ubicar un vehículo en un puesto especifico del parqueadero
     * @param i
     * @param j
     * @param vehiculo
     */
    public void ubicarVehiculo(int i, int j, Vehiculo vehiculo) {
        assert i >= 0 && i < filas : "La fila está fuera de los límites.";
        assert j >= 0 && j < columnas : "La columna está fuera de los límites.";
        if (verificarDisponibilidadPuesto(i, j)) {
            puestos[i][j].ocuparPuesto(vehiculo);
            registros.add(new Registro(vehiculo, puestos[i][j]));
        } 
        else {
            System.out.println("El puesto ya está ocupado.");
        }
        
        /*
        int i, j;
        do {
            i = (int) (Math.random() * filas);
            j = (int) (Math.random() * columnas);
        }
        while (!verificarDisponibilidadPuesto(i, j));
        //assert i >= 0 && i < filas;
        //assert j >= 0 && j < columnas;
        
        puestos[i][j].ocuparPuesto(vehiculo);
        registros.add(new Registro(vehiculo, puestos[i][j], LocalDateTime.now()));
         */
    }    
          
    

    /**
     * Método para identificar el propietario de un vehículo en un puesto especifico
     * @param i
     * @param j
     * @return
     */
    public Propietario identificarPropietario(int i, int j) {
        assert i >= 0 && i < filas;
        assert j >= 0 && j < columnas;
        if(puestos[i][j].estaOcupado()) {
            return puestos[i][j].getVehiculo().getPropietario();
        }
        else {
            return null;
        }
    }

    /**
     * Método para obtener el registro de un vehículo que no ha salido
     * @param vehiculo
     * @return
     */
    public Registro obtenerRegistro(Vehiculo vehiculo) {
    for (Registro registro : registros) {
        if (registro.getVehiculo().equals(vehiculo)) {
            return registro;
        }
    }
    return null;
}

  
    

    /**
     * Método para configurar las tarifas por hora de cada vehículo
     * @param tarifaCarro
     * @param tarifaClasica
     * @param tarifaHibrida
     */
    public void configurarTarifasPorHora(double tarifaCarro, double tarifaClasica, double tarifaHibrida) {
        assert tarifaCarro > 0;
        assert tarifaClasica > 0;
        assert tarifaHibrida > 0;
        
        Carro.setTarifaCarro(tarifaCarro);
        Moto.setTarifaClasica(tarifaClasica);
        Moto.setTarifaHibrida(tarifaHibrida);
    }
     
    

    /**
     * Método para desocupar un puesto en el parqueadero y actualizar el recaudo diario y mensual
     * @param i
     * @param j
     */
   public void liberarPuesto(int i, int j) {
        assert i >= 0 && i < filas;
        assert j >= 0 && j < columnas;
        if(puestos[i][j].estaOcupado()) {
            Registro registro = obtenerRegistro(puestos[i][j].getVehiculo());
            if(registro != null) {
                registro.setSalida(LocalDateTime.now());
                double tarifa = registro.calcularCosto();
                actualizarRecaudaciones(tarifa);
         
            }
            puestos[i][j].desocuparPuesto();
        }   
    }
 

    /**
     * Método para actualizar el recaudo diaro y mensual
     * @param tarifa
     */
    private void actualizarRecaudaciones(double tarifa) {
        totalRecaudadoDiario += tarifa;
        totalRecaudadoMensual += tarifa;
    }
    public void generarReporteDiario() {
        System.out.println("Reporte diario del parqueadero");
        System.out.println("Total recaudado en el día: " + totalRecaudadoDiario + " Pesos\n");
        
        double totalCarros = 0;
        double totalMotosClasicas = 0;
        double totalMotosHibridas = 0;
    
        for (Registro registro : registros) {
            if (registro.getSalida() != null) {
                double costo = registro.calcularCosto();
                if (registro.getVehiculo() instanceof Carro) {
                    totalCarros += costo;
                } else if (registro.getVehiculo() instanceof Moto) {
                    Moto moto = (Moto) registro.getVehiculo();
                    if (moto.getTipoMoto() == TipoMoto.MOTOCLASICA) {
                        totalMotosClasicas += costo;
                    } else if (moto.getTipoMoto() == TipoMoto.MOTOHIBRIDA) {
                        totalMotosHibridas += costo;
                    }
                }
            }
        }
    
        System.out.println("Carros: " + totalCarros + " Pesos");
        System.out.println("Motos Clásicas: " + totalMotosClasicas + " Pesos");
        System.out.println("Motos Híbridas: " + totalMotosHibridas + " Pesos");
        
        totalRecaudadoDiario = totalCarros + totalMotosClasicas + totalMotosHibridas;
    }
    

    /*
     * Método para generar un reporte diario y al final reiniciar el total del recaudo para el día siguiente
     */
   /**  public void generarReporteDiario() {
        System.out.println("Reporte diario del parqueadero");
        System.out.println("Total recaudado en el día: " + totalRecaudadoDiario + " Pesos\n");
        
        double totalCarros = 0;
        double totalMotosClasicas = 0;
        double totalMotosHibridas = 0;

        for (Registro registro : registros) {
            if (registro.getSalida() != null && registro.getVehiculo() != null) {
                if (registro.getVehiculo() instanceof Carro) {
                    totalCarros += registro.calcularCosto();
                } 
                else if (registro.getVehiculo() instanceof Moto) {
                    Moto moto = (Moto) registro.getVehiculo();
                    if (moto.getTipoMoto() == TipoMoto.MOTOCLASICA) {
                        totalMotosClasicas += registro.calcularCosto();
                    }
                    else if(moto.getTipoMoto() == TipoMoto.MOTOHIBRIDA) {
                        totalMotosHibridas += registro.calcularCosto();
                    }
                }
            }
        }

        System.out.println("Carros: " + totalCarros + " Pesos");
        System.out.println("Motos Clásicas: " + totalMotosClasicas + " Pesos");
        System.out.println("Motos Híbridas: " + totalMotosHibridas + " Pesos");
        
        totalRecaudadoDiario = 0;
    }
*/
    /*
     * Método para generar un reporte mensual
     */
    public void generarReporteMensual() {
        System.out.println("\nReporte mensual del parqueadero");
        System.out.println("Total recaudado en el mes " + totalRecaudadoMensual + " Pesos");

        totalRecaudadoMensual = 0;
    }
    public Vehiculo buscarVehiculoRealPorPlaca(String placa) {
        for (Registro registro : registros) {
            if (registro.getSalida() == null && registro.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return registro.getVehiculo();
            }
        }
        return null;
    }
    
 

 
     
}


    
    

