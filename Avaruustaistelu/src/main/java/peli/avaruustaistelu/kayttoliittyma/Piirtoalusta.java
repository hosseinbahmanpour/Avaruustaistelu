package peli.avaruustaistelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import peli.avaruustaistelu.logiikka.Avaruustaistelu;
import peli.avaruustaistelu.logiikka.Laaseri;
import peli.avaruustaistelu.logiikka.SuperAse;

/**
 * Piirtoalustassa hoidetaan grafiikoiden piirtäminen.
 *
 * @author xbax
 */
public class Piirtoalusta extends JPanel {

    private final Avaruustaistelu a;

    /**
     * Konstruktori.
     *
     * @param a kyseisen piirtoalustan peli.
     */
    public Piirtoalusta(Avaruustaistelu a) {
        this.a = a;
    }

    /**
     * piirtää uudestaan.
     */
    public void paivita() {
        repaint();
    }

    /**
     * Metodi piirtää kaikki pelin oliot joilla on grafiikka.
     *
     * @param g Javan grafiikka.
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, a.getLeveys(), a.getKorkeus());

        g2d.setColor(Color.GREEN);
        g2d.drawString(a.getP1().getNimi(), 10, 12);
        g2d.setColor(Color.BLUE);
        g2d.drawString(a.getP2().getNimi(), 690, 12);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Elämä: " + a.getP1().getElama() + "%", 10, 25);
        g2d.drawString("Fotoni: " + a.getP1().getLataus() + "%", 10, 37);
        g2d.drawString("Elämä: " + a.getP2().getElama() + "%", 690, 25);
        g2d.drawString("Fotoni: " + a.getP2().getLataus() + "%", 690, 37);

        for (Laaseri l : a.getPelaaja1Laaserit()) {
            l.getLaaseriGrafiikka().piirra(g);
        }

        for (Laaseri l : a.getPelaaja2Laaserit()) {
            l.getLaaseriGrafiikka().piirra(g);
        }

        for (SuperAse s : a.getPelaaja1SuperAse()) {
            s.getSuperAseGrafiikka().piirra(g);
        }

        for (SuperAse s : a.getPelaaja2SuperAse()) {
            s.getSuperAseGrafiikka().piirra(g);
        }

        a.getPelaaja1AlusGrafiikka().piirra(g2d);
        a.getPelaaja2AlusGrafiikka().piirra(g2d);

        if (a.getP1().getElama() == 0 || a.getP2().getElama() == 0) {
            g2d.setColor(Color.RED);
            g2d.drawRect(300, 175, 200, 50);
            g2d.setColor(Color.WHITE);
            g2d.drawString("GAME OVER", 370, 200);
        }
    }

}
