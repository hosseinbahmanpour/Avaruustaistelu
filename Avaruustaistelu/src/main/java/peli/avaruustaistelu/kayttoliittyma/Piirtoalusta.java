package peli.avaruustaistelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import peli.avaruustaistelu.Avaruustaistelu;
import peli.avaruustaistelu.grafiikka.LaaseriGrafiikka;
import peli.avaruustaistelu.logiikka.Laaseri;

/**
 * Piirtoalustassa hoidetaan grafiikoiden piirtäminen.
 *
 * @author xbax
 */
public class Piirtoalusta extends JPanel {

    private Avaruustaistelu avaruustaistelu;

    /**
     * Konstruktori.
     *
     * @param avaruustaistelu kyseisen piirtoalustan peli.
     */
    public Piirtoalusta(Avaruustaistelu avaruustaistelu) {
        this.avaruustaistelu = avaruustaistelu;
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
        g2d.fillRect(0, 0, avaruustaistelu.getLeveys(), avaruustaistelu.getKorkeus());
        g2d.setColor(Color.WHITE);
        g2d.drawString(avaruustaistelu.getP1().getNimi() + " --- Aluksen suojakenttä: " + avaruustaistelu.getP1().getElama() + "/100", 10, 30);
        g2d.drawString(avaruustaistelu.getP2().getNimi() + " --- Aluksen suojakenttä: " + avaruustaistelu.getP2().getElama() + "/100", 520, 30);

        for (Laaseri l : avaruustaistelu.getLaaseritA1()) {
            l.getlG().piirra(g);
        }

        for (Laaseri l : avaruustaistelu.getLaaseritA2()) {
            l.getlG().piirra(g);
        }

        avaruustaistelu.getA1G().piirra(g2d);
        avaruustaistelu.getA2G().piirra(g2d);

        if (avaruustaistelu.getP1().getElama() == 0 && avaruustaistelu.getP2().getElama() > 0) {
            g2d.setColor(Color.RED);
            g2d.fillOval(275, 225, 200, 125);
            g2d.setColor(Color.WHITE);
            g2d.drawString("Pelaaja 2 voitti!", 300, 300);
        }

        if (avaruustaistelu.getP2().getElama() == 0 && avaruustaistelu.getP1().getElama() > 0) {
            g2d.setColor(Color.RED);
            g2d.fillOval(275, 225, 200, 125);
            g2d.setColor(Color.WHITE);
            g2d.drawString("Pelaaja 1 voitti!", 300, 300);
        }

        if (avaruustaistelu.getP1().getElama() == 0 && avaruustaistelu.getP2().getElama() == 0) {
            g2d.setColor(Color.RED);
            g2d.fillOval(275, 225, 200, 125);
            g2d.setColor(Color.WHITE);
            g2d.drawString("Kamikaze tasapeli!!!", 300, 300);
        }

    }

}
