package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class PuestoTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /*
     * Prueba para verificar que los datos de un puesto estén completos
     */
    @Test
    public void datosCompletosPuesto() {
        LOG.info("Inicio test datosCompletosPuesto");

        Puesto puesto = new Puesto(1, 2);

        assertEquals(1, puesto.getI());
        assertEquals(2, puesto.getJ());

        LOG.info("Fin test datosCompletosPuesto");
    }

    /*
     * Prueba para verificar el funcionamiento de los métodos ocupar y desocupar puesto
     */
    @Test
    public void ocuparYDesocuparPuesto() {
        LOG.info("Inicio test ocuparYDesocuparPuesto");

        Puesto puesto = new Puesto(1, 2);
        Carro carro = new Carro("2023", "PFN234", new Propietario("Juan", "1234"));

        assertFalse(puesto.estaOcupado());
        puesto.ocuparPuesto(carro);
        assertTrue(puesto.estaOcupado());
        assertEquals(carro, puesto.getVehiculo());
        puesto.desocuparPuesto();
        assertFalse(puesto.estaOcupado());
    }

    /*
     * Método para no poder crear un puesto con valores negativos
     */
    @Test
    public void datosPuestoNegativo() {
        LOG.info("Inicio test datosPuestoNegativo");

        assertThrows(Throwable.class, ()-> new Puesto(-2, -1) );

        LOG.info("Inicio test datosPuestoNegativo");
    }
}
