package peli.avaruustaistelu;

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

    public static void main(String[] args) {
        Avaruustaistelu a = new Avaruustaistelu();
        Kayttoliittyma k = new Kayttoliittyma(a);
        SwingUtilities.invokeLater(k);

        long aloitusAika = System.currentTimeMillis();
        int FPS = 25;
        long haluttuAika = 1000 / FPS;

        while (true) {

            a.getA1().liiku(a.getLeveys(), a.getKorkeus());
            a.getA2().liiku(a.getLeveys(), a.getKorkeus());

            for (Laaseri l : a.getLaaserit()) {
                l.liiku(a.getLeveys(), a.getKorkeus());
            }
            for (int i = 0; i < a.getLaaserit().size(); i++) {
                if (!a.getLaaserit().get(i).getAktiivinen()) {
                    a.getLaaserit().remove(i);
                }
            }
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
