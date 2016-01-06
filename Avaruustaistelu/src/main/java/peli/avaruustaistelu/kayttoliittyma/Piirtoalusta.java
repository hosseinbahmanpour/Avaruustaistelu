package peli.avaruustaistelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import peli.avaruustaistelu.logiikka.Avaruustaistelu;
import peli.avaruustaistelu.logiikka.Laaseri;

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
        g2d.setColor(Color.WHITE);
        g2d.drawString(a.getP1().getNimi() + " --- Aluksen suojakenttä: " + a.getP1().getElama() + "/100", 10, 30);
        g2d.drawString(a.getP2().getNimi() + " --- Aluksen suojakenttä: " + a.getP2().getElama() + "/100", 520, 30);

        for (Laaseri l : a.getPelaaja1Laaserit()) {
            l.getlG().piirra(g);
        }

        for (Laaseri l : a.getPelaaja2Laaserit()) {
            l.getlG().piirra(g);
        }

        a.getPelaaja1AlusGrafiikka().piirra(g2d);
        a.getPelaaja2AlusGrafiikka().piirra(g2d);
    }

}
