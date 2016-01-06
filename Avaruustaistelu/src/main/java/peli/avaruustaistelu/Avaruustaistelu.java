package peli.avaruustaistelu;

import java.awt.Color;
import java.util.ArrayList;
import peli.avaruustaistelu.grafiikka.AlusGrafiikka;
import peli.avaruustaistelu.logiikka.Alus;
import peli.avaruustaistelu.logiikka.Laaseri;
import peli.avaruustaistelu.logiikka.Pelaaja;

/**
 * Tämä luokka on pelini pää luokka, missä luodaan kaikki pelin oliot ja array
 * lista laaseri oliolle
 *
 * @author xbax
 */
public class Avaruustaistelu {

    private Alus a1;
    private Alus a2;
    private Pelaaja p1;
    private Pelaaja p2;
    private AlusGrafiikka a1G;
    private AlusGrafiikka a2G;
    private int leveys;
    private int korkeus;
    private ArrayList<Laaseri> laaseritA1;
    private ArrayList<Laaseri> laaseritA2;

    /**
     * konstruktorissa kovakoodataan pelin ikkunan koko
     */
    public Avaruustaistelu() {
        this.a1 = new Alus(50, 150, 0, .15, .5, .98);
        this.a2 = new Alus(500, 500, 0, .15, .5, .98);
        this.p1 = new Pelaaja("Pelaaja 1", a1);
        this.p2 = new Pelaaja("Pelaaja 2", a2);
        this.a1G = new AlusGrafiikka(a1, Color.GREEN);
        this.a2G = new AlusGrafiikka(a2, Color.BLUE);
        this.leveys = 800;
        this.korkeus = 600;
        this.laaseritA1 = new ArrayList<>();
        this.laaseritA2 = new ArrayList<>();
    }

    public Alus getA1() {
        return a1;
    }

    public Alus getA2() {
        return a2;
    }

    public Pelaaja getP1() {
        return p1;
    }

    public Pelaaja getP2() {
        return p2;
    }

    public AlusGrafiikka getA1G() {
        return a1G;
    }

    public AlusGrafiikka getA2G() {
        return a2G;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public ArrayList<Laaseri> getLaaseritA1() {
        return laaseritA1;
    }

    public ArrayList<Laaseri> getLaaseritA2() {
        return laaseritA2;
    }

}
