package peli.avaruustaistelu;

import java.awt.Shape;

public class Kuvio {

    private Shape shape;
    private double x;
    private double y;
    private double vauhtiX;
    private double vauhtiY;
    private double liikkumisKulma;
    private double suuntaKulma;

    public Kuvio() {

    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVauhtiX() {
        return vauhtiX;
    }

    public double getVauhtiY() {
        return vauhtiY;
    }

    public double getLiikkumisKulma() {
        return liikkumisKulma;
    }

    public double getSuuntaKulma() {
        return suuntaKulma;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void lisaaX(double i) {
        this.x += i;
    }

    public void lisaaY(double i) {
        this.y += i;
    }

    public void setVauhtiX(double vauhtiX) {
        this.vauhtiX = vauhtiX;
    }

    public void setVauhtiY(double vauhtiY) {
        this.vauhtiY = vauhtiY;
    }

    public void lisaaVauhtiaX(double i) {
        this.vauhtiX += i;
    }

    public void lisaaVauhtiaY(double i) {
        this.vauhtiY += i;
    }

    public void setLiikkumisKulma(double liikkumisKulma) {
        this.liikkumisKulma = liikkumisKulma;
    }

    public void lisaaLiikkumisKulmaa(double i) {
        this.liikkumisKulma += i;
    }

    public void setSuuntaKulma(double suuntaKulma) {
        this.suuntaKulma = suuntaKulma;
    }

    public void lisaaSuuntaKulmaa(double i) {
        this.suuntaKulma += i;
    }

}
