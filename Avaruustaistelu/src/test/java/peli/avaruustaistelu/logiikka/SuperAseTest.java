package peli.avaruustaistelu.logiikka;

import peli.avaruustaistelu.logiikka.SuperAse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SuperAseTest {

    private Alus a;
    private Pelaaja p;
    private SuperAse s;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        a = new Alus(0, 0, 0, .15, .5, .98);
        p = new Pelaaja("Pelaaja 1", a);
        s = p.ammuSuperAse();
    }

    @Test
    public void konstruktoriToimiiOikein() {
        assertEquals(0, s.getX(), DELTA);
        assertEquals(0, s.getY(), DELTA);
        assertEquals(0, s.getKulma(), DELTA);
        assertEquals(6, s.getSade(), DELTA);
        assertTrue(s.getAktiivinen());
    }

    @Test
    public void ampuminenNollaaLatauksen() {
        assertEquals(0, p.getLataus());
    }

    @Test
    public void liikkuminenToimiiOikein() {
        s.liiku(10, 10);
        assertEquals(8, s.getX(), DELTA);
    }

    @Test
    public void getAktiivinenToimii() {
        s.liiku(10, 10);
        assertTrue(s.getAktiivinen());
    }

    @Test
    public void elinIkaVaheneeOikein() {
        SuperAse s2 = new SuperAse(0, 0, 0, 0, 0, 2);
        s2.liiku(10, 10);
        s2.liiku(10, 10);
        assertFalse(s2.getAktiivinen());
    }

}
