package peli.avaruustaistelu.pelimoottori;

import peli.avaruustaistelu.logiikka.Avaruustaistelu;
import peli.avaruustaistelu.kayttoliittyma.Kayttoliittyma;
import peli.avaruustaistelu.logiikka.Laaseri;

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

            a.getPelaaja1Alus().liiku(a.getLeveys(), a.getKorkeus());
            a.getPelaaja2Alus().liiku(a.getLeveys(), a.getKorkeus());

            for (Laaseri l : a.getPelaaja1Laaserit()) {
                l.liiku(a.getLeveys(), a.getKorkeus());
            }
            for (int i = 0; i < a.getPelaaja1Laaserit().size(); i++) {
                if (!a.getPelaaja1Laaserit().get(i).getAktiivinen()) {
                    a.getPelaaja1Laaserit().remove(i);
                }
            }

            for (Laaseri l : a.getPelaaja2Laaserit()) {
                l.liiku(a.getLeveys(), a.getKorkeus());
            }
            for (int i = 0; i < a.getPelaaja2Laaserit().size(); i++) {
                if (!a.getPelaaja2Laaserit().get(i).getAktiivinen()) {
                    a.getPelaaja2Laaserit().remove(i);
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
