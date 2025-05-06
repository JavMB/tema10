package Ej4;

/**
 * The type Electrodomestico.
 */
public abstract class Electrodomestico {


    public enum Color {
        RED("RED"),
        GREEN("GREEN"),
        YELLOW("YELLOW"),
        WHITE("WHITE");

        private final String color;

        Color(String color1) {
            this.color = color1;
        }

        public String getColor() {
            return color;
        }
    }

    public enum Consumo {
        A('A', 100),
        B('B', 80),
        C('C', 60),
        D('D', 50),
        E('E', 30),
        F('F', 10);
        private final char letra;
        private final int precio;

        Consumo(char letra, int precio) {
            this.letra = letra;
            this.precio = precio;
        }

        public char getLetra() {
            return letra;
        }

        public int getPrecio() {
            return precio;
        }
    }

    public enum RangoPeso {
        PESO1(0, 19, 10),
        PESO2(20, 49, 50),
        PESO3(50, 79, 80),
        PESO4(80, Integer.MAX_VALUE, 100);

        private final int min;
        private final int max;
        private final int precio;


        RangoPeso(int min, int max, int precio) {
            this.min = min;
            this.max = max;
            this.precio = precio;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public int getPrecio() {
            return precio;
        }
    }


    private static final float pBase = 100;
    private static final Color cBase = Color.WHITE;
    private static final Consumo conBase = Consumo.F;
    private static final float pesBase = 5;

    private final float precioBase;
    private final Color color;
    private final Consumo consumo;
    private final float peso;


    /**
     * Instantiates a new Electrodomestico.
     *
     * @param precioBase the precio base
     * @param color      the color
     * @param consumo    the consumo
     * @param peso       the peso
     */
    protected Electrodomestico(float precioBase, Color color, Consumo consumo, float peso) {
        this.precioBase = precioBase;

        if (comprobarColor(color.getColor())) {
            this.color = color;

        } else this.color = cBase;

        if (comprobarConsumoEnergetico(consumo.getLetra())) {
            this.consumo = consumo;
        } else this.consumo = conBase;

        this.peso = peso;
    }

    /**
     * Instantiates a new Electrodomestico.
     */
    protected Electrodomestico() {
        this(pBase, cBase, conBase, pesBase);
    }

    /**
     * Instantiates a new Electrodomestico.
     *
     * @param precio the precio
     * @param peso   the peso
     */
    protected Electrodomestico(float precio, float peso) {
        this(precio, cBase, conBase, peso);
    }

    /**
     * Gets precio base.
     *
     * @return the precio base
     */
    public float getPrecioBase() {
        return precioBase;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets consumo.
     *
     * @return the consumo
     */
    public Consumo getConsumo() {
        return consumo;
    }

    /**
     * Gets peso.
     *
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    private boolean comprobarConsumoEnergetico(char letra) {

        for (Consumo c : Consumo.values()) {
            if (letra == c.getLetra()) {
                return true;
            }
        }

        return false;
    }

    private boolean comprobarColor(String color) {
        for (Color c : Color.values()) {
            if (color.equals(c.getColor())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Precio final float.
     *
     * @return the float
     */
    public float precioFinal() {
        int precioPeso = 0;
        for (RangoPeso p : RangoPeso.values()) {
            if (peso >= p.min && peso <= p.max) {
                precioPeso = p.getPrecio();
            }
        }

        return precioBase + consumo.getPrecio() + precioPeso;
    }





}
