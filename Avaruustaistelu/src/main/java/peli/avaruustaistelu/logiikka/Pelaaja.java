package peli.avaruustaistelu.logiikka;

/**
 * Pelaaja luokassa luodaan Pelaaja oliot ja toteutetaan metodi ottaaDamagea().
 *
 * @author Hossein Bahmanpour
 */
public class Pelaaja {

    private String nimi;
    private int elama;
    private Alus alus;

    /**
     * Konstruktorissa luodaan Pelaaja olio ja elämäksi asetetaan 100.
     *
     * @param nimi pelaajan nimi
     * @param alus pelaajan alus
     */
    public Pelaaja(String nimi, Alus alus) {
        this.nimi = nimi;
        this.elama = 100;
        this.alus = alus;
    }

    /**
     * vähentää pelaajan elämää tietyn verran.
     *
     * @param paljonko
     */
    public void ottaaDamagee(int paljonko) {
        this.elama -= paljonko;
        if (this.elama < 0) {
            this.elama = 0;
        }
    }

    public String getNimi() {
        return nimi;
    }

    public int getElama() {
        return elama;
    }

    public Alus getAlus() {
        return this.alus;
    }

}
