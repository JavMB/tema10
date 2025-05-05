package Ej1;

import java.util.Objects;

/**
 * The type Punto.
 */
public class Punto {
    private double x;
    private double y;


    /**
     * Instantiates a new Punto.
     *
     * @param x the x
     * @param y the y
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Instantiates a new Punto.
     */
    public Punto() {
        this(0, 0);
    }

    /**
     * Distancia double.
     *
     * @param p the p
     * @return the double
     */
    public double distancia(Punto p) {
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(double x) {
        if (x >= 0) {
            this.x = x;
        }

    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(double y) {
        if (y >= 0) {
            this.y = y;
        }

    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return Double.compare(x, punto.x) == 0 && Double.compare(y, punto.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
