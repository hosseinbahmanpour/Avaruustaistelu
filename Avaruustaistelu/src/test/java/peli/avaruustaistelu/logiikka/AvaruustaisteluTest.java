package peli.avaruustaistelu.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AvaruustaisteluTest {

    private final double DELTA = 1e-15;
    private Avaruustaistelu a;

    @Before
    public void setUp() {
        this.a = new Avaruustaistelu();
    }

    @Test
    public void konstruktoriLuoPelaajanOikein() {
        assertEquals("Pelaaja 1", a.getP1().getNimi());
        assertEquals(100, a.getP1().getElama());
        assertEquals(50, a.getPelaaja1Alus().getX(), DELTA);
        assertEquals(150, a.getPelaaja1Alus().getY(), DELTA);
        assertEquals(0, a.getPelaaja1Alus().getKulma(), DELTA);
        assertEquals(12, a.getPelaaja1Alus().getSade(), DELTA);
    }

    @Test
    public void konstruktoriLuoPelaajanOikein2() {
        assertEquals("Pelaaja 2", a.getP2().getNimi());
        assertEquals(100, a.getP2().getElama());
        assertEquals(730, a.getPelaaja2Alus().getX(), DELTA);
        assertEquals(450, a.getPelaaja2Alus().getY(), DELTA);
        assertEquals(3.14, a.getPelaaja2Alus().getKulma(), DELTA);
        assertEquals(12, a.getPelaaja2Alus().getSade(), DELTA);
    }

    @Test
    public void konstruktorinKorkeusJaLeveys() {
        assertEquals(800, a.getLeveys());
        assertEquals(600, a.getKorkeus());
    }

    @Test
    public void konstruktoriLuoTyhjatListat() {
        assertTrue(a.getPelaaja1Laaserit().isEmpty());
        assertTrue(a.getPelaaja2Laaserit().isEmpty());
        assertTrue(a.getPelaaja1SuperAse().isEmpty());
        assertTrue(a.getPelaaja2SuperAse().isEmpty());
    }

}
