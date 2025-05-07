package Ej4;

import lib.GeneradorDatos;
import lib.Rnd;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Tienda.
 */
public class Tienda {
    private final List<Electrodomestico> catalogo;

    /**
     * Instantiates a new Tienda.
     */
    public Tienda() {
        this.catalogo = new ArrayList<>();
    }

    /**
     * Generar catalogo.
     */
    public void generarCatalogo() { //TODO al constructor
        for (int i = 0; i < 10; i++) {
            switch (Rnd.getInt(1, 2)) {
                case 1 -> catalogo.add(generarLavadoraAleatoria());
                case 2 -> catalogo.add(generarTelevisionAleatoria());
            }
        }
    }

    private Lavadora generarLavadoraAleatoria() {
        GeneradorDatos g = new GeneradorDatos();
        float pBase = g.generarNumeroEntero(100, 500);
        float peso = (float) Rnd.getDouble(100, 1000);
        Electrodomestico.Color color = colorAleatorio();
        Electrodomestico.Consumo consumo = consumoAleatorio();
        float carga = (float) Rnd.getDouble(10, 100);
        return new Lavadora(pBase, color, consumo, peso, carga);
    }

    private Television generarTelevisionAleatoria() {
        GeneradorDatos g = new GeneradorDatos();
        float pBase = g.generarNumeroEntero(200, 1200);
        float peso = (float) Rnd.getDouble(50, 700);
        Electrodomestico.Color color = colorAleatorio();
        Electrodomestico.Consumo consumo = consumoAleatorio();
        float pulgadas = (float) Rnd.getDouble(20, 80);
        boolean tdt = Rnd.getBoolean();
        return new Television(pBase, color, consumo, peso, pulgadas, tdt);
    }

    private Electrodomestico.Color colorAleatorio() {
        Electrodomestico.Color[] colores = Electrodomestico.Color.values();
        int idx = Rnd.getInt(0, colores.length - 1);
        return colores[idx];
    }

    private Electrodomestico.Consumo consumoAleatorio() {
        Electrodomestico.Consumo[] consumos = Electrodomestico.Consumo.values();
        int idx = Rnd.getInt(0, consumos.length - 1);
        return consumos[idx];
    }

    /**
     * Precio de todos los Electrodomesticos especificados.
     *
     * @param tipo the tipo
     * @return the precio final electrodomestico
     */
    public double getPrecioFinalTotalElectrodomestico(Class<? extends Electrodomestico> tipo) {
        double sum = 0;
        for (Electrodomestico e : catalogo) {
            if (tipo.isInstance(e)) {
                sum += e.precioFinal();
            }
        }
        return sum;
    }


}