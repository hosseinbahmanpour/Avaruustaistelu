package peli.avaruustaistelu;

import java.awt.Rectangle;

public class Luoti extends Kuvio {

    public Luoti() {
        setShape(new Rectangle(0, 0, 1, 1));
    }

    public Rectangle osumaRaja() {
        Rectangle r = new Rectangle((int) getX(), (int) getY(), 1, 1);
        return r;
    }

}
