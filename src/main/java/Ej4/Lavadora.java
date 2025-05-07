package Ej4;

/**
 * The type Lavadora.
 */
public class Lavadora extends Electrodomestico {
    private final static int CARGA = 5;

    private final float carga;

    /**
     * Instantiates a new Lavadora.
     */
    public Lavadora() {
        super();
        this.carga = CARGA;
    }

    /**
     * Instantiates a new Lavadora.
     *
     * @param precio the precio
     * @param peso   the peso
     */ //TODO usar this()
    public Lavadora(float precio, float peso) {
        super(precio, peso);
        carga = CARGA;
    }

    /**
     * Instantiates a new Lavadora.
     *
     * @param precioBase the precio base
     * @param color      the color
     * @param consumo    the consumo
     * @param peso       the peso
     * @param carga      the carga
     */
    public Lavadora(float precioBase, Color color, Consumo consumo, float peso, float carga) {
        super(precioBase, color, consumo, peso);
        this.carga = carga;
    }

    /**
     * Gets carga.
     *
     * @return the carga
     */
    public float getCarga() {
        return carga;
    }

    @Override
    public float precioFinal() {
        if (carga > 30) {
            return super.precioFinal();
        } else {
            return getPrecioBase();
        }

    }
}
