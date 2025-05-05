package Ej4;

public class Lavadora extends Electrodomestico {
    private final static int CARGA = 5;

    private final float carga;

    public Lavadora() {
        super();
        this.carga = CARGA;
    }

    public Lavadora(float precio, float peso) {
        super(precio, peso);
        carga = CARGA;
    }

    public Lavadora(float precioBase, Color color, Consumo consumo, float peso, float carga) {
        super(precioBase, color, consumo, peso);
        this.carga = carga;
    }

    public float getCarga() {
        return carga;
    }

}
