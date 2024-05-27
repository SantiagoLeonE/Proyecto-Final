package co.edu.uniquindio.poo;

import java.util.Collection;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parqueadero {

    /*
     * Atributos propios de la clase parqueadero
     */
    private int filas;
    private int columnas;
    private Collection <Vehiculo> vehiculos;
    private Puesto[][] puestos;
    private List <Registro> registrosDiarios;
    private List <Registro> registrosHistoricos;
    private double totalRecaudadoDiario, totalRecaudadoMensual;
    private Collection <String> placasRegistradas;
    private Collection <String> identificacionesPropietarios;
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
        this.vehiculos = new LinkedList<>();
        this.puestos = new Puesto[filas][columnas];
        assert puestos != null;
        this.registrosDiarios = new ArrayList<>();
        assert registrosDiarios != null;
        this.registrosHistoricos = new ArrayList<>();
        assert registrosHistoricos != null;
        this.totalRecaudadoDiario = 0;
        this.totalRecaudadoMensual = 0;
        this.placasRegistradas = new HashSet<>();
        this.identificacionesPropietarios = new HashSet<>();

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
     * Método get para obtener la colección de registros diarios
     * @return
     */
    public List<Registro> getRegistrosDiarios() {
        return registrosDiarios;
    }

    /**
     * Método get para obtener la colección de registros históricos
     * @return
     */
    public List<Registro> getRegistrosHistoricos() {
        return registrosHistoricos;
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
        assert filas > 0;
        this.filas = filas;
    }

    /**
     * Método para modificar el número de columas del parqueadero
     * @param columnas
     */
    public void setColumnas(int columnas) {
        assert columnas > 0;
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
     * Método set para modificar los registros diarios del parqueadero
     * @param registros
     */
    public void setRegistrosDiarios(List<Registro> registrosDiarios) {
        assert registrosDiarios != null;
        this.registrosDiarios = registrosDiarios;
    }

    /**
     * Método set para modificar los registros historicos del parqueadero
     * @param registros
     */
    public void setRegistrosHistoricos(List<Registro> registrosHistoricos) {
        assert registrosHistoricos != null;
        this.registrosHistoricos = registrosHistoricos;
    }

    /**
     * Método set para modificar el recaudo diario del parqueadero
     * @param totalRecaudadoDiario
     */
    public void setTotalRecaudadoDiario(double totalRecaudadoDiario) {
        assert totalRecaudadoDiario > 0;
        this.totalRecaudadoDiario = totalRecaudadoDiario;
    }

    /**
     * Método set para modificar el recaudo mensual del parqueadero
     * @param totalRecaudadoMensual
     */
    public void setTotalRecaudadoMensual(double totalRecaudadoMensual) {
        assert totalRecaudadoMensual > 0;
        this.totalRecaudadoMensual = totalRecaudadoMensual;
    }

    /*
     * Método toString para obtener el número de filas y columnas del parqueadero
     */
    public String toString() {
        return "Número de filas: " + filas + " \nNúmero de columnas: " + columnas;
    }

    /**
     * Método para verificar que una placa no se repita en el parqueadero
     * @param placa
     * @return
     */
    public boolean verificarPlacaExiste(String placa) {
        return placasRegistradas.contains(placa);
    }

    /**
     * Método para verificar que una identificación no se repita
     * @param identificacion
     * @return
     */
    public boolean verificarIdExiste(String identificacion) {
        return identificacionesPropietarios.contains(identificacion);
    }

    /*
     * Método para configurar las tarifas por horas de cada vehículo
     */
    public void configurarTarifasPorHora() { 
        double tarifaCarro = 0;
        double tarifaClasica = 0;
        double tarifaHibrida = 0;
        String input;

        do {
            System.out.println("Ingresar la tarifa por hora para carros");
            input = scanner.nextLine();
            if(input.matches("\\d+(\\.\\d+)?")) {
                tarifaCarro = Double.parseDouble(input);
            }    
            else {
                System.out.println("El valor de la tarifa no es valido.");
            }
        }
        while(tarifaCarro < 1);    

        do {
            System.out.println("Ingresar la tarifa por hora para motos clasicas");
            input = scanner.nextLine();
            if(input.matches("\\d+(\\.\\d+)?")) {
                tarifaClasica = Double.parseDouble(input);
            }    
            else {
                System.out.println("El valor de la tarifa no es valido.");
            }
        }
        while(tarifaClasica < 1);

        do {
            System.out.println("Ingresar la tarifa por hora para motos hibridas");
            input = scanner.nextLine();
            if(input.matches("\\d+(\\.\\d+)?")) {
                tarifaHibrida = Double.parseDouble(input);
            }    
            else {
                System.out.println("El valor de la tarifa no es valido.");
            }
        }
        while(tarifaHibrida < 1);
        
        System.out.println("Se configuraron las tarifas correctamente");   
        
        Carro.setTarifaPorHoraCarro(tarifaCarro);
        Moto.setTarifaPorHoraMotoClasica(tarifaClasica);
        Moto.setTarifaPorHoraMotoHibrida(tarifaHibrida);
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

    /**
     * Método para asignar un puesto desocupado del parqueadero a un vehículo 
     * @param i
     * @param j
     * @param vehiculo
     * @param ingreso
     */
    public void asignarPuestoVehiculo(int i, int j, Vehiculo vehiculo, LocalDateTime ingreso) {
        assert i >= 0 && i < filas : "La fila está fuera de los límites.";
        assert j >= 0 && j < columnas : "La columna está fuera de los límites.";
        if (verificarDisponibilidadPuesto(i, j)) {
            puestos[i][j].ocuparPuesto(vehiculo);
            Registro registro = new Registro(vehiculo, puestos[i][j], ingreso);
            registrosDiarios.add(registro);
            registrosHistoricos.add(registro);
            vehiculos.add(vehiculo);
            System.out.println("Vehículo registrado exitosamente.");
        } 
        else {
            System.out.println("El puesto ya está ocupado.");
        }
    }

    /*
     * Método para registrar el ingreso de un vehículo al parqueadero
     */
    public void registrarIngresoVehiculo() {
        int i, j;
        String input;

        do {
            i = -1;
            j = -1;
            do {
                System.out.println("Ingresar el número de la fila");
                input = scanner.nextLine();
                if(input.matches("-?\\d+")) {
                    i = Integer.parseInt(input);
                    if(i < 0 || i > puestos.length - 1) {
                        System.out.println("El número de la fila esta fuera de los límites.");
                    }
                }
                else {
                    System.out.println("El número de fila no es valido.");
                }
                
            }while(i < 0 || i > puestos.length - 1);

            do {
                System.out.println("Ingresar el número de la columna");
                input = scanner.nextLine();
                if(input.matches("-?\\d+")) {
                    j = Integer.parseInt(input);
                    if(j < 0 || j > puestos.length - 1) {
                        System.out.println("El número de la columna esta fuera de los límites.");
                    }
                }
                else {
                    System.out.println("El número de columna no es valido.");
                }
                
            }
            while(j < 0 || j > puestos.length - 1);

            if(!verificarDisponibilidadPuesto(i, j)) {
                System.out.println("El puesto ya está ocupado. Intente de nuevo por favor.");
            }
        }   
        while(!verificarDisponibilidadPuesto(i, j)); 

        String nombre;
        do {
            System.out.println("Ingresar el nombre del propietario");
            nombre = scanner.nextLine();
            if(nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío");
            }
            else if(!Pattern.matches("[a-zA-z ]+", nombre)) {
                System.out.println("El nombre no puede contener números ni caracteres especiales");
            }
        }
        while(nombre.isBlank() || !Pattern.matches("[a-zA-z ]+", nombre));

        String identificacion;
        do {
            System.out.println("Ingresar la identificación del propietario");
            identificacion = scanner.nextLine();
            if(identificacion.isBlank()) {
                System.out.println("La identificación no puede estar vacía");
            }
            else if(verificarIdExiste(identificacion)) {
                System.out.println("La identificación ya existe. Por favor ingresar una identificación valida");
            }
        }
        while(identificacion.isBlank() || verificarIdExiste(identificacion));

        Propietario propietario = new Propietario(nombre, identificacion);
        LocalDateTime ingreso = LocalDateTime.now();

        System.out.println("Tipo de vehiculos: 1. Carro   2. Moto Clásica    3. Moto Híbrida");
        System.out.print("Seleccionar el tipo de vehículo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        while(tipo != 1 && tipo != 2 && tipo != 3) {
            System.out.println("El tipo de vehículo seleccionado no es válido. Ingresar nuevamente el tipo de vehículo");
            System.out.println("Tipo de vehiculos: 1. Carro   2. Moto Clásica    3. Moto Híbrida");
            tipo = scanner.nextInt();
            scanner.nextLine();
        }

        String modelo;
        do {
            System.out.println("Ingresar el modelo del vehiculo: ");
            modelo = scanner.nextLine();
            if(modelo.isBlank()) {
                System.out.println("El modelo no puede estar vacío");
            }
            else if(!Pattern.matches("\\d{4}", modelo)) {
                System.out.println("El modelo debe ser un número de 4 dígitos");
            }
        }
        while(modelo.isBlank() || !Pattern.matches("\\d{4}", modelo));

        String placa;
        do {
            System.out.println("Ingresar la placa del vehiculo: ");
            placa = scanner.nextLine();
            if(placa.isBlank()) {
                System.out.println("La placa no puede estar vacía");
            }
            else if(verificarPlacaExiste(placa)) {
                System.out.println("La placa ya existe. Por favor ingresar una placa valida");
            }
        }
        while(placa.isBlank() || verificarPlacaExiste(placa));

        int velocidadMaxima = -1;
        switch (tipo) {
            case 1:
                if(!verificarPlacaExiste(placa)) {
                    Carro carro = new Carro(modelo, placa, propietario);
                    asignarPuestoVehiculo(i, j, carro, ingreso);
                    placasRegistradas.add(placa);
                    identificacionesPropietarios.add(identificacion);                    
                }
                break;
            case 2:
                do {
                    System.out.println("Ingresar la velocidad máxima de la moto");
                    input = scanner.nextLine();
                    if(input.matches("-?\\d+")) {
                        velocidadMaxima = Integer.parseInt(input);
                        if(velocidadMaxima < 0) {
                            System.out.println("La velocidad máxima no puede ser negativa");
                        }
                    }
                    else {
                        System.out.println("La velocidad máxima no es valida");
                    }        
                }
                while(velocidadMaxima < 0);

                if(!verificarPlacaExiste(placa)) { 
                    TipoMoto tipoMoto1 = TipoMoto.MOTOCLASICA;
                    Moto motoClasica = new Moto(modelo, placa, propietario, velocidadMaxima, tipoMoto1);
                    asignarPuestoVehiculo(i, j, motoClasica, ingreso);
                    placasRegistradas.add(placa);
                    identificacionesPropietarios.add(identificacion); 
                }
                break;                
            case 3:
                do {
                    System.out.println("Ingresar la velocidad máxima de la moto");
                    input = scanner.nextLine();
                    if(input.matches("-?\\d+")) {
                        velocidadMaxima = Integer.parseInt(input);
                        if(velocidadMaxima < 0) {
                            System.out.println("La velocidad máxima no puede ser negativa");
                        }
                    }
                    else {
                        System.out.println("La velocidad máxima no es valida");
                    }
                }
                while(velocidadMaxima < 0);

                if(!verificarPlacaExiste(placa)) {
                    TipoMoto tipoMoto2 = TipoMoto.MOTOHIBRIDA;
                    Moto motoHibrida = new Moto(modelo, placa, propietario, velocidadMaxima, tipoMoto2);
                    asignarPuestoVehiculo(i, j, motoHibrida, ingreso);
                    placasRegistradas.add(placa);
                    identificacionesPropietarios.add(identificacion);                             
                    }
                break;
        }
    }
          
    /**
     * Método para buscar el propietario de un vehículo en un puesto especifico
     * @param i
     * @param j
     * @return
     */
    public Propietario buscarPropietarioVehiculo(int i, int j) {
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

    /*
     * Método para obtener el propietario de un vehículo en un puesto especifico
     */
    public void obtenerPropietarioVehiculo() {
        int i = -1;
        int j = -1;
        String input;
        do {
            System.out.println("Ingrese la fila en la que se encuentra el vehículo: ");
            input = scanner.nextLine();
            if(input.matches("-?\\d+")) {
                i = Integer.parseInt(input);
                if(i < 0 || i > puestos.length - 1) {
                    System.out.println("El número de fila esta fuera de los limites");
                }
            }
            else {
                System.out.println("El número de fila no es válido");
            }   
        }
        while(i < 0 || i > puestos.length - 1);

        do {
            System.out.println("Ingrese la columna en la que se encuentra el vehículo: ");
            input = scanner.nextLine();
            if(input.matches("-?\\d+")) {
                j = Integer.parseInt(input);
                if(j < 0 || j > puestos.length - 1) {
                    System.out.println("El número de columna esta fuera de los limites");
                }
            }
            else {
                System.out.println("El número de columna no es válido");
            }   
        }
        while(j < 0 || j > puestos.length - 1);

        Propietario propietario = buscarPropietarioVehiculo(i, j);

        if(propietario != null){
            System.out.println(propietario);
        }
        else {
            System.out.println("El puesto esta vacío");
        }
    }

    /**
     * Método para obtener el registro de un vehículo que no ha salido del parqueadero
     * @param vehiculo
     * @return
     */
    public Registro obtenerRegistroVehiculoSinSalir(Vehiculo vehiculo) {
        for (Registro registro : registrosDiarios) {
            if (registro.getVehiculo().equals(vehiculo)) {
                return registro;
            }
        }
        return null;
    }

    /**
     * Método para obtener el registro de un vehículo que ha salido del parqueadero
     * @param vehiculo
     * @return
     */
    public Registro obtenerRegistroVehiculoSalido(Vehiculo vehiculo) {
        for (Registro registro : registrosHistoricos) {
            if (registro.getVehiculo().equals(vehiculo)) {
                return registro;
            }
        }
        return null;
    }

    /**
     * Método para buscar un vehículo por su placa
     * @param placa
     * @return
     */
    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Registro registro : registrosHistoricos) {
            if (registro.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return registro.getVehiculo();
            }
        }
        return null;
    }

    /*
     * Método para obtener el registro de un vehículo
     */
    public void obtenerRegistroVehiculo() {
        if(!placasRegistradas.isEmpty()) {
            System.out.println("Ingrese la placa del vehículo");
            String placa = scanner.nextLine();

            while(!placasRegistradas.contains(placa)) {
                System.out.println("La placa ingresada no se encuentra registrada en el parqueadero, por favor ingrese  una placa válida");
                placa = scanner.nextLine();
            }
            Vehiculo vehiculo = buscarVehiculoPorPlaca(placa);

            if(vehiculo != null) {
                Registro registro = obtenerRegistroVehiculoSalido(vehiculo);
                if(registro != null) {
                    System.out.println(registro);
                }
            }    
            else {
                System.out.println("No se encontró vehículo con esa placa.");
            }
        }
        else {
            System.out.println("No se han registrado vehículos en el parqueadero");
        }        
    }

    /**
     * Método para desocupar un puesto en el parqueadero y actualizar el recaudado diario y mensual
     * @param i
     * @param j
     */
    public void liberarPuesto(int i, int j) {
        assert i >= 0 && i < filas;
        assert j >= 0 && j < columnas;
        if(puestos[i][j].estaOcupado()) {
            Registro registro = obtenerRegistroVehiculoSinSalir(puestos[i][j].getVehiculo());
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
    public void registrarSalidaVehiculo() {
        int i = -1; 
        int j = -1;
        String input;

        do {
            System.out.println("Ingresar el número de la fila");
            input = scanner.nextLine();
            if(input.matches("-?\\d+")) {
                i = Integer.parseInt(input);
                if(i < 0 || i > puestos.length - 1) {
                    System.out.println("El número de la fila esta fuera de los límites.");
                }
            }
            else {
                System.out.println("El número de fila no es valido.");
            }
            
        }while(i < 0 || i > puestos.length - 1);

        do {
            System.out.println("Ingresar el número de la columna");
            input = scanner.nextLine();
            if(input.matches("-?\\d+")) {
                j = Integer.parseInt(input);
                if(j < 0 || j > puestos.length - 1) {
                    System.out.println("El número de la columna esta fuera de los límites.");
                }
            }
            else {
                System.out.println("El número de columna no es valido.");
            }
            
        }while(j < 0 || j > puestos.length - 1);


        if(puestos[i][j].estaOcupado()) {
            liberarPuesto(i, j);
        }
        else {
            System.out.println("El puesto está libre");
        }
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

        for (Registro registro : registrosDiarios) {
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
        registrosDiarios.clear();
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