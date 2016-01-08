package peli.avaruustaistelu.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    private Pelaaja p;
    private Alus a;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        a = new Alus(0, 0, 0, .15, .5, .98);
        this.p = new Pelaaja("Pelaaja 1", a);
    }

    @Test
    public void pelaajanKonstruktoriToimiiOikein() {
        assertEquals("Pelaaja 1", p.getNimi());
        assertEquals(100, p.getElama());
        assertEquals(100, p.getLataus());
    }

    @Test
    public void ottaaDamageeToimii() {
        p.ottaaDamagee(1);
        assertEquals(99, p.getElama());
    }

    @Test
    public void superAseenAmpuminenTyhjentaaLatauksen() {
        p.ammuSuperAse();
        assertEquals(0, p.getLataus());
    }

    @Test
    public void lataaminenToimii() {
        p.ammuSuperAse();
        p.lataa();
        assertEquals(1, p.getLataus());
    }

    @Test
    public void lataaminenEiLataaYliSataProsenttia() {
        p.lataa();
        assertEquals(100, p.getLataus());
    }

    @Test
    public void pysaytaPelaajaToimiiX() {
        p.getAlus().setxSuuntainenNopeus(1);
        p.pysaytaPelaaja();
        assertEquals(1, p.getAlus().getxSuuntainenNopeus(), DELTA);
    }

    @Test
    public void pysaytaPelaajaToimiiY() {
        p.getAlus().setySuuntainenNopeus(1);
        p.pysaytaPelaaja();
        assertEquals(1, p.getAlus().getySuuntainenNopeus(), DELTA);
    }

    @Test
    public void pysaytaPelaajaToimiiKiihtyyko() {
        p.getAlus().setKiihtyyko(true);
        p.pysaytaPelaaja();
        assertFalse(p.getAlus().getKiihtyyko());
    }

    @Test
    public void nollaaPelaajaXY() {
        p.nollaaPelaaja(10, 10);
        assertEquals(10, p.getAlus().getX(), DELTA);
        assertEquals(10, p.getAlus().getY(), DELTA);
    }

    @Test
    public void nollaaPelaajaXYNopeus() {
        p.nollaaPelaaja(10, 10);
        assertEquals(0, p.getAlus().getxSuuntainenNopeus(), DELTA);
        assertEquals(0, p.getAlus().getySuuntainenNopeus(), DELTA);
    }

    @Test
    public void nollaaPelajaElamaTayteen() {
        p.ottaaDamagee(50);
        p.nollaaPelaaja(0, 0);
        assertEquals(100, p.getElama(), DELTA);
    }

    @Test
    public void nollaaPelajaLatausTayteen() {
        p.ottaaDamagee(50);
        p.nollaaPelaaja(0, 0);
        assertEquals(100, p.getLataus(), DELTA);
    }

}
