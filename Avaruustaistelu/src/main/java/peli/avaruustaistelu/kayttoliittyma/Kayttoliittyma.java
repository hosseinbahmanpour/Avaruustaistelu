package peli.avaruustaistelu.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import peli.avaruustaistelu.Avaruustaistelu;

/**
 * Käyttöliittymä luokassa luodaan graafinen käyttöliittymä pelille.
 * @author Hossein Bahmanpour
 */

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Avaruustaistelu avaruustaistelu;
    private Piirtoalusta piirtoalusta;
    
    /**
     * Konstruktori.
     * @param avaruustaistelu peli jolle käyttöliittymä luodaan.
     */

    public Kayttoliittyma(Avaruustaistelu avaruustaistelu) {
        this.avaruustaistelu = avaruustaistelu;
        this.piirtoalusta = new Piirtoalusta(avaruustaistelu);
    }
    
    /**
     * metodissa annetaan luodulle ikkunalle näkyvä otsikko.
     * ikkuna asetetaan näkyväksi, sen koko asetetaan ja komponentit lisätään.
     */

    @Override
    public void run() {
        frame = new JFrame("Avaruustaistelu");
        frame.setPreferredSize(new Dimension(avaruustaistelu.getLeveys(), avaruustaistelu.getKorkeus()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * komponentteja luodessa luodaan pelille näppäimistönkuuntelija.
     * @param container ikkuna.
     */
    private void luoKomponentit(Container container) {
        container.add(piirtoalusta);
        NappaimistonKuuntelija n = new NappaimistonKuuntelija(avaruustaistelu.getP1(), avaruustaistelu.getP2(), avaruustaistelu.getLaaserit());
        getFrame().addKeyListener(n);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Piirtoalusta getPaivitettava() {
        return piirtoalusta;
    }

}
