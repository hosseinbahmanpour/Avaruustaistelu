package peli.avaruustaistelu;

import javax.swing.SwingUtilities;
import peli.avaruustaistelu.kayttoliittyma.Kayttoliittyma;
import peli.avaruustaistelu.logiikka.Laaseri;

/**
 * Pelin main luokkassa on pelin gamelooppi
 * @author Hossein Bahmanpour
 */

public class Main {

    public static void main(String[] args) {
        Avaruustaistelu a = new Avaruustaistelu();
        Kayttoliittyma k = new Kayttoliittyma(a);
        SwingUtilities.invokeLater(k);

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
            
            System.out.println(a.getLaaserit());

        }
    }
}
