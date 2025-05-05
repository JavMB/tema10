package Ej3;

/**
 * The type Coche manual.
 */
public class CocheManual extends Coche {

    /**
     * Instantiates a new Coche manual.
     *
     * @param matricula          the matricula
     * @param velocidadesMaximas the velocidades maximas
     */
    public CocheManual(String matricula, double[] velocidadesMaximas) {
        super(matricula, velocidadesMaximas);
    }

    @Override
    public void acelerar(boolean pressed) {
        if (pressed && getVelocidadActual() < getVelocidadesMaximas()[getMarchaActual().ordinal()]) {
            super.acelerar(true);
        }
    }

    @Override
    public void cambiarMarcha(Marcha marcha) {
        setMarchaActual(marcha);
    }
}
