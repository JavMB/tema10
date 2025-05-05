package Ej2;

import Ej1.Punto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Punto> puntos = new ArrayList<>();
        puntos.add(new Punto());
        puntos.add(new Punto(2, 0));
        puntos.add(new Punto(2, 2));
        puntos.add(new Punto(0, 2));

        Poligono p = new Poligono(puntos);

        System.out.println(p);
        System.out.println(p.perimetro());

        p.traslada(4, -3);

        System.out.println(p);
        System.out.println(p.perimetro());

    }
}
