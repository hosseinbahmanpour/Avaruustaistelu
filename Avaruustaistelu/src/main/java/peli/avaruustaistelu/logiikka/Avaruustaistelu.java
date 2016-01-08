package peli.avaruustaistelu.logiikka;

import java.awt.Color;
import java.util.ArrayList;
import peli.avaruustaistelu.grafiikka.AlusGrafiikka;

/**
 * Tämä luokka on pelini pää luokka, missä luodaan kaikki pelin oliot ja array
 * lista laaseri oliolle
 *
 * @author xbax
 */
public class Avaruustaistelu {

    private final Alus pelaaja1Alus;
    private final Alus pelaaja2Alus;
    private final Pelaaja p1;
    private final Pelaaja p2;
    private final AlusGrafiikka pelaaja1AlusGrafiikka;
    private final AlusGrafiikka pelaaja2AlusGrafiikka;
    private final int leveys;
    private final int korkeus;
    private final ArrayList<Laaseri> pelaaja1Laaserit;
    private final ArrayList<Laaseri> pelaaja2Laaserit;
    private final ArrayList<SuperAse> pelaaja1SuperAse;
    private final ArrayList<SuperAse> pelaaja2SuperAse;
    private final ArrayList<Rajahdys> rajahdykset;

    /**
     * Konstruktorissa kovakoodataan pelin ikkunan koko.
     */
    public Avaruustaistelu() {
        this.pelaaja1Alus = new Alus(50, 150, 0, .15, .5, .98);
        this.pelaaja2Alus = new Alus(730, 450, 3.14, .15, .5, .98);
        this.p1 = new Pelaaja("Pelaaja 1", pelaaja1Alus);
        this.p2 = new Pelaaja("Pelaaja 2", pelaaja2Alus);
        this.pelaaja1AlusGrafiikka = new AlusGrafiikka(pelaaja1Alus, Color.GREEN);
        this.pelaaja2AlusGrafiikka = new AlusGrafiikka(pelaaja2Alus, Color.BLUE);
        this.leveys = 800;
        this.korkeus = 600;
        this.pelaaja1Laaserit = new ArrayList<>();
        this.pelaaja2Laaserit = new ArrayList<>();
        this.pelaaja1SuperAse = new ArrayList<>();
        this.pelaaja2SuperAse = new ArrayList<>();
        this.rajahdykset = new ArrayList<>();
    }

    public Alus getPelaaja1Alus() {
        return pelaaja1Alus;
    }

    public Alus getPelaaja2Alus() {
        return pelaaja2Alus;
    }

    public Pelaaja getP1() {
        return p1;
    }

    public Pelaaja getP2() {
        return p2;
    }

    public AlusGrafiikka getPelaaja1AlusGrafiikka() {
        return pelaaja1AlusGrafiikka;
    }

    public AlusGrafiikka getPelaaja2AlusGrafiikka() {
        return pelaaja2AlusGrafiikka;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public ArrayList<Laaseri> getPelaaja1Laaserit() {
        return pelaaja1Laaserit;
    }

    public ArrayList<Laaseri> getPelaaja2Laaserit() {
        return pelaaja2Laaserit;
    }

    public ArrayList<SuperAse> getPelaaja1SuperAse() {
        return pelaaja1SuperAse;
    }

    public ArrayList<SuperAse> getPelaaja2SuperAse() {
        return pelaaja2SuperAse;
    }

    public ArrayList<Rajahdys> getRajahdykset() {
        return rajahdykset;
    }

}
