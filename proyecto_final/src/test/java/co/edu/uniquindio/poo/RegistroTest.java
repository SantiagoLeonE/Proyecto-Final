package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class RegistroTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /*
     * Prueba para verificar que los datos de un registro estén completos
     */
    @Test
    public void datosCompletosRegistro() {
        LOG.info("Inicio test datosCompletos");

        Registro registro = new Registro(new Carro("2023", "PFN649", new Propietario("Juan", "1234")), new Puesto(0, 0), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        assertEquals("2023", registro.getVehiculo().getModelo());
        assertEquals("PFN649", registro.getVehiculo().getPlaca());
        assertEquals("Juan", registro.getVehiculo().getPropietario().getNombre());
        assertEquals("1234", registro.getVehiculo().getPropietario().getIdentificacion());
        assertEquals(0, registro.getPuesto().getI());
        assertEquals(0, registro.getPuesto().getJ());
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), registro.getIngreso().truncatedTo(ChronoUnit.SECONDS));

        LOG.info("Fin test datosCompletos");
    }

    /*
     * Prueba para verificar que los datos de un registro no estén nulos
     */
    @Test
    public void datosNulosRegistro() {
        LOG.info("Inicio test datosNulosRegistro");

        assertThrows(Throwable.class,()-> new Registro(null, null, null));

        LOG.info("Fin test datosNulosRegistro");
    }

    /*
     * Prueba para verificar el método para calcular el costo
     */
    @Test
    public void calcularCosto() {
        LOG.info("Inicio test calcularCosto");

        double tarifaPorHoraCarro = 2000.0;
        Carro.setTarifaPorHoraCarro(tarifaPorHoraCarro);

        Registro registro = new Registro(new Carro("2020", "PFN649", new Propietario("Juan", "4567")), new Puesto(0, 0), LocalDateTime.now().minusMinutes(30));
        registro.setSalida(LocalDateTime.now());

        assertEquals(2000.0, registro.calcularCosto());

        LOG.info("Fin test calcularCosto");
    }
}