package peli.avaruustaistelu;


public class Pelaaja {

    private String nimi;
    private int elama;
    private boolean ase;

    public Pelaaja(String nimi) {

        this.nimi = nimi;
        this.elama = 10;
        this.ase = true;
    }

    public int getElama() {
        return elama;
    }
    
    public void ottaaDamagee() {
        this.elama--;
    }

    public void lataaAse() {
        this.ase = true;
    }
    
    public boolean onkoAseLadattu(){
        return this.ase;
    }

    public void ammu() {
        if (onkoAseLadattu()) {
            System.out.println("Piu piu");
            this.ase = false;
        }
    }
    
            
}
