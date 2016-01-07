package peli.avaruustaistelu.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    private Pelaaja p;
    private Alus a;

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

}
