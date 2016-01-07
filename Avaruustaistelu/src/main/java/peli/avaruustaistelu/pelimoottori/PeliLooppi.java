package peli.avaruustaistelu.pelimoottori;

import java.util.Iterator;
import peli.avaruustaistelu.logiikka.Avaruustaistelu;
import peli.avaruustaistelu.kayttoliittyma.Kayttoliittyma;
import peli.avaruustaistelu.logiikka.Laaseri;
import peli.avaruustaistelu.logiikka.SuperAse;

/**
 * Tässä luokassa on pelilooppi.
 *
 * @author Hossein Bahmanpour
 */
public class PeliLooppi {

    private final Avaruustaistelu a;
    private final Kayttoliittyma k;
    private final TormaysTarkistaja t;

    /**
     * Konstruktori
     *
     * @param a avaruustaistelu pelin oliot
     * @param k kayttoliittyma
     */
    public PeliLooppi(Avaruustaistelu a, Kayttoliittyma k) {
        this.a = a;
        this.k = k;
        this.t = new TormaysTarkistaja(this.a);
    }

    /**
     * Metodissa pelilooppi, missä oliot liikkuvat ja kutsutaan
     * törmäystarkistajaa.
     */
    public void kaynnistaLooppi() {

        long aloitusAika = System.currentTimeMillis();
        int FPS = 25;
        long haluttuAika = 1000 / FPS;

        while (a.getP1().getElama() > 0 && a.getP2().getElama() > 0) {
            
            a.getP1().lataa();
            a.getP2().lataa();

            a.getPelaaja1Alus().liiku(a.getLeveys(), a.getKorkeus());
            a.getPelaaja2Alus().liiku(a.getLeveys(), a.getKorkeus());

            for (Laaseri l : a.getPelaaja1Laaserit()) {
                l.liiku(a.getLeveys(), a.getKorkeus());
            }
            Iterator<Laaseri> iteraattoriL1 = a.getPelaaja1Laaserit().iterator();
            while (iteraattoriL1.hasNext()) {
                if (!iteraattoriL1.next().getAktiivinen()) {
                    iteraattoriL1.remove();
                }
            }

            for (Laaseri l : a.getPelaaja2Laaserit()) {
                l.liiku(a.getLeveys(), a.getKorkeus());
            }
            Iterator<Laaseri> iteraattoriL2 = a.getPelaaja2Laaserit().iterator();
            while (iteraattoriL2.hasNext()) {
                if (!iteraattoriL2.next().getAktiivinen()) {
                    iteraattoriL2.remove();
                }
            }

            for (SuperAse s : a.getPelaaja1SuperAse()) {
                s.liiku(a.getLeveys(), a.getKorkeus());
            }
            Iterator<SuperAse> iteraattoriS1 = a.getPelaaja1SuperAse().iterator();
            while (iteraattoriS1.hasNext()) {
                if (!iteraattoriS1.next().getAktiivinen()) {
                    iteraattoriS1.remove();
                }
            }

            for (SuperAse s : a.getPelaaja2SuperAse()) {
                s.liiku(a.getLeveys(), a.getKorkeus());
            }
            Iterator<SuperAse> iteraattoriS2 = a.getPelaaja2SuperAse().iterator();
            while (iteraattoriS2.hasNext()) {
                if (!iteraattoriS2.next().getAktiivinen()) {
                    iteraattoriS2.remove();
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
