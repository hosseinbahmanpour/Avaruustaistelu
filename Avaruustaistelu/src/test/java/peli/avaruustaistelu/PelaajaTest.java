package peli.avaruustaistelu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelaajaTest {
    
private Pelaaja pelaaja1;
    
    @Before
    public void setUp() {
        this.pelaaja1 = new Pelaaja("Pelaaja 1");
    }
    
    @Test
    public void pelaajanKonstruktoriToimiiOikein() {
        assertEquals("Pelaaja 1", pelaaja1.getNimi());
        assertEquals(10, pelaaja1.getElama());
        assertTrue(pelaaja1.onkoAseLadattu());
    }
    
    @Test
    public void ottaaDamageeToimii(){
        pelaaja1.ottaaDamagee();
        assertEquals(9, pelaaja1.getElama());
    }
    
    @Test
    public void ampuminenMuuttaaAseenTilanLataamattomaksi() {
        pelaaja1.ammu();
        assertFalse(pelaaja1.onkoAseLadattu());
    }
    
    @Test
    public void aseenLataaminenMuuttaaAseenTilanLadatuksi() {
        pelaaja1.ammu();
        pelaaja1.lataaAse();
        assertTrue(pelaaja1.onkoAseLadattu());
    }
    
}
