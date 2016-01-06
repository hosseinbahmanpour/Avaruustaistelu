package peli.avaruustaistelu.kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import peli.avaruustaistelu.logiikka.Laaseri;
import peli.avaruustaistelu.logiikka.Pelaaja;

/**
 * Tässä luokassa kuunnellaan näppäimistöä ja muutetaan pelaajien alusten
 * boolean arvoja sekä ammutaan.
 *
 * @author Hossein Bahmanpour
 */
public class NappaimistonKuuntelija implements KeyListener {

    private final Pelaaja p1;
    private final Pelaaja p2;
    private final ArrayList<Laaseri> lA1;
    private final ArrayList<Laaseri> lA2;

    /**
     * Konstruktori
     * @param p1 pelaaja 1
     * @param p2 pelaaja 2
     * @param lA1 pelaaja 1 aluksen ampumat laaserit
     * @param lA2 pelaaja 2 aluksen ampumat laaserit
     */
    public NappaimistonKuuntelija(Pelaaja p1, Pelaaja p2, ArrayList<Laaseri> lA1, ArrayList<Laaseri> lA2) {
        this.p1 = p1;
        this.p2 = p2;
        this.lA1 = lA1;
        this.lA2 = lA2;
    }

    /**
     * Metodi muuttaa boolean arvoja perustuen siihen onko nappi painettu.
     *
     * @param e painettu nappi.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            p1.getAlus().setKiihtyyko(true);
        }
        if (key == KeyEvent.VK_RIGHT) {
            p1.getAlus().setKaantyyOikealle(true);
        }
        if (key == KeyEvent.VK_LEFT) {
            p1.getAlus().setKaantyyVasemmalle(true);

        }
        if (key == KeyEvent.VK_W) {
            p2.getAlus().setKiihtyyko(true);
        }
        if (key == KeyEvent.VK_D) {
            p2.getAlus().setKaantyyOikealle(true);
        }
        if (key == KeyEvent.VK_A) {
            p2.getAlus().setKaantyyVasemmalle(true);
        }
    }

    /**
     * metodi muuttaa pelaaiien alusten boolean arvoja perustuen siihen että
     * nappia ei paineta.
     *
     * @param e painamaton nappi.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            lA1.add(p1.getAlus().ammu());
        }

        if (key == KeyEvent.VK_1) {
            lA2.add(p2.getAlus().ammu());
        }

        if (key == KeyEvent.VK_UP) {
            p1.getAlus().setKiihtyyko(false);
        }
        if (key == KeyEvent.VK_RIGHT) {
            p1.getAlus().setKaantyyOikealle(false);
        }
        if (key == KeyEvent.VK_LEFT) {
            p1.getAlus().setKaantyyVasemmalle(false);
        }

        if (key == KeyEvent.VK_W) {
            p2.getAlus().setKiihtyyko(false);
        }
        if (key == KeyEvent.VK_D) {
            p2.getAlus().setKaantyyOikealle(false);
        }
        if (key == KeyEvent.VK_A) {
            p2.getAlus().setKaantyyVasemmalle(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
