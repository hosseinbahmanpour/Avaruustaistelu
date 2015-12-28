package peli.avaruustaistelu;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlusTest {

    private Alus alus;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        alus = new Alus(0, 0, 0, .15, .5, .98);
    }

    @Test
    public void konstruktoriToimiiOikein() {
        assertEquals(0, alus.getX(), DELTA);
        assertEquals(0, alus.getY(), DELTA);
        assertEquals(12, alus.getSade(), DELTA);
    }

    @Test
    public void setXToimiiOikein() {
        alus.setX(100);
        assertEquals(100, alus.getX(), DELTA);
    }

    @Test
    public void setYToimiiOikein() {
        alus.setY(100);
        assertEquals(100, alus.getY(), DELTA);
    }

}
