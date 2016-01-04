package peli.avaruustaistelu.logiikka;

import peli.avaruustaistelu.logiikka.Alus;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlusTest {

    private Alus a;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        a = new Alus(0, 0, 0, .15, .5, .98);
    }

    @Test
    public void konstruktoriToimiiOikein() {
        assertEquals(0, a.getX(), DELTA);
        assertEquals(0, a.getY(), DELTA);
        assertEquals(12, a.getSade(), DELTA);
        assertEquals(0, a.getKulma(), DELTA);
    }

    @Test
    public void setXToimiiOikein() {
        a.setX(100);
        assertEquals(100, a.getX(), DELTA);
    }

    @Test
    public void setYToimiiOikein() {
        a.setY(100);
        assertEquals(100, a.getY(), DELTA);
    }
    
    @Test
    public void kaantyminenOikealleToimiiOikein() {
        a.setKaantyyOikealle(true);
        a.liiku(100, 100);
        assertEquals(0.15, a.getKulma(), DELTA);
    }
    
    @Test
    public void kaantyminenVasemmalleToimiiOikein() {
        a.setKaantyyVasemmalle(true);
        a.liiku(100, 100);        
        assertEquals(-0.15, a.getKulma(), DELTA);
    }
    
    @Test
    public void kiihtyminenToimiiOikein() {
        a.setKiihtyyko(true);
        a.liiku(100, 100);
        assertEquals(0.5, a.getX(), DELTA);
    } 
                

}
