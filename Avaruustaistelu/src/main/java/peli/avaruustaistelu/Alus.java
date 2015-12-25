package peli.avaruustaistelu;

import java.awt.*;
import java.awt.geom.Point2D;

public class Alus {

    private double x;
    private double y;
    private double kulma;
    private double kaantymisNopeus;
    private double kiihtyvyys;
    private double xSuuntainenNopeus;
    private double ySuuntainenNopeus;
    private double ilmavastus;
    private double sade = 12;
    private boolean kiihtyyko;
    private boolean kaantyyVasemmalle;
    private boolean kaantyyOikealle;
    private final double[] xPisteetAlussa = {-15, -10, -15, 15};
    private final double[] yPisteetAlussa = {10, 0, -10, 0};
    private final double[] xPisteetAlussaLiekille = {-10, -25, -10};
    private final double[] yPisteetAlussaLiekille = {5, 0, -5};
    private int[] xPts;
    private int[] yPts;
    private int[] xPisteetLiekille;
    private int[] yPisteetLiekille;

    public Alus(double x, double y, double kulma, double kaantymisNopeus, double kiihtyvyys, double ilmavastus) {
        this.x = x;
        this.y = y;
        this.kulma = kulma;
        this.kaantymisNopeus = kaantymisNopeus;
        this.kiihtyvyys = kiihtyvyys;
        this.ilmavastus = ilmavastus;
        kiihtyyko = false;
        kaantyyVasemmalle = false;
        kaantyyOikealle = false;
        xPts = new int[4];
        yPts = new int[4];
        xPisteetLiekille = new int[3];
        yPisteetLiekille = new int[3];
    }

    public void piirra(Graphics g) {
        if (kiihtyyko) {
            for (int i = 0; i < 3; i++) {
                xPisteetLiekille[i] = (int) (xPisteetAlussaLiekille[i] * Math.cos(kulma) - yPisteetAlussaLiekille[i] * Math.sin(kulma) + x + 0.5);
                yPisteetLiekille[i] = (int) (yPisteetAlussaLiekille[i] * Math.sin(kulma) + yPisteetAlussaLiekille[i] * Math.cos(kulma) + y + 0.5);
            }
            g.setColor(Color.ORANGE);
            g.fillPolygon(xPisteetLiekille, yPisteetLiekille, 3);
        }

        for (int i = 0; i < 4; i++) {
            xPts[i] = (int) (xPisteetAlussa[i] * Math.cos(kulma) - yPisteetAlussa[i] * Math.sin(kulma) + x + 0.5);
            yPts[i] = (int) (xPisteetAlussa[i] * Math.sin(kulma) + yPisteetAlussa[i] * Math.cos(kulma) + y + 0.5);
        }
        g.setColor(Color.WHITE);
        g.fillPolygon(xPts, yPts, 4);
    }

    public void liiku(int ruudunLeveys, int ruudunKorkeus) {
        if (kaantyyOikealle) {
            kulma += kaantymisNopeus;
        }
        if (kaantyyVasemmalle) {
            kulma -= kaantymisNopeus;
        }

        if (kiihtyyko) {
            xSuuntainenNopeus += kiihtyvyys * Math.cos(kulma);
            ySuuntainenNopeus += kiihtyvyys * Math.sin(kulma);
        }

        x += xSuuntainenNopeus;
        y += ySuuntainenNopeus;
        xSuuntainenNopeus *= ilmavastus;
        ySuuntainenNopeus *= ilmavastus;

        if (x < 0) {
            x += ruudunLeveys;
        } else if (x > ruudunLeveys) {
            x -= ruudunLeveys;
        }

        if (y < 0) {
            y += ruudunKorkeus;
        } else if (y > ruudunKorkeus) {
            y -= ruudunKorkeus;
        }
    }

    public Laaseri ammu() {
        return new Laaseri(x, y, kulma, xSuuntainenNopeus, ySuuntainenNopeus, 50);
    }

    public void setKiihtyyko(boolean k) {
        this.kiihtyyko = k;
    }

    public void setKaantyyVasemmalle(boolean k) {
        this.kaantyyVasemmalle = k;
    }

    public void setKaantyyOikealle(boolean k) {
        this.kaantyyOikealle = k;
    }

    public Point2D getKeskipiste() {
        return new Point2D.Double(x, y);
    }

    public double getSade() {
        return sade;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
