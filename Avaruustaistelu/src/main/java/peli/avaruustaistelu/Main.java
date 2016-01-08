package peli.avaruustaistelu;

import peli.avaruustaistelu.pelimoottori.PeliLooppi;
import peli.avaruustaistelu.logiikka.Avaruustaistelu;
import javax.swing.SwingUtilities;
import peli.avaruustaistelu.kayttoliittyma.Kayttoliittyma;

/**
 * Pelin main luokkassa on pelin gamelooppi ja törmäysten laskemisen metodi.
 *
 * @author Hossein Bahmanpour
 */
public class Main {

    /**
     * Luodaan peli ja käynnistetään pelilooppi
     *
     * @param args ...
     */
    public static void main(String[] args) {
        Avaruustaistelu a = new Avaruustaistelu();
        Kayttoliittyma k = new Kayttoliittyma(a);
        SwingUtilities.invokeLater(k);
        PeliLooppi p = new PeliLooppi(a, k);
        p.kaynnistaLooppi();
    }

}
