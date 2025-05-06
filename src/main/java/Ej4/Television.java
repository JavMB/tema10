package Ej4;

/**
 * The type Television.
 */
public class Television extends Electrodomestico {
    private static boolean DEFAULTSMARTV = false;
    private static float PULGADAS = 20;


    private final float pulgadas;
    private final boolean isSmartTv;

    /**
     * Instantiates a new Television.
     *
     * @param pulgadas  the pulgadas
     * @param isSmartTv the is smart tv
     */
    public Television(float pulgadas, boolean isSmartTv) {
        super();
        this.pulgadas = pulgadas;
        this.isSmartTv = isSmartTv;
    }

    /**
     * Instantiates a new Television.
     *
     * @param precio    the precio
     * @param peso      the peso
     * @param pulgadas  the pulgadas
     * @param isSmartTv the is smart tv
     */
    public Television(float precio, Color color, Consumo consumo, float peso, float pulgadas, boolean isSmartTv) {
        super(precio, color, consumo, peso);
        this.pulgadas = pulgadas;
        this.isSmartTv = isSmartTv;
    }

    /**
     * Instantiates a new Television.
     */
    public Television() {
        super();
        this.pulgadas = PULGADAS;
        this.isSmartTv = DEFAULTSMARTV;
    }

    /**
     * Gets pulgadas.
     *
     * @return the pulgadas
     */
    public float getPulgadas() {
        return pulgadas;
    }

    /**
     * Is smart tv boolean.
     *
     * @return the boolean
     */
    public boolean isSmartTv() {
        return isSmartTv;
    }

    @Override
    public float precioFinal() {
        if (pulgadas > 40) {
            return (float) (super.precioFinal() * 1.3);
        } else if (isSmartTv) {
            return getPrecioBase() + 50;
        } else {
            return super.precioFinal();
        }
    }
}
