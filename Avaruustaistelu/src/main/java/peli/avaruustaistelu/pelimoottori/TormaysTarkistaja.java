package peli.avaruustaistelu.pelimoottori;

import peli.avaruustaistelu.logiikka.Avaruustaistelu;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import peli.avaruustaistelu.logiikka.Laaseri;

/**
 * Luokka tarkistaa olioiden törmäämiset x y koordinaatistolla
 *
 * @author Hossein Bahmanpour
 */
public class TormaysTarkistaja {

    private final Avaruustaistelu a;

    public TormaysTarkistaja(Avaruustaistelu a) {
        this.a = a;
    }

    /**
     * Metodissa tarkistetaan peliloopissa tapahtuneet törmäykset.
     */
    public void tarkistaTormaykset() {

        ArrayList<Laaseri> poistettavat1 = new ArrayList<>();
        ArrayList<Laaseri> poistettavat2 = new ArrayList<>();

        Point2D a1Keskipiste = a.getPelaaja1Alus().getKeskipiste();
        Point2D a2Keskipiste = a.getPelaaja2Alus().getKeskipiste();

        double alustenEtaisyys = a1Keskipiste.distance(a2Keskipiste);

        if (alustenEtaisyys < a.getPelaaja1Alus().getSade()) {
            a.getP1().ottaaDamagee(100);
            a.getP2().ottaaDamagee(100);
        }

        for (Laaseri l : a.getPelaaja1Laaserit()) {

            Point2D laaserinKeskipiste = l.getKeskipiste();
            double etaisyysA2 = laaserinKeskipiste.distance(a2Keskipiste);

            if (etaisyysA2 <= (l.getSade() + a.getPelaaja2Alus().getSade())) {
                a.getP2().ottaaDamagee(1);
                poistettavat1.add(l);
            }
        }

        for (Laaseri l : a.getPelaaja2Laaserit()) {

            Point2D laaserinKeskipiste = l.getKeskipiste();
            double etaisyysA1 = laaserinKeskipiste.distance(a1Keskipiste);

            if (etaisyysA1 <= (l.getSade() + a.getPelaaja1Alus().getSade())) {
                a.getP1().ottaaDamagee(1);
                poistettavat2.add(l);
            }
        }

        for (Laaseri l : poistettavat1) {
            a.getPelaaja1Laaserit().remove(l);
        }

        for (Laaseri l : poistettavat2) {
            a.getPelaaja2Laaserit().remove(l);
        }
    }

}
