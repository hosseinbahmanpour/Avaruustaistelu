package peli.avaruustaistelu.logiikka;

import java.awt.geom.Point2D;
import peli.avaruustaistelu.grafiikka.SuperAseGrafiikka;

/**
 * Super ase luokassa tullaan luomaan erikoinen ase pelaajan alukselle.
 *
 * @author Hossein Bahmanpour
 */
public class SuperAse {

    private double x;
    private double y;
    private final double xSuuntainenNopeus;
    private final double ySuuntainenNopeus;
    private final double kulma;
    private int elinIkaaJaljella;
    private boolean aktiivinen;
    private final double superAseenSade = 6;
    private final double superAseenNopeus = 8;
    private final SuperAseGrafiikka superAseGrafiikka;
    private int latausProsentti;

    /**
     * Konstruktori
     *
     * @param x x koordinaatti
     * @param y y koordinaatti
     * @param kulma kulma
     * @param aluksenXSuuntainenNopeus nopeus x koordinaatistossa
     * @param aluksenYSuuntainenNopeus nopeus y koordinaatistossa
     * @param elinIkaaJaljella kauanko ase on pelissä
     */
    public SuperAse(double x, double y, double kulma, double aluksenXSuuntainenNopeus, double aluksenYSuuntainenNopeus, int elinIkaaJaljella) {
        this.x = x;
        this.y = y;
        this.kulma = kulma;
        xSuuntainenNopeus = superAseenNopeus * Math.cos(kulma) + aluksenXSuuntainenNopeus;
        ySuuntainenNopeus = superAseenNopeus * Math.sin(kulma) + aluksenYSuuntainenNopeus;
        this.elinIkaaJaljella = elinIkaaJaljella;
        aktiivinen = true;
        this.superAseGrafiikka = new SuperAseGrafiikka(this);
    }

    /**
     * metodi liikuttaa super ase oliota x ja y koordinaatistossa.
     *
     * @param ruudunLeveys ruudun leveys
     * @param ruudunKorkeus ruudun korkeus
     */
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
        return superAseenSade;
    }

    public double getKulma() {
        return this.kulma;
    }

    public SuperAseGrafiikka getSuperAseGrafiikka() {
        return superAseGrafiikka;
    }

    public double getxSuuntainenNopeus() {
        return xSuuntainenNopeus;
    }

    public double getySuuntainenNopeus() {
        return ySuuntainenNopeus;
    }

}
