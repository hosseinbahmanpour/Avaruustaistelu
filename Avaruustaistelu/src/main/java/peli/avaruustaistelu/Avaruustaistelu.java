package peli.avaruustaistelu;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JApplet;

public class Avaruustaistelu extends JApplet implements Runnable, KeyListener {

    Thread thread;
    long aloitusAika;
    long lopetusAika;
    long framePeriod;
    Image img;
    Dimension dim;
    int leveys;
    int korkeus;
    Graphics g;
    Pelaaja p1 = new Pelaaja("Pelaaja 1");
    Pelaaja p2 = new Pelaaja("Pelaaja 2");
    Alus p1Alus;
    Alus p2Alus;
    boolean alusTormays;
    ArrayList<Laaseri> laaserit = new ArrayList<>();
    ArrayList<Alus> alukset = new ArrayList<>();

    public void init() {
        resize(800, 600);
        dim = getSize();
        leveys = dim.width;
        korkeus = dim.height;
        framePeriod = 25;
        addKeyListener(this);
        setFocusable(true);
        p1Alus = new Alus(20, korkeus / 2, 0, .15, .5, .98);
        p2Alus = new Alus(780, korkeus / 2, 0, .15, .5, .98);
        alusTormays = false;
        img = createImage(leveys, korkeus);
        g = img.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics gfx) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, leveys, korkeus);
        g2d.setColor(Color.WHITE);
        g2d.drawString(p1.getNimi() + " : " + p1.getElama(), 10, 10);
        g2d.drawString(p2.getNimi() + " : " + p2.getElama(), 10, 590);

        for (Laaseri l : laaserit) {
            l.piirra(g2d);
        }

        p1Alus.piirra(g2d);
        p2Alus.piirra(g2d);

        gfx.drawImage(img, 0, 0, this);
    }

    public void update(Graphics gfx) {
        paint(gfx);
    }

    public void run() {
        while (true) {
            aloitusAika = System.currentTimeMillis();
            p1Alus.liiku(leveys, korkeus);
            p2Alus.liiku(leveys, korkeus);

            for (Laaseri l : laaserit) {
                l.liiku(leveys, korkeus);
            }
            for (int i = 0; i < laaserit.size(); i++) {
                if (!laaserit.get(i).getAktiivinen()) {
                    laaserit.remove(i);
                }
            }

            tarkistaTormaykset();

            repaint();

            try {
                lopetusAika = System.currentTimeMillis();
                if (framePeriod - (lopetusAika - aloitusAika) > 0) {
                    Thread.sleep(framePeriod - (lopetusAika - aloitusAika));
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            laaserit.add(p1Alus.ammu());
        }
        if (key == KeyEvent.VK_UP) {
            p1Alus.setKiihtyyko(true);
        }
        if (key == KeyEvent.VK_RIGHT) {
            p1Alus.setKaantyyOikealle(true);
        }
        if (key == KeyEvent.VK_LEFT) {
            p1Alus.setKaantyyVasemmalle(true);
        }
        if (key == KeyEvent.VK_TAB) {
            laaserit.add(p2Alus.ammu());
        }
        if (key == KeyEvent.VK_W) {
            p2Alus.setKiihtyyko(true);
        }
        if (key == KeyEvent.VK_D) {
            p2Alus.setKaantyyOikealle(true);
        }
        if (key == KeyEvent.VK_A) {
            p2Alus.setKaantyyVasemmalle(true);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            p1Alus.setKiihtyyko(false);
        }
        if (key == KeyEvent.VK_RIGHT) {
            p1Alus.setKaantyyOikealle(false);
        }
        if (key == KeyEvent.VK_LEFT) {
            p1Alus.setKaantyyVasemmalle(false);
        }
        if (key == KeyEvent.VK_W) {
            p2Alus.setKiihtyyko(false);
        }
        if (key == KeyEvent.VK_D) {
            p2Alus.setKaantyyOikealle(false);
        }
        if (key == KeyEvent.VK_A) {
            p2Alus.setKaantyyVasemmalle(false);
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void tarkistaTormaykset() {


    }
}
