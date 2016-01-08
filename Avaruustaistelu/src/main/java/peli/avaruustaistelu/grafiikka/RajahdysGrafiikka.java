package peli.avaruustaistelu.grafiikka;

import java.awt.Color;
import java.awt.Graphics;
import peli.avaruustaistelu.logiikka.Rajahdys;

/**
 * Rajahdysgrafiikka luokassa piirretään räjähdykset jotka syntyvät, kun
 * laaserit tai superaseet törmäävät aluksiin.
 *
 * @author Hossein Bahmanpour
 */
public class RajahdysGrafiikka {

    private final Rajahdys r;

    /**
     * Konstruktori.
     *
     * @param r räjähdys olio.
     */
    public RajahdysGrafiikka(Rajahdys r) {
        this.r = r;
    }

    /**
     * Räjähdyksen piirtämisen toteuttava metodi. Räjähdyksen väri välkkyy
     * oranssin ja punaisen välillä.
     *
     * @param g Javan grafiikka.
     */
    public void piirra(Graphics g) {
        if (r.getElamaaJaljella() % 2 == 0) {
            g.setColor(Color.ORANGE);
        } else {
            g.setColor(Color.RED);
        }
        g.fillOval(r.getX(), r.getY(), r.getLeveys(), r.getLeveys());
    }

}
