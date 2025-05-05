package Ej2;

import Ej1.Punto;

import java.util.List;
import java.util.Objects;

/**
 * The type Poligono.
 */
public class Poligono {
    private final List<Punto> puntos;

    /**
     * Instantiates a new Poligono.
     *
     * @param puntos the puntos
     */
    public Poligono(List<Punto> puntos) {
        this.puntos = puntos;
    }

    /**
     * Traslada.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void traslada(double dx, double dy) {
        for (Punto p : puntos) {
            p.setX(p.getX() + dx);
            p.setY(p.getY() + dy);
        }

    }

    /**
     * Num vertices int.
     *
     * @return the int
     */
    public int numVertices() {
        return puntos.size();
    }

    /**
     * Perimetro double.
     *
     * @return the double
     */
    public double perimetro() {
        double perimetro = 0;

        for (int i = 0; i < puntos.size(); i++) {
            perimetro += puntos.get(i).distancia(puntos.get((i + 1) % puntos.size()));
        }


        return perimetro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Punto p : puntos) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Poligono poligono = (Poligono) o;
        return Objects.equals(puntos, poligono.puntos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(puntos);
    }
}
