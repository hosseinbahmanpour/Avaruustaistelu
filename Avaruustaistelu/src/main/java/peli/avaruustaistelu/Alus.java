package peli.avaruustaistelu;

import java.awt.Rectangle;
import java.awt.Polygon;

public class Alus extends Kuvio {

    private int[] muotoX = {-6, -3, 0, 3, 6, 0};
    private int[] muotoY = {6, 7, 7, 7, 6, -7};

    public Alus() {
        setShape(new Polygon(muotoX, muotoY, 6));
    }

    public Rectangle osumaRaja() {
        Rectangle r = new Rectangle((int)getX() - 6, (int)getY() - 6, 12, 12);
        return r;
    }

}
