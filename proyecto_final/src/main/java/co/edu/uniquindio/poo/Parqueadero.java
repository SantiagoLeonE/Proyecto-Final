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
        // Declaración de las variables para las tarifas
        double tarifaCarro = 0;
        double tarifaClasica = 0;
        double tarifaHibrida = 0;
        String input;
    
        // Bucle para obtener una tarifa válida para carros
        do {
            System.out.println("Ingresar la tarifa por hora para carros");
            // Leer la entrada del usuario
            input = scanner.nextLine();
            // Verificar si la entrada es un número válido
            if(input.matches("\\d+(\\.\\d+)?")) {
                tarifaCarro = Double.parseDouble(input);
            }    
            else {
                // Imprimir mensaje de error si la entrada no es válida
                System.out.println("El valor de la tarifa no es valido.");
            }
        }
        // Repetir mientras la tarifa sea menor que 1
        while(tarifaCarro < 1);    
    
        // Bucle para obtener una tarifa válida para motos clásicas
        do {
            System.out.println("Ingresar la tarifa por hora para motos clasicas");
            // Leer la entrada del usuario
            input = scanner.nextLine();
            // Verificar si la entrada es un número válido
            if(input.matches("\\d+(\\.\\d+)?")) {
                tarifaClasica = Double.parseDouble(input);
            }    
            else {
                // Imprimir mensaje de error si la entrada no es válida
                System.out.println("El valor de la tarifa no es valido.");
            }
        }
        // Repetir mientras la tarifa sea menor que 1
        while(tarifaClasica < 1);
    
        // Bucle para obtener una tarifa válida para motos híbridas
        do {
            System.out.println("Ingresar la tarifa por hora para motos hibridas");
            // Leer la entrada del usuario
            input = scanner.nextLine();
            // Verificar si la entrada es un número válido
            if(input.matches("\\d+(\\.\\d+)?")) {
                tarifaHibrida = Double.parseDouble(input);
            }    
            else {
                // Imprimir mensaje de error si la entrada no es válida
                System.out.println("El valor de la tarifa no es valido.");
            }
        }
        // Repetir mientras la tarifa sea menor que 1
        while(tarifaHibrida < 1);
        
        // Mensaje de confirmación de que las tarifas fueron configuradas correctamente
        System.out.println("Se configuraron las tarifas correctamente");   
        
        // Configurar la tarifa por hora para carros en la clase Carro
        Carro.setTarifaPorHoraCarro(tarifaCarro);
        // Configurar la tarifa por hora para motos clásicas en la clase Moto
        Moto.setTarifaPorHoraMotoClasica(tarifaClasica);
        // Configurar la tarifa por hora para motos híbridas en la clase Moto
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
        // Asegura que el índice i esté dentro del rango válido de filas
        assert i >= 0 && i < filas;
        // Asegura que el índice j esté dentro del rango válido de columnas
        assert j >= 0 && j < columnas;
        // Devuelve verdadero si el puesto en la posición [i][j] no está ocupado, falso si está ocupado
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
        // Aserción para verificar que el índice de fila está dentro de los límites del parqueadero.
        assert i >= 0 && i < filas : "La fila está fuera de los límites.";
    
        // Aserción para verificar que el índice de columna está dentro de los límites del parqueadero.
        assert j >= 0 && j < columnas : "La columna está fuera de los límites.";
    
        // Verifica si el puesto en la posición (i, j) está disponible.
        if (verificarDisponibilidadPuesto(i, j)) {
            // Ocupa el puesto con el vehículo proporcionado.
            puestos[i][j].ocuparPuesto(vehiculo);
    
            // Crea un nuevo registro de ingreso del vehículo en el parqueadero.
            Registro registro = new Registro(vehiculo, puestos[i][j], ingreso);
    
            // Añade el nuevo registro a la lista de registros diarios.
            registrosDiarios.add(registro);
    
            // Añade el nuevo registro a la lista de registros históricos.
            registrosHistoricos.add(registro);
    
            // Añade el vehículo a la lista de vehículos presentes en el parqueadero.
            vehiculos.add(vehiculo);
    
            // Imprime un mensaje indicando que el vehículo se ha registrado exitosamente.
            System.out.println("Vehículo registrado exitosamente.");
        } 
        else {
            // Imprime un mensaje indicando que el puesto ya está ocupado.
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
                //Verificar si en la variable input se ingreso un valor que se puede pasar a un numero entero sin importar si es negativo
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
                //Verificar si en la variable input se ingreso un valor que se puede pasar a un numero entero sin importar si es negativo
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
            //Verificar que la variable nombre no pueda estar vacia
            if(nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío");
            }
            //Condición para verificar que un nombre solo debe contener caracteres del abecedario 
            else if(!Pattern.matches("[a-zA-z ]+", nombre)) {
                System.out.println("El nombre no puede contener números ni caracteres especiales");
            }
        }
        while(nombre.isBlank() || !Pattern.matches("[a-zA-z ]+", nombre));

        String identificacion;
        do {
            System.out.println("Ingresar la identificación del propietario");
            identificacion = scanner.nextLine();
            //Verificar que la variable nombre no pueda estar vacia
            if(identificacion.isBlank()) {
                System.out.println("La identificación no puede estar vacía");
            }
            //Condición para verificar que no se pueda registrar una identificacion que ya ha sido registrada anteriormente
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
            //Verificar que la variable modelo no pueda estar vacía
            if(modelo.isBlank()) {
                System.out.println("El modelo no puede estar vacío");
            }
            //Condición para verificar que un modelo debe ser un número de 4 dígitos
            else if(!Pattern.matches("\\d{4}", modelo)) {
                System.out.println("El modelo debe ser un número de 4 dígitos");
            }
        }
        while(modelo.isBlank() || !Pattern.matches("\\d{4}", modelo));

        String placa;
        do {
            System.out.println("Ingresar la placa del vehiculo: ");
            placa = scanner.nextLine();
            //Verificar que la variable placa no pueda estar vacía
            if(placa.isBlank()) {
                System.out.println("La placa no puede estar vacía");
            }
            //Condición para verificar que no se pueda registrar una placa que ya ha sido registrada anteriormente
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
                    //Condicion para verificar que lo ingresado en la variable input se pueda convertir en un numero entero, ya sea positivo o negativo
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
                    //Condicion para verificar que lo ingresado en la variable input se pueda convertir en un numero entero, ya sea positivo o negativo
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

  
    /**
 * Método para obtener el propietario del vehículo en un puesto específico.
 */
public void obtenerPropietarioVehiculo() {
    int i = -1; // Variable para almacenar el índice de la fila ingresada por el usuario.
    int j = -1; // Variable para almacenar el índice de la columna ingresada por el usuario.
    String input; // Variable para almacenar la entrada del usuario.

    do {
        System.out.println("Ingrese la fila en la que se encuentra el vehículo: "); // Solicitar al usuario que ingrese la fila.
        input = scanner.nextLine(); // Leer la entrada del usuario.

        if(input.matches("-?\\d+")) { // Verificar si la entrada es un número entero.
            i = Integer.parseInt(input); // Convertir la entrada a un entero y asignarlo a la variable i.

            if(i < 0 || i > puestos.length - 1) { // Verificar si el valor de i está dentro de los límites de las filas.
                System.out.println("El número de fila está fuera de los límites"); // Imprimir un mensaje de error.
            }
        } else {
            System.out.println("El número de fila no es válido"); // Imprimir un mensaje de error si la entrada no es un número.
        }   
    } while(i < 0 || i > puestos.length - 1); // Repetir el bucle hasta que se ingrese un valor válido para i.

    do {
        System.out.println("Ingrese la columna en la que se encuentra el vehículo: "); // Solicitar al usuario que ingrese la columna.
        input = scanner.nextLine(); // Leer la entrada del usuario.

        if(input.matches("-?\\d+")) { // Verificar si la entrada es un número entero.
            j = Integer.parseInt(input); // Convertir la entrada a un entero y asignarlo a la variable j.

            if(j < 0 || j > puestos.length - 1) { // Verificar si el valor de j está dentro de los límites de las columnas.
                System.out.println("El número de columna está fuera de los límites"); // Imprimir un mensaje de error.
            }
        } else {
            System.out.println("El número de columna no es válido"); // Imprimir un mensaje de error si la entrada no es un número.
        }   
    } while(j < 0 || j > puestos.length - 1); // Repetir el bucle hasta que se ingrese un valor válido para j.

    // Llamar al método buscarPropietarioVehiculo para obtener el propietario del vehículo en el puesto especificado.
    Propietario propietario = buscarPropietarioVehiculo(i, j);

    // Verificar si se encontró un propietario para el vehículo en el puesto especificado.
    if(propietario != null){
        System.out.println(propietario); // Imprimir el propietario del vehículo.
    } else {
        System.out.println("El puesto está vacío"); // Imprimir un mensaje indicando que el puesto está vacío.
    }
}

    /**
 * Método para obtener el registro de un vehículo que aún no ha salido del parqueadero.
 * @param vehiculo El vehículo del cual se desea obtener el registro.
 * @return El registro del vehículo si se encuentra en la lista de registros diarios, de lo contrario, devuelve null.
 */
public Registro obtenerRegistroVehiculoSinSalir(Vehiculo vehiculo) {
    for (Registro registro : registrosDiarios) { // Iterar sobre la lista de registros diarios.
        if (registro.getVehiculo().equals(vehiculo)) { // Verificar si el vehículo del registro coincide con el vehículo proporcionado.
            return registro; // Devolver el registro si se encuentra.
        }
    }
    return null; // Devolver null si no se encuentra ningún registro para el vehículo.
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
 * Método para buscar un vehículo por su placa.
 * @param placa La placa del vehículo que se desea buscar.
 * @return El vehículo cuya placa coincide con la proporcionada, si se encuentra en los registros históricos.
 *         De lo contrario, devuelve null.
 */
public Vehiculo buscarVehiculoPorPlaca(String placa) {
    for (Registro registro : registrosHistoricos) { // Iterar sobre la lista de registros históricos.
        if (registro.getVehiculo().getPlaca().equalsIgnoreCase(placa)) { // Verificar si la placa del vehículo en el registro coincide con la placa proporcionada, ignorando mayúsculas y minúsculas.
            return registro.getVehiculo(); // Devolver el vehículo si se encuentra.
        }
    }
    return null; // Devolver null si no se encuentra ningún vehículo con la placa proporcionada.
}


    /*
     * Método para obtener el registro de un vehículo
     */
    /*
 * Método para obtener el registro de un vehículo.
 */
public void obtenerRegistroVehiculo() {
    if (!placasRegistradas.isEmpty()) { // Verificar si hay placas registradas en el parqueadero.
        System.out.println("Ingrese la placa del vehículo"); // Solicitar al usuario que ingrese la placa del vehículo.
        String placa = scanner.nextLine(); // Leer la placa ingresada por el usuario.

        while (!placasRegistradas.contains(placa)) { // Verificar si la placa ingresada está registrada en el parqueadero.
            System.out.println("La placa ingresada no se encuentra registrada en el parqueadero, por favor ingrese una placa válida"); // Notificar al usuario que la placa no está registrada y solicitar una placa válida.
            placa = scanner.nextLine(); // Leer la nueva placa ingresada por el usuario.
        }
        
        Vehiculo vehiculo = buscarVehiculoPorPlaca(placa); // Buscar el vehículo correspondiente a la placa ingresada.

        if (vehiculo != null) { // Verificar si se encontró un vehículo con la placa ingresada.
            Registro registro = obtenerRegistroVehiculoSalido(vehiculo); // Obtener el registro del vehículo que ha salido del parqueadero.
            if (registro != null) { // Verificar si se encontró el registro del vehículo.
                System.out.println(registro); // Mostrar el registro del vehículo.
            }
        } else {
            System.out.println("No se encontró vehículo con esa placa."); // Notificar al usuario que no se encontró ningún vehículo con la placa ingresada.
        }
    } else {
        System.out.println("No se han registrado vehículos en el parqueadero"); // Notificar al usuario que no se han registrado vehículos en el parqueadero.
    }
}


    /**
     * Método para desocupar un puesto en el parqueadero y actualizar el recaudado diario y mensual
     * @param i
     * @param j
     */
    
     /**
 * Este método libera un puesto de estacionamiento dado por su posición en la matriz de puestos.
 * @param i La fila del puesto a liberar.
 * @param j La columna del puesto a liberar.
 */
public void liberarPuesto(int i, int j) {
    // Asegurarse de que los índices de fila y columna estén dentro de los límites válidos de la matriz.
    assert i >= 0 && i < filas;
    assert j >= 0 && j < columnas;

    // Verificar si el puesto de estacionamiento en la posición dada está ocupado.
    if(puestos[i][j].estaOcupado()) {
        // Obtener el registro del vehículo que ocupa el puesto de estacionamiento.
        Registro registro = obtenerRegistroVehiculoSinSalir(puestos[i][j].getVehiculo());
        // Verificar si se encontró un registro válido para el vehículo que ocupa el puesto.
        if(registro != null) {
            // Establecer la hora de salida del vehículo en el registro como la hora actual.
            registro.setSalida(LocalDateTime.now());
            // Actualizar las recaudaciones del estacionamiento con el costo calculado del registro.
            actualizarRecaudaciones(registro.calcularCosto());
            // Imprimir un mensaje indicando que el puesto de estacionamiento ha quedado libre.
            System.out.println("El puesto: " + puestos[i][j] + " ha quedado libre: ");
        }
        // Desocupar el puesto de estacionamiento.
        puestos[i][j].desocuparPuesto();
    }
}


    /*
     * Método para registrar la salida de un vehículo
     */
    
     /**
 * Este método maneja el proceso de registro de la salida de un vehículo del estacionamiento.
 */
public void registrarSalidaVehiculo() {
    // Se inicializan las variables i y j con el valor -1.
    int i = -1; 
    int j = -1;
    // Se declara una variable input de tipo String que se utilizará para almacenar la entrada del usuario.
    String input;

    // Bucle para obtener el número de fila del puesto de estacionamiento a liberar.
    do {
        System.out.println("Ingresar el número de la fila");
        input = scanner.nextLine();
        // Condición para verificar que la entrada sea un número entero válido.
        if(input.matches("-?\\d+")) {
            i = Integer.parseInt(input);
            // Verificar si el número de fila está dentro de los límites del estacionamiento.
            if(i < 0 || i > puestos.length - 1) {
                System.out.println("El número de la fila está fuera de los límites.");
            }
        }
        else {
            System.out.println("El número de fila no es válido.");
        }
    } while(i < 0 || i > puestos.length - 1);

    // Bucle para obtener el número de columna del puesto de estacionamiento a liberar.
    do {
        System.out.println("Ingresar el número de la columna");
        input = scanner.nextLine();
        // Condición para verificar que la entrada sea un número entero válido.
        if(input.matches("-?\\d+")) {
            j = Integer.parseInt(input);
            // Verificar si el número de columna está dentro de los límites del estacionamiento.
            if(j < 0 || j > puestos.length - 1) {
                System.out.println("El número de la columna está fuera de los límites.");
            }
        }
        else {
            System.out.println("El número de columna no es válido.");
        }
    } while(j < 0 || j > puestos.length - 1);

    // Verificar si el puesto de estacionamiento en la posición dada está ocupado.
    if(puestos[i][j].estaOcupado()) {
        liberarPuesto(i, j); // Liberar el puesto si está ocupado.
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
 * Método para generar un reporte diario y al final reiniciar el total del recaudo para el día siguiente.
 */
public void generarReporteDiario() {
    System.out.println("Reporte diario del parqueadero"); // Imprimir encabezado del reporte.

    // Imprimir el total recaudado en el día.
    System.out.print("Total recaudado en el día: " + totalRecaudadoDiario + " Pesos\n");
    
    // Inicializar variables para almacenar el total de recaudo por tipo de vehículo.
    double totalCarros = 0;
    double totalMotosClasicas = 0;
    double totalMotosHibridas = 0;

    // Recorrer todos los registros diarios para calcular el recaudo por tipo de vehículo.
    for (Registro registro : registrosDiarios) {
        // Verificar si el vehículo ha salido del parqueadero.
        if (registro.getSalida() != null) {
            // Verificar el tipo de vehículo.
            if (registro.getVehiculo() instanceof Carro) {
                totalCarros += registro.calcularCosto(); // Incrementar el total de recaudo de carros.
            } 
            else if (registro.getVehiculo() instanceof Moto) {
                Moto moto = (Moto) registro.getVehiculo();
                // Verificar el tipo de moto.
                if (moto.getTipoMoto() == TipoMoto.MOTOCLASICA) {
                    totalMotosClasicas += registro.calcularCosto(); // Incrementar el total de recaudo de motos clásicas.
                }
                else if(moto.getTipoMoto() == TipoMoto.MOTOHIBRIDA) {
                    totalMotosHibridas += registro.calcularCosto(); // Incrementar el total de recaudo de motos híbridas.
                }
            }
        }
    }

    // Imprimir el total de recaudo por tipo de vehículo.
    System.out.println("Carros: " + totalCarros + " Pesos");
    System.out.println("Motos Clásicas: " + totalMotosClasicas + " Pesos");
    System.out.println("Motos Híbridas: " + totalMotosHibridas + " Pesos");    

    totalRecaudadoDiario = 0; // Reiniciar el total recaudado para el día siguiente.
    registrosDiarios.clear(); // Limpiar la lista de registros diarios.
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