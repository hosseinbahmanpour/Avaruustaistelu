package peli.avaruustaistelu;

import java.awt.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KuvioTest {

    private Kuvio kuvio;
    private Rectangle r;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
        this.kuvio = new Kuvio();
        this.r = new Rectangle(0, 0, 1, 1);
        kuvio.setShape(r);
        kuvio.setX(10);
        kuvio.setY(10);
        kuvio.setSuuntaKulma(20);
        kuvio.setLiikkumisKulma(20);
        kuvio.setVauhtiX(2);
        kuvio.setVauhtiY(2);
    }
    
    @Test
    public void konstruktoriToimiiOikein() {
        Kuvio k = new Kuvio();
        assertEquals(null, k.getShape());
        assertEquals(0, k.getLiikkumisKulma(), DELTA);
        assertEquals(0, k.getSuuntaKulma(), DELTA);
        assertEquals(0, k.getVauhtiX(), DELTA);
        assertEquals(0, k.getVauhtiY(), DELTA);
        assertEquals(0, k.getX(), DELTA);
        assertEquals(0, k.getY(), DELTA);
    }

    @Test
    public void kuvionShapeToimiiOikein() {
        assertEquals(r, kuvio.getShape());
    }
    
    @Test
    public void kuvionSetXToimiiOikein() {
        assertEquals(10, kuvio.getX(), DELTA);
    }
    
    
    
    
    
    
}
