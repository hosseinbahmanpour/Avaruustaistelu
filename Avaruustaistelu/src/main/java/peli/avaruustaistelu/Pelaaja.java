package peli.avaruustaistelu;

public class Pelaaja {

    private String nimi;
    private int elama;
    private SuperAse superAse;
    private Alus alus;

    public Pelaaja(String nimi) {

        this.nimi = nimi;
        this.elama = 100;
        this.superAse = new SuperAse();
        this.alus = new Alus();
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

    public SuperAse getAse() {
        return this.superAse;
    }
    
    public Alus getAlus() {
        return this.alus;
    }

}
