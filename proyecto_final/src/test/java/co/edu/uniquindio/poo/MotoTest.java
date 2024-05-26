package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class MotoTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /*
     * Prueba para verificar que los datos de una moto clásica estén correctos
     */
    @Test
    public void datosCompletosMotoClasica() {
        LOG.info("Inicio test datosCompletosMotoClasica");

        Moto moto = new Moto("2024", "DZW86E", new Propietario("Andres", "4567"), 135, TipoMoto.MOTOCLASICA);

        assertEquals("2024", moto.getModelo());
        assertEquals("DZW86E", moto.getPlaca());
        assertEquals("Andres", moto.getPropietario().getNombre());
        assertEquals("4567", moto.getPropietario().getIdentificacion());
        assertEquals(135, moto.getVelocidadMaxima());
        assertEquals(TipoMoto.MOTOCLASICA, moto.getTipoMoto());

        LOG.info("Fin test datosCompletosMotoClasica");
    }

    /*
     * Prueba para verificar que los datos de una moto híbrida estén correctos
     */
    @Test
    public void datosCompletosMotoHibrida() {
        LOG.info("Inicio test datosCompletosMotoHibrida");

        Moto moto = new Moto("2023", "YPN67A", new Propietario("Camilo", "6545"), 135, TipoMoto.MOTOHIBRIDA);

        assertEquals("2023", moto.getModelo());
        assertEquals("YPN67A", moto.getPlaca());
        assertEquals("Camilo", moto.getPropietario().getNombre());
        assertEquals("6545", moto.getPropietario().getIdentificacion());
        assertEquals(135, moto.getVelocidadMaxima());
        assertEquals(TipoMoto.MOTOHIBRIDA, moto.getTipoMoto());

        LOG.info("Fin test datosCompletosMotoHibrida");
    }

    /*
     * Prueba para verificar que los datos de una moto no estén nulos
     */
    @Test
    public void datosNulosMoto() {
        LOG.info("Inicio test datosNulosMoto");

        assertThrows(Throwable.class,()-> new Moto(null, null, null, -10, null));

        LOG.info("Fin test datosNulosMoto");
    }

    /*
     * Prueba para configurar la tarifa por hora de una moto clásica
     */
    @Test
    public void configurarTarifaPorHoraMotoClasica() {
        LOG.info("Inicio test configurarTarifaPorHoraMotoClasica");

        double tarifa = 5.0;
        Moto.setTarifaPorHoraMotoClasica(tarifa);

        Moto moto = new Moto("2024", "DZW86E", new Propietario("Juan", "10234"), 135, TipoMoto.MOTOCLASICA);
        assertEquals(tarifa, moto.getTarifaPorHoraVehiculo());

        LOG.info("Fin test configurarTarifaPorHoraMotoClasica");
    }

    /*
     * Prueba para configurar la tarifa por hora de una moto híbrida
     */
    @Test
    public void configurarTarifaPorHoraMotoHibrida() {
        LOG.info("Inicio test configurarTarifaPorHoraMotoHibrida");

        double tarifa = 9.0;
        Moto.setTarifaPorHoraMotoHibrida(tarifa);

        Moto moto = new Moto("2023", "YPN67A", new Propietario("Camilo", "6545"), 175, TipoMoto.MOTOHIBRIDA);
        assertEquals(tarifa, moto.getTarifaPorHoraVehiculo());

        LOG.info("Fin test configurarTarifaPorHoraMotoHibrida");
    }
}
