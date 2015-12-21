
package peli.avaruustaistelu;

import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Avaruustaistelu extends Applet implements Runnable, KeyListener{
    
    Thread peliLooppi;    
    BufferedImage varmuusKuva;
    Graphics2D g;
    boolean naytaRajat = false;
    ArrayList<Luoti> luodit;
    Pelaaja pelaaja1 = new Pelaaja("Pelaaja 1");
    Pelaaja pelaaja2 = new Pelaaja("Pelaaja 2");
    Alus alus1 = new Alus();
    Alus alus2 = new Alus();
    AffineTransform at = new AffineTransform();    
    
    

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
