package peli.avaruustaistelu.pelimoottori;

import peli.avaruustaistelu.kayttoliittyma.Kayttoliittyma;
import peli.avaruustaistelu.logiikka.Laaseri;

/**
 *Tässä luokassa on pelilooppi.
 * @author Hossein Bahmanpour
 */
public class PeliLooppi {

    private Avaruustaistelu a;
    private Kayttoliittyma k;
    private TormaysTarkistaja t;
    
    /**
     * Konstruktori
     * @param a avaruustaistelu pelin oliot
     * @param k kayttoliittyma
     */

    public PeliLooppi(Avaruustaistelu a, Kayttoliittyma k) {
        this.a = a;
        this.k = k;
        this.t = new TormaysTarkistaja(this.a);
    }
    
    /**
     * Metodissa pelilooppi, missä oliot liikkuvat ja kutsutaan törmäystarkistajaa.
     */

    public void kaynnistaLooppi() {

        long aloitusAika = System.currentTimeMillis();
        int FPS = 25;
        long haluttuAika = 1000 / FPS;

        while (a.getP1().getElama() > 0 && a.getP2().getElama() > 0) {

            a.getA1().liiku(a.getLeveys(), a.getKorkeus());
            a.getA2().liiku(a.getLeveys(), a.getKorkeus());

            for (Laaseri l : a.getLaaseritA1()) {
                l.liiku(a.getLeveys(), a.getKorkeus());
            }
            for (int i = 0; i < a.getLaaseritA1().size(); i++) {
                if (!a.getLaaseritA1().get(i).getAktiivinen()) {
                    a.getLaaseritA1().remove(i);
                }
            }

            for (Laaseri l : a.getLaaseritA2()) {
                l.liiku(a.getLeveys(), a.getKorkeus());
            }
            for (int i = 0; i < a.getLaaseritA2().size(); i++) {
                if (!a.getLaaseritA2().get(i).getAktiivinen()) {
                    a.getLaaseritA2().remove(i);
                }
            }

            t.tarkistaTormaykset();
            k.getPaivitettava().paivita();

            long aikaNyt = System.currentTimeMillis();
            long kulunutAika = aikaNyt - aloitusAika;

            try {
                Thread.sleep(haluttuAika - kulunutAika);
            } catch (InterruptedException ex) {
            }

            aloitusAika = System.currentTimeMillis();

        }
    }

}
