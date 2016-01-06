package peli.avaruustaistelu.grafiikka;

import peli.avaruustaistelu.logiikka.Laaseri;
import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Tässä luokassa laaseri olion piirtämiseen liittyvät metodit.
 *
 * @author Hossein Bahmanpour
 */
public class LaaseriGrafiikka {

    private Laaseri laaseri;
    private final double[] xPisteetAlussa = {8, 2, -2, -8, -2, 2};
    private final double[] yPisteetAlussa = {0, 2, 2, 0, -2, -2};
    private int[] xPisteet;
    private int[] yPisteet;

    /**
     * Konstruktori.
     *
     * @param laaseri piirretyn grafiikan laaseri olio.
     */
    public LaaseriGrafiikka(Laaseri l) {
        this.laaseri = l;
        xPisteet = new int[6];
        yPisteet = new int[6];
    }

    /**
     * laaserin piirtämisen metodi
     *
     * @param g Java grafiikka.
     */
    public void piirra(Graphics g) {
        for (int i = 0; i < 6; i++) {
            xPisteet[i] = (int) (xPisteetAlussa[i] * Math.cos(laaseri.getKulma()) - yPisteetAlussa[i] * Math.sin(laaseri.getKulma()) + laaseri.getX() + 0.5);
            yPisteet[i] = (int) (xPisteetAlussa[i] * Math.sin(laaseri.getKulma()) + yPisteetAlussa[i] * Math.cos(laaseri.getKulma()) + laaseri.getY() + 0.5);
        }
        g.setColor(Color.RED);
        g.fillPolygon(xPisteet, yPisteet, 6);
    }

}
