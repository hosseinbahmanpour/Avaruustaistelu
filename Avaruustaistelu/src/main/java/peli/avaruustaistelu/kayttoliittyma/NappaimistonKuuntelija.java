package peli.avaruustaistelu.kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import peli.avaruustaistelu.logiikka.Laaseri;
import peli.avaruustaistelu.logiikka.Pelaaja;

public class NappaimistonKuuntelija implements KeyListener {

    private Pelaaja p1;
    private Pelaaja p2;
    private ArrayList<Laaseri> laaserit;

    public NappaimistonKuuntelija(Pelaaja p1, Pelaaja p2, ArrayList<Laaseri> laaserit) {
        this.laaserit = laaserit;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            laaserit.add(p1.getAlus().ammu());
        }
        if (key == KeyEvent.VK_UP) {
            p1.getAlus().setKiihtyyko(true);
        }
        if (key == KeyEvent.VK_RIGHT) {
            p1.getAlus().setKaantyyOikealle(true);
        }
        if (key == KeyEvent.VK_LEFT) {
            p1.getAlus().setKaantyyVasemmalle(true);
        }
        if (key == KeyEvent.VK_TAB) {
            laaserit.add(p2.getAlus().ammu());
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

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

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
