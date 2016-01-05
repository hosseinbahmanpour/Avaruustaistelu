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

    private Pelaaja p1;
    private Pelaaja p2;
    private ArrayList<Laaseri> laaserit;

    /**
     * konstruktori.
     *
     * @param p1 pelin eka pelaaja.
     * @param p2 pelin toka pelaaja.
     * @param laaserit arraylista pelissä olevista lasereista.
     */
    public NappaimistonKuuntelija(Pelaaja p1, Pelaaja p2, ArrayList<Laaseri> laaserit) {
        this.laaserit = laaserit;
        this.p1 = p1;
        this.p2 = p2;
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
            laaserit.add(p1.getAlus().ammu());
        }

        if (key == KeyEvent.VK_1) {
            laaserit.add(p2.getAlus().ammu());
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

    /**
     * tässä pelaajien alukset ampuvat aseilla aina kun nappia on näppäilty.
     *
     * @param e näppäilty nappi.
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

}
