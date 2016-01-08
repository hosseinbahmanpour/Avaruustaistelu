package peli.avaruustaistelu.logiikka;

/**
 * Pelaaja luokassa luodaan Pelaaja oliot ja toteutetaan metodi ottaaDamagea().
 *
 * @author Hossein Bahmanpour
 */
public class Pelaaja {

    private final String nimi;
    private int elama;
    private final Alus alus;
    private int lataus;

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
        this.lataus = 100;
    }

    /**
     * Metodi luo uuden Laaseri olion ja palautta sen.
     *
     * @return Laaseri uusi laaseri olio
     */
    public Laaseri ammu() {
        return new Laaseri(alus.getX(), alus.getY(), alus.getKulma(), alus.getxSuuntainenNopeus(), alus.getySuuntainenNopeus(), 50);
    }

    /**
     * Metodi luo uuden palautettavan SuperAse olion ja nollaa latauksen.
     *
     * @return palauttaa uuden SuperAse olion.
     */
    public SuperAse ammuSuperAse() {
        this.lataus = 0;
        return new SuperAse(alus.getX(), alus.getY(), alus.getKulma(), alus.getxSuuntainenNopeus(), alus.getySuuntainenNopeus(), 70);
    }

    /**
     * Lisää latausta.
     */
    public void lataa() {
        this.lataus++;
        if (lataus > 100) {
            lataus = 100;
        }
    }

    /**
     * Vähentää pelaajan elämää tietyn verran.
     *
     * @param paljonko kuinka paljon vähennetään elämästä.
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

    public int getLataus() {
        return this.lataus;
    }

    /**
     * Tämä metodi resetoi pelaajan ja pelaajaa vastaavan aluksen kaikki
     * parametrit.
     *
     * @param x x koordinaatti
     * @param y y koordinaatti
     */
    public void uusiPeli(double x, double y) {
        alus.setX(x);
        alus.setY(y);
        this.elama = 100;
        this.lataus = 100;
        alus.setxSuuntainenNopeus(0);
        alus.setySuuntainenNopeus(0);
    }

    /**
     * Tätä metodia kutsutaan kun peli on loppunut niin, että alus pysähtyy.
     */
    public void peliLoppui() {
        alus.setKiihtyyko(false);
        alus.setKaantyyOikealle(false);
        alus.setKaantyyVasemmalle(false);
    }

}
