package peli.avaruustaistelu.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RajahdysTest {

    private Rajahdys r;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        this.r = new Rajahdys(0, 0);
    }

    @Test
    public void konstruktorinKoordinaatistoToimii() {
        assertEquals(0, r.getX());
        assertEquals(0, r.getY());
    }

    @Test
    public void konstruktorinLeveysJaKorkeusALussaToimii() {
        assertEquals(1, r.getLeveys());
        assertEquals(1, r.getKorkeus());
    }

    @Test
    public void elamaaAlussa() {
        assertEquals(30, r.getElamaaJaljella());
    }

    @Test
    public void elamaVaheneeOikein() {
        r.laajene();
        assertEquals(29, r.getElamaaJaljella());
    }

    @Test
    public void laajeneeToimii() {
        r.laajene();
        assertEquals(2, r.getLeveys());
        assertEquals(2, r.getKorkeus());
    }

}
