package peli.avaruustaistelu.logiikka;

/**
 * Super ase luokassa tullaan luomaan erikoinen ase pelaajan alukselle. Luokka
 * on kehitysvaiheessa ja luonnos.
 *
 * @author Hossein Bahmanpour
 */
public class SuperAse {

    private boolean lataus;

    /**
     * konstruktorissa ase asetetaan ladatuksi.
     */
    public SuperAse() {
        this.lataus = true;
    }

    /**
     * lataa aseen.
     */
    public void lataa() {
        this.lataus = true;
    }

    /**
     * palauttaa aseen latauksen booleanin.
     *
     * @return lataus kertoo onko ase ladattu vai ei.
     */
    public boolean onkoAseLadattu() {
        return this.lataus;
    }

    /**
     * SuperAseen ampuminen muuttaa latauksen falseksi. Aseen voi ampua vain jos
     * ase on ladattu.
     */
    public void ammu() {
        if (onkoAseLadattu()) {
            this.lataus = false;
        }
    }

}
