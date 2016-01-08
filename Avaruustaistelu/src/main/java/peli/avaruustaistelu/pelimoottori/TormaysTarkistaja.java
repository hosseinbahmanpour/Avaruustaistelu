package peli.avaruustaistelu.pelimoottori;

import peli.avaruustaistelu.logiikka.Avaruustaistelu;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import peli.avaruustaistelu.logiikka.Rajahdys;
import peli.avaruustaistelu.logiikka.Laaseri;
import peli.avaruustaistelu.logiikka.SuperAse;

/**
 * Luokka tarkistaa olioiden törmäämiset x y koordinaatistolla.
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

        ArrayList<Laaseri> poistettavatLaaseritP1 = new ArrayList<>();
        ArrayList<Laaseri> poistettavatLaaseritP2 = new ArrayList<>();

        ArrayList<SuperAse> poistettavatSuperAseetP1 = new ArrayList<>();
        ArrayList<SuperAse> poistettavatSuperAseetP2 = new ArrayList<>();

        Point2D a1Keskipiste = a.getPelaaja1Alus().getKeskipiste();
        Point2D a2Keskipiste = a.getPelaaja2Alus().getKeskipiste();

        double alustenEtaisyys = a1Keskipiste.distance(a2Keskipiste);

        if (alustenEtaisyys < a.getPelaaja1Alus().getSade()) {
            a.getPelaaja1Alus().setxSuuntainenNopeus(a.getPelaaja2Alus().getxSuuntainenNopeus() - a.getPelaaja1Alus().getxSuuntainenNopeus());
            a.getPelaaja1Alus().setySuuntainenNopeus(a.getPelaaja2Alus().getySuuntainenNopeus() - a.getPelaaja1Alus().getySuuntainenNopeus());
            a.getPelaaja2Alus().setxSuuntainenNopeus(a.getPelaaja1Alus().getxSuuntainenNopeus() - a.getPelaaja2Alus().getxSuuntainenNopeus());
            a.getPelaaja2Alus().setySuuntainenNopeus(a.getPelaaja1Alus().getySuuntainenNopeus() - a.getPelaaja2Alus().getySuuntainenNopeus());
            a.getP1().ottaaDamagee(5);
            a.getP2().ottaaDamagee(5);
        }

        for (Laaseri l : a.getPelaaja1Laaserit()) {

            double etaisyysA2 = l.getKeskipiste().distance(a2Keskipiste);

            if (etaisyysA2 <= (l.getSade() + a.getPelaaja2Alus().getSade())) {
                a.getP2().ottaaDamagee(1);
                a.getRajahdykset().add(new Rajahdys(l.getX(), l.getY()));
                poistettavatLaaseritP1.add(l);
            }
        }

        for (Laaseri l : a.getPelaaja2Laaserit()) {

            double etaisyysA1 = l.getKeskipiste().distance(a1Keskipiste);

            if (etaisyysA1 <= (l.getSade() + a.getPelaaja1Alus().getSade())) {
                a.getP1().ottaaDamagee(1);
                a.getRajahdykset().add(new Rajahdys(l.getX(), l.getY()));
                poistettavatLaaseritP2.add(l);
            }
        }

        for (Laaseri l : poistettavatLaaseritP1) {
            a.getPelaaja1Laaserit().remove(l);
        }

        for (Laaseri l : poistettavatLaaseritP2) {
            a.getPelaaja2Laaserit().remove(l);
        }

        for (SuperAse s : a.getPelaaja1SuperAse()) {

            double etaisyysA2 = s.getKeskipiste().distance(a2Keskipiste);

            if (etaisyysA2 <= (s.getSade() + a.getPelaaja2Alus().getSade())) {
                a.getPelaaja2Alus().setxSuuntainenNopeus(s.getxSuuntainenNopeus() - a.getPelaaja2Alus().getxSuuntainenNopeus());
                a.getPelaaja2Alus().setySuuntainenNopeus(s.getySuuntainenNopeus() - a.getPelaaja2Alus().getySuuntainenNopeus());
                a.getP2().ottaaDamagee(20);
                a.getRajahdykset().add(new Rajahdys(s.getX(), s.getY()));
                poistettavatSuperAseetP1.add(s);
            }
        }

        for (SuperAse s : a.getPelaaja2SuperAse()) {

            double etaisyysA1 = s.getKeskipiste().distance(a1Keskipiste);

            if (etaisyysA1 <= (s.getSade() + a.getPelaaja1Alus().getSade())) {
                a.getPelaaja1Alus().setxSuuntainenNopeus(s.getxSuuntainenNopeus() - a.getPelaaja1Alus().getxSuuntainenNopeus());
                a.getPelaaja1Alus().setySuuntainenNopeus(s.getySuuntainenNopeus() - a.getPelaaja1Alus().getySuuntainenNopeus());
                a.getP1().ottaaDamagee(20);
                a.getRajahdykset().add(new Rajahdys(s.getX(), s.getY()));
                poistettavatSuperAseetP2.add(s);
            }
        }

        for (SuperAse s : poistettavatSuperAseetP1) {
            a.getPelaaja1SuperAse().remove(s);
        }

        for (SuperAse s : poistettavatSuperAseetP2) {
            a.getPelaaja2SuperAse().remove(s);
        }
    }

}
