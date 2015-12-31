package peli.avaruustaistelu.logiikka;

import java.awt.Color;
import peli.avaruustaistelu.logiikka.Pelaaja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelaajaTest {
    
private Pelaaja pelaaja1;
private Alus a;
    
    @Before
    public void setUp() {
        a = new Alus(0, 0, 0, .15, .5, .98, Color.GREEN);
        this.pelaaja1 = new Pelaaja("Pelaaja 1", a);
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
