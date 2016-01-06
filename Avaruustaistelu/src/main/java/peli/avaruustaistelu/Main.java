package peli.avaruustaistelu;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import peli.avaruustaistelu.kayttoliittyma.Kayttoliittyma;
import peli.avaruustaistelu.logiikka.Laaseri;

/**
 * Pelin main luokkassa on pelin gamelooppi ja törmäysten laskemisen metodi.
 *
 * @author Hossein Bahmanpour
 */
public class Main {

    /**
     * Luodaan peli ja käynnistetään pelilooppi
     *
     * @param args
     */
    public static void main(String[] args) {
        Avaruustaistelu a = new Avaruustaistelu();
        Kayttoliittyma k = new Kayttoliittyma(a);
        SwingUtilities.invokeLater(k);

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

            tarkistaTormaykset(a);
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

    /**
     * Metodissa tarkistetaan peliloopissa tapahtuneet törmäykset.
     */
    public static void tarkistaTormaykset(Avaruustaistelu a) {

        ArrayList<Laaseri> poistettavat1 = new ArrayList<>();
        ArrayList<Laaseri> poistettavat2 = new ArrayList<>();

        Point2D a1Keskipiste = a.getA1().getKeskipiste();
        Point2D a2Keskipiste = a.getA2().getKeskipiste();

        double alustenEtaisyys = a1Keskipiste.distance(a2Keskipiste);

        if (alustenEtaisyys < a.getA1().getSade()) {
            a.getP1().ottaaDamagee(100);
            a.getP2().ottaaDamagee(100);
        }

        for (Laaseri l : a.getLaaseritA1()) {

            Point2D laaserinKeskipiste = l.getKeskipiste();
            double etaisyysA2 = laaserinKeskipiste.distance(a2Keskipiste);

            if (etaisyysA2 <= (l.getSade() + a.getA2().getSade())) {
                a.getP2().ottaaDamagee(1);
                poistettavat1.add(l);
            }
        }

        for (Laaseri l : a.getLaaseritA2()) {

            Point2D laaserinKeskipiste = l.getKeskipiste();
            double etaisyysA1 = laaserinKeskipiste.distance(a1Keskipiste);

            if (etaisyysA1 <= (l.getSade() + a.getA1().getSade())) {
                a.getP1().ottaaDamagee(1);
                poistettavat2.add(l);
            }
        }

        for (Laaseri l : poistettavat1) {
            a.getLaaseritA1().remove(l);
        }

        for (Laaseri l : poistettavat2) {
            a.getLaaseritA2().remove(l);
        }
    }

}
