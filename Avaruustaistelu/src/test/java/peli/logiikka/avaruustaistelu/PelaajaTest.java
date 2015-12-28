package peli.logiikka.avaruustaistelu;

import peli.logiikka.avaruustaistelu.Pelaaja;
import org.junit.Before;
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
        assertEquals(100, pelaaja1.getElama());
    }
    
    @Test
    public void ottaaDamageeToimii(){
        pelaaja1.ottaaDamagee(1);
        assertEquals(99, pelaaja1.getElama());
    }
    
}