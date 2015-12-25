package peli.avaruustaistelu;

import java.awt.*;
import java.awt.geom.Point2D;

public class Laaseri {

    private final double laaserinNopeus = 10;
    private double x;
    private double y;
    private double xSuuntainenNopeus;
    private double ySuuntainenNopeus;
    private double kulma;
    private int elinIkaaJaljella;
    private boolean aktiivinen;
    private final double[] xPisteetAlussa = {8, 2, -2, -8, -2, 2};
    private final double[] yPisteetAlussa = {0, 2, 2, 0, -2, -2};
    private double laaserinSade = 4;
    private int[] xPisteet, yPisteet;
    

    public Laaseri(double x, double y, double kulma, double aluksenXSuuntainenNopeus, double aluksenYSuuntainenNopeus, int elinIkaaJaljella) {
        this.x = x;
        this.y = y;
        this.kulma = kulma;
        xSuuntainenNopeus = laaserinNopeus * Math.cos(kulma) + aluksenXSuuntainenNopeus;
        ySuuntainenNopeus = laaserinNopeus * Math.sin(kulma) + aluksenYSuuntainenNopeus;
        this.elinIkaaJaljella = elinIkaaJaljella;
        aktiivinen = true;
        xPisteet = new int[6];
        yPisteet = new int[6];        
    }

    public void piirra(Graphics g) {
        for (int i = 0; i < 6; i++) {
            xPisteet[i] = (int) (xPisteetAlussa[i] * Math.cos(kulma) - yPisteetAlussa[i] * Math.sin(kulma) + x + 0.5);
            yPisteet[i] = (int) (xPisteetAlussa[i] * Math.sin(kulma) + yPisteetAlussa[i] * Math.cos(kulma) + y + 0.5);
        }
        g.setColor(Color.RED);
        g.fillPolygon(xPisteet, yPisteet, 6);

    }

    public void liiku(int ruudunLeveys, int ruudunKorkeus) {
        if (aktiivinen) {
            x += xSuuntainenNopeus;
            y += ySuuntainenNopeus;
        }

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

        elinIkaaJaljella--;
        if (elinIkaaJaljella == 0) {
            aktiivinen = false;
        }
    }

    public boolean getAktiivinen() {
        return aktiivinen;
    }

    public Point2D getKeskipiste() {
        return new Point2D.Double(x, y);
    }

    public double getSade() {
        return laaserinSade;
    }

}
