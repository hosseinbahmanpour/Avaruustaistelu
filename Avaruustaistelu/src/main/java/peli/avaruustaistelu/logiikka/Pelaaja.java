package peli.avaruustaistelu.logiikka;

public class Pelaaja {

    private String nimi;
    private int elama;
    private Alus alus;

    public Pelaaja(String nimi, Alus alus) {
        this.nimi = nimi;
        this.elama = 100;
        this.alus = alus;
    }

    public String getNimi() {
        return nimi;
    }

    public int getElama() {
        return elama;
    }

    public void ottaaDamagee(int paljonko) {
        this.elama -= paljonko;
    }
    
    public Alus getAlus() {
        return this.alus;
    }

}
