package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class PropietarioTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /*
     * Prueba para verificar que los datos de un propietario estén completos
     */
    @Test
    public void datosCompletosPropietario() {
        LOG.info("Inicio test datosCompletosPropietario");

        Propietario propietario = new Propietario("Juan", "234");

        assertEquals("Juan", propietario.getNombre());
        assertEquals("234", propietario.getIdentificacion());

        LOG.info("Fin test datosCompletosPropietario");
    }

    /*
     * Prueba para verificar que los datos de un propietario no estén nulos
     */
    @Test
    public void datosNulosPropietario() {
        LOG.info("Inicio test datosNulosPropietario");

        assertThrows(Throwable.class,()-> new Propietario(null, null));

        LOG.info("Fin test datosNulosPropietario");
    }

    /*
     * Prueba para verificar que el método toString del propietario esté correcto
     */
    @Test
    public void toStringPropietario() {
        LOG.info("Inicio test toStringPropietario");
        Propietario propietario = new Propietario("Juan", "234");

        assertEquals("Propietario: Juan - Identificacion: 234", propietario.toString());

        LOG.info("Fin test toStringPropietario");
    }
}
