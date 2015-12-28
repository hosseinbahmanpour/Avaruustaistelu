package peli.grafiikka.avaruustaistelu;

import peli.logiikka.avaruustaistelu.Alus;
import java.awt.*;
import java.awt.geom.Point2D;

public class AlusGrafiikka {

    private Alus alus;
    private final double[] xPisteetAlussa = {-15, -10, -15, 15};
    private final double[] yPisteetAlussa = {10, 0, -10, 0};
    private final double[] xPisteetAlussaLiekille = {-10, -25, -10};
    private final double[] yPisteetAlussaLiekille = {5, 0, -5};
    private int[] xPisteet;
    private int[] yPisteet;
    private int[] xPisteetLiekille;
    private int[] yPisteetLiekille;

    public AlusGrafiikka(Alus alus) {
        this.alus = alus;
        xPisteet = new int[4];
        yPisteet = new int[4];
        xPisteetLiekille = new int[3];
        yPisteetLiekille = new int[3];
    }

    public void piirra(Graphics g) {
        if (alus.getKiihtyyko()) {
            for (int i = 0; i < 3; i++) {
                xPisteetLiekille[i] = (int) (xPisteetAlussaLiekille[i] * Math.cos(alus.getKulma()) - yPisteetAlussaLiekille[i] * Math.sin(alus.getKulma()) + alus.getX() + 0.5);
                yPisteetLiekille[i] = (int) (yPisteetAlussaLiekille[i] * Math.sin(alus.getKulma()) + yPisteetAlussaLiekille[i] * Math.cos(alus.getKulma()) + alus.getY() + 0.5);
            }
            g.setColor(Color.ORANGE);
            g.fillPolygon(xPisteetLiekille, yPisteetLiekille, 3);
        }

        for (int i = 0; i < 4; i++) {
            xPisteet[i] = (int) (xPisteetAlussa[i] * Math.cos(alus.getKulma()) - yPisteetAlussa[i] * Math.sin(alus.getKulma()) + alus.getX() + 0.5);
            yPisteet[i] = (int) (xPisteetAlussa[i] * Math.sin(alus.getKulma()) + yPisteetAlussa[i] * Math.cos(alus.getKulma()) + alus.getY() + 0.5);
        }
        g.setColor(alus.getVari());
        g.fillPolygon(xPisteet, yPisteet, 4);
    }
}
