package peli.avaruustaistelu.logiikka;

import java.awt.Color;
import java.awt.geom.Point2D;

public class Alus {

    private double x;
    private double y;
    private double kulma;
    private final double kaantymisNopeus;
    private final double kiihtyvyys;
    private double xSuuntainenNopeus;
    private double ySuuntainenNopeus;
    private final double ilmavastus;
    private final double sade = 12;
    private boolean kiihtyyko;
    private boolean kaantyyVasemmalle;
    private boolean kaantyyOikealle;
    private final Color aluksenVari;

    public Alus(double x, double y, double kulma, double kaantymisNopeus,
            double kiihtyvyys, double ilmavastus, Color vari) {
        this.x = x;
        this.y = y;
        this.kulma = kulma;
        this.kaantymisNopeus = kaantymisNopeus;
        this.kiihtyvyys = kiihtyvyys;
        this.ilmavastus = ilmavastus;
        kiihtyyko = false;
        kaantyyVasemmalle = false;
        kaantyyOikealle = false;
        this.aluksenVari = vari;
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

    public boolean getKiihtyyko() {
        return this.kiihtyyko;
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

    public double getKulma() {
        return this.kulma;
    }

    public Color getVari() {
        return this.aluksenVari;
    }

}
