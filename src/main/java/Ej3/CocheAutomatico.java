package Ej3;

/**
 * The type Coche automatico.
 */
public class CocheAutomatico extends Coche {
    /**
     * Instantiates a new Coche automatico.
     *
     * @param matricula          the matricula
     * @param velocidadesMaximas the velocidades maximas
     */
    public CocheAutomatico(String matricula, double[] velocidadesMaximas) {
        super(matricula, velocidadesMaximas);
    }

    @Override
    public void acelerar(boolean pressed) {
        super.acelerar(pressed);
        cambiarMarcha(getMarchaActual());

    }

    @Override
    public void frenar(boolean pressed) {
        super.frenar(pressed);
        cambiarMarcha(getMarchaActual());
    }

    @Override
    protected void cambiarMarcha(Marcha marcha) {
        double velocidad = getVelocidadActual();
        double[] vmax = getVelocidadesMaximas();

        int nuevaMarcha = 0;
        for (int i = 0; i < vmax.length; i++) {
            if (velocidad >= vmax[i]) {
                nuevaMarcha = i;
            }
        }
        setMarchaActual(Marcha.values()[nuevaMarcha]);
    }





}
