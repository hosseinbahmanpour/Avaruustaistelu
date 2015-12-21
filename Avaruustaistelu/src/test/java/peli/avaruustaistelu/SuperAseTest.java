package peli.avaruustaistelu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SuperAseTest {

    private SuperAse ase;

    @Before
    public void setUp() {
        this.ase = new SuperAse();
    }

    @Test
    public void konstruktoriToimiiOikein() {
        assertTrue(ase.onkoAseLadattu());
    }

    @Test
    public void ampuminenToimiiOikein() {
        ase.ammu();
        assertFalse(ase.onkoAseLadattu());
    }

    @Test
    public void lataaminenToimiiOikein() {
        ase.ammu();
        ase.lataa();
        assertTrue(ase.onkoAseLadattu());
    }

}