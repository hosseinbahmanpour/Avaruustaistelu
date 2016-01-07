package peli.avaruustaistelu.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import peli.avaruustaistelu.logiikka.Avaruustaistelu;

/**
 * Käyttöliittymä luokassa luodaan graafinen käyttöliittymä pelille.
 *
 * @author Hossein Bahmanpour
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private final Avaruustaistelu a;
    private final Piirtoalusta piirtoalusta;

    /**
     * Konstruktori.
     *
     * @param a peli jolle käyttöliittymä luodaan.
     */
    public Kayttoliittyma(Avaruustaistelu a) {
        this.a = a;
        this.piirtoalusta = new Piirtoalusta(a);
    }

    /**
     * metodissa annetaan luodulle ikkunalle näkyvä otsikko. ikkuna asetetaan
     * näkyväksi, sen koko asetetaan ja komponentit lisätään.
     */
    @Override
    public void run() {
        frame = new JFrame("Avaruustaistelu");
        frame.setPreferredSize(new Dimension(a.getLeveys(), a.getKorkeus()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * komponentteja luodessa luodaan pelille näppäimistönkuuntelija.
     *
     * @param container ikkuna.
     */
    private void luoKomponentit(Container container) {
        container.add(piirtoalusta);
        NappaimistonKuuntelija n = new NappaimistonKuuntelija(a.getP1(), a.getP2(), a.getPelaaja1Laaserit(), a.getPelaaja2Laaserit(), a.getPelaaja1SuperAse(), a.getPelaaja2SuperAse());
        getFrame().addKeyListener(n);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Piirtoalusta getPaivitettava() {
        return piirtoalusta;
    }

}
