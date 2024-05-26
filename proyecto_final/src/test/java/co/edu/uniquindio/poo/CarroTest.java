package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class CarroTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /*
     * Prueba para verificar que los datos de un carro estén completos
     */
    @Test
    public void datosCompletosCarro() {
        LOG.info("Inicio test datosCompletosCarro");

        Carro carro = new Carro("2023", "PFN649", new Propietario("Juan", "10234"));

        assertEquals("2023", carro.getModelo());
        assertEquals("PFN649", carro.getPlaca());
        assertEquals("Juan", carro.getPropietario().getNombre());
        assertEquals("10234", carro.getPropietario().getIdentificacion());

        LOG.info("Fin test datosCompletosCarro");
    }

    /*
     * Prueba para verificar que los datos de un carro no estén nulos
     */
    @Test
    public void datosNulosCarro() {
        LOG.info("Inicio test datosNulosCarro");

        assertThrows(Throwable.class,()-> new Carro(null, null, null));

        LOG.info("Fin test datosNulosCarro");
    }

    /*
     * Prueba para verificar que el método set de la tarifa por hora de un carro esté correcto
     */
    @Test
    public void configurarTarifaPorHoraCarro() {
        LOG.info("Inicio test modificarTarifaPorHoraCarro");

        double tarifa = 10.0;
        Carro.setTarifaPorHoraCarro(tarifa);

        Carro carro = new Carro("2023", "PFN649", new Propietario("Juan", "10234"));
        assertEquals(tarifa, carro.getTarifaPorHoraVehiculo());

        LOG.info("Fin test configurarTarifaPorHoraCarro");
    }
}
