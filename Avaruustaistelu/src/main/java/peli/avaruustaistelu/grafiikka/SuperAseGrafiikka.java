package peli.avaruustaistelu.grafiikka;

import java.awt.Color;
import java.awt.Graphics;
import peli.avaruustaistelu.logiikka.SuperAse;

/**
 * Piirtää super ase olion
 *
 * @author Hossein Bahmanpour
 */
public class SuperAseGrafiikka {

    private final SuperAse s;
    private final double[] xPisteetAlussa = {8, 5, -5, -8, -5, 5};
    private final double[] yPisteetAlussa = {0, 5, 5, 0, -5, -5};
    private int[] xPisteet;
    private int[] yPisteet;

    /**
     * konstruktori
     *
     * @param s super ase olio
     */
    public SuperAseGrafiikka(SuperAse s) {
        this.s = s;
        xPisteet = new int[6];
        yPisteet = new int[6];
    }

    /**
     * metodi piirtää super ase olion x ja y koordinaatistossa
     *
     * @param g javan grafiikka
     */
    public void piirra(Graphics g) {
        for (int i = 0; i < 6; i++) {
            xPisteet[i] = (int) (xPisteetAlussa[i] * Math.cos(s.getKulma()) - yPisteetAlussa[i] * Math.sin(s.getKulma()) + s.getX() + 0.5);
            yPisteet[i] = (int) (xPisteetAlussa[i] * Math.sin(s.getKulma()) + yPisteetAlussa[i] * Math.cos(s.getKulma()) + s.getY() + 0.5);
        }
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(xPisteet, yPisteet, 6);
    }

}
