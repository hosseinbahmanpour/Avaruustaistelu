package peli.logiikka.avaruustaistelu;

import java.awt.geom.Point2D;

public class Laaseri {

    private double x;
    private double y;
    private double xSuuntainenNopeus;
    private double ySuuntainenNopeus;
    private double kulma;
    private int elinIkaaJaljella;
    private boolean aktiivinen;
    private final double laaserinSade = 4;
    private final double laaserinNopeus = 10;
    
    public Laaseri(double x, double y, double kulma, double aluksenXSuuntainenNopeus, double aluksenYSuuntainenNopeus, int elinIkaaJaljella) {
        this.x = x;
        this.y = y;
        this.kulma = kulma;
        xSuuntainenNopeus = laaserinNopeus * Math.cos(kulma) + aluksenXSuuntainenNopeus;
        ySuuntainenNopeus = laaserinNopeus * Math.sin(kulma) + aluksenYSuuntainenNopeus;
        this.elinIkaaJaljella = elinIkaaJaljella;
        aktiivinen = true;
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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
    
    public double getKulma() {
        return this.kulma;
    }

}
