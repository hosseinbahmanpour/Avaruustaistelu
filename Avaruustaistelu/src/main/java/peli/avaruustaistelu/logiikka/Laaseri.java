package peli.avaruustaistelu.logiikka;

import java.awt.geom.Point2D;
import peli.avaruustaistelu.grafiikka.LaaseriGrafiikka;

/**
 * Laaseri luokassa luodaan laasei oliot, ja getterien ja setterien lisäksi
 * siinä on liiku metodi minkä avulla laaseri olioiden sijaintia x ja y
 * koordinaatistossa muutetaan pelin aikana.
 *
 * @author Hossein Bahmanpour
 */
public class Laaseri {

    private double x;
    private double y;
    private final double xSuuntainenNopeus;
    private final double ySuuntainenNopeus;
    private final double kulma;
    private int elinIkaaJaljella;
    private boolean aktiivinen;
    private final double laaserinSade = 4;
    private final double laaserinNopeus = 10;
    private final LaaseriGrafiikka lG;

    /**
     * Laaseri olion konstruktorissa luodaan uusi laaseri olio.
     *
     * @param x laaseri olion x koordinaatti.
     * @param y laaseri olion y koordinaatti.
     * @param kulma laaseri olion kulma x koordinaatin suhteen.
     * @param aluksenXSuuntainenNopeus laaseri olion vauhti suuntaan x perustuu
     * laaserin luoneen aluksen vauhtiin.
     * @param aluksenYSuuntainenNopeus laaseri olion vauhti suuntaan y perustuu
     * laaserin luoneen aluksen vauhtiin.
     * @param elinIkaaJaljella kuinka kauan laaseri on vielä olemassa.
     */
    public Laaseri(double x, double y, double kulma, double aluksenXSuuntainenNopeus, double aluksenYSuuntainenNopeus, int elinIkaaJaljella) {
        this.x = x;
        this.y = y;
        this.kulma = kulma;
        xSuuntainenNopeus = laaserinNopeus * Math.cos(kulma) + aluksenXSuuntainenNopeus;
        ySuuntainenNopeus = laaserinNopeus * Math.sin(kulma) + aluksenYSuuntainenNopeus;
        this.elinIkaaJaljella = elinIkaaJaljella;
        aktiivinen = true;
        this.lG = new LaaseriGrafiikka(this);
    }

    /**
     * Liiku metodi siirtää Laaseri oliota ruudulla.
     *
     * @param ruudunLeveys peliruudun leveys.
     * @param ruudunKorkeus peliruudun korkeus.
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
        return laaserinSade;
    }

    public double getKulma() {
        return this.kulma;
    }

    public LaaseriGrafiikka getlG() {
        return lG;
    }

}
