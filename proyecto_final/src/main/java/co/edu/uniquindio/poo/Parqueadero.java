package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Parqueadero {

    /*
     * Atributos propios de la clase parqueadero
     */
    private int filas;
    private int columnas;
    private Puesto[][] puestos;
    private List <Registro> registros;
    private double totalRecaudadoDiario, totalRecaudadoMensual;
    private static Scanner scanner = new Scanner(System.in);
 
    /**
     * Metodo constructor de la clase parqueadero
     * @param filas
     * @param columnas
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
     * Método para obtener los puestos del parqueadero en forma de matriz
     * @return
     */
    public Puesto[][] getPuestos() {
        return puestos;
    }

    /**
     * Método get para obtener la colección de registros
     * @return
     */
    public List<Registro> getRegistros() {
        return registros;
    }

    /**
     * Método get para obtener el recaudo diario del parqueadero
     * @return
     */
    public double getTotalRecaudadoDiario() {
        return totalRecaudadoDiario;
    }

    /**
     * Método get para obtener el recaudo mensual del parqueadero
     * @return
     */
    public double getTotalRecaudadoMensual() {
        return totalRecaudadoMensual;
    }

    /**
     * Método para modificar el número de filas del parqueadero
     * @param filas
     */
    public void setFilas(int filas) {
        this.filas = filas;
    }

    /**
     * Método para modificar el número de columas del parqueadero
     * @param columnas
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
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
     * Método set para modificar los registros que hay en el parqueadero
     * @param registros
     */
    public void setRegistros(List<Registro> registros) {
        assert registros != null;
        this.registros = registros;
    }

    /**
     * Método set para modificar el recaudo diario del parqueadero
     * @param totalRecaudadoDiario
     */
    public void setTotalRecaudadoDiario(double totalRecaudadoDiario) {
        this.totalRecaudadoDiario = totalRecaudadoDiario;
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
     * @return
     */
    public boolean verificarDisponibilidadParqueadero() {
        for(int i=0;i<puestos.length;i++){
            for(int j=0;j<puestos[i].length;j++) {
                //Si encuentra al menos un puesto desocupado entonces el parqueadero tendrá disponibilidad
                if(!puestos[i][j].estaOcupado()) {
                    System.out.println("Hay disponibilidad en el parqueadero");
                    return true;
                }
            }
        }
        //Sino retornará que el parqueadero esta lleno 
        System.out.println("El parqueadero esta lleno");
        return false;
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

    /*
     * Método para ingresar un vehículo en un puesto especifico del parqueadero
     */
    public void ingresoVehiculo() {
        int i, j;

        do{
            System.out.println("Ingresar el número de la fila: ");
            i = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingresar el número de la columna: ");
            j = scanner.nextInt();
            scanner.nextLine();

            if(i < 0 || i >= puestos.length || j < 0 || j >= puestos.length) {
                System.out.println("Los valores de la fila o columna estan fuera de los limites");
            }
            else if(!verificarDisponibilidadPuesto(i, j)) {
                System.out.println("El puesto ya está ocupado. Intente de nuevo por favor.");
            }
        }
        while(i < 0 || i >= puestos.length || j < 0 || j >= puestos.length || !verificarDisponibilidadPuesto(i, j)); 

        System.out.println("Ingresar el nombre del propietario");
        String nombre = scanner.nextLine();

        System.out.println("Ingresar la identificación del propietario: ");
        String identificacion = scanner.nextLine();

        Propietario propietario = new Propietario(nombre, identificacion);
        LocalDateTime ingreso = LocalDateTime.now();

        System.out.println("Tipo de vehiculos: 1. Carro   2. Moto Clásica    3. Moto Híbrida");
        System.out.print("Seleccionar el tipo de vehículo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        String modelo;
        String placa;

        switch (tipo) {
            case 1:
                System.out.println("Ingresar el modelo del carro: ");
                modelo = scanner.nextLine();
            
                System.out.println("Ingresar la placa del carro: ");
                placa = scanner.nextLine();

                Carro carro = new Carro(modelo, placa, propietario);
                ubicarVehiculo(i, j, carro, ingreso);
                break;
            case 2: 
                System.out.println("Ingresar el modelo de la moto: ");
                modelo = scanner.nextLine();
            
                System.out.println("Ingresar la placa de la moto: ");
                placa = scanner.nextLine();

                System.out.println("Ingresar la velocidad máxima de la moto: ");
                double velocidadMaxima = scanner.nextDouble();
                scanner.nextLine();

                TipoMoto tipoMoto1 = TipoMoto.MOTOCLASICA;
                Moto motoClasica = new Moto(modelo, placa, propietario, velocidadMaxima, tipoMoto1);
                ubicarVehiculo(i, j, motoClasica, ingreso);
                break;
            case 3:
                System.out.println("Ingresar el modelo de la moto: ");
                modelo = scanner.nextLine();
        
                System.out.println("Ingresar la placa de la moto: ");
                placa = scanner.nextLine();

                System.out.println("Ingresar la velocidad máxima de la moto: ");
                velocidadMaxima = scanner.nextDouble();
                scanner.nextLine();

                TipoMoto tipoMoto2 = TipoMoto.MOTOHIBRIDA;
                Moto motoHibrida = new Moto(modelo, placa, propietario, velocidadMaxima, tipoMoto2);
                ubicarVehiculo(i, j, motoHibrida, ingreso);
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
        
    }
    
    /**
     * Método para ubicar un vehículo en un puesto específico del parqueadero
     * @param i
     * @param j
     * @param vehiculo
     * @param ingreso
     */
    public void ubicarVehiculo(int i, int j, Vehiculo vehiculo, LocalDateTime ingreso) {
        assert i >= 0 && i < filas : "La fila está fuera de los límites.";
        assert j >= 0 && j < columnas : "La columna está fuera de los límites.";
        if (verificarDisponibilidadPuesto(i, j)) {
            puestos[i][j].ocuparPuesto(vehiculo);
            registros.add(new Registro(vehiculo, puestos[i][j], ingreso));
            System.out.println("Vehículo registrado exitosamente.");
        } 
        else {
            System.out.println("El puesto ya está ocupado.");
        }
    }
          
    /*
     * Método para buscar el propietario de un vehículo en un puesto especifico
     */
    public void buscarPropietario() {
        System.out.println("Ingrese la fila en la que se encuentra el vehículo: ");
        int i = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la columna en la que se encuentra el vehículo: ");
        int j = scanner.nextInt();
        scanner.nextLine();

        Propietario propietario = identificarPropietario(i, j);

        if(propietario != null){
            System.out.println(propietario);
        }
        else {
            System.out.println("El puesto esta vacío");
        }
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

        if(i > filas || i < 0 || j > columnas || j < 0) {
            System.out.println("Los valores de la fila o columna esta fuera de los límites");
        }

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

    /*
     * Método para configurar las tarifas por horas de cada vehículo
     */
    public void configurarTarifasPorHora() {
        double tarifaCarro, tarifaClasica, tarifaHibrida;

        do {
            System.out.println("Ingresar la tarifa por hora para carros: ");
            tarifaCarro = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Ingresar la tarifa por hora para motos clasicas: ");
            tarifaClasica = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.println("Ingresar la tarifa por hora para motos hibridas");
            tarifaHibrida = scanner.nextDouble();
            scanner.nextLine();

            if(tarifaCarro < 0 || tarifaClasica < 0 || tarifaHibrida < 0) {
                System.out.println("Las tarifas no pueden ser negativas");
            }
        }
        while(tarifaCarro < 0 || tarifaClasica < 0 || tarifaHibrida < 0);

        System.out.println("Se configuraron las tarifas correctamente");

        Carro.setTarifaPorHoraCarro(tarifaCarro);
        Moto.setTarifaPorHoraMotoClasica(tarifaClasica);
        Moto.setTarifaPorHoraMotoHibrida(tarifaHibrida);
    }
     
    /*
     * Método para la salida de un vehículo
     */
    public void salidaVehiculo() {
        
        System.out.println("Ingresar el número de la fila: ");
        int i = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresar el número de la columna: ");
        int j = scanner.nextInt();
        scanner.nextLine();

        if(i < 0 || i >= filas || j < 0 || j >= columnas) {
            System.out.println("Los valores de fila o columna están fuera de los límites.");
        }
        else if(puestos[i][j].estaOcupado()) {
            liberarPuesto(i, j);
        }
        else {
            System.out.println("El puesto está libre");
        }
    }

    /**
     * Método para desocupar un puesto en el parqueadero y actualizar lo recaudado diario y mensual
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
                actualizarRecaudaciones(registro.calcularCosto());
                System.out.println("El puesto: " + puestos[i][j] + " ha quedado libre: ");
            }
            puestos[i][j].desocuparPuesto();
        }   
    }

    /*
     * Método para registrar la salida de un vehículo
     */
    public void registroVehiculoSalida() {
        System.out.println("Ingrese la placa del vehículo");
        String placa = scanner.nextLine();

        Vehiculo vehiculo = buscarVehiculoPorPlaca(placa);

        if(vehiculo != null) {
            Registro registro = obtenerRegistro(vehiculo);
            if(registro != null) {
                System.out.println(registro);
            }
        } else {
            System.out.println("No se encontró vehículo con esa placa.");
        }
    }

    /**
     * Método para buscar un vehículo por su placa
     * @param placa
     * @return
     */
    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Registro registro : registros) {
            if (registro.getSalida() != null && registro.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return registro.getVehiculo();
            }
        }
        return null;
    }
 
    /**
     * Método para actualizar las recaudaciones diarias y mensuales
     * @param costo
     */
    private void actualizarRecaudaciones(double costo) {
        totalRecaudadoDiario += costo;
        totalRecaudadoMensual += costo;
    }

    /*
     * Método para generar un reporte diario y al final reiniciar el total del recaudo para el día siguiente
     */
    public void generarReporteDiario() {
        System.out.println("Reporte diario del parqueadero");
        System.out.print("Total recaudado en el día: " + totalRecaudadoDiario + " Pesos\n");
        
        double totalCarros = 0;
        double totalMotosClasicas = 0;
        double totalMotosHibridas = 0;

        for (Registro registro : registros) {
            if (registro.getSalida() != null) {
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
        
    /*
     * Método para generar un reporte mensual y reiniciarlo a fin de mes para el próximo mes
     */
    public void generarReporteMensual() {
        System.out.println("\nReporte mensual del parqueadero");
        System.out.println("Total recaudado en el mes: " + totalRecaudadoMensual + " Pesos");

        totalRecaudadoMensual = 0;
    }  
}