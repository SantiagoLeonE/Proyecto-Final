package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void testVerificarDisponibilidad() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3,3);
        assertTrue(parqueadero.verificarDisponibilidadParqueadero()); // Comprobar disponibilidad de un puesto vacío
        parqueadero.asignarPuestoVehiculo(0, 0, new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez", "1234567890")),LocalDateTime.of(2024,5,3,23,2,2));
        assertFalse(parqueadero.verificarDisponibilidadPuesto(0, 0)); // Comprobar disponibilidad de un puesto ocupado

        LOG.info("Finalizando Test");
    }
    
 

    @Test
    public void testGenerarReporteMensual() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3,8);
        Vehiculo carro = new Carro("ABC123", "Toyota", new Propietario("Juan", "12345"));
        parqueadero. asignarPuestoVehiculo(0, 0, new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez", "1234567890")),LocalDateTime.of(2024,5,3,23,2,2));
        parqueadero.liberarPuesto(0, 0);
        parqueadero.generarReporteMensual();
        assertEquals(0, parqueadero.getTotalRecaudadoMensual()); // Verificar que el total recaudado se reinicia después de generar el reporte mensual

        LOG.info("Finalizando Test");
    } 

    @Test
    public void testCrearParqueaderoNegativo() {
        LOG.info("Iniciando Test");

        assertThrows(Throwable.class,()-> new Parqueadero(-1, -2));
        
            
        LOG.info("Finalizando Test");
    }

 

    @Test
    public void testIdentificarPropietarioPuestoVacio() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3,2);
        // Comprobamos que la función identificarPropietario para un puesto vacío devuelve null
        Propietario propietario = parqueadero.buscarPropietarioVehiculo(1, 1);
        if (propietario != null) {
            fail("Se esperaba que el puesto estuviera vacío y no tuviera propietario.");
        }

        LOG.info("Finalizando Test");
    }
    @Test
    public void testBuscarPropietarioVehiculo() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3, 3);
        Carro carro = new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez", "1234567890"));
        parqueadero.asignarPuestoVehiculo(0, 0, carro, LocalDateTime.of(2024, 5, 3, 23, 2, 2));
        Propietario propietario = parqueadero.buscarPropietarioVehiculo(0, 0);
        assertEquals("Camilo Sanchez", propietario.getNombre()); // Verificar que el propietario del vehículo asignado se pueda encontrar

        LOG.info("Finalizando Test");
    }

    @Test
    public void testLiberarPuesto() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3, 3);
        Carro carro = new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez", "1234567890"));
        parqueadero.asignarPuestoVehiculo(0, 0, carro, LocalDateTime.of(2024, 5, 3, 23, 2, 2));
        parqueadero.liberarPuesto(0, 0);
        assertTrue(parqueadero.verificarDisponibilidadPuesto(0, 0)); // Verificar que el puesto está vacío después de liberarlo

        LOG.info("Finalizando Test");
    }
    @Test
    public void testAsignarPuestoVehiculo() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3, 3);
        Carro carro = new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez", "1234567890"));
        parqueadero.asignarPuestoVehiculo(0, 0, carro, LocalDateTime.of(2024, 5, 3, 23, 2, 2));
        assertFalse(parqueadero.verificarDisponibilidadPuesto(0, 0)); // Verificar que el puesto está ocupado después de asignar un vehículo

        LOG.info("Finalizando Test");
    }
    
}