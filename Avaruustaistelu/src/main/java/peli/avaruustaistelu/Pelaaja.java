package peli.avaruustaistelu;

public class Pelaaja {

    private String nimi;
    private int elama;

    public Pelaaja(String nimi) {

        this.nimi = nimi;
        this.elama = 100;
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

}
