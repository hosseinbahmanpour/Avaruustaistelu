package peli.avaruustaistelu;

public class Pelaaja {

    private String nimi;
    private int elama;
    private SuperAse superAse;

    public Pelaaja(String nimi) {

        this.nimi = nimi;
        this.elama = 100;
        this.superAse = new SuperAse();
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

}
