package peli.avaruustaistelu.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaaseriTest {

    private Alus a;
    private Pelaaja p;
    private Laaseri l;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        a = new Alus(0, 0, 0, .15, .5, .98);
        p = new Pelaaja ("Pelaaja 1", a);
        l = p.ammu();
    }

    @Test
    public void konstruktoriToimiiOikein() {
        assertEquals(0, l.getX(), DELTA);
        assertEquals(0, l.getY(), DELTA);
        assertEquals(0, l.getKulma(), DELTA);
        assertEquals(4, l.getSade(), DELTA);
        assertTrue(l.getAktiivinen());
    }

    @Test
    public void liikkuminenToimiiOikein() {
        l.liiku(10, 10);
        assertEquals(10, l.getX(), DELTA);
    }

    @Test
    public void getAktiivinenToimii() {
        l.liiku(10, 10);
        assertTrue(l.getAktiivinen());
    }

    @Test
    public void elinIkaVaheneeOikein() {
        Laaseri l2 = new Laaseri(0, 0, 0, 0, 0, 2);
        l2.liiku(10, 10);
        l2.liiku(10, 10);
        assertFalse(l2.getAktiivinen());
    }
    
}