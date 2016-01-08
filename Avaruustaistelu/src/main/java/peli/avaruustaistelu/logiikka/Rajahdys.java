package peli.avaruustaistelu.logiikka;

import java.awt.*;
import peli.avaruustaistelu.grafiikka.RajahdysGrafiikka;

/**
 * Rajahdys luokassa rakennetaan räjähdys oliot.
 *
 * @author Hossein Bahmanpour
 */
public class Rajahdys {

    private final int x;
    private final int y;
    private int leveys;
    private int korkeus;
    private int elamaaJaljella;
    private RajahdysGrafiikka rajahdysGrafiikka;

    /**
     * Konstruktori.
     *
     * @param x koordinaatti x.
     * @param y koordinaatti y.
     */
    public Rajahdys(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
        this.leveys = 1;
        this.korkeus = 1;
        this.elamaaJaljella = 30;
        this.rajahdysGrafiikka = new RajahdysGrafiikka(this);
    }

    /**
     * Metodi kasvattaa rajahdys olion kokoa, ja vähentää elämää.
     */
    public void laajene() {
        leveys++;
        korkeus++;
        elamaaJaljella--;
    }

    public int getElamaaJaljella() {
        return elamaaJaljella;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public RajahdysGrafiikka getRajahdysGrafiikka() {
        return rajahdysGrafiikka;
    }

}
